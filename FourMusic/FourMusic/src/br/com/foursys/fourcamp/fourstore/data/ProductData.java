package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;
import java.util.List;

import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductData implements DataInterface {
		 static List<Object> listOfProducts = new ArrayList<Object>();

		@Override
		public void save(Object product) {
			listOfProducts.add(product);
		}

		@Override
		public void update(Object object) {
			Product product = (Product) object;
			for(int i = 0; i < listOfProducts.size(); i++) {
				Product product2 = (Product) listOfProducts.get(i);
				if(product.getSku().equals(product2.getSku())){
					ProductData.listOfProducts.set(i, product2);
				break;
				}
			}
		}

		@Override
		public void delete(Object object) {
			Product product = (Product) object;
			for(int i = 0; i < listOfProducts.size(); i++) {
				Product product2 = (Product) listOfProducts.get(i);
				if(product.getSku().equals(product2.getSku())){
					ProductData.listOfProducts.remove(i);
				}
			}
		}

		@Override
		public Product getBySku(String sku) {
			Product return1 = null;
			for(int i = 0; i < listOfProducts.size(); i++) {
				Product product2 = (Product) listOfProducts.get(i);
				if(sku.equals(product2.getSku())){
					return1 =  product2;
				} 
			}
			return return1;
			
			
			
		}

		@Override
		public List<Object> listAll() {
			return listOfProducts;
		}
		
}
