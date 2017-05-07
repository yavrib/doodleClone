package doodle;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.xml.stream.Location;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Berkan on 24-Apr-17.
 */
public class Main {
    private static LinkedList<Event> events = new LinkedList<>();
    public static void main(String[] args){
        String exitPrompt = new String();
        Boolean fillDummyData = Boolean.TRUE;
        try{fillDummyData(fillDummyData);}
        catch (ParseException e){

        }


        System.out.println("Welcome to Doodle");
        System.out.println("Please choose one of three options below");
        System.out.println("1. Create an event");
        //System.out.println("2. Edit existing event");
        System.out.println("2. Participate/view events");
        System.out.println("3. Terminate the program.");

        Scanner scan = new Scanner(System.in);

        String options = scan.nextLine();


        if (options.equals("1")) {
            Date pickedDate = new Date();
            Integer participantNumberInteger = new Integer(-1);
            Boolean participantNumberCheck = new Boolean(Boolean.FALSE);
            LinkedList<EventDateDetail> eventDetails = new LinkedList<>();

            System.out.println("We need some information about your event. Please fill the fields as requested.");
            System.out.println("Enter event name");
            String eventName = scan.nextLine();


            System.out.println("Enter event description");
            String eventDescription = scan.nextLine();


            System.out.println("Enter your name");
            String eventHostName = scan.nextLine();


            System.out.println("Enter event location");
            String eventLocation = scan.nextLine();


            System.out.println("Enter your email");
            String eventHostEmail = scan.nextLine();


            String dateRepeatFlag = "yes";
            Integer eventSessionCount = 0;

            while(dateRepeatFlag.toUpperCase().equals("YES")){
                System.out.println("Enter your event time with dd/MM/yyyy");
                String eventDate = scan.nextLine();

                String hourRepeatFlag = "yes";
                while(hourRepeatFlag.toUpperCase().equals("YES")){
                    eventSessionCount = eventSessionCount + 1;
                    System.out.println("Enter your event time with HH:mm");
                    eventDate = eventDate.substring(0, "dd/MM/yyyy".length()) + " " + scan.nextLine();
                    try {
                        pickedDate = eventDatePicker(eventDate, "dd/MM/yyyy HH:mm");
                    } catch (ParseException e){
                        e.printStackTrace();
                    }
                    System.out.println("Would you like to limit participant number?");
                    String participantNumberFlag = scan.nextLine();

                    participantNumberCheck = new Boolean(Boolean.FALSE);
                    if (participantNumberFlag.toUpperCase().equals("YES")){
                        participantNumberCheck = new Boolean(Boolean.TRUE);
                        System.out.println("What is the cap of the participants?");
                        participantNumberInteger = Integer.parseInt(scan.nextLine());
                    }
                    EventDateDetail edd = new EventDateDetail(pickedDate, participantNumberInteger, eventSessionCount, participantNumberCheck, 0);
                    System.out.println(edd);
                    eventDetails.add(edd);
                    System.out.println("Would you like to add another time?");
                    hourRepeatFlag = scan.nextLine();

                }
                System.out.println("Would you like to add another date?");
                dateRepeatFlag = scan.nextLine();

            }

            System.out.println("Will others be able to see other participants?");
            String eventConfidential = scan.nextLine().toUpperCase();
            Boolean eventConfidentialBoolean = new Boolean(Boolean.FALSE);
            if(eventConfidential.equals("YES")){
                eventConfidentialBoolean = new Boolean(Boolean.TRUE);
            }
            Event event = createEvent(eventHostName, eventName, eventDescription, eventLocation, eventHostEmail, eventDetails, eventConfidentialBoolean);
            //System.out.println(event);
            events.add(event);
            System.out.println(event.toString());
        } else if (options.equals("2")){
            Integer eventNumber = new Integer(0);
            System.out.println("Event Number | Event Name");
            for (Event event:events){
                eventNumber = eventNumber+1;
                System.out.println(eventNumber+"           "+event.getEventName());
            }
            System.out.println();
            System.out.println("Please select the event you would like to view by Event Number");
            System.out.println();
            System.out.println("Type \"exit\" to go back to main menu");
            String selection = scan.nextLine();
            if (!selection.equalsIgnoreCase("exit")){
                Event selectedEvent = events.get(Integer.parseInt(selection) - 1);
                selectedEvent.printEventDetails();
                System.out.println("Would you like to attend to this event?");
                String participantAnswer = scan.nextLine();
                String anotherSessionSelectionQuery = "yes";
                while(anotherSessionSelectionQuery.toUpperCase().equals("YES")) {
                    if (participantAnswer.equalsIgnoreCase("yes")) {
                        System.out.println("Which session would you like to join?");
                        String selectedSession = scan.nextLine();
                        Integer previousEventParticipants = selectedEvent.getEventDateDetails().get(Integer.parseInt(selectedSession) - 1).getCurrentParticipantNumber();
                        selectedEvent.getEventDateDetails().get(Integer.parseInt(selectedSession) - 1).setCurrentParticipantNumber(previousEventParticipants + 1);
                    }

                    System.out.println("Would you like to attend another session of this event?");
                    anotherSessionSelectionQuery = scan.nextLine();
                }
            }
            /*
            for (Event event:events){
                //TODO TEST THIS
                System.out.println(event.getEventDateDetails().get(0));
                System.out.println(event.getEventDateDetails().get(1));
            }
            */
        } else if (options.equals("3")){
            System.exit(0);
        }
        main(null);//repeats main
    }

    private static void fillDummyData(Boolean fillDummyData) throws ParseException {
        if (fillDummyData){
            LinkedList<EventDateDetail> dummyEventDetailList = new LinkedList();
            for (int i = 0; i<5; i++){
                dummyEventDetailList.add(new EventDateDetail(eventDatePicker("11/11/2011 1"+i+":00","dd/MM/yyyy HH:mm"),-1,i+1,Boolean.FALSE,i));
            }
            events.add(createEvent("Ali", "COME342", "Intorduction to software engineering", "DOU", "alicankabakulak@gmail.com", dummyEventDetailList, Boolean.FALSE));
        }
    }

    private static Event createEvent(String eventHostName, String eventName, String eventDescription, String eventLocation, String eventHostEmail, LinkedList<EventDateDetail> eventDetails, Boolean eventConfidentialBoolean) {
        Event newEvent = new Event(eventHostName, eventName, eventDescription, eventLocation, eventHostEmail, eventConfidentialBoolean, eventDetails);
        return newEvent;
    }

    private static Date eventDatePicker(String eventDate, String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(eventDate);
    }
}
