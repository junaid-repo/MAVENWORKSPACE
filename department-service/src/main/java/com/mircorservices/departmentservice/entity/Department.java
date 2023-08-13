package com.mircorservices.departmentservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Department {

    String name;
    String location;
    String code;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
}
