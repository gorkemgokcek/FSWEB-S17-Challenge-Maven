package com.workintech.spring17challenge.entity;

import org.springframework.stereotype.Component;

@Component
public class MediumCourseGpa implements com.workintech.spring17challenge.entity.CourseGpa {
    @Override
    public int getGpa() {
        return 5;
    }
}
