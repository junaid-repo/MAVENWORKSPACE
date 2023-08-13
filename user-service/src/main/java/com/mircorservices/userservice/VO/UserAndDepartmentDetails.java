package com.mircorservices.userservice.VO;

import com.mircorservices.userservice.entity.Users;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserAndDepartmentDetails {

    Department department;
    Users user;
}
