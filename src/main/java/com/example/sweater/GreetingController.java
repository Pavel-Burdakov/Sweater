package com.example.sweater;

import com.example.sweater.domain.Message;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String main(Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model){
        // первым шагом сохранили, нотация @RequestParam выдергивает сообщение из формы если мы передаем
        // с помощью post или из URL строки запроса
        Message message = new Message(text, tag);
        messageRepo.save(message);
        // вторым шагом получили и отдали пользователю
        /*Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);*/
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Message> messageList;
        if (filter !=null && !filter.isEmpty()){
            messageList =  messageRepo.findByTag(filter);
        } else {
            messageList = messageRepo.findAll();
        }

        model.put("messages", messageList);
        return "main";
    }


}
