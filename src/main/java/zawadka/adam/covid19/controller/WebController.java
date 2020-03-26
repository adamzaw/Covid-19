package zawadka.adam.covid19.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
@GetMapping("/www/")
public String home(){

    return "home";
}

}
