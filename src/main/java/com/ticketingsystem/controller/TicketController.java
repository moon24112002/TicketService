package com.ticketingsystem.controller;

import com.ticketingsystem.entity.Ticket;
import com.ticketingsystem.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    ITicketService _ticketService;

    @PostMapping()
    public String createTicket(@RequestBody Ticket ticket){
       var res =  _ticketService.createTicket(ticket);
       return res.getToken()+"";
    }

    @GetMapping("/{tokenId}")
    public Ticket findTicketByToken(@PathVariable String tokenId){
       return  _ticketService.findTicketByToken(Integer.parseInt(tokenId));
    }

    @GetMapping()
    public List<Ticket> getAllTicket(){
       return  _ticketService.findAllTicket();
    }

    @GetMapping("/state/{tokenId}")
    public String tokenStatus(@PathVariable String tokenId){
       return _ticketService.TicketStatus(Integer.parseInt(tokenId));
    }
}
