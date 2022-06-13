package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;
import java.util.List;

public class SaleData implements DataInterface {
	static List<Object> listOfSales = new ArrayList<Object>();
	
	@Override
	public void save(Object sale) {
		listOfSales.add(sale);
		
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getBySku(String sku) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> listAll() {
		return listOfSales;
	}
	
	
		
	
}
