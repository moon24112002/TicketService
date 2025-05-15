package com.ticketingsystem.service;

import com.ticketingsystem.entity.Ticket;

import java.util.List;

public interface ITicketService {
    Ticket createTicket(Ticket ticket);
    Ticket findTicketById(String id);
    Ticket findTicketByToken(int token);
    List<Ticket> findAllTicket();
    String TicketStatus(int token);
}
