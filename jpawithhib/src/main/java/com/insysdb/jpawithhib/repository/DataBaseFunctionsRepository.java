package com.insysdb.jpawithhib.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.insysdb.jpawithhib.entity.Brand;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class DataBaseFunctionsRepository {

	@Autowired
	EntityManager em;

	public void addBrandsInTable() {

		Brand brand = new Brand("Samsung");
		em.persist(brand);
		em.flush();
	}

	public Brand findBrandById(Long id) {

		Brand brand = em.find(Brand.class, id);
		return brand;
	}

}
