package by.iteen.dao;

import by.iteen.dao.common.BaseDaoImpl;
import by.iteen.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao {

    @Override
    public Course findByTitle(String title) {
        List<Course> courses = getSessionFactory().getCurrentSession().createQuery(
                "SELECT c FROM Course c WHERE c.title=:title", Course.class)
                .setParameter("title", title)
                .getResultList();
        return courses.size() > 0 ? courses.get(0) : null;
    }
}
