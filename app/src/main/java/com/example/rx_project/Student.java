package com.example.rx_project;

import java.util.List;

/**
 * @author yujie
 * @date on 2018/7/18
 * @describe TODO
 */
public class Student {
    private List<Course> courseList;
    private String name;

    public Student(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
