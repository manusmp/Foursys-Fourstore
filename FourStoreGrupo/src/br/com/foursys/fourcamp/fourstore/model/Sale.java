package br.com.foursys.fourcamp.fourstore.model;

public class Sale {
	private Product product;
	private String cpf;
	private String paymentType;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Sale(Product product, String cpf, String paymentType) {
		super();
		this.product = product;
		this.cpf = cpf;
		this.paymentType = paymentType;
	}
	public Sale() {
		super();
	}
	
	
}
