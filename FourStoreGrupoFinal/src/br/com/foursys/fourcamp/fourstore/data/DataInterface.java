package br.com.foursys.fourcamp.fourstore.data;

import java.util.List;


public interface DataInterface {
	public void save(Object object);
	public void update(Object object);
	public void delete(Object object);
	public Object getBySku(String sku);
	public List<Object> listAll();
}