import java.io.*;
import java.util.*;

public class Arrangement{
   
   //Fields
   private Event[] arr;
   
   //Constructor
   public Arrangement(){
      arr = new Event[0];
   }
   
   public Arrangement(Event[] par){
      arr = par;
   }
   
   //Methods
   public void addEvent(Virksomhed customer, Person eventAnsvarlig){
      Event[] temp = new Event[arr.length + 1];
      for(int i = 0; i < arr.length; i++){
         temp[i] = arr[i];
      }
      temp[temp.length - 1] = Event.opretEvent(customer, eventAnsvarlig);
      arr = temp;
   }
   
   public int totalPrice(){
      int price = 0;
      for(int i = 0; i < arr.length; i++){
         price += arr[i].getPrice();
      }
      return price;
   }
   
   public double totalTime(){
      int time = 0;
      for(int i = 0; i< arr.length; i++){
         time += arr[i].getVarighedTimer();
      }
      return time;
   }
   
   //Gemmer til en .txt-fil med et navn, som brugeren specificerer. Først skrivet et tal, som indikerer, hvor mange
   //events, der er i arrangementet. Dernæst kommer en værdier, der bruges som parametre i de forskellige
   //konstruktorer. Værdierne er adskildt af semikolon, hvilket en scanner med en delimitor kan genkende.
   public void saveArrangementToFile()throws FileNotFoundException{
      Scanner console = new Scanner(System.in);
      System.out.print("Indtast fil-navn. Udelad filtype: ");
      String filename = console.next() + ".txt";
      PrintStream save = new PrintStream(new File(filename));
      save.print(arr.length + ";");
      for(int i=0; i<arr.length; i++){
         save.print(arr[i].saveToFile() +";");
      }
   }
   
   public static Arrangement loadArrangementFromFile()throws FileNotFoundException{
      Scanner console = new Scanner(System.in);
      System.out.print(" Enter file name. Exclude file extension: ");
      String filename = console.next() + ".txt";
      Scanner load = new Scanner(new File(filename));
      load.useDelimiter(";");
      Event[] arr = new Event[load.nextInt()];
      for(int i = 0; i < arr.length; i++){
         arr[i] = Event.eventFromFile(load);
      }
      return new Arrangement(arr);
   }
   
   public static Arrangement opretArrangement(Virksomhed kunde){
      Scanner console = new Scanner(System.in);
      Arrangement arr = new Arrangement();
      System.out.println("Vil du føje et event til arrangementet?");
      System.out.print(" Indtast 'ja' eller 'nej': ");
      String svar = console.nextLine();
      while (svar.equals("ja")){
         System.out.println("Indtast eventansvarlig-");
         Person ansvarlig = Person.opretPerson();
         arr.addEvent(kunde, ansvarlig);
         System.out.println("Vil du føje endnu et event til arrangementet?");
         System.out.print(" Indtast 'ja' eller 'nej': ");
         svar = console.nextLine();
      }
      return arr;
   }
   
   public void searchArray() {
      Scanner scan = new Scanner(System.in);
      System.out.print("Search array: ");
      String valueToSearch = scan.nextLine();
      boolean isExists = false;
      for (int i = 0; i < arr.length; i++) {
        String arrayValue = arr[i].getEventNavn();
        if (valueToSearch.equals(arrayValue)) {
           isExists = true;
           System.out.println("Fundet på position: " + (i+1));
           break;
        }
         }
         if(isExists) {
            System.out.println("String is found in the array");
         }else{
             System.out.println("String is not found in the array");
         }
   }
   
   public void redigerArrangement() throws FileNotFoundException{
      Scanner console = new Scanner(System.in);
      int svar = 1;
      boolean gem = true;
      while (svar !=5){
         System.out.println("------------------------------------");
         System.out.println("Tast 1 hvis du vil tilføje et event.");
         System.out.println("Tast 2 hvis du vil redigere et ekstisterende event.");
         System.out.println("Tast 3 hvis du vil fjerne et event.");
         System.out.println("Tast 4 hvis du vil gemme ændringer.");
         System.out.println("Tast 5 for at afslutte");
         svar = console.nextInt();
         switch (svar){
            case 1:
               System.out.println("Du har valgt at tilføje et event til arrangementet.");
               //arr.addEvent(); //Der skal lige kigges på constructoren
               gem = false;
               break;
            case 2:
               System.out.println("Du har valgt at redigere et eksisterende event.");
               System.out.println("-----------");
               System.out.println("Hvilket event vil du redigere?");
               for(int i=0; i<arr.length; i++){
                  System.out.println("(" + (i+1) + ")" + arr[i].getEventNavn());
               }
               System.out.print("Rediger: ");
               int rediger = console.nextInt() - 1; //HER HER HER
               arr[rediger].redigerEvent();
               //Vælg en af events'ne med Scanneren. Brug redigerEvent() på det event.
               gem = false;
               break;
            case 3:
               System.out.println("Du har valgt at fjerne et eksisterende event.");
               System.out.println("-----------");
               System.out.println("Hvilket event vil du fjerne?");
               for(int i=0; i<arr.length; i++){
                  System.out.println("(" + (i+1) + ")" + arr[i].getEventNavn());
               }
               System.out.print("Fjern: ");
               int slet = console.nextInt() - 1;
               //Virksomhed v1 = Virksomhed.opretVirksomhed();
               //Person p1 = Person.opretPerson();
               //Event e1 = Event.opretEvent(v1,p1);
               deleteEvent(slet);
               System.out.println("Eventet er fjernet.");
               gem = false;
               break;
            case 4:
               System.out.println("Du har valgt at gemme arrangementet.");
               saveArrangementToFile();
               gem = true;
               break;
            case 5:
               if(!gem){
                  System.out.println("Vil du gemme dine ændringer inden du afslutter?");
                  System.out.println("Indtast 'ja' eller 'nej': ");
                  String confirm = console.nextLine();
                  if(confirm.equals("ja")){
                     saveArrangementToFile();
                  }
               }
               break;
            default:
               System.out.println("Indtast venligst et gyldigt nummer, tak.");
         }
      }
   }
   
   public void deleteEvent(int valg){
      Event[] temp = new Event[arr.length - 1];
      for(int i = 0; i<valg-1; i++){
         temp[i] = arr[i];
      }
      for(int i = valg + 1; i < arr.length; i++){
         temp[i-1] = arr[i];
      }
      arr = temp;
   }
}
