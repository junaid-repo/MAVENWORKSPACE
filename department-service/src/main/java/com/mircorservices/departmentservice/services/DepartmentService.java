package com.mircorservices.departmentservice.services;

import com.mircorservices.departmentservice.entity.Department;
import com.mircorservices.departmentservice.repositories.DepartmentSaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentSaveRepository deptSaveRepo;

    public Department saveDepartment(Department dept) {

        return deptSaveRepo.save(dept);
    }

    public List<Department> getDepartmentList() {
        return deptSaveRepo.findAll();
    }

    public Department getDepartment(Integer id) {

        return deptSaveRepo.findById(id).get();
    }
}
