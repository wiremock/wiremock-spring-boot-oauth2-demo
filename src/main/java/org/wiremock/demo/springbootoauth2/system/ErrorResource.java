package org.wiremock.demo.springbootoauth2.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorResource {

    @GetMapping("/error")
    public String getErrorPage() {
        return "error";
    }
}
