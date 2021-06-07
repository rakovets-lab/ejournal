package by.iteen.controller;

import by.iteen.entity.Course;
import by.iteen.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Controller
public class ShowListCoursesController {

    private final CourseService courseService;

    @Autowired
    public ShowListCoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @ModelAttribute("courses")
    public List<Course> courses() {
        return courseService.findAll();
    }

    @GetMapping("/show/courses")
    public String showListCourses() {
        return "showListCourses";
    }
}
