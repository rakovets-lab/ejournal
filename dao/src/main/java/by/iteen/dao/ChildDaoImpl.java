package by.iteen.dao;

import by.iteen.dao.common.BaseDaoImpl;
import by.iteen.entity.Child;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChildDaoImpl extends BaseDaoImpl<Child> implements ChildDao {

    @Override
    public List<Child> findByGroupId(Long id) {
        List<Child> children = getSessionFactory().getCurrentSession().createQuery("SELECT c FROM Child c WHERE c.group.id=:id")
                .setParameter("id", id)
                .getResultList();
        return children;
    }
}
