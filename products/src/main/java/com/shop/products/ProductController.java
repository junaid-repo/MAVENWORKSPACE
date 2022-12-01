package com.shop.products;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@GetMapping("/getProductDetails")
	List<Map> getWareHouseDetails(@RequestParam String productId) {

		Map<String, String> retMap = new HashMap<>();
		Map<String, String> retMap2 = new HashMap<>();
		Map<String, String> retMap3 = new HashMap<>();

		List<Map> retList = new LinkedList<>();

		retMap.put("productId", "23");
		retMap.put("productName", "Western Digital WDS250G1B0A");
		retMap.put("description", "Series:Blue,Type:SSD,Capacity:250GB,Cache:N/A");
		retMap.put("standardCost", "72.54");
		retMap.put("listPrice", "89.89");
		retMap.put("categoryId", "5");
		retMap.put("productCount", "165");

		retMap2.put("productId", "27");
		retMap2.put("productName", "Intel Core i7-3960X Extreme Edition");
		retMap2.put("description", "Speed:3.3GHz,Cores:6,TDP:130W");
		retMap2.put("standardCost", "573.41");
		retMap2.put("listPrice", "800.74");
		retMap2.put("categoryId", "1");
		retMap2.put("productCount", "146");

		retMap3.put("productId", "33");
		retMap3.put("productName", "ADATA ASU800SS-128GT-C");
		retMap3.put("description", "Series:Ultimate SU800,Type:SSD,Capacity:128GB,Cache:N/A");
		retMap3.put("standardCost", "37.78");
		retMap3.put("listPrice", "52.65");
		retMap3.put("categoryId", "5");
		retMap3.put("productCount", "150");

		retList.add(retMap);
		retList.add(retMap2);
		retList.add(retMap3);

		return retList;
	}

}
