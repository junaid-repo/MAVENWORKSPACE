package com.microservices.userservices.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @Column (name ="ID")
    private String userId;

    @Column (name ="NAME", length = 20)
    private String name;

    @Column (name ="EMAIL")
    private String email;

    @Column (name ="ABOUT")
    private String about;

    @Transient
    List<Rating> rating= new ArrayList<>();
}
