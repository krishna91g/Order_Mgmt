package com.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Krishna
 *
 */

@Entity
@Table(name="ORDER_ITEMS")

public class Products {
	
	@Id
    @GeneratedValue
    private Long Id;
	
	private String productCode;
	private String productName;	
	private int	quantity;
	
	public Products(String productCode, String productName, int quantity) {
		this.productCode = productCode;
		this.productName = productName;
		this.quantity = quantity;
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderItems [productCode=" + productCode + ", productName=" + productName + ", quantity=" + quantity
				+ "]";
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
