package by.iteen.dao;

import by.iteen.dao.common.BaseDaoImpl;
import by.iteen.entity.Theme;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ThemeDaoImpl extends BaseDaoImpl<Theme> implements ThemeDao {

    @Override
    public List<Theme> findAllByCourseId(Long id) {
        List<Theme> themesCourse = getSessionFactory().getCurrentSession().createQuery(
                "SELECT t FROM Theme t WHERE t.course.id=:id", Theme.class)
                .setParameter("id", id)
                .getResultList();
        return themesCourse.size() > 0 ? themesCourse : null;
    }

    //По хорошему в базовый нужно вынести :)
    @Override
    public List<Theme> findPageByCourseId(Long id, int page, int sizePage) {
        List<Theme> themesCourse = getSessionFactory().getCurrentSession().createQuery(
                "SELECT t FROM Theme t WHERE t.course.id=:id", Theme.class)
                .setParameter("id", id)
                .setFirstResult(sizePage * (page - 1))
                .setMaxResults(sizePage)
                .getResultList();
        return themesCourse.size() > 0 ? themesCourse : null;
    }


    @Override
    public int countByCourseId(Long id) {
        return getSessionFactory().getCurrentSession().createQuery(
                "SELECT t FROM Theme t WHERE t.course.id=:id", Theme.class)
                .setParameter("id", id)
                .getResultList().size();
    }
}
