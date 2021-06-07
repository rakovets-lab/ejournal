package by.iteen.service;

import by.iteen.dao.ChildDao;
import by.iteen.entity.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ChildServiceImpl implements ChildService {

    private final ChildDao childDao;

    @Autowired
    public ChildServiceImpl(ChildDao childDao) {
        this.childDao = childDao;
    }

    @Override
    public void save(Child child) {
        childDao.save(child);
    }

    @Override
    public List<Child> findAll() {
        return childDao.findAll();
    }

    @Override
    public List<Child> findByGroupId(Long id) {
        return childDao.findByGroupId(id);
    }
}
