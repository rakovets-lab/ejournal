package by.iteen.service;

import by.iteen.entity.Group;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class GroupServiceTest extends BaseServiceTest {

    @Autowired
    private GroupService groupService;

    @Test
    public void testFindById() {
        Group group = new Group();
        group.setTitle("123");
        groupService.save(group);

        assertEquals(group, groupService.findById(1L));
    }
}
