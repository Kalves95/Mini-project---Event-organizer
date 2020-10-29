import java.util.*;

public class Virksomhed {
   private String firmaNavn;
   private Person kunde;
   
   public Virksomhed(String firmaNavn, Person kunde){
      this.firmaNavn = firmaNavn;
      this.kunde = kunde;
   }
   
   public String toString(){
      return("Firmname: " + firmaNavn + " Kunde:" + kunde);
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
   
   public static Virksomhed opretVirksomhed(){
      Scanner console = new Scanner(System.in);
      System.out.print("Virksomhed: ");
      String firma = console.nextLine();
      System.out.println("Detaljer om kontaktperson:");
      Person kontakt = Person.opretPerson();
      return new Virksomhed(firma, kontakt);
   }
 }  
