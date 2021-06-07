package by.iteen.controller;

import by.iteen.entity.Parent;
import by.iteen.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ShowListParentsController {

    private final ParentService parentService;

    @Autowired
    public ShowListParentsController(ParentService parentService) {
        this.parentService = parentService;
    }

    @ModelAttribute("parents")
    public List<Parent> parents() {
        return parentService.findAll();
    }

    @GetMapping("/show/parents")
    public String showFormChild() {
        return "showListParents";
    }

}
