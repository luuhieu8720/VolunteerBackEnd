//package com.codeproject.model.point;
//
//import com.codeproject.model.Project;
//import com.codeproject.model.TestUser;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@NoArgsConstructor
//@Builder
//@AllArgsConstructor
//@Table(name = "ProjectRating")
//public class ProjectRating {
//
//    @EmbeddedId
//    private ProjectRatingKey Id;
//
//    @ManyToOne
//    @MapsId("projectId")
//    @JoinColumn(name = "projectId")
//    private Project project;
//
//    @ManyToOne
//    @MapsId("Id_User")
//    @JoinColumn(name = "Id_User")
//    private TestUser user;
//
//    private double point;
//} 
