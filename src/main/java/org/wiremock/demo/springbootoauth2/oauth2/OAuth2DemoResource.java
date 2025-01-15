package org.wiremock.demo.springbootoauth2.oauth2;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class OAuth2DemoResource {

    @GetMapping("/user")
    public ModelAndView getUserInfo(@AuthenticationPrincipal OAuth2User user) {
        ModelAndView modelAndView = new ModelAndView("userinfo");
        modelAndView.addObject("user", Map.of(
                "email", user.getAttribute("email"),
                "id", user.getAttribute("sub")
        ));

        return modelAndView;
    }

    @GetMapping("/login")
    public String getSsoPage(Model model) {
        return "login";
    }
}
