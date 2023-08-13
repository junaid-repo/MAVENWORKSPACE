package com.mircorservices.userservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Users {
    private String firstName;
    private String lastName;
    private String email;
    private String deptId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
