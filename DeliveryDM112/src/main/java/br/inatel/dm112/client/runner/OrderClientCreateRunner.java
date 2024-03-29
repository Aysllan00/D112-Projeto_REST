package br.inatel.dm112.client.runner;

import java.util.Date;

import br.inatel.dm112.client.OrderClient;
import br.inatel.dm112.model.Order;

public class OrderClientCreateRunner {

    public static void main(String[] args) {
        OrderClient client = new OrderClient();
        client.setRestURL(ClientUtil.getOrderRestURL());

        String cpf = "212.333.333-33";
        
        Order order = new Order();
        order.setCpfCustomer(cpf);
        order.setAssociatedDeliveryPerson("Entregador1");
        //order.setOrderDate(new Date());
        order.setStatus(0);
        

        try {
            client.createOrder(order);
            System.out.println("Pedido criado com sucesso: " + order.getOrderCode());
        } catch (Exception e) {
            System.err.println("Erro ao criar pedido: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

