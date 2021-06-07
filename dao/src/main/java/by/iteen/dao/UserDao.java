package by.iteen.dao;

import by.iteen.dao.common.BaseDao;
import by.iteen.entity.Role;
import by.iteen.entity.User;

public interface UserDao extends BaseDao<User> {

    User findByEmail(String email);

    User findByName(String name);

}
