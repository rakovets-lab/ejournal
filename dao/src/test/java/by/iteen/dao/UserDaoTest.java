package by.iteen.dao;

import by.iteen.dao.common.BaseTest;
import by.iteen.entity.Role;
import by.iteen.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindByEmail() {
        User user = new User();
        user.setEmail("ivanov@gmail.com");
        user.setPassword("ivanov");
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setMobile("+375291111111");
        user.setRole(Role.METHODIST);

        userDao.save(user);

        User ivan = userDao.findByEmail("ivanov@gmail.com");

        assertEquals(ivan, user);
    }

    @Test
    public void testFindByName() {
        User user = new User();
        user.setEmail("ivanov@gmail.com");
        user.setPassword("ivanov");
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setMobile("+375291111111");
        user.setRole(Role.METHODIST);

        userDao.save(user);

        User ivan = userDao.findByName("Ivan");

        assertEquals(ivan, user);
    }
}
