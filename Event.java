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
   
   public void redigerEvent(Person[] medarbejdere){
      Scanner console = new Scanner(System.in);
      int svar = 1;
      String confirm = "";
      while (svar != 7){
         System.out.println("Hvilken af de følgende vil du redigere?");
         System.out.println("(1) Eventnavn");
         System.out.println("(2) Varighed");
         System.out.println("(3) Kunde");
         System.out.println("(4) Om der er facilitator til stede");
         System.out.println("(5) Eventansvarlige medarbejder");
         System.out.println("(6) Om eventet finder sted i en weekend");
         System.out.println("(7) Aflsut eventredigering");
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
               console.nextLine();
               setTimer(nyVarighed);
               break;
            case 3:
               //Er denne her overhovedet nødvendig? Vi kan vel redigere kundeinformationer andetsteds i programmet.
               //kunde.redigerVirksomhed();
               break;
            case 4:
               System.out.println("Er der en facilitator til stede?");
               System.out.print("Indtast 'ja' eller 'nej': ");
               confirm = console.nextLine();
               if (confirm.equals("ja")){
                  setFacilitator(true);
               } else if (confirm.equals("nej")){
                  setFacilitator(false);
               } else{
                  System.out.println("Forkert værdi indtastet. Ingen ændring foretaget.");
               }
               break;
            case 5:
               eventansvarlig = Person.personFraListe(medarbejdere);
               break;
            case 6:
               System.out.println("Finder eventet sted en weekend?");
               System.out.print("Indtast 'ja' eller 'nej': ");
               confirm = console.nextLine();
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
               System.out.println("Indtast venligst et gyldigt nummer, tak.");
         }
      }
   }
}
