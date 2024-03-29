package br.inatel.dm112.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inatel.dm112.client.EmailClient;
import br.inatel.dm112.client.OrderClient;
import br.inatel.dm112.client.runner.ClientUtil;
import br.inatel.dm112.model.Order;
import br.inatel.dm112.model.Entregador;
import br.inatel.dm112.model.Entregador.PAY_STATUS;

@Service
public class DeliveryService {

	@Autowired
	private OrderClient clientOrder;

	@Autowired
	private EmailClient clientEmail;

	/**
	 * Lógica de geração de pendência de pagamento (1) consulta o pedido pelo número
	 * (2) atualiza o status do pedido (3) gera o boleto (4) envia email com o pdf
	 * (5) retorna sucesso
	 * 
	 * @param cpf
	 * @param orderNumber
	 * @return
	 */
	public Entregador confirmDelivery(String deliveryPerson, int orderNumber) {

		clientOrder.setRestURL(ClientUtil.getOrderRestURL());

		Order orderToUpdate = clientOrder.retrieveOrder(orderNumber);
		if (orderToUpdate == null) {
			System.out.println("Order not found: " + 1);
			return null;
		}

		if(orderToUpdate.getStatus() == 1) {
			String msg = "Status do pedido " + orderNumber + " inválido: " + orderToUpdate.getStatus();
			throw Entregador.createErrorStatus(msg, deliveryPerson, orderNumber, PAY_STATUS.WRONG_ORDER_STATUS);
		}
		
		// update the values for the order
		orderToUpdate.setStatus(1);
		String body = "Entrega realizada por " + deliveryPerson +
					  ". Caso tenha algum problema com a entrega, entre em contato com a nossa central de atendimento.";
		clientOrder.updateOrder(orderToUpdate);
		
//		Order order = getOrder(cpf, orderNumber); // (1) consulta o pedido pelo número
//
//		if (order.getStatus() != Order.STATUS.PENDING.ordinal()) {
//			String msg = "Status do pedido " + orderNumber + " inválido: " + order.getStatus();
//			throw Entregador.createErrorStatus(msg, cpf, orderNumber, PAY_STATUS.WRONG_ORDER_STATUS);
//		}
//
//		try {
//			//clientOrder.startOrderPayment(orderNumber); // (2) atualiza o status do pedido
//		} catch (Exception e) {
//			String msg = "Erro no serviço de pedido: start payment";
//			throw Entregador.createErrorStatus(msg, cpf, orderNumber, PAY_STATUS.ORDER_ERROR);
//		}
//		BilletGenResponse respBillet;
//		try {
//			respBillet = clientBillet.callGenerateBilletService(orderNumber, cpf); // (3) gera o boleto
//		} catch (Exception e) {
//			String msg = "Erro no serviço de boleto";
//			throw Entregador.createErrorStatus(msg, cpf, orderNumber, PAY_STATUS.BILLET_ERROR);
//		}
//
//		byte[] PDFContent = respBillet.getPdfContent();
		try {
			clientEmail.callSendMailService(orderNumber,body); // (4) envia email com o pdf
		} catch (Exception e) {
			String msg = "Erro no serviço de email";
			throw Entregador.createErrorStatus(msg,deliveryPerson, orderNumber, PAY_STATUS.EMAIL_ERROR);
		}
		System.out.println("Sucesso ao atualizar o pedido: orderNumber: " + orderNumber);
		return new Entregador(PAY_STATUS.OK.ordinal()); // (5) retorna sucesso
	}

	/**
	 * Lógica de confirmação de pagamento (1) consulta o pedido pelo número (2)
	 * atualiza o status do pedido confirmando o pagamento (3) responde Ok
	 * 
	 * @param cpf
	 * @param orderNumber
	 * @return
	 */
	public List<Order> listOrders(String deliveryPerson) {

		List<Order> entities = clientOrder.getOrdersDelivery();
		List<Order> orders = new ArrayList<>();

		for (Order entity : entities) {
			System.out.println(entity.toString());
			if(entity.getAssociatedDeliveryPerson().equals(deliveryPerson) && entity.getStatus() != 1) {
				
				System.out.println(entity.toString());
				orders.add(entity);
			}
			
		}
		return orders;
		
//		Order order = getOrder(cpf, orderNumber); // (1) consulta o pedido pelo número
//
//		if (order.getStatus() == Order.STATUS.CONFIRMED.ordinal()) {
//			String msg = "Status do pedido " + orderNumber + " inválido: " + order.getStatus();
//			throw Entregador.createErrorStatus(msg, cpf, orderNumber, PAY_STATUS.WRONG_ORDER_STATUS);
//		}
//		try {
//			clientOrder.confirmOrderPayment(orderNumber); // (2) confirma o pagamento (e atualiza o status)
//		} catch (Exception e) {
//			String msg = "Erro no serviço de pedido: confirm payment";
//			throw Entregador.createErrorStatus(msg, cpf, orderNumber, PAY_STATUS.ORDER_ERROR);
//		}
//		System.out.println("Sucesso ao confirmar o pagamento: orderNumber: " + orderNumber + " cpf: " + cpf);
//		return new Entregador(PAY_STATUS.OK.ordinal(), cpf, orderNumber); // (3) responde Ok
	}

	private Order getOrder(String cpf, int orderNumber) {
		if (cpf == null || orderNumber < 0) {
			throw Entregador.createErrorStatus("CPF e pedido são obrigatórios", cpf, orderNumber,
					PAY_STATUS.NULL_VALUES);
		}
		Order order;
		try {
			order = clientOrder.retrieveOrder(orderNumber); // (1) consulta o pedido pelo número
		} catch (Exception e) {
			String msg = "Pedido " + orderNumber + " não encontrado.";
			throw Entregador.createErrorStatus(msg, cpf, orderNumber, PAY_STATUS.ORDER_NOT_FOUND);
		}
		return order;
	}

}