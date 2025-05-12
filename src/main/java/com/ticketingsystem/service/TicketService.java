package com.ticketingsystem.service;

import com.ticketingsystem.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
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

        store.add(ticket);


        // mail service
        SimpleMailMessage mail= new SimpleMailMessage();
        mail.setTo(ticket.getEmail());
        String subject = "Token : "+token;
        mail.setSubject(subject);
        String text = "Hi " + ticket.getName() + ",\n\n" +
                "You have raised a ticket : " + token + "\n"+
                "For "+ticket.getMessage()+". \n"+
                "One of us will reach out to you soon.\n\n" +
                "Thanks and regards,\n" +
                "IT Help Desk";
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
}
