package com.order.item.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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

	@NotEmpty(message = "Product Code must not be empty")
	private String productCode;

	@NotEmpty(message = "Product Name must not be empty")
	private String productName;
	
	private int	quantity;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	
	

}
