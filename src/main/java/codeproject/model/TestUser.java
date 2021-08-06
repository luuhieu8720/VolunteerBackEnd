//package com.codeproject.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.Collection;
//import java.util.Date;
//import java.util.Set;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Table(name = "test_User")
//public class TestUser {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long Id_User;
//
//    private String name;
//    private String gender;
//    private String phone;
//    private String email;
//    private Date date;
//
////    @OneToMany(mappedBy = "user")
////    private Set<Comment> comments;
//
////    @OneToMany(mappedBy = "user")
////    private Set<ProjectRating> point;
//}
