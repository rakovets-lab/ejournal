package by.iteen.controller;

import by.iteen.entity.Teacher;
import by.iteen.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.TabExpander;

@Controller
public class ShowTeacherController {

    private final TeacherService teacherService;

    @Autowired
    public ShowTeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @ModelAttribute("teacher")
    public Teacher teacher(@PathVariable("id") Long id) {
        return teacherService.findById(id);
    }

    @GetMapping("/show/teacher/{id}")
    public String showTeacher() {
        return "showTeacher";
    }

}
