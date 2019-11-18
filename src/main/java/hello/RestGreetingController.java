package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RestGreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greetingJSON")
    public GreetingJSON greetingJSON(@RequestParam(value = "name", defaultValue = "World") String name){
        return new GreetingJSON(counter.incrementAndGet(), String.format(template, name));
    }
}
