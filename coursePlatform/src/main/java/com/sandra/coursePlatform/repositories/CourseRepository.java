package com.sandra.coursePlatform.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sandra.coursePlatform.models.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
