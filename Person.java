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
      return(navn + ";" + nummer + ";" + email);
   }
   
   public static Person opretPerson(){
      Scanner console = new Scanner(System.in);
      System.out.print("Navn: ");
      String name = console.nextLine();
      System.out.print("Tlf: ");
      String num = console.nextLine();
      System.out.print("E-mail: ");
      String mail = console.nextLine();
      return new Person(name, num, mail);
   }
    public static Person opretPersonForening(){
       Scanner console = new Scanner(System.in);
       System.out.print("Navn: ");
       String name = console.nextLine();
       System.out.print("Tlf: ");
       String num = console.nextLine();
       System.out.print("E-mail: ");
       String mail = console.nextLine();
       System.out.print("Forenings navn: ");
       String forening = console.nextLine();
       return new Person(name, num, mail,forening);
   }
   public static Person opretPersonCVR(){
      Scanner console = new Scanner(System.in);
      System.out.print("Navn: ");
      String name = console.nextLine();
      System.out.print("Tlf: ");
      String num = console.nextLine();
      System.out.print("E-mail: ");
      String mail = console.nextLine();
      System.out.print("Firma navn: ");
      String firma = console.nextLine();
      System.out.print("CVR Nr: ");
      int CVR = console.nextInt();
      return new Person(name, num, mail,firma,CVR);
   }
   
   public static Person personFromFile(Scanner input){
      String name = input.next();
      String num = input.next();
      String mail = input.next();
      return new Person(name, num, mail);
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
  
}
