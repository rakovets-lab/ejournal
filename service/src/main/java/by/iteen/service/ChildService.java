package by.iteen.service;

import by.iteen.entity.Child;

import java.util.List;

public interface ChildService {

    void save(Child child);

    List<Child> findAll();

    List<Child> findByGroupId(Long id);
}
