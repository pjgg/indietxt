package org.indietxt.model;

/**
 * Representacion del inventario de un producto
 * Ej: sizeId: 2, qty: 50
 */
public class StockEntry {


	protected  Integer sizeId;
	protected  Integer qty;

	public StockEntry(Integer sizeId,Integer qty){
		this.sizeId  = sizeId;
		this.qty = qty;
	}

	public Integer getSizeId(){
		return sizeId;
	}

	public Integer getQty(){
		return qty;
	}

}
