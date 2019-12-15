package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Setter
@Getter
@Entity
@Table(name="student")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String className;
}

