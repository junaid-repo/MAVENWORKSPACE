package com.shop.inventories;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventroiesController {

	@GetMapping("/getInventoriesDetails")
	List<Map> getWareHouseDetails(@RequestParam String inventoryId) {

		Map<String, String> retMap = new HashMap<>();
		Map<String, String> retMap2 = new HashMap<>();
		Map<String, String> retMap3 = new HashMap<>();

		List<Map> retList = new LinkedList<>();

		retMap.put("wareHouseId", "22");
		retMap.put("productId", "224");
		retMap.put("quantity", "876");

		retMap2.put("wareHouseId", "74");
		retMap2.put("productId", "663");
		retMap2.put("quantity", "844");

		retMap3.put("wareHouseId", "68");
		retMap3.put("productId", "33");
		retMap3.put("quantity", "333");

		retList.add(retMap);
		retList.add(retMap2);
		retList.add(retMap3);

		return retList;

	}

}
