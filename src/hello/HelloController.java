package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    String sayHello() {
        return "Hello";
    }
    @RequestMapping("/world")
    String sayWorld() {
        return "world";
    }
}
