package by.iteen.controller;

import by.iteen.entity.Group;
import by.iteen.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddGroupController {

    private final GroupService groupService;

    @Autowired
    public AddGroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @ModelAttribute("group")
    public Group group() {
        return new Group();
    }

    @GetMapping("/add/group")
    public String showFormChild() {
        return "addGroup";
    }

    @PostMapping("/add/group")
    public String addChild(Group group) {
        groupService.save(group);
        return "addGroup";
    }

}
