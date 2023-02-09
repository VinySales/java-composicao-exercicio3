package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Name: ");
		String name = scan.next();
		
		System.out.print("E-mail: ");
		String email = scan.next();
		
		System.out.print("Birth Date (DD/MM/YYYY): ");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate birthDate = LocalDate.parse(scan.next(), fmt);
		
		System.out.println("");
		System.out.print("Enter Order Data: ");
		String orderStatus = scan.next();
		
		System.out.println("");
		System.out.print("How many items to this order?: ");
		int orderQuantity = scan.nextInt();
		System.out.println("");
		
		Client c1 = new Client(name, email, birthDate);
		Order order = new Order(Instant.now(), OrderStatus.valueOf(orderStatus), c1);
		
		for (int i = 0; i < orderQuantity; i++) {
			System.out.print("Product name: ");
			String productName = scan.next();
			
			System.out.print("Product Price: ");
			double productPrice = scan.nextDouble();
			
			System.out.print("Quantity: ");
			int productQuantity = scan.nextInt();
			
			Product p = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, p);
			
			order.addItem(orderItem);
			System.out.println("");
		}
		
		System.out.println("Order sumary");
		System.out.println("Order moment: " + order.getMoment());
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + order.getClient().getName() + " " + order.getClient().getBirthDate() + " " + order.getClient().getEmail());
		System.out.println("");
		System.out.println("Order items: ");
		
		for (OrderItem orderItem : order.getOrderItems()) {
			StringBuilder sb = new StringBuilder();
			sb.append(orderItem.getProduct().getName() + ", ");
			sb.append("$" + orderItem.getProduct().getPrice() + ", ");
			sb.append("Quantity: " + orderItem.getQuantity() + ", ");
			sb.append("Subtotal:" + orderItem.subTotal());
			
			System.out.println(sb.toString());
		}
		
		System.out.println("Total price: $" + order.total());
	}

}
