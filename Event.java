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
      this.kunde = kunde;
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
   
   public String saveToFile(){
      String facil = "nej";
      if (facilitator){
         facil = "ja";
      }
      String weekE = "nej";
      if (weekend){
         weekE = "ja";
      }
      return (eventnavn + ";" + varighedTimer + ";" + kunde.saveToFile() + ";" + facil + ";" + eventansvarlig.saveToFile() + ";" + weekE);
   }
   
   public static Event opretEvent(Virksomhed customer, Person eventAnsvarlig){
      Scanner console = new Scanner(System.in);
      System.out.print("Event-navn: ");
      String navn = console.nextLine();
      System.out.print("Varighed: ");
      double tid = console.nextDouble();
      console.nextLine();
      Virksomhed kunde = customer;
      System.out.println("Skal der være en facilitator til stede?");
      System.out.print("Indtast 'ja' eller 'nej': ");
      String facil = console.next();
      boolean facilitator = false;
      if(facil.equals("ja")){
         facilitator = true;
      }
      Person ansvarlig = eventAnsvarlig;
      System.out.println("Finder eventet sted i weekenden?");
      System.out.print("Indtast 'ja' eller 'nej': ");
      String weekE = console.next();
      boolean weekend = false;
      if(weekE.equals("ja")){
         weekend = true;
      }
      return new Event(navn, tid, kunde, facilitator, ansvarlig, weekend);
   }
}
