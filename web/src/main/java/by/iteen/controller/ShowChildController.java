package by.iteen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowChildController {

    @GetMapping("/show/child/{id}")
    public String showFormChild() {
        return "showChild";
    }

}
