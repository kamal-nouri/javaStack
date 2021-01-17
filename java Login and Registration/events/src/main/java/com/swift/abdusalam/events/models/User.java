package com.swift.abdusalam.events.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "([a-zA-Z]*){3,}",message = "First name must be letters and at least 3 characters")
    private String firstName;
    @Pattern(regexp = "([a-zA-Z]*){3,}",message = "Last name must be letters and at least 3 characters")
    private String lastName;
    @Email(message = "Email must be valid")
    @NotBlank(message = "Email must not be blank")
    private String email;
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "password must contain capital letter, small letter, numbers and at least 8 characters")
    private String password;
    @Transient
    private String passwordConfirmation;
    @NotBlank(message = "Location must not be empty")
    private String location;
    private String state;
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Message> messages;
    @OneToMany(mappedBy="planner", fetch = FetchType.LAZY)
    private List<Event> eventsPlanned;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_events",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> eventsJoined;
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    public User() {
    }

    public User(@Pattern(regexp = "([a-zA-Z]*){3,}", message = "First name must be letters and at least 3 characters") String firstName, @Pattern(regexp = "([a-zA-Z]*){3,}", message = "Last name must be letters and at least 3 characters") String lastName, @Email(message = "Email must be valid") @NotBlank(message = "Email must not be blank") String email, @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "password must contain capital letter, small letter, numbers and at least 8 characters") String password, String passwordConfirmation, @NotBlank(message = "Location must not be empty") String location, String state, List<Message> messages, List<Event> eventsPlanned, List<Event> eventsJoined) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.location = location;
        this.state = state;
        this.messages = messages;
        this.eventsPlanned = eventsPlanned;
        this.eventsJoined = eventsJoined;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Event> getEventsPlanned() {
        return eventsPlanned;
    }

    public void setEventsPlanned(List<Event> eventsPlanned) {
        this.eventsPlanned = eventsPlanned;
    }

    public List<Event> getEventsJoined() {
        return eventsJoined;
    }

    public void setEventsJoined(List<Event> eventsJoined) {
        this.eventsJoined = eventsJoined;
    }
}