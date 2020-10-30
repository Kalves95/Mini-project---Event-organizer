import java.util.*;
import java.io.*;

public class Person {
   
   //Fields
   private String navn;
   private String nummer;
   private String email;
   private String stilling;
   private int CVR;
   
   //Constructor
   public Person(String navn, String nummer, String email) {
      this.navn = navn;
      this.nummer = nummer;
      this.email = email;     
   }
   public Person (String navn, String nummer, String email,String stilling) {
      this.navn = navn;
      this.nummer = nummer;
      this.email = email;
      this.stilling = stilling;  
  }
     public Person (String navn, String nummer, String email,String stilling, int CVR) {
      this.navn = navn;
      this.nummer = nummer;
      this.email = email;
      this.CVR = CVR;
      this.stilling = stilling;  
  }
 
   public Person() {           
   }
   public String toString() {
      
      return ("Navn: "+navn + " \nTlf: " + nummer + " \nMail: " + email + "\nStilling: " + stilling + "\nCVRNr: "+CVR);
   }

   
   // Getters

   public String getNavn(String navn) {
      
      return navn;
   }
   public String geStilling(String stilling) {
      
     return stilling;
   }
public int getCVR(int CVR) {
      
      return CVR;
   }

   
   public String getNummer(String nummer) {
      
      return nummer;
   }
   
   public String getEmail(String email) {
      
      return email;
   }
   
   // Setters
   public void setNavn(String navn) {
      
      this.navn = navn;
   }
   public void setStilling(String stilling) {
      
      this.stilling = stilling;
   }
   public void setCVR (int CVR) {
      
      this.CVR = CVR;
   }

   
   public void setNummer(String nummer) {
      
      this.nummer = nummer;
   }
   
   public void setEmail(String email) {
      
      this.email = email;
   }
   
   public String saveToFile(){
      return(navn + ";" + nummer + ";" + email + ";" + stilling + ";" + CVR);
   }
      
   public static Person opretPerson(){
      Scanner console = new Scanner(System.in);
      System.out.print("Navn: ");
      String name = console.nextLine();
      System.out.print("Tlf: ");
      String num = console.nextLine();
      System.out.print("E-mail: ");
      String mail = console.nextLine();
      System.out.print("Stilling: ");
      String stil = console.nextLine();
      return new Person(name, num, mail,stil);
   }
    public static Person opretPersonForening(String forening){
       Scanner console = new Scanner(System.in);
       System.out.print("Navn: ");
       String name = console.nextLine();
       System.out.print("Tlf: ");
       String num = console.nextLine();
       System.out.print("E-mail: ");
       String mail = console.nextLine();
       return new Person(name, num, mail,forening);
   }
   public static Person opretPersonCVR(String firma,int CVR){
      Scanner console = new Scanner(System.in);
      System.out.print("Navn: ");
      String name = console.nextLine();
      System.out.print("Tlf: ");
      String num = console.nextLine();
      System.out.print("E-mail: ");
      String mail = console.nextLine();     
      return new Person(name, num, mail,firma,CVR);
   }
   
   public static Person personFromFile(Scanner input){
      String name = input.next();
      String num = input.next();
      String mail = input.next();
      String stil = input.next();
      int cvr = input.nextInt();
      return new Person(name, num, mail, stil, cvr);
   }
   
   public static Person[] medarbejdereFromFile()throws FileNotFoundException{
      Scanner load = new Scanner(new File("medarbejdere.txt"));
      load.useDelimiter(";");
      Person[] medarbejdere = new Person[load.nextInt()];
      for (int i = 0; i < medarbejdere.length; i++) {
         medarbejdere[i] = personFromFile(load);
      }
      return medarbejdere;
   }
  
   public static void medarbejdereToFile(Person[] medarbejdere)throws FileNotFoundException{
      PrintStream save = new PrintStream(new File("medarbejdere.txt"));
      save.print(medarbejdere.length + ";");
      for(int i=0; i<medarbejdere.length; i++){
         save.print(medarbejdere[i].saveToFile() +";");
      }
   }
  
   public static Person[] addPerson(Person[] medarbejdere){
      Person[] temp = new Person[medarbejdere.length + 1];
      for(int i = 0; i < medarbejdere.length; i++){
         temp[i] = medarbejdere[i];
      }
      temp[temp.length - 1] = Person.opretPerson();
      return temp;
   }
  
   public static Person[] deletePerson(Person[] medarbejdere, int valg){
      Person[] temp = new Person[medarbejdere.length - 1];
      for(int i = 0; i<valg-1; i++){
         temp[i] = medarbejdere[i];
      }
      for(int i = valg + 1; i < medarbejdere.length; i++){
         temp[i-1] = medarbejdere[i];
      }
      return temp;
   }
  
   public static Person personFraListe(Person[] personer){
      Scanner console = new Scanner(System.in);
      for (int i = 0; i<personer.length; i++){
         System.out.println("(" + (i+1) + ") " + personer[i].navn);
      }
      System.out.println("Vælg medarbejder: ");
      int valg = console.nextInt();
      return personer[valg-1];
   }
   
   public void redigerPerson(Person[] medarbejdere){
      Scanner console = new Scanner(System.in);
      int svar = 1;
      String confirm = "";
      while (svar != 6){
         System.out.println("Hvilken af de følgende vil du redigere?");
         System.out.println("Tast 1 for at redigere navn");
         System.out.println("Tast 2 for at redigere nummer");
         System.out.println("Tast 3 for at redigere email");
         System.out.println("Tast 4 for at redigere stilling");
         System.out.println("Tast 5 for at redigere CVR");
         System.out.println("Tast 6 for at vende tilbage til hovedmenu.");
         
         svar = console.nextInt();
         console.nextLine();
         switch (svar){
            case 1:
               System.out.print("Indtast nyt navn: ");
               String nytNavn = console.nextLine();
               setNavn(nytNavn);
               break;
            case 2:
               System.out.println("Indtast nummer: ");
               String nytNummer = console.nextLine();
               console.nextLine();
               setNummer(nytNummer);
               break;
            case 3:
               System.out.println("Indtast email: ");
               String nyEmail = console.nextLine();
               setEmail(nyEmail);
                          
               break;
            case 4:
               System.out.println("Indtast stilling: ");
               String nyStilling = console.nextLine();
               setStilling(nyStilling);
               break;
            case 5:
               System.out.println("Indtast CVR: ");
               int nyCVR = console.nextInt();
               setCVR(nyCVR);
               break;
            
            case 6:
               break;
               
            default:
               System.out.println("Hovedmenu");
               System.out.println("---------");
         }
      }

  
  }
}
