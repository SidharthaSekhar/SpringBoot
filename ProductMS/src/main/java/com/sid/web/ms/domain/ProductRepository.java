/**
 * 
 */
package com.sid.web.ms.domain;

import java.util.List;

import com.sid.common.model.Product;

/**
 * @author sahu
 *
 */
public interface ProductRepository {

	List<Product> getProductsByType(String productType);

	String addProduct(Product product);

	String initProduct();

	List<Product> getAllProducts();

	Product removeProduct(Long productId);

	Boolean isProductExist(Product product);

}
