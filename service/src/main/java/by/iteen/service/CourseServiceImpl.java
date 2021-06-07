package by.iteen.service;

import by.iteen.dao.CourseDao;
import by.iteen.dao.CourseDaoImpl;
import by.iteen.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public Course findByTitle(String title) {
        return courseDao.findByTitle(title);
    }

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }
}
