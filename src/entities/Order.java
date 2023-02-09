package entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Instant moment;
	private OrderStatus status;
	private Client client;
	
	List<OrderItem> orderItems = new ArrayList<OrderItem>();

	public Order(Instant moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void addItem(OrderItem orderItem) {
		orderItems.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		orderItems.remove(orderItem);
	}
	
	public Double total() {
		double value = 0.0;
		
		for (OrderItem orderItem : orderItems) {
			value += orderItem.subTotal();	
		}
		
		return value;
	}
}
