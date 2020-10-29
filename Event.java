import java.util.*;
import java.io.*;

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
   public Event(){
   
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
   
   public int getPrice(){
      int pris = 100;
      if (facilitator){
         if (weekend){
            pris += varighedTimer * 350;
         }else{
            pris += varighedTimer * 250;
         }
         pris = (int) pris;
      }
      return pris;
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
   int count = 0;
   int sum = 100;
   for(int i = 0; i < varighedTimer; i++){
      count++;
      sum += 250;
   }
   int moms = (int)(sum*0.25) + sum;
   return String.format("Event navn\n----------\n%s\n\nInfo om kunde\n-------------\n%s\n\nEr facilitator tilstede?: %b \n"+
          "\nEr det weekend?: %b \n\nEventansvarlig navn\n-------------------\n%s\n\nVarighed & pris (oprettesle 100kr)\n----------------------------------\n"+
          "%.1f Timer %d kr. uden moms. %d kr. med moms.",getEventNavn(),getVirksomhed(),getFacilitator(),getWeekend(),getEventAnsvar(),getVarighedTimer(),sum,moms);
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
   
   public static Event eventFromFile(Scanner input){
      String name = input.next();
      String time = input.next();
      double dtime = Double.valueOf(time);
      Virksomhed kunde = Virksomhed.virksomhedFromFile(input);
      String facil = input.next();
      boolean facilitator = false;
      if (facil.equals("ja")){
         facilitator = true;
      }
      Person ansvarlig = Person.personFromFile(input);
      String weekE= input.next();
      boolean weekend = true;
      if (weekE.equals("ja")){
         weekend = true;
      }
      return new Event(name, dtime, kunde, facilitator, ansvarlig, weekend);
   }
   
   public void redigerEvent(){
      Scanner console = new Scanner(System.in);
      int svar = 1;
      String confirm = "";
      while (svar != 7){
         System.out.println("Hvilken af de følgende vil du redigere?");
         System.out.println("Tast 1 for eventnavn");
         System.out.println("Tast 2 for varighed");
         System.out.println("Tast 3 for kunde");
         System.out.println("Tast 4 for om der er facilitator til stede");
         System.out.println("Tast 5 for eventansvarlige medarbejder");
         System.out.println("Tast 6 for om eventet finder sted i en weekend");
         System.out.println("Tast 7 for aflsut eventredigering");
         svar = console.nextInt();
         console.nextLine();
         switch (svar){
            case 1:
               System.out.print("Indtast nyt eventnavt: ");
               String nytNavn = console.nextLine();
               setEventNavn(nytNavn);
               break;
            case 2:
               System.out.println("Indtast varighed: ");
               double nyVarighed = console.nextDouble();
               setTimer(nyVarighed);
               break;
            case 3:
               //Er denne her overhovedet nødvendig? Vi kan vel redigere kundeinformationer andetsteds i programmet.
               //kunde.redigerVirksomhed();
               break;
            case 4:
               System.out.println("Er der en facilitator til stede?");
               System.out.print("Indtast 'ja' eller 'nej': ");
               confirm = console.next();
               if (confirm.equals("ja")){
                  setFacilitator(true);
               } else if (confirm.equals("nej")){
                  setFacilitator(false);
               } else{
                  System.out.println("Forkert værdi indtastet. Ingen ændring foretaget.");
               }
               break;
            case 5:
               //Metoden skal bare gøre det muligt at tilknytte en anden eventansvarlig. Redigering i personaleinformationer sker andetsted i programmet.
               //eventansvarlig.skiftPerson();
               break;
            case 6:
               System.out.println("Finder eventet sted en weekend?");
               System.out.print("Indtast 'ja' eller 'nej': ");
               confirm = console.next();
               if (confirm.equals("ja")){
                  setWeekend(true);
               } else if (confirm.equals("nej")){
                  setWeekend(false);
               } else{
                  System.out.println("Forkert værdi indtastet. Ingen ændring foretaget.");
               }
               break;
            case 7:
               break;
            default:
               System.out.println("Hovedmenu");
               System.out.println("---------");
         }
      }
   }
}
