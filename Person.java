import java.util.*;

public class Person {
   
   //Fields
   private String navn;
   private String nummer;
   private String email;
   
   //Constructor
   public Person(String navn, String nummer, String email) {
      this.navn = navn;
      this.nummer = nummer;
      this.email = email;
      
   }
   public String toString() {
      
      return navn + " " + nummer + " " + email;
   }
   
   // Getters
   public String getNavn(String navn) {
      
      return navn;
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
}
