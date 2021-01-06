package com.display.time;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class display {
    @RequestMapping("/time")
    public String displayTime(Model model) {
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        String time = formatter.format(date);
        model.addAttribute("time",time );
        return "time.jsp";
    }
    @RequestMapping("")
    public String display(){
        return "display.jsp";
    }
    @RequestMapping("/date")
    public String displayDate(Model model){
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, yyyy");
        String newDate = formatter.format(date);
        model.addAttribute("date",newDate );
        return "date.jsp";
    }
}
