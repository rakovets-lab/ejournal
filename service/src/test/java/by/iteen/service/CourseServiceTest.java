package by.iteen.service;

import by.iteen.dao.CourseDao;
import by.iteen.entity.Course;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class CourseServiceTest extends BaseServiceTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseDao courseDao;

    @Test
    public void findByTitle() {
        Course course = new Course();
        course.setTitle("Java");
        courseDao.save(course);
        assertEquals(courseService.findByTitle("Java"), course);
    }

    @Test
    public void findAll() {
        for (int i = 0; i < 6; i++) {
            Course course = new Course();
            course.setTitle("" + i);
            courseDao.save(course);
        }
        assertEquals(6, courseService.findAll().size());
    }
}
