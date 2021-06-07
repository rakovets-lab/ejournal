package by.iteen.dao;

import by.iteen.dao.common.BaseDao;
import by.iteen.entity.Child;

import java.util.List;

public interface ChildDao extends BaseDao<Child> {
    List<Child> findByGroupId(Long id);
}
