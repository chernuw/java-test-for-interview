package net.itspartner.test.n7;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;


@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public Map<String, String> hello() {
        return Collections.singletonMap("message",  "Hello, ITS Partner");
    }

}
