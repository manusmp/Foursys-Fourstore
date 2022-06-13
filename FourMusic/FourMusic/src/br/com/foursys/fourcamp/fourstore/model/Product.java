package br.com.foursys.fourcamp.fourstore.model;

import br.com.foursys.fourcamp.fourstore.enums.CategoryEnum;
import br.com.foursys.fourcamp.fourstore.enums.ColorEnum;
import br.com.foursys.fourcamp.fourstore.enums.DepartmentEnum;
import br.com.foursys.fourcamp.fourstore.enums.SizeEnum;
import br.com.foursys.fourcamp.fourstore.enums.TypeEnum;

public class Product {
	private String sku;
	private Double originPrice;
	private Double salePrice;
	private Integer qtt;
	private TypeEnum type;
	private SizeEnum size;
	private ColorEnum color;
	private CategoryEnum category;
	private DepartmentEnum department;
	private String description;
	private Double totalSale;
	
	public Product(String sku, Double originPrice, Double salePrice, Integer qtt) {
		super();
		this.sku = sku;
		this.originPrice = originPrice;
		this.salePrice = salePrice;
		this.qtt = qtt;
		seeSku(sku);
	}
	
	
	public Double getTotalSale() {
		return totalSale;
	}


	public void setTotalSale(Double totalSale) {
		this.totalSale = totalSale;
	}


	public Product(String sku, Integer qtt) {
		super();
		this.sku = sku;
		this.qtt = qtt;
	}


	public Product(String sku, Double originPrice, Double salePrice, Integer qtt, TypeEnum type, SizeEnum size2,
			ColorEnum color2, CategoryEnum category2, DepartmentEnum department2) {
		super();
		this.sku = sku;
		this.originPrice = originPrice;
		this.salePrice = salePrice;
		this.qtt = qtt;
		this.type = type;
		this.size = size2;
		this.color = color2;
		this.category = category2;
		this.department = department2;
		seeSku(sku);
	}

	public Product(String sku, Double newPrice) {
		super();
		this.sku = sku;
		this.salePrice = newPrice;
		seeSku(sku);
	}
	

	public Product(String sku) {
		this.sku = sku;
	}

	public Integer getQtt() {
		return qtt;
	}
	public void setQtt(Integer qtt) {
		this.qtt = qtt;
	}
	public TypeEnum getType() {
		return type;
	}
	public void setType(TypeEnum type) {
		this.type = type;
	}
	public SizeEnum getSize() {
		return size;
	}
	public void setSize(SizeEnum size) {
		this.size = size;
	}
	public ColorEnum getColor() {
		return color;
	}
	public void setColor(ColorEnum color) {
		this.color = color;
	}

	public CategoryEnum getCategory() {
		return category;
	}
	public void setCategory(CategoryEnum category) {
		this.category = category;
	}
	public DepartmentEnum getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentEnum department) {
		this.department = department;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}

	public Product() {
		super();
	}


	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

	public Double getOriginPrice() {
		return originPrice;
	}

	public Double setOriginPrice(Double originPrice) {
		return originPrice;
	}
	public void seeSku(String sku) {
		this.color = ColorEnum.get(sku.substring(0, 2));
		this.type = TypeEnum.get(sku.substring(2, 4 ));
		this.department = DepartmentEnum.get(sku.substring(4, 6));
		this.category = CategoryEnum.get(sku.substring(6, 8));
		this.size = SizeEnum.get(sku.substring(8, 10));
	
	}
}
