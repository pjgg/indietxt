package org.indietxt.model;

/**
 * Representacion de la talla de un producto
 * ej: id:2 , sizeSystem:456 , description = "XL"
 */
public class ProductSize {

	protected Integer id;
	protected Integer sizeSystem;
	protected String description;

	public ProductSize(Integer id,Integer sizeSystem,String description){
		this.id = id;
		this.sizeSystem = sizeSystem;
		this.description = description;
	}

	public Integer getId(){
		return id;
	}

	public Integer getSizeSystem(){
		return sizeSystem;
	}

	public String getDescription(){
		return description;
	}
}
