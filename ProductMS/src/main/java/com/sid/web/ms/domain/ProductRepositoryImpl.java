/**
 * 
 */
package com.sid.web.ms.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sid.common.model.Product;
import com.sid.web.ms.rowmapper.ProductRowMapper;
import com.sid.web.ms.rowmapper.ProductsRowMapper;
import com.sid.web.ms.util.ApplicationUtils;
import com.sid.web.ms.util.ProductUtils;


/**
 * @author sahu
 *
 */
@Repository
public class ProductRepositoryImpl  implements ProductRepository{
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	JdbcTemplate jdbcCon;

	@Override
	public String initProduct() {
		String status =null;
		try{
			jdbcCon.execute(ApplicationUtils.CREATE_PRODUCT_TABLE_SQL);
			status = insertDummyData();

		}catch(Exception e){
			e.printStackTrace();
			status= "initialized failed :"+e.getMessage();	
		}
		return 	status;

	}
	private String insertDummyData() {
		List<Product> products = ProductUtils.dummyProductData();
		for(Product product :products){
			addProduct(product);
		}
		return "initialized successfully";	
	}
	@Override
	public List<Product> getProductsByType(String productType) {
		List<Product> products;
		try{
			MapSqlParameterSource paramSource = new MapSqlParameterSource();
			paramSource.addValue("productType", productType);
			products = jdbcTemplate.queryForObject(ApplicationUtils.PRODUCTS_TYPE_SQL, paramSource, new ProductsRowMapper());
		}catch(EmptyResultDataAccessException e){
			products= new ArrayList<Product>();
		}
		return products;
	}
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = null;
		try{
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		products = jdbcTemplate.queryForObject(ApplicationUtils.ALL_PRODUCTS_SQL, paramSource, new ProductsRowMapper());
		}catch(BadSqlGrammarException e){
			products = new ArrayList<Product>();
		}
return products;
	}
	@Override
	public Product removeProduct(Long productId) {
		Product product=null;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("productId", productId);
		try{
			product = jdbcTemplate.queryForObject(ApplicationUtils.PRODUCT_BY_ID_SQL,paramSource, new ProductRowMapper());
		}catch(EmptyResultDataAccessException e){

		}
		if(product!= null )
			jdbcTemplate.update(ApplicationUtils.REMOVE_PRODUCT, paramSource);
		return product;
	}

	@Override
	public String addProduct(Product product) {	
		Integer productId;
		try{
			productId = jdbcCon.queryForObject(ApplicationUtils.SELECT_TOP_PRODUCT_ID_SQL, Integer.class);
		}catch(EmptyResultDataAccessException e){
			productId =100;
		}
		product.setProductId(productId+1);
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("productId", product.getProductId());
		paramSource.addValue("productName", product.getProductName());
		paramSource.addValue("productType", product.getProductType());
		paramSource.addValue("productDesc", product.getProductDesc());
		paramSource.addValue("productPrice", product.getProductPrice());
		jdbcTemplate.update(ApplicationUtils.INSERT_PRODUCT_SQL, paramSource);
		return Long.toString(product.getProductId());
	}
	@Override
	public Boolean isProductExist(Product product) {
		Boolean isExists = Boolean.FALSE;
		List<String> productIds = null;
		try{
			MapSqlParameterSource paramSource = new MapSqlParameterSource();
			paramSource.addValue("productType", product.getProductType());
			paramSource.addValue("productName", product.getProductName());
			productIds = jdbcTemplate.queryForList(ApplicationUtils.PRODUCTS_NAME_AND_TYPE_SQL,paramSource, String.class);
		}catch(EmptyResultDataAccessException e){
		}
		if(productIds !=null && !productIds.isEmpty() )
			isExists = Boolean.TRUE;
		return isExists;
	}




}
