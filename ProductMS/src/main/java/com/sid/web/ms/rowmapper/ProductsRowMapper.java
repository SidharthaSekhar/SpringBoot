
package com.sid.web.ms.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.sid.common.model.Product;

/**
 * @author sahu
 *
 */
public class ProductsRowMapper implements RowMapper<List<Product>> {

	@Override
	public List<Product> mapRow(ResultSet rs, int arg1) throws SQLException {
		List<Product> products=new ArrayList<Product>();
		do {
			products.add(new Product(rs.getLong("product_id"),rs.getString("product_name"), rs.getString("product_desc"),rs.getString("product_type"),rs.getDouble("product_price")));
		} while (rs.next());
		return products;
	}


}