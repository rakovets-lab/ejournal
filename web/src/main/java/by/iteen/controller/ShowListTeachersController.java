package by.iteen.controller;

import by.iteen.entity.Teacher;
import by.iteen.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ShowListTeachersController {

    private final TeacherService teacherService;

    @Autowired
    public ShowListTeachersController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @ModelAttribute("teachers")
    public List<Teacher> teachers() {
        return teacherService.findAll();
    }

    @GetMapping("/show/teachers")
    public String showFormChild() {
        return "showListTeachers";
    }

    @PostMapping("/show/teachers")
    public String addChild() {
        return "showListTeachers";
    }
}
