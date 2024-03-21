package br.inatel.dm112;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.inatel.dm112.model.dao.OrderRepository;
import br.inatel.dm112.model.entities.OrderEntity;

@SpringBootApplication
public class PedidoApp implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PedidoApp.class, args);
	}

	@Autowired
	private OrderRepository repo;

	@Override
	public void run(String... args) throws Exception {

		OrderEntity order1 = new OrderEntity();
		order1.setCpfCustomer("111.111.111-11");
		//order1.setAssociatedDeliveryPerson("Entregador1");
		//order1.setOrderDate(new Date());
		order1.setStatus(0);

		repo.save(order1);

		OrderEntity order2 = new OrderEntity();
		order2.setCpfCustomer("222.222.222-22");
		//order2.setAssociatedDeliveryPerson("Entregador2");
		//order2.setOrderDate(new Date());
		order2.setStatus(0);


		repo.save(order2);
	}
}