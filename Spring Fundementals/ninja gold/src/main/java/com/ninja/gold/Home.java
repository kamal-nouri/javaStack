package com.ninja.gold;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
public class Home {
    @RequestMapping("")
    public String main(HttpSession session){
        if(session.isNew()) {
            session.setAttribute("gold", 0);
            session.setAttribute("result", "");
            session.setAttribute("lose", "");
            return "redirect:/";
        }
        else return "index.jsp";
    }
    @RequestMapping(value = "/process_money",method = RequestMethod.POST)
    public String process(@RequestParam String which_form, HttpSession session){
        if(which_form.equals("farm")) {
            Random r = new Random();
            int Gold = r.nextInt(20 - 10) + 10;
            String farm = (String) session.getAttribute("result");
            farm = farm + "You entered a farm and earned " + Gold + " gold (" + new java.util.Date() +")"+"<br/>";
            session.setAttribute("result", farm);
            Gold += (int) session.getAttribute("gold");
            session.setAttribute("gold", Gold);
        }
        if(which_form.equals("cave")) {
            Random r = new Random();
            int Gold = r.nextInt(10 - 5) + 5;
            String cave = (String) session.getAttribute("result");
            cave = cave + "You entered a cave and earned " + Gold + " gold (" + new java.util.Date() +")"+"<br/>";
            session.setAttribute("result", cave);
            Gold += (int) session.getAttribute("gold");
            session.setAttribute("gold", Gold);
        }
        if(which_form.equals("house")) {
            Random r = new Random();
            int Gold = r.nextInt(5- 2) + 2;
            String house = (String) session.getAttribute("result");
            house = house + "You entered a house and earned " + Gold + " gold (" + new java.util.Date() +")"+"<br/>";
            session.setAttribute("result", house);
            Gold += (int) session.getAttribute("gold");
            session.setAttribute("gold", Gold);
        }
        if(which_form.equals("casino")) {
            Random r = new Random();
            int Gold = r.nextInt(50) * (r .nextBoolean() ? -1 : 1);
            if (Gold>0) {
                String casino = (String) session.getAttribute("result");
                casino = casino + "You entered a Casino and earned " + Gold + " gold (" + new java.util.Date() + ")" + "<br/>";
                session.setAttribute("result", casino);
            }
            else{
                String casino = (String) session.getAttribute("result");
                casino = casino + "<span>You entered a casino and lost " + Gold*-1 + " gold..Ouch. (" + new java.util.Date() + ")" + "<br/></span>";
                session.setAttribute("result", casino);
            }
            Gold += (int) session.getAttribute("gold");
            session.setAttribute("gold", Gold);
        }
        if(which_form.equals("spa")) {
            Random r = new Random();
            int Gold = (r.nextInt(20- 5) + 5)*-1;
            String spa = (String) session.getAttribute("result");
            spa = spa + "<span>You entered a spa and lost " + Gold + " gold..Ouch. (" + new java.util.Date() + ")" + "<br/></span>";
            session.setAttribute("result", spa);
            Gold += (int) session.getAttribute("gold");
            session.setAttribute("gold", Gold);
        }
        if((int)session.getAttribute("gold")<0){
            return "prison.jsp";
        }
        return "redirect:/";
    }
    @RequestMapping("/destroy")
    public String destroy(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
