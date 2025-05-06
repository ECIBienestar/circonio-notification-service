package com.notification.event;

import com.notification.model.Notification;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class NotificationEvent extends RemoteApplicationEvent {

    private Notification notification;

    public NotificationEvent() {}

    public NotificationEvent(Object source, String originService, String destinationService, Notification notification) {
        super(source, originService, destinationService);
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
