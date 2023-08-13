package com.mircorservices.departmentservice.controller;

import com.mircorservices.departmentservice.entity.Department;
import com.mircorservices.departmentservice.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService serv;
    @PostMapping("/department")
    ResponseEntity<Department> saveDepartment(@RequestBody Department dept){
        Department response = new Department();
        response=serv.saveDepartment(dept);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/department")
    ResponseEntity<List<Department>> getDepartmentList(){
        List<Department> responseList = new ArrayList<>();
        responseList=serv.getDepartmentList();

        return ResponseEntity.status(HttpStatus.FOUND).body(responseList);
    }
    @GetMapping("/department/{id}")
    ResponseEntity<Department> getDepartmentDetails(@PathVariable Integer id){
        Department response= new Department();
        response=serv.getDepartment(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }
}
