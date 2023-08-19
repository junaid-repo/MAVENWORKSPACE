package com.mircorservices.userservice.Services;

import com.mircorservices.userservice.Repositories.UserSaveRepository;
import com.mircorservices.userservice.VO.Department;
import com.mircorservices.userservice.VO.UserAndDepartmentDetails;
import com.mircorservices.userservice.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    UserSaveRepository userSaveRepo;

    @Autowired
    RestTemplate restTemplate;


    public Users saveUser(Users user) {

        return userSaveRepo.save(user);
    }

    public UserAndDepartmentDetails getUserNDeptDetails(Integer id) {
        UserAndDepartmentDetails response = new UserAndDepartmentDetails();
        Users user= new Users();
        user=userSaveRepo.findById(id).get();

        Department dept = new Department();

        dept=restTemplate.getForObject("http://localhost:8081/department/"+user.getDeptId(),Department.class);

        response.setDepartment(dept);
		return response;
        
      
    }
}
