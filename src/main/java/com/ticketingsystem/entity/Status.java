package com.ticketingsystem.entity;

public enum Status {
    NEW("New"),
    IN_PROGRESS("In Progress"),
    RESOLVED("Resolved"),
    CLOSED("Closed");

    private final String displayName;
    Status(String state) {

        this.displayName = state;
    }
    public String getDisplayName() {
        return displayName;
    }
}

