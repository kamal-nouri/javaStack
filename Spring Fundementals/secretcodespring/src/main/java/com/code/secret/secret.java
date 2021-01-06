package com.code.secret;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class secret {
    @RequestMapping("")
    public String main() {
        return "main.jsp";
    }

    @RequestMapping(value = "/code", method = RequestMethod.POST)
    public String secret(@RequestParam(value = "code") String code) {
        if (code.equals("kamal")) {
            return "redirect:/test";
        } else {
            return "redirect:/createError";
        }
    }
    @RequestMapping("/test")
    public String test(){
        return "code.jsp";
    }
    @RequestMapping("/createError")
    public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "You can do BETTER!");
        return "redirect:/";
    }
}
