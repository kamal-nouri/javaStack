package com.swift.abdusalam.events.services;

import com.swift.abdusalam.events.models.Event;
import com.swift.abdusalam.events.models.Message;
import com.swift.abdusalam.events.models.User;
import com.swift.abdusalam.events.repositories.EventRepository;
import com.swift.abdusalam.events.repositories.MessageRepository;
import com.swift.abdusalam.events.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class EventsService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public EventsService(EventRepository eventRepository, UserRepository userRepository, MessageRepository messageRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }
    public Event createEvent(Event event,User planner){
        event.setPlanner(planner);
        Date date = event.getDate();
        SimpleDateFormat dateFormat=new SimpleDateFormat("MM dd,yyyy");
        dateFormat.format(date);
        event.setDate(date);
        return eventRepository.save(event);
    }
    public Event findEvent(Long id){
        Optional<Event> event =eventRepository.findById(id);
        if(event.isPresent()) {
            return event.get();
        } else {
            return null;
        }
    }
    public int countByJoinedUsers(Long id){

        Event event=eventRepository.findById(id).orElse(null);
//        return eventRepository.countJoinedUsersById(id);
        List<User> joinedUsers =event.getJoinedUsers();
        int count=0;
        for(int i=0;i<joinedUsers.size();i++){
            count++;
        }
        return count;
    }
    public void joinEvent(Long event_id,Long user_id){
        User user = userRepository.findById(user_id).orElse(null);
        Event event = eventRepository.findById(event_id).orElse(null);
        List<User> users = event.getJoinedUsers();
        users.add(user);
        event.setJoinedUsers(users);
        eventRepository.save(event);
    }
    public void cancelEvent(Long event_id,Long user_id){
        User user = userRepository.findById(user_id).orElse(null);
        Event event = eventRepository.findById(event_id).orElse(null);
        List<User> users = event.getJoinedUsers();
        users.remove(user);
        event.setJoinedUsers(users);
        eventRepository.save(event);
    }
    public void updateEvent(Event event){
        Event event1 = eventRepository.findById(event.getId()).orElse(null);
        assert event1 != null;
        event1.setName(event.getName());
        event1.setDate(event.getDate());
        event1.setLocation(event.getLocation());
        event1.setState(event.getState());
        eventRepository.save(event1);
    }

    public List<Event> allEventsWithState(String state){
        return eventRepository.findAllByState(state);
    }
    public List<Event> allEventsWithoutState(String state){
        return eventRepository.findByStateNot(state);
    }
    public void deleteEvent(Long id){
        Event event=eventRepository.findById(id).orElse(null);
        List<Message> messages = event.getMessages();
        List<User> users = event.getJoinedUsers();
        for(Message msg:messages){
            messageRepository.deleteById(msg.getId());
        }
        for(User usr:users){
            users.remove(usr);
        }
        eventRepository.deleteById(id);
    }
    public Message createMessage(Message message,Long event_id,Long user_id){
        User user = userRepository.findById(user_id).orElse(null);
        Event event = eventRepository.findById(event_id).orElse(null);
        return messageRepository.save(new Message(message.getComment(),user,event));
    }
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }

    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // find user by id
    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    // authenticate usercopy
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
