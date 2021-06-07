package by.iteen.service;

import by.iteen.entity.Teacher;

import java.util.List;

public interface TeacherService {
    void save(Teacher teacher);

    List<Teacher> findAll();

    Teacher findById(Long id);
}
