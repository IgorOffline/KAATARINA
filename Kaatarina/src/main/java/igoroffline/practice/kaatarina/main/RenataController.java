package igoroffline.practice.kaatarina.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RenataController {

    @GetMapping("/hello")
    public String getHelloo() {
        return "hello";
    }
}
