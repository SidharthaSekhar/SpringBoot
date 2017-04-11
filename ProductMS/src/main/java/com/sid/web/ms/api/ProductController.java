
package com.sid.web.ms.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sid.common.model.Product;
import com.sid.web.ms.domain.ProductRepository;


/**
 * @author sahu
 *
 */
@RestController
@RequestMapping("/globo")
public class ProductController {

	@Autowired
	ProductRepository productRepo;

	@RequestMapping(value = "/product/", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> products = productRepo.getAllProducts();
		if (products== null || products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/product/productType/{productType}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProduct(@PathVariable(value = "productType") final  String productType) {
		List<Product> products = productRepo.getProductsByType(productType);
		if (products== null || products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE)
	public  ResponseEntity<Product> removeProduct(@PathVariable("productId") Long productId) {
		Product deletedProduct;
		deletedProduct =productRepo.removeProduct(productId);
		if (deletedProduct == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(deletedProduct,HttpStatus.OK);
	}

	@RequestMapping(value = "/product/", method = RequestMethod.PUT)
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		if (productRepo.isProductExist(product)) {
			return new ResponseEntity<String>("Product Already Exists",HttpStatus.CONFLICT);
		}
		String productId = productRepo.addProduct(product);
		return new ResponseEntity<String>(productId,HttpStatus.CREATED);
	}
	@RequestMapping(value = "/product/init", method = RequestMethod.POST)
	public String initProduct() {
		return productRepo.initProduct();
	}
	@ExceptionHandler
	public ResponseEntity<String> myError(HttpServletRequest request, Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
