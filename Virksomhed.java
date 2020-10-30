import java.util.*;
import java.io.*;

public class Virksomhed {
   
   //Fields
   private String firmaNavn;
   private Person kunde;
   
   //Constructor
   public Virksomhed(String firmaNavn, Person kunde){
      this.firmaNavn = firmaNavn;
      this.kunde = kunde;
   }
   public Virksomhed(){
   
   }
   
   //Methods
   
   public String toString(){
      return("Firmname: " + firmaNavn + " \n" + kunde);
   }
   
   public String getfirmaNavn(String firmaNavn){
      return firmaNavn;
   }
   public Person getPerson(Person kunde){
      return kunde;
   }
   public void setfirmaNavn(String firmaNavn){
      this.firmaNavn = firmaNavn;
   }
   public void setPerson(Person kunde){
      this.kunde = kunde;   
   }
   
   public String saveToFile(){
      return (firmaNavn +  ";" + kunde.saveToFile());
   }
   
   public static Virksomhed opretVirksomhedCVR(){
      Scanner console = new Scanner(System.in);
      System.out.print("Virksomhed: ");
      String firma = console.nextLine();
      System.out.print("CVR: ");
      int CVR = console.nextInt();
      System.out.println("Detaljer om kontaktperson:");
      Person kontakt = Person.opretPersonCVR(firma,CVR);
      return new Virksomhed(firma, kontakt);
   }
   public static Virksomhed opretVirksomhedPrivat(){
      Scanner console = new Scanner(System.in);
      System.out.print("Virksomhed: ");
      String firma = console.nextLine();
      System.out.println("Detaljer om kontaktperson:");
      Person kontakt = Person.opretPerson();
      return new Virksomhed(firma, kontakt);
   }
   public static Virksomhed opretVirksomhedForening(){
      Scanner console = new Scanner(System.in);
      System.out.print("Forenings navn: ");
      String forening = console.nextLine();
      System.out.println("Detaljer om kontaktperson:");
      Person kontakt = Person.opretPersonForening(forening);
      return new Virksomhed(forening, kontakt);
   }
   
   public static Virksomhed virksomhedFromFile(Scanner input){
      String name = input.next();
      Person kontakt = Person.personFromFile(input);
      return new Virksomhed(name, kontakt);
   }
   
   public static Virksomhed[] kunderFromFile()throws FileNotFoundException{
      Scanner load = new Scanner(new File("kunder.txt"));
      load.useDelimiter(";");
      Virksomhed[] kunder = new Virksomhed[load.nextInt()];
      for (int i = 0; i < kunder.length; i++) {
         kunder[i] = virksomhedFromFile(load);
      }
      return kunder;
   }
   
   public static Virksomhed virksomhedFraListe(Virksomhed[] virksomheder){
      Scanner console = new Scanner(System.in);
      for (int i = 0; i<virksomheder.length; i++){
         System.out.println("(" + i+1 + ") " + virksomheder[i].firmaNavn);
      }
      System.out.println("VÃ¦lg kunde: ");
      int valg = console.nextInt();
      return virksomheder[valg-1];
   }
   
   public static void kunderToFile(Virksomhed[] kunder)throws FileNotFoundException{
      PrintStream save = new PrintStream(new File("kunder.txt"));
      save.print(kunder.length + ";");
      for(int i=0; i<kunder.length; i++){
         save.print(kunder[i].saveToFile() +";");
      }
   }
   public static Virksomhed[] addVirksomhedCVR(Virksomhed[] kunde){
      Virksomhed[] temp = new Virksomhed[kunde.length + 1];
      for(int i = 0; i < kunde.length; i++){
         temp[i] = kunde[i];
      }
      temp[temp.length - 1] = Virksomhed.opretVirksomhedCVR();
      return temp;
   }
   public static Virksomhed[] addVirksomhedPrivat(Virksomhed[] kunde){
      Virksomhed[] temp = new Virksomhed[kunde.length + 1];
      for(int i = 0; i < kunde.length; i++){
         temp[i] = kunde[i];
      }
      temp[temp.length - 1] = Virksomhed.opretVirksomhedPrivat();
      return temp;
      }
      public static Virksomhed[] addVirksomhedForening(Virksomhed[] kunde){
      Virksomhed[] temp = new Virksomhed[kunde.length + 1];
      for(int i = 0; i < kunde.length; i++){
         temp[i] = kunde[i];
      }
      temp[temp.length - 1] = Virksomhed.opretVirksomhedForening();
      return temp;
      }
   
   
   public static Virksomhed[] deleteVirksomhed(Virksomhed[] kunde, int valg){
      Virksomhed[] temp = new Virksomhed[kunde.length - 1];
      for(int i = 0; i<valg-1; i++){
         temp[i] = kunde[i];
      }
      for(int i = valg + 1; i < kunde.length; i++){
         temp[i-1] = kunde[i];
      }
      return temp;
   }
 }  
