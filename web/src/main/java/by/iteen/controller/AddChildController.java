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
public class AddChildController {

    private final ChildService childService;
    private final GroupService groupService;
    private final ParentService parentService;
    private final PasswordEncoder passwordEncoder;
    private final ContractService contractService;

    @Autowired
    public AddChildController(ChildService childService, GroupService groupService, ParentService parentService, PasswordEncoder passwordEncoder, ContractService contractService) {
        this.childService = childService;
        this.groupService = groupService;
        this.parentService = parentService;
        this.passwordEncoder = passwordEncoder;
        this.contractService = contractService;
    }

    @ModelAttribute("child")
    public Child child() {
        return new Child();
    }

    @ModelAttribute("parents")
    public List<Parent> parents() {
        return parentService.findAll();
    }

    @ModelAttribute("groups")
    public List<Group> groups() {
        return groupService.findAll();
    }

    @GetMapping(path = "/add/child")
    public String showFormChild() {
        return "addChild";
    }

    @PostMapping(path = "/add/child")
    public String addChild(Child child) {
        Contract contract = new Contract();
        contract.setTitle(LocalDate.now().getMonth().toString() + LocalDate.now().getDayOfMonth() + Math.random()*1000000);
        contract.setExpiryDate(LocalDate.now());
        contract.setConclusionDate(LocalDate.now().plusYears(1L));
        contractService.save(contract);
        child.getParent().setVersion(0L);
        child.setRole(Role.CHILD);
        child.setContract(contract);
        child.setPassword(passwordEncoder.encode(child.getPassword()));

        childService.save(child);
        return "addChild";
    }

}
