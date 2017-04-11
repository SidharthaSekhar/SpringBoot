/**
 * 
 */
package com.sid.web.ms.util;

import java.util.ArrayList;
import java.util.List;

import com.sid.common.model.Product;


/**
 * @author sahu
 *
 */
public class ProductUtils {
	public static List<Product> dummyProductData() {
		Product prod1=new Product("LG", "Oven", "Machine", 20565);
		Product prod2=new Product("Samsung", "Mobile", "Mobile", 14990);
		Product prod3=new Product("Whirlpool", "Fridge", "Machine", 18000);
		Product prod4=new Product("IFB", "Water Purifier", "Machine", 17000);
		Product prod5=new Product("Panasonic", "Mixer", "Machine", 10000);
		Product prod6=new Product("Videocon", "Music System", "Machine", 11000);
		Product prod7=new Product("Onida", "AC", "AC", 12000);
		Product prod8=new Product("Sony", "Sony TV", "TV", 12000);

		List<Product> productList=new ArrayList<Product>();
		productList.add(prod1);
		productList.add(prod2);
		productList.add(prod3);
		productList.add(prod4);
		productList.add(prod5);
		productList.add(prod6);
		productList.add(prod7);
		productList.add(prod8);
		return productList;
	}

}
