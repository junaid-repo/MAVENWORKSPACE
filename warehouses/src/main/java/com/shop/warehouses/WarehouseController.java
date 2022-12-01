package com.shop.warehouses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {
	
	@GetMapping("/getWarehouseDetails")
	List<Map> getWareHouseDetails(@RequestParam String warehouseId){
		
		Map<String, String> retMap = new HashMap<>();
		Map<String, String> retMap2 = new HashMap<>();
		Map<String, String> retMap3 = new HashMap<>();
		
		List<Map> retList=new LinkedList<>();
	
		
		retMap.put("wareHouseId", "22");
		retMap.put("locationId", "453");
		retMap.put("wareHouseName", "Southlake, Texas");
		
		retMap2.put("wareHouseId", "74");
		retMap2.put("locationId", "663");
		retMap2.put("wareHouseName", "Seattle, Washington");
		
		retMap3.put("wareHouseId", "68");
		retMap3.put("locationId", "821");
		retMap3.put("wareHouseName", "Beijing");
		
		retList.add(retMap);
		retList.add(retMap2);
		retList.add(retMap3);
		
		return retList;
	}

}
