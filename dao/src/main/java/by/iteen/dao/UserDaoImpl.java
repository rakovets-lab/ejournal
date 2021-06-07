package by.iteen.dao;

import by.iteen.dao.common.BaseDaoImpl;
import by.iteen.entity.Role;
import by.iteen.entity.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User findByEmail(String email) {
        List<User> users = getSessionFactory().getCurrentSession().createQuery(
                "select u from User u where u.email=:email", User.class)
                .setParameter("email", email)
                .getResultList();
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public User findByName(String name) {
        List<User> users = getSessionFactory().getCurrentSession().createQuery(
                "select u from User u where u.firstName=:name", User.class)
                .setParameter("name", name)
                .getResultList();
        return users.size() > 0 ? users.get(0) : null;
    }

}
