package com.jdbcdemo.jdbcdemo.interfaces;

import com.jdbcdemo.jdbcdemo.dto.CountryGDPResponse;

public interface IGDPCountries {
	
	CountryGDPResponse getGDPWiseCounrties(String year, String gpd);

}
