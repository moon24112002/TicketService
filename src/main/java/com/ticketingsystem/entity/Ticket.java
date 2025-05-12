package com.ticketingsystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    private String id;
    private int token;
    private String name;
    private String email;
    private String message;

}
