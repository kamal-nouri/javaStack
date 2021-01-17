package com.overflow.dojjo.controllers;

import com.overflow.dojjo.models.Answer;
import com.overflow.dojjo.models.Question;
import com.overflow.dojjo.models.Tag;
import com.overflow.dojjo.services.OverFlowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OverFlowController {
    private final OverFlowService overFlowService;

    public OverFlowController(OverFlowService overFlowService) {
        this.overFlowService = overFlowService;
    }
    @RequestMapping("/questions")
    public String main(Model model) {
        List<Question> questions = overFlowService.allQuestions();
        model.addAttribute("questions", questions);
        return "dash.jsp";
    }
    @RequestMapping("/questions/new")
    public String newQuestion(@ModelAttribute("questions") Question question,@ModelAttribute("tag") Tag tag) {
        return "newquestion.jsp";
    }

    @RequestMapping(value = "/addquestions", method = RequestMethod.POST)
    public String createQuestion(@Valid @ModelAttribute("questions") Question question,@Valid @ModelAttribute("tag") Tag tag, BindingResult result) {
        if (result.hasErrors()) {
            return "newquestion.jsp";
        } else {
            Question question1 = overFlowService.addQuestion(question,tag);
            return "redirect:/questions";
        }
    }
    @RequestMapping("/questions/{id}")
    public String show(Model model, @PathVariable("id")Long id, @ModelAttribute("answers")Answer answer){
        Question question=overFlowService.findQuestion(id);
        model.addAttribute("question",question);
        return "show.jsp";
    }
    @RequestMapping(value = "/questions/{id}", method = RequestMethod.POST)
    public String createAnswer(@Valid @ModelAttribute("answers") Answer answer, BindingResult result,@PathVariable("id")Long id) {
        if (result.hasErrors()) {
            return "newanswer.jsp";
        } else {
//            Question question=overFlowService.findQuestion(id);
//            Answer ans=new Answer(answer.getAnswer(),question);
//            Answer answer1 = overFlowService.createAnswer(ans);
            overFlowService.createQuestionAnswer(id,answer);
            return "redirect:/questions/"+id;
        }
    }


}
