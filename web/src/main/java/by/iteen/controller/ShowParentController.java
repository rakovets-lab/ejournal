package by.iteen.controller;

import by.iteen.entity.Parent;
import by.iteen.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShowParentController {

    private final ParentService parentService;

    @Autowired
    public ShowParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @ModelAttribute("parent")
    public Parent parent(@PathVariable("id") Long id) {
        return parentService.findById(id);
    }

    @GetMapping("/show/parent/{id}")
    public String showParent(@PathVariable("id") String id) {
        return "showParent";
    }

}
