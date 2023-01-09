package com.insysdb.jpawithhib;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.insysdb.jpawithhib.entity.Brand;
import com.insysdb.jpawithhib.repository.DataBaseFunctionsRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpawithhibApplication.class)
class DataBaseFunctionTest {

	@Autowired
	DataBaseFunctionsRepository dbfr;
	
	
	@Test
	void test() {
		System.out.println("Test is successful");
	}
	
	@Test
	void test1() {
	Brand	brand=	dbfr.findBrandById(1001L);
		assertEquals("Samsung",brand.getName());
	}
	

}
