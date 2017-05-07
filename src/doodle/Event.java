package doodle;

import java.util.LinkedList;

/**
 * Created by Berkan on 24-Apr-17.
 */
public class Event {
    private String eventHostName;
    private String eventName;
    private String eventDescription;
    private String eventLocation;
    private String eventHostMail;
    private Boolean eventConfidentiality;
    private LinkedList<EventDateDetail> eventDateDetails;

    public Event(String eventHostName, String eventName, String eventDescription, String eventLocation, String eventHostMail, Boolean eventConfidentiality, LinkedList<EventDateDetail> eventDateDetails) {
        this.eventHostName = eventHostName;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventLocation = eventLocation;
        this.eventHostMail = eventHostMail;
        this.eventConfidentiality = eventConfidentiality;
        this.eventDateDetails = eventDateDetails;
    }

    public String getEventHostName() {
        return eventHostName;
    }

    public void setEventHostName(String eventHostName) {
        this.eventHostName = eventHostName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventHostMail() {
        return eventHostMail;
    }

    public void setEventHostMail(String eventHostMail) {
        this.eventHostMail = eventHostMail;
    }

    public Boolean getEventConfidentiality() {
        return eventConfidentiality;
    }

    public void setEventConfidentiality(Boolean eventConfidentiality) {
        this.eventConfidentiality = eventConfidentiality;
    }

    public LinkedList<EventDateDetail> getEventDateDetails() {
        return eventDateDetails;
    }

    public void setEventDateDetails(LinkedList<EventDateDetail> eventDateDetails) {
        this.eventDateDetails = eventDateDetails;
    }

    public void printEventDetails(){
        System.out.println("Event details");
        System.out.println(getEventName() + " " + getEventDescription() + " " + getEventLocation() + " " + getEventHostName() + " " + getEventHostMail());
        for (int i = 0; i<getEventDateDetails().size(); i++) {
            System.out.println("Session " + (i+1) + ":" + getEventDateDetails().get(i).getEventDate());
        }
        if (!getEventConfidentiality()){
            for (int i = 0; i<getEventDateDetails().size(); i++) {
                if (getEventDateDetails().get(i).getParticipantPerEventSession()<=0){
                    System.out.println("Session " + (i+1) + ": No session cap");
                } else {
                    System.out.println("Session " + (i+1) + ":" + getEventDateDetails().get(i).getParticipantPerEventSession());
                }
                System.out.println("Current attendies: " + getEventDateDetails().get(i).getCurrentParticipantNumber());
            }
        }
    }
}
