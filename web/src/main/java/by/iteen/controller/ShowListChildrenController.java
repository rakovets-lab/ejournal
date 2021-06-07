package by.iteen.controller;

import by.iteen.entity.Child;
import by.iteen.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ShowListChildrenController {

    private final ChildService childService;

    @Autowired
    public ShowListChildrenController(ChildService childService) {
        this.childService = childService;
    }

    @ModelAttribute("children")
    public List<Child> children() {
        return childService.findAll();
    }

    @GetMapping("/show/children")
    public String showFormChild() {
        return "showListChildren";
    }

    @PostMapping("/show/children")
    public String addChild() {
        return "showListChildren";
    }
}
