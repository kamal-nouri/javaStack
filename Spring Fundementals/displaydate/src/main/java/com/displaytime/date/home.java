package com.displaytime.date;

import com.fasterxml.jackson.databind.Module;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class home {
    @RequestMapping("/")
    public String display(){
        
        return "home.jsp";
    }
    @RequestMapping("/time")
    public String displayTime(Module model){
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, yyyy");
        model.addAttribute("Date", formatter.format(date));
        return "time.jsp";
    }
    @RequestMapping("/date")
    public String displayDate(Module model){
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        model.addExports();
        return "date.jsp";
    }
}
