package by.iteen.service;

import by.iteen.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class UserServiceTest extends BaseServiceTest{

    @Autowired
    private UserService userService;

    @Test
    public void save() {
        User user = new User();
        user.setFirstName("ygadhsh");
        userService.save(user);

        assertEquals(user, userService.findByName("ygadhsh"));
    }

    @Test
    public void findByName() {
        User user = new User();
        user.setFirstName("ygadhsh");
        userService.save(user);

        assertEquals(user, userService.findByName("ygadhsh"));
    }

    @Test
    public void update() {
        User user = new User();
        user.setFirstName("ygadhsh");
        userService.save(user);
        user.setEmail("dfgdfg");
        userService.update(user);
        assertEquals(user.getEmail(), userService.findByName("ygadhsh").getEmail());
    }
}
