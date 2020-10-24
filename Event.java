import java.util.*;

public class Event {
   private String eventnavn;
   private double varighedTimer;
   private Virksomhed kunde;
   private boolean facilitator;
   private Person eventansvarlig;
   private boolean weekend;
   
   //Constructor 
   public Event(String enavn, double time, Virksomhed kunde, boolean faci, Person eansvar, boolean week) {
      eventnavn = enavn;
      varighedTimer = time;
      kunde = this.kunde;
      facilitator = faci;
      eventansvarlig = eansvar;
      weekend = week;
   }
   
   //Methods
   //Setters
   public static void udregnPris(double time) {
      int count = 0;
      int sum = 0;
      for(int i = 0; i < time; i++){
         count++;
         sum += 250;
      }
      System.out.println("Tid = "+count+" timer"+" Pris = "+sum+" kr.");
   }
   
   public void setEventNavn(String enavn) {
      eventnavn = enavn;
   }
   public void setTimer(double time) {
      varighedTimer = time;
   }
   public void setVirksomhed(Virksomhed kund) {
      kunde = kund;
   }
   public void setFacilitator(boolean faci) {
      facilitator = faci;
   }
   public void setEventAnsvar(Person eventansvar) {
      eventansvarlig = eventansvar;
   }
   public void setWeekend(boolean week) {
      weekend = week;
   }
   //Getters
   public String getEventNavn() {
      return eventnavn;
   }
   public double getVarighedTimer() {
      return varighedTimer;
   }
   public Virksomhed getVirksomhed() {
      return kunde;
   }
   public boolean getFacilitator() {
      return facilitator;
   }
   public Person getEventAnsvar() {
      return eventansvarlig;
   }
   public boolean getWeekend() {
      return weekend;
   }

   public String toString() {
      return("Name of Event: " +getEventNavn()+"\nName of customer: "+getVirksomhed()+"\nDuration of event: "+getVarighedTimer()+"\nIs facilitator present?: "+getFacilitator()+
             "\nName of Eventansvarlig: "+getEventAnsvar()+"\nIs it weekend?: "+getWeekend());
   }
}