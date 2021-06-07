package by.iteen.service;

import by.iteen.entity.Group;

import java.util.List;

public interface GroupService {
    void save(Group group);

    List<Group> findAll();

    Group findById(Long id);
}
