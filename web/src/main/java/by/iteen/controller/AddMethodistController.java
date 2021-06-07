package by.iteen.controller;

import by.iteen.entity.Role;
import by.iteen.entity.User;
import by.iteen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddMethodistController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AddMethodistController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping(path = "/add/methodist")
    public String showFormMethodist() {
        return "addMethodist";
    }

    @PostMapping(path = "/add/methodist")
    public String addMethodist(User user) {
        user.setRole(Role.METHODIST);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "addMethodist";
    }

}
