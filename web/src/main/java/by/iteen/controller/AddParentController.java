package by.iteen.controller;

import by.iteen.entity.Address;
import by.iteen.entity.Parent;
import by.iteen.entity.Role;
import by.iteen.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddParentController {

    private final ParentService parentService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AddParentController(ParentService parentService, PasswordEncoder passwordEncoder) {
        this.parentService = parentService;
        this.passwordEncoder = passwordEncoder;
    }

    @ModelAttribute("parent")
    public Parent parent() {
        return new Parent();
    }

    @ModelAttribute("currentParent")
    public Parent currentParent(@PathVariable("id") Long id) {
        return parentService.findById(id);
    }

    @ModelAttribute("address")
    public Address address() {
        return new Address();
    }

    @GetMapping("/add/parent/{id}")
    public String add(@PathVariable("id") String id) {
        return "addParent";
    }

    @PostMapping("/add/parent/{id}")
    public String add(Parent parent, @PathVariable("id") String id) {
        parent.setRole(Role.PARENT);
        parent.setPassword(passwordEncoder.encode(parent.getPassword()));
        parentService.save(parent);
        return "addParent";
    }

    @GetMapping(path = "/update/parent/{id}")
    public String upgrade(@PathVariable("id") Long id, Model model) {
        return "updateParent";
    }

    @PostMapping(path = "/update/parent/{id}")
    public String upgrade(Parent parent, @PathVariable("id") Long id) throws Exception {
        parent.setRole(Role.PARENT);
        parent.setPassword(passwordEncoder.encode(parent.getPassword()));
        try {
            parentService.update(parent);
        } catch (HibernateOptimisticLockingFailureException error){
            return "redirect:/error/1";
        }
        return "redirect:/show/parent/" + id;
    }

}
