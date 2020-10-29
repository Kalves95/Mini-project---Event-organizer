import java.util.*;
import java.io.*;

public class MuligArrangementFordeling {
   public static void main (String[] args) throws FileNotFoundException {
      Scanner der = new Scanner(System.in);
      Person[] medarbejdere = Person.medarbejdereFromFile();
      Virksomhed[] kunder = Virksomhed.kunderFromFile();
      Arrangement a1 = new Arrangement();
      
      //Velkomst menu, med valg muligheder.
      System.out.printf("%27S %n", "Velkommen til PlanOrgan");
      System.out.println();
      int svar = 1;
      //Person p1 = new Person();
      //Virksomhed v1 = new Virksomhed();
            
      while(svar != 5) {
         System.out.printf("%s %n", "Tast 1 for person menu.");
         System.out.printf("%s %n", "Tast 2 for kunde menu.");
         System.out.printf("%s %n", "Tast 3 for arrangement menu.");
         System.out.printf("%s %n", "Tast 4 for at bruge søgefunktionen");
         System.out.printf("%s %n", "Tast 5 for at afslutte. ");
         svar = der.nextInt();

      //Vores switch menu.
      switch(svar) {
         
         // Person menu
         case 1:
            System.out.println("Du har valgt at oprette en ny person");
            System.out.println("------------------------------------");
            medarbejdere = Person.addPerson(medarbejdere);
            Person.medarbejdereToFile(medarbejdere);
            //System.out.println(p1);
            System.out.println("------------------------------------");
               break;
         
         //Virksomhed / kunde menu.   
         case 2:
            System.out.println("Tast 1 hvis du vil oprette en privat kunde.");
            System.out.println("Tast 2 hvis du vil oprette erhvervs kunde.");
            System.out.println("Tast 3 hvis du vil oprette forenings kunde.");
            int svar1 = der.nextInt();
            
            if(svar1 == 1) {
               System.out.println("Du har valgt at oprette en privat kunde");
               System.out.println("---------------------------------------");
               Person pr2 = Person.opretPerson(); //Oprette virksomhedsobjekt?
               //System.out.println(pr2);
               System.out.println("---------------------------------------");
            
            } if(svar1 == 2) {
               System.out.println("Du har valgt at oprette en erhvervs kunde.");
               System.out.println("------------------------------------------");
               Person er1 = Person.opretPersonCVR(); //Oprette virksomhedsobjekt?              
               //System.out.println(v1);
               System.out.println("------------------------------------------");
                           
            } if(svar1 == 3) {
               System.out.println("Du har valgt at oprette en forenings kunde.");
               System.out.println("-------------------------------------------");
               Person fo2 = Person.opretPersonForening(); //Oprette virksomhedsobjekt?
               //System.out.println(fo2);
               System.out.println("-------------------------------------------");
            }
               break;
         
         //Vores arrangement menu
         case 3:
            System.out.println("Tast 1 hvis du vil oprette et arrangement.");
            System.out.println("Tast 2 hvis du vil redigere et arrangement / event.");
            System.out.println("Tast 3 hvis du vil åbne arrangement fil");
            int svar2 = der.nextInt();
            
            if(svar2 == 1) {
               System.out.println("Du har valgt at oprette et arrengement."); // HER HER HER
               System.out.println("---------------------------------------");
	       System.out.println("Vælg kunde: ");
               Virksomhed kunde = Virksomhed.virksomhedFraListe(kunder);
               arr = Arrangement.opretArrangement(kunde, medarbejdere);
               arr.saveArrangementToFile();
               System.out.println();
               a1 = Arrangement.opretArrangement(v1);//
               a1.saveArrangementToFile();
               System.out.println("---------------------------------------");
            
            }if(svar2 == 2) {
               System.out.println("Du har valgt at redigere i et arrangement.");
               System.out.println("------------------------------------------");
               System.out.println("Tast 1 hvis du vil redigere i et arrangement");
               System.out.println("Tast 2 hvis du vil oprette et event.");
               System.out.println("Tast 3 hvis du vil slette arrangement");
               System.out.println("Tast 4 hvis du ønsker at redigere et event");

               int svar3 = der.nextInt();
               
               switch(svar3) {
                  
                  case 1: // HER
                     System.out.println("Du har valgt at redigere et arrangement.");
                     System.out.println("----------------------------------------");
                     a1 = Arrangement.loadArrangementFromFile();
		     a1.redigerArrangement();
                     System.out.println("----------------------------------------");
                     break;
                  
                  case 2:
                     System.out.println("Du har valgt at oprette et event.");
                     System.out.println("---------------------------------");
                     
                     Event e1 = Event.opretEvent(v1, p1);
               
                     System.out.println(e1);
                     System.out.println("------------------------------------");
                     break;
                     
                  case 3:
                     System.out.println("Du har valgt at slette et arrangement.");
                     System.out.println("--------------------------------------");
                     
                     sletFil();
                     System.out.println("-------------------------------------------------------------------");
                     break;
                     
                  case 4: // HER
                     System.out.println("Du har valgt at redigere et event.");
                     System.out.println("----------------------------------");
                     Event e2 = Event.opretEvent(v1, p1);
                     
                     e2.redigerEvent();
                  
                  default:
                     System.out.println("Velkommen til hovedmenuen");
                     System.out.println("-------------------------");

               } 
            
            }if(svar2 == 3) {
               System.out.println("Du har valgt at åbne en arrangement fil");
               System.out.println("---------------------------------------");
               
               Arrangement bryllup = Arrangement.loadArrangementFromFile();
      
               //Virksomhed sted = Virksomhed.opretVirksomhed();
               //Person ansat = Person.opretPerson();
      
               //bryllup.addEvent(sted, ansat);
      
               //bryllup.saveArrangementToFile();
               
               System.out.println("---------------------------------------");
            }   
               break;
               
            case 4: // HER
               System.out.println("Du har valgt at bruge søgefunktionen.");
               System.out.println("-------------------------------------");
               System.out.println("Tast 1 hvis du vil søge i arrayet.");
               int svar4 = der.nextInt();
               
               if(svar4 == 1) {
               
               Arrangement a2 = Arrangement.loadArrangementFromFile();
               a2.searchArray();
               System.out.println("-------------------------------------");
            }
            
            case 5:
               break;
         
         default:
            System.out.println("Indtast venligst et gyldigt nummer, tak.");
      }
      
     }
     Person.medarbejdereToFile(medarbejdere);
     Virksomhed.kunderToFile(kunder);
     System.out.println("Du har valgt at afslutte, fortsat god dag.");
     System.out.println("------------------------------------------");
   
   }
   
    public static void sletFil() {
      Scanner in = new Scanner(System.in);
      System.out.println("Hvilken fil skal slettes?");
      String name = in.nextLine();
      File file = new File(name);
      System.out.println("Er du sikker på at du vil slette filen " + name + "?\nTast 1 for at slette\nTast 2 for at annulere" );
      int svar = in.nextInt();
      
      
      if(svar == 1) {
         file.delete();
         System.out.println("Filen er slettet");
     
      } else {
         System.out.println("Fejl, filen blev ikke slettet");
      }

   }


}
