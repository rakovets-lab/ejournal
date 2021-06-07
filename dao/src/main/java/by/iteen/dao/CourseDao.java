package by.iteen.dao;

import by.iteen.dao.common.BaseDao;
import by.iteen.entity.Course;

import java.util.List;

public interface CourseDao extends BaseDao<Course> {

    Course findByTitle(String title);

}
