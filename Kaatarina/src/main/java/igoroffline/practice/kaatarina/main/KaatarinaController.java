package igoroffline.practice.kaatarina.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KaatarinaController {

    @GetMapping("/sunshine")
    public String getSunshine() {
        return "fm-sunshine";
    }
}
