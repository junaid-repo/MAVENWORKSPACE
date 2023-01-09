package com.insysdb.jpawithhib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.insysdb.jpawithhib.entity.Brand;
import com.insysdb.jpawithhib.repository.DataBaseFunctionsRepository;

@SpringBootApplication
public class JpawithhibApplication implements CommandLineRunner {
	
	@Autowired
	DataBaseFunctionsRepository df;
	

	public static void main(String[] args) {
		SpringApplication.run(JpawithhibApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//df.addBrandsInTable();
		Brand brand = df.findBrandById(1001l);
		System.out.println(brand);

	}
}
