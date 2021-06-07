package by.iteen.dao;

import by.iteen.dao.common.BaseTest;
import by.iteen.entity.Course;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class CourseDaoTest extends BaseTest {

    @Autowired
    private CourseDao courseDao;

    @Test
    public void аindByTitle() {
        Course course = new Course();
        course.setTitle("Java");

        courseDao.save(course);

        Course java = courseDao.findByTitle("Java");
        assertEquals(course, java);
    }

}
