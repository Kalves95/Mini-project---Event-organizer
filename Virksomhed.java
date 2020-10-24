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
 }  