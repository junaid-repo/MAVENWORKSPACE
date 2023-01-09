package com.jpa.hibernate.hibdemo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa.hibernate.hibdemo.HibdemoApplication;
import com.jpa.hibernate.hibdemo.entity.Course;
import com.jpa.hibernate.hibdemo.entity.Passport;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibdemoApplication.class)
class JPQLTest {

	@Autowired
	EntityManager em;

	
	  @Test public void JPQL_NativQuery_Basic() {
	  
	  List resultList =
	  em.createNativeQuery("select * from Course ").getResultList();
	  
	  System.out.println("Response of JPQL_Basic---->" + resultList);
	  
	  }
	  
		/*
		 * @Test public void JPQL_NativQuery_Typed() {
		 * 
		 * List<Course> resultList = em.createNativeQuery("select * from Course ",
		 * Course.class).getResultList();
		 * 
		 * System.out.println("Response of JPQL_Typed---->" + resultList);
		 * 
		 * }
		 * 
		 * @Test public void JPQL_NativQuery_Where() {
		 * 
		 * List<Course> resultList = em
		 * .createNativeQuery("select * from Course   where name='Springboot'",
		 * Course.class).getResultList();
		 * 
		 * System.out.println("Response of JPQL_Where---->" + resultList);
		 * 
		 * }
		 * 
		 * @Test public void JPQL_NativQuery_With_Parameter() {
		 * 
		 * Query query = em.createNativeQuery("select * from Course   where name=?",
		 * Course.class); query.setParameter(1, "MavenWorkspace");
		 * 
		 * List resultList = query.getResultList();
		 * System.out.println("Response of JPQL_NativQuery_With_Parameter---->" +
		 * resultList);
		 * 
		 * }
		 * 
		 * @Test
		 * 
		 * @Transactional public void JPQL_NativQuery_update_timestamp() {
		 * 
		 * Query query = em.
		 * createNativeQuery("update course set last_updated_date=CURRENT_TIMESTAMP()",
		 * Course.class); // query.setParameter(1, // "MavenWorkspace");
		 * 
		 * int noOfRowsUpdated = query.executeUpdate();
		 * System.out.println("Response of JPQL_NativQuery_update_timestamp---->" +
		 * noOfRowsUpdated);
		 * 
		 * }
		 * 
		 * @Test public void JPQL_Basic2() {
		 * 
		 * List resultList = em.createNamedQuery("named_query1").getResultList();
		 * 
		 * System.out.println("Response of JPQL_Basic---->" + resultList);
		 * 
		 * }
		 * 
		 * @Test public void JPQL_Typed2() {
		 * 
		 * List<Course> resultList = em.createNamedQuery("named_query1",
		 * Course.class).getResultList();
		 * 
		 * System.out.println("Response of JPQL_Typed---->" + resultList);
		 * 
		 * }
		 * 
		 * @Test public void JPQL_Where2() {
		 * 
		 * List<Course> resultList = em.createNamedQuery("name_query2_where",
		 * Course.class).getResultList();
		 * 
		 * System.out.println("Response of JPQL_Where---->" + resultList);
		 * 
		 * }
		 * 
		 * @Test public void jpql_course_with_atLeast_2_students() { TypedQuery<Course>
		 * qry = em.createQuery("select c from Course c where size(c.students)>=2",
		 * Course.class); List<Course> crs = qry.getResultList(); System.out.
		 * println("The output of the test jpql_course_with_atLeast_2_students is--> " +
		 * crs);
		 * 
		 * }
		 */
	 
	@Test
	public void jpql_similar_passportNumber() {
		TypedQuery qry = em.createQuery("SELECT p FROM PASSPORT p where p.passportnumber like '%123%'", Passport.class);
		List<Passport> crs = qry.getResultList();
		System.out.println("The output of the test jpql_similar_passportNumber is--> "+crs);

	}
}
