package by.iteen.service;

import by.iteen.dao.ChildDao;
import by.iteen.entity.Child;
import by.iteen.entity.Contract;
import by.iteen.entity.Group;
import by.iteen.entity.Parent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class ChildServiceTest extends BaseServiceTest {

    @Autowired
    private ChildService childService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private ParentService parentService;

    @Autowired
    private ChildDao childDao;


    @Test
    public void findByGroupId() {
        Group group1 = new Group();
        group1.setTitle("Java");
        groupService.save(group1);

        Group group2 = new Group();
        group2.setTitle("C++");
        groupService.save(group2);

        Contract contract = new Contract();
        contract.setTitle("contract");
        contractService.save(contract);

        Parent parent = new Parent();
        parent.setLastName("124");
        parentService.save(parent);

        for (int i = 0; i < 6; i++) {
            Child child = new Child();
            child.setFirstName("Ребенок " + i);
            child.setContract(contract);
            child.setParent(parent);
            child.setGroup(((i % 2) == 0) ? group1 : group2);
            childService.save(child);
        }
        assertEquals(3, childService.findByGroupId(1L).size());
    }

    @Test
    public void save() {
        Group group1 = new Group();
        group1.setTitle("Java");
        groupService.save(group1);

        Contract contract = new Contract();
        contract.setTitle("contract");
        contractService.save(contract);

        Parent parent = new Parent();
        parent.setLastName("124");
        parentService.save(parent);

        Child child = new Child();
        child.setFirstName("Ребенок ");
        child.setContract(contract);
        child.setParent(parent);
        child.setGroup(group1);

        childService.save(child);

        assertEquals(child, child);
    }

    @Test
    public void findAll() {
        Group group1 = new Group();
        group1.setTitle("Java");
        groupService.save(group1);

        Group group2 = new Group();
        group2.setTitle("C++");
        groupService.save(group2);

        Contract contract = new Contract();
        contract.setTitle("contract");
        contractService.save(contract);

        Parent parent = new Parent();
        parent.setLastName("124");
        parentService.save(parent);

        for (int i = 0; i < 6; i++) {
            Child child = new Child();
            child.setFirstName("Ребенок " + i);
            child.setContract(contract);
            child.setParent(parent);
            child.setGroup(((i % 2) == 0) ? group1 : group2);
            childService.save(child);
        }
        assertEquals(6, childService.findAll().size());
    }
}
