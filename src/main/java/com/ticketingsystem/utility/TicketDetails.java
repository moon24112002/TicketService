package com.ticketingsystem.utility;

import com.ticketingsystem.entity.User;

import java.util.List;
import java.util.UUID;

public class TicketDetails {
    public static List<User> list = List.of(new User(UUID.randomUUID().toString(),"Rachit","xyz@gmail.com"),
            new User(UUID.randomUUID().toString(),"Rachit","xyz@gmail.com"),
    new User(UUID.randomUUID().toString(),"Aurojit","xyz@gmail.com"),
            new User(UUID.randomUUID().toString(),"Anurag","xyz@gmail.com"),
            new User(UUID.randomUUID().toString(),"Abhisekh","xyz@gmail.com"),
            new User(UUID.randomUUID().toString(),"Satish","xyz@gmail.com"),
            new User(UUID.randomUUID().toString(),"Shahbaz","xyz@gmail.com"));

}
