package by.iteen.controller;

import by.iteen.entity.Child;
import by.iteen.entity.Group;
import by.iteen.service.ChildService;
import by.iteen.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ShowGroupController {

    private final GroupService groupService;
    private final ChildService childService;

    @Autowired
    public ShowGroupController(GroupService groupService, ChildService childService) {
        this.groupService = groupService;
        this.childService = childService;
    }

    @ModelAttribute("children")
    public List<Child> children(@PathVariable("id") Long id) {
        return childService.findByGroupId(id);
    }

    @ModelAttribute("group")
    public Group group(@PathVariable("id") Long id) {
        return groupService.findById(id);
    }

    @GetMapping("/show/group/{id}")
    public String showGroup(@PathVariable("id") Long id) {
        return "showGroup";
    }

}
