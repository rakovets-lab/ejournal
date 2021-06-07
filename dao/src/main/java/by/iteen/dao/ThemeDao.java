package by.iteen.dao;

import by.iteen.dao.common.BaseDao;
import by.iteen.entity.Theme;

import java.util.List;

public interface ThemeDao extends BaseDao<Theme> {
    List<Theme> findAllByCourseId(Long id);

    List<Theme> findPageByCourseId(Long id, int page, int sizePage);

    int countByCourseId(Long id);
}
