package by.iteen.service;

import by.iteen.entity.Course;

import java.util.List;

public interface CourseService {

    Course findByTitle(String title);

    List<Course> findAll();
}
