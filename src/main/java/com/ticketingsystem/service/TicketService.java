package com.ticketingsystem.service;

import com.ticketingsystem.entity.Status;
import com.ticketingsystem.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TicketService implements ITicketService{
    static List<Ticket> store  = new ArrayList<>();
    @Autowired
    private JavaMailSender _javaMailSender;

    @Override
    public Ticket createTicket(Ticket ticket) {
        ticket.setId(UUID.randomUUID().toString());
        int token = ThreadLocalRandom.current().nextInt(1000, 10000);
        ticket.setToken(token);
        ticket.setState(Status.NEW.getDisplayName());
        ticket.setAssignedTo("Not assigned yet");

        store.add(ticket);

        // mail service
        SimpleMailMessage mail= new SimpleMailMessage();
        mail.setTo(ticket.getEmail());
        String subject = "Token : "+token;
        mail.setSubject(subject);
        String text =buildTicketMessage(ticket.getName(),ticket.getMessage(),ticket.getToken());
        mail.setText(text);
        _javaMailSender.send(mail);

        return ticket;
    }

    @Override
    public Ticket findTicketById(String id) {
        return null;
    }

    @Override
    public Ticket findTicketByToken(int token) {
        return store.stream().filter(item->item.getToken()==token).findFirst().orElse(null);
    }

    @Override
    public List<Ticket> findAllTicket() {
        return store;
    }

    @Override
    public String TicketStatus(int token) {
        return findTicketByToken(token).getState();
    }


    //private region
    public String buildTicketMessage(String name, String message,int token){
        StringBuilder sb = new StringBuilder();
        if (name != null && !name.trim().isEmpty()) {
            sb.append("Hi ").append(name).append(",\n\n");
        } else {
            sb.append("Hi,\n\n");
        }
        sb.append("You have raised a ticket: ").append(token).append("\n")
                .append("For ").append(message).append(".\n")
                .append("One of us will reach out to you soon.\n\n")
                .append("Thanks and regards,\n")
                .append("IT Help Desk");
        return sb.toString();
    }


}
