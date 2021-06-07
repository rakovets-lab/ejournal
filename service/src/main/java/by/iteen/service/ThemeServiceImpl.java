package by.iteen.service;

import by.iteen.dao.ThemeDao;
import by.iteen.entity.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ThemeServiceImpl implements ThemeService {

    private final ThemeDao themeDao;

    @Autowired
    public ThemeServiceImpl(ThemeDao themeDao) {
        this.themeDao = themeDao;
    }

    @Override
    public void save(Theme theme) {
        themeDao.save(theme);
    }

    @Override
    public List<Theme> findAllByCourseId(Long id) {
        return themeDao.findAllByCourseId(id);
    }

    @Override
    public List<Theme> findPageByCourseId(Long id, int page, int sizePage) {
        return themeDao.findPageByCourseId(id, page, sizePage);
    }

    @Override
    public int countByCourseId(Long id) {
        return themeDao.countByCourseId(id);
    }
}
