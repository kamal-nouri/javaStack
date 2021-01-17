package com.overflow.dojjo.services;

import com.overflow.dojjo.models.Answer;
import com.overflow.dojjo.models.Question;
import com.overflow.dojjo.models.Tag;
import com.overflow.dojjo.repositories.AnswerRepository;
import com.overflow.dojjo.repositories.QuestionRepository;
import com.overflow.dojjo.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class OverFlowService {
    private final AnswerRepository answerRepository;
    private final TagRepository tagRepository;
    private final QuestionRepository questionRepository;

    public OverFlowService(AnswerRepository answerRepository, TagRepository tagRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.tagRepository = tagRepository;
        this.questionRepository = questionRepository;
    }

    public List<Answer> allAnswers() {
        return answerRepository.findAll();
    }

    public List<Tag> allTags() {
        return tagRepository.findAll();
    }

    public List<Question> allQuestions() {
        return questionRepository.findAll();
    }

    public Answer findAnswer(Long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (optionalAnswer.isPresent()) {
            return optionalAnswer.get();
        } else {
            return null;
        }
    }

    public Tag findTag(Long id) {
        Optional<Tag> optionalTag = tagRepository.findById(id);
        if (optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return null;
        }
    }

    public Question findQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    }

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }
    public void createQuestionAnswer(Long id,Answer answer){
        Question question = questionRepository.findById(id).orElse(null);
        Answer ans=new Answer(answer.getAnswer(),question);
        answerRepository.save(ans);

    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }
    public Question addQuestion(Question question,Tag tag){
    Question newQuestion=questionRepository.save(question);
    String[] newTags=tag.getSubject().split(",");
    List<Tag> tags=tagRepository.findAll();
    ArrayList<Tag> questionTags =new ArrayList<>();
        for(String subject:newTags){
            if(subject.length()!=0){
                Tag findTag=tagRepository.findBySubject(subject);
                if(findTag==null){
                    findTag=new Tag(subject);
                    tagRepository.save(findTag);
                }
                questionTags.add(findTag);
            }
        }
        question.setTags(questionTags);
        questionRepository.save(question);
    return question;
    }

}
