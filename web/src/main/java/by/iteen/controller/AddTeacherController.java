package by.iteen.controller;

import by.iteen.entity.Role;
import by.iteen.entity.Teacher;
import by.iteen.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddTeacherController {


    private final TeacherService teacherService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AddTeacherController(TeacherService teacherService, PasswordEncoder passwordEncoder) {
        this.teacherService = teacherService;
        this.passwordEncoder = passwordEncoder;
    }

    @ModelAttribute("teacher")
    public Teacher teacher() {
        return new Teacher();
    }

    @GetMapping(path = "/add/teacher")
    public String showFormChild() {
        return "addTeacher";
    }

    @PostMapping("/add/teacher")
    public String addChild(Teacher teacher) {
        teacher.setRole(Role.TEACHER);
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        System.out.println();
        teacherService.save(teacher);
        return "addTeacher";
    }

}
