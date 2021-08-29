package com.example.students.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "studentswithgrades")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sex;
    private Long age;
    private String address;
    private String motherJob;
    private String fatherJob;
    private Long studyTime;
    private Long failures;
    private String internet;
    private String romantic;
    private Long freeTime;
    private Long goOut;
    private Long dailyConsumptionOfAlcohol;
    private Long weekendConsumptionOfAlcohol;
    private Long health;
    private Long absences;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<Grade> grades = new HashSet<>();

    public void addGrade(Grade g) {
        grades.add(g);
        g.setStudent(this);
    }
}
