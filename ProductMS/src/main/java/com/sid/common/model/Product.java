package com.sid.common.model;

import java.io.Serializable;

/**
 * @author sahu
 *
 */
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5571999162559598802L;
	
	private long productId;
	private String productName;
	private String productDesc;
	private String productType;
	private double productPrice;
	
	public Product(){
		productId=0;
	}
	
	public Product( String productName, String productDesc, String productType, double productPrice){
		this.productDesc=productDesc;
		this.productName=productName;
		this.productPrice=productPrice;
		this.productType=productType;
	}

	

	public Product( long productId, String productName, String productDesc, String productType, double productPrice) {
		this.productId = productId;
		this.productDesc=productDesc;
		this.productName=productName;
		this.productPrice=productPrice;
		this.productType=productType;	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc + ", productType="
				+ productType + ", productPrice=" + productPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (productId ^ (productId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId != other.productId)
			return false;
		return true;
	}
	
}
