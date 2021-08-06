//package com.codeproject.model;
//
//import lombok.Data;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "Type")
//public class Type {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long typeId;
//    private String nameOfType;
//
//    public Type() {
//    }
//
//    public Type(String nameOfType) {
//        this.nameOfType = nameOfType;
//    }
//
//    public Long getTypeId() {
//        return typeId;
//    }
//
//    public void setTypeId(Long typeId) {
//        this.typeId = typeId;
//    }
//
//    public String getNameOfType() {
//        return nameOfType;
//    }
//
//    public void setNameOfType(String nameOfType) {
//        this.nameOfType = nameOfType;
//    }
//}
