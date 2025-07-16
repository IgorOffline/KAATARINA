package igoroffline.practice.kaatarina.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KaatarinaController {

    @GetMapping("/kaatarina/1")
    public String getKaatarina1() {
        return "fm-kaatarina-1";
    }
}
