package by.iteen.service;


import by.iteen.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Edenmond on 7/11/2017.
 */
public interface UserService extends UserDetailsService {

    void save(User user);

    void update(User user);

    User findByName(String user);

    User findByEmail(String email);
}
