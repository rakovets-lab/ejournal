package by.iteen.service;

import by.iteen.entity.Parent;

import java.util.List;

public interface ParentService {
    void save(Parent parent);

    List<Parent> findAll();

    Parent findById(Long id);

    void update(Parent parent);
}
