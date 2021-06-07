package by.iteen.controller;

import by.iteen.entity.Group;
import by.iteen.service.CourseService;
import by.iteen.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ShowListGroupsController {

    private final GroupService groupService;
    private final CourseService courseService;

    @Autowired
    public  ShowListGroupsController(GroupService groupService, CourseService courseService) {
        this.groupService = groupService;
        this.courseService = courseService;
    }

    @ModelAttribute("groups")
    public List<Group> groups() {
        return groupService.findAll();
    }

    @GetMapping("/show/groups")
    public String showFormChild() {
        return "showListGroups";
    }

    @PostMapping("/show/groups")
    public String addChild() {
        return "showListGroups";
    }


}
