
package com.sid.web.ms.util;

/**
 * @author sahu
 *This interface contains all the global constants and sql queries
 */
public interface ApplicationUtils {

	final String  PRODUCT_BY_ID_SQL=  "select * from product where product_id =:productId ";
	final String REMOVE_PRODUCT="delete from product where product_id = :productId";
	final String ALL_PRODUCTS_SQL = "select * from product ";
	final String INSERT_PRODUCT_SQL ="insert into product(product_id,product_name,product_type,product_desc,product_price) "
			+ "values(:productId, :productName, :productType, :productDesc, :productPrice)";
	
	final String INSERT_PRODUCT_TABLE_SQL = 	" INSERT INTO PRODUCT VALUES (12345, 'Zara', 'Ali', 'database',18.3 ) ";
	final String SELECT_TOP_PRODUCT_ID_SQL =  " select product_id from PRODUCT ORDER BY product_id DESC LIMIT 1 ";
	
	final String CREATE_PRODUCT_TABLE_SQL = " CREATE TABLE IF NOT EXISTS PRODUCT ( PRODUCT_ID INT PRIMARY KEY , PRODUCT_NAME varchar(50) NOT NULL,"
			+ " PRODUCT_TYPE varchar(20) , PRODUCT_DESC varchar(100), PRODUCT_PRICE FLOAT ) ";
	final String PRODUCTS_TYPE_SQL = "select * from product where product_type =:productType";
	final String PRODUCTS_NAME_AND_TYPE_SQL = "select product_id from product where product_type =:productType and product_name=:productName";
}
