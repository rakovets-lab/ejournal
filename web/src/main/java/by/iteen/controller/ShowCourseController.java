package by.iteen.controller;

import by.iteen.entity.Course;
import by.iteen.entity.Theme;
import by.iteen.service.CourseService;
import by.iteen.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShowCourseController {

    private final ThemeService themeService;
    private final CourseService courseService;

    @Autowired
    public ShowCourseController(ThemeService themeService, CourseService courseService) {
        this.themeService = themeService;
        this.courseService = courseService;
    }

    @ModelAttribute("course")
    public Course course(@PathVariable("title") String title) {
        return courseService.findByTitle(title);
    }

    @ModelAttribute("themes")
    public List<Theme> themes(@PathVariable("title") String title, @RequestParam("page") int page) {
        return themeService.findPageByCourseId(courseService.findByTitle(title).getId(), page, 7);
    }

    @GetMapping(path = "/show/course/{title}")
    public String showCoursePage(@PathVariable("title") String title, @RequestParam("page") int page, Model model) {
        int sizePage = 7;
        model.addAttribute("page", page);
        model.addAttribute("sizePage", sizePage);
        model.addAttribute("countPage", (int)Math.ceil(themeService.countByCourseId(courseService.findByTitle(title).getId()) / (double)sizePage));
        return "showCourse";
    }

}
