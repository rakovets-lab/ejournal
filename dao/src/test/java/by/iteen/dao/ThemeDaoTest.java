package by.iteen.dao;

import by.iteen.dao.common.BaseTest;
import by.iteen.entity.Course;
import by.iteen.entity.Theme;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ThemeDaoTest extends BaseTest {

    @Autowired
    private ThemeDao themeDao;

    @Autowired
    private CourseDao courseDao;

    @Test
    public void testFindAllByCourseId() {

        Course course = new Course();
        course.setTitle("Java");
        courseDao.save(course);

        Theme theme = new Theme();
        theme.setTheme("Java");
        theme.setHomework("java/lesson1/homework1.pdf");
        theme.setCourse(courseDao.findByTitle("Java"));

        themeDao.save(theme);

        System.out.println(theme);
        System.out.println(themeDao.findAllByCourseId(1L).get(0));
        assertEquals(theme, themeDao.findAllByCourseId(1L).get(0));
    }

    @Test
    public void testCountByCourseId() {
        Course course = new Course();
        course.setTitle("Java");
        courseDao.save(course);

        Theme theme = new Theme();
        theme.setTheme("Java");
        theme.setHomework("java/lesson1/homework1.pdf");
        theme.setCourse(courseDao.findByTitle("Java"));
        themeDao.save(theme);

        assertEquals(themeDao.countByCourseId(1L), 1);
    }
}
