package doodle;

import java.util.Date;

/**
 * Created by Berkan on 24-Apr-17.
 */
public class EventDateDetail {
    private Date eventDate;
    private Integer participantPerEventSession;
    private Integer eventSession;
    private Boolean participantNumberCheck;
    private Integer currentParticipantNumber;



    public EventDateDetail(Date eventDate, Integer participantPerEventSession, Integer eventSession, Boolean participantNumberCheck, Integer currentParticipantNumber) {
        this.eventDate = eventDate;
        this.participantPerEventSession = participantPerEventSession;
        this.eventSession = eventSession;
        this.participantNumberCheck = participantNumberCheck;
        this.currentParticipantNumber = currentParticipantNumber;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getParticipantPerEventSession() {
        return participantPerEventSession;
    }

    public void setParticipantPerEventSession(Integer participantPerEventSession) {
        this.participantPerEventSession = participantPerEventSession;
    }

    public Integer getEventSession() {
        return eventSession;
    }

    public void setEventSession(Integer eventSession) {
        this.eventSession = eventSession;
    }

    public Boolean getParticipantNumberCheck() {
        return participantNumberCheck;
    }

    public void setParticipantNumberCheck(Boolean participantNumberCheck) {
        this.participantNumberCheck = participantNumberCheck;
    }

    public Integer getCurrentParticipantNumber() {
        return currentParticipantNumber;
    }

    public void setCurrentParticipantNumber(Integer currentParticipantNumber) {
        this.currentParticipantNumber = currentParticipantNumber;
    }
}
