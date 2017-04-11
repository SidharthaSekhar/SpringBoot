
package com.sid.web.ms.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sid.common.model.Product;

/**
 * @author sahu
 *
 */
public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int arg1) throws SQLException {
			return new Product(rs.getLong("product_id"),rs.getString("product_name"), rs.getString("product_desc"),rs.getString("product_type"),rs.getDouble("product_price"));
	}




}
