package by.iteen.service;

import by.iteen.entity.Theme;

import java.util.List;

public interface ThemeService {

    void save(Theme theme);

    List<Theme> findAllByCourseId(Long id);

    List<Theme> findPageByCourseId(Long id, int page, int sizePage);

    int countByCourseId(Long id);

}
