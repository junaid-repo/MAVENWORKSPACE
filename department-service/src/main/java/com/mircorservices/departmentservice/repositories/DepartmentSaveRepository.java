package com.mircorservices.departmentservice.repositories;

import com.mircorservices.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentSaveRepository extends JpaRepository<Department, Integer> {


}
