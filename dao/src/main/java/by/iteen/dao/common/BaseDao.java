package by.iteen.dao.common;

import by.iteen.entity.BaseEntity;
import java.util.List;

public interface BaseDao<T extends BaseEntity> {

    void save(T entity);

    void delete(T entity);

    void update(T entity);

    T findOne(Long id);

    List<T> findAll();
}
