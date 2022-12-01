package com.shop.locations;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationsController {
	
	@GetMapping("/getLocationDetails")
	List<Map> getWareHouseDetails(@RequestParam String locationId){
		
		Map<String, String> retMap = new HashMap<>();
		Map<String, String> retMap2 = new HashMap<>();
		Map<String, String> retMap3 = new HashMap<>();
		
		List<Map> retList=new LinkedList<>();
	
		
		retMap.put("addresss", "1297 Via Cola di Rie");
		retMap.put("locationId", "1");
		retMap.put("postalCode", "00989");
		retMap.put("city", "Tokyo");
		retMap.put("State", "Tokyo Prefecture");
		retMap.put("CountryId", "JP");	
		
		retMap2.put("addresss", "2011 Interiors Blvd");
		retMap2.put("locationId", "6");
		retMap2.put("postalCode", "99236");
		retMap2.put("city", "South San Francisco");
		retMap2.put("State", "California");
		retMap2.put("CountryId", "US");	
		
		retMap3.put("addresss", "20 Rue des Corps-Saints");
		retMap3.put("locationId", "20");
		retMap3.put("postalCode", "1730");
		retMap3.put("city", "Geneva");
		retMap3.put("State", "Geneve");
		retMap3.put("CountryId", "CH");	
		
		retList.add(retMap);
		retList.add(retMap2);
		retList.add(retMap3);
		
		return retList;
	}



}
