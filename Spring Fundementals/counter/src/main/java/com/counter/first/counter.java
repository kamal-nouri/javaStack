package com.counter.first;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class counter {
    private int getSession(HttpSession count){
        Integer countValue=(Integer) count.getAttribute("count");
        if(countValue==null){
            setSession(count,0);
            countValue=(Integer)count.getAttribute("count");
        }
        return countValue;
    }
    private void setSession(HttpSession count,int val){
        count.setAttribute("count",val);
    }
    @RequestMapping("")
    public String home(HttpSession session){
        int value =getSession(session);
        setSession(session,++value);
        return "home.jsp";
    }
    @RequestMapping("/counter")
    public String Counter(HttpSession session, Model model) {
        model.addAttribute("count", getSession(session));
        return "counter.jsp";

    }
    @RequestMapping("/reset")
    public String reset(HttpSession session){
        session.invalidate();
        return "redirect:/counter";
    }
}
