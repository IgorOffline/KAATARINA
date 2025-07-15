package igoroffline.practice.kaatarina.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KaatarinaController {

    @GetMapping("/hello")
    public String getHello() {
        return "fm-hello";
    }

    @GetMapping("/typaero")
    public String getTypaero() {
        return "fm-typaero";
    }
}
