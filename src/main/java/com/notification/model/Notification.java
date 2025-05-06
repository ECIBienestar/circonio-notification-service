package com.notification.model;

public class Notification {
    private String recipient;
    private String message;
    private NotificationChannel channel;

    public Notification(String recipient, String message, NotificationChannel channel) {
        this.recipient = recipient;
        this.message = message;
        this.channel = channel;
    }

    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public NotificationChannel getChannel() { return channel; }
    public void setChannel(NotificationChannel channel) { this.channel = channel; }
}