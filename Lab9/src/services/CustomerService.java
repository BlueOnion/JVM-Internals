package services;

import java.lang.reflect.Field;
import java.util.List;

import java.util.stream.Collectors;


import entities.Customer;
import entities.Product;

public class CustomerService implements CustomerServiceInterface {

	private List<Customer> customers;

	public CustomerService(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public List<Customer> findByName(String name) {
		return customers.stream().filter(c -> c.getName().equals(name)).collect(Collectors.toList()); 
	}

	@Override
	public List<Customer> findByField(String fieldName, Object value) {
		return customers.stream().filter((c) -> {
			try {
				Field field = c.getClass().getDeclaredField(fieldName);
				field.setAccessible(true);
				return value.equals(field.get(c));
			} catch(Exception e) {
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());
	}

	@Override
	public List<Customer> customersWhoBoughtMoreThan(int number) {
		return customers.stream().filter(c -> 
				c.getBoughtProducts().size() > number).collect(Collectors.toList());
	}

	@Override
	public List<Customer> customersWhoSpentMoreThan(double price) {
		return customers.stream().filter(c ->
				c.getBoughtProducts().stream().mapToDouble(p -> p.getPrice()).sum() > price)).collect(Collectors.toList());
	}

	@Override
	public List<Customer> customersWithNoOrders() {
		return customers.stream().filter(c -> c.getBoughtProducts().isEmpty().collect(Collectors.toList()));
	}

	@Override
	public void addProductToAllCustomers(Product p) {
		customers.forEach(c -> c.addProduct(p));
	}
	
	@Override
	public double avgOrders(boolean includeEmpty) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean wasProductBought(Product p) {
		return customers.stream().filter(c -> c.getBoughtProducts().stream().filter(product -> product.equals(p))
				.collect(Collectors.toList()).size() > 0).collect(Collectors.toList()).size() > 0;
	}

	@Override
	public List<Product> mostPopularProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countBuys(Product p) {
		return (int) customers.stream()
			      .map(c -> c.getBoughtProducts().stream().map(product -> product.equals(p)).count())
			      .count();
	}

	@Override
	public int countCustomersWhoBought(Product p) {
		return (int) customers.stream()
			      .filter(c -> c.getBoughtProducts().stream().filter(product -> product.equals(p)).collect(Collectors.toList()).size() > 0)
			      .count();
	}

}
