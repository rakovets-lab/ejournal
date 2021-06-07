package by.iteen.dao;

import by.iteen.dao.common.BaseTest;
import by.iteen.entity.Child;
import by.iteen.entity.Contract;
import by.iteen.entity.Group;
import by.iteen.entity.Parent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by Edenmond on 7/5/2017.
 */
public class ChildDaoTest extends BaseTest {

    @Autowired
    private ChildDao childDao;

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private ParentDao parentDao;

    @Test
    public void findByGroupId() {
        Group group1 = new Group();
        group1.setTitle("Java");
        groupDao.save(group1);


        Group group2 = new Group();
        group2.setTitle("C++");
        groupDao.save(group2);

        Contract contract = new Contract();
        contract.setTitle("contract");
        contractDao.save(contract);

        Parent parent = new Parent();
        parent.setLastName("124");
        parentDao.save(parent);

        for (int i = 0; i < 6; i++) {
            Child child = new Child();
            child.setFirstName("Ребенок " + i);
            child.setContract(contract);
            child.setParent(parent);
            child.setGroup(((i % 2) == 0) ? group1 : group2);
            childDao.save(child);
        }
        assertEquals(3, childDao.findByGroupId(1L).size());
    }
}
