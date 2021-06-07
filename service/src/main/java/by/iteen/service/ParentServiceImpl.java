package by.iteen.service;

import by.iteen.dao.ParentDao;
import by.iteen.entity.Parent;
import by.iteen.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ParentServiceImpl implements ParentService {

    private final ParentDao parentDao;

    @Autowired
    public ParentServiceImpl(ParentDao parentDao) {
        this.parentDao = parentDao;
    }

    @Override
    public void save(Parent parent) {
        parentDao.save(parent);
    }

    @Override
    public List<Parent> findAll() {
        return parentDao.findAll();
    }

    @Override
    public Parent findById(Long id) {
        return parentDao.findOne(id);
    }

    @Override
    public void update(Parent parent) {
        parentDao.update(parent);
    }
}
