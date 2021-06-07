package by.iteen.controller;

import by.iteen.entity.*;
import by.iteen.service.ChildService;
import by.iteen.service.ContractService;
import by.iteen.service.GroupService;
import by.iteen.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ErrorController {

    @GetMapping(path = "/error/1")
    public String showFormChild() {
        return "error";
    }

}
