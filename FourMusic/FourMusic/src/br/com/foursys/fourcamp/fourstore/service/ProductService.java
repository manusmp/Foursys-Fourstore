package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.data.SaleData;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Sale;

public class ProductService {

	ProductData data = new ProductData();
	SaleData dataSale = new SaleData();

	public boolean registerProduct(Product product) {
		boolean return1 = false;
		Product verifyProduct = (Product) data.getBySku(product.getSku());
		if (verifyProduct == null) {
			data.save(product);
			return1 = true;
		}
		return return1;
	}

	public List<Object> listAllProducts() {
		return data.listAll();
	}

	public Product searchBySku(Product product) {
		Product verifySku = (Product) data.getBySku(product.getSku());
		return verifySku;

	}

	public boolean registerSale(Product product, Integer qtt, String cpf, String paymentType) {
		boolean return1 = false;

		Product verifyQtt = (Product) data.getBySku(product.getSku());
		if (verifyQtt != null && qtt <= product.getQtt()) {
			Integer qttNew = product.getQtt() - qtt;
			if (qttNew == 0) {
				data.delete(product);
			} else if (qttNew != 0) {
				product.setQtt(qttNew);
				data.update(product);
			}
			Product productP = new Product();
			product.getSku();
			productP.setQtt(qtt);
			productP.setSku(product.getSku());
			productP.setCategory(product.getCategory());
			productP.setColor(product.getColor());
			productP.setDepartment(product.getDepartment());
			productP.setDescription(product.getDescription());
			productP.setOriginPrice(product.getOriginPrice());
			productP.setSalePrice(product.getSalePrice());
			productP.setSize(product.getSize());
			productP.setTotalSale(product.getTotalSale());
			productP.setType(product.getType());

			addSale(productP, cpf, paymentType, qtt);

			return1 = true;
		}
		return return1;

	}

	private void addSale(Product product, String cpf, String paymentType, Integer Qtt) {
		Sale sale = new Sale(product, cpf, paymentType);
		dataSale.save(sale);

	}

	public List<Object> listAllSales() {
		return dataSale.listAll();
	}
}
