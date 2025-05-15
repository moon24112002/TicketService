package com.ticketingsystem.controller;


import com.ticketingsystem.entity.User;
import com.ticketingsystem.utility.TicketDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public List<User> getAllUser(){
        return TicketDetails.list;
    }
}
