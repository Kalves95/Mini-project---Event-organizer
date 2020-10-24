import java.util.*;
import java.io.*;

public class MuligMain {
   public static void main (String[] args) {
      Scanner der = new Scanner(System.in);
      
      System.out.printf("%27s %n", "Velkommen til PlanOrgan");
      System.out.println();
      System.out.printf("%s %n", "Tast 1 for at tilgå person menu.");
      System.out.printf("%s %n", "Tast 2 for at tilgå virksomhed / Kunde menu.");
      System.out.printf("%s %n", "Tast 3 for at tilgå arrangement menu.");
      int svar = der.nextInt();
      
      switch(svar) {
         case 1:
            System.out.println("Du har valgt at oprette en ny person");
               break;
            
         case 2:
            System.out.println("Tast 1 hvis du vil oprette en privat kunde.");
            System.out.println("Tast 2 hvis du vil oprette erhvervs kunde.");
            System.out.println("Tast 3 hvis du vil oprette forenings kunde.");
               break;
         
         case 3:
            System.out.println("Tast 1 hvis du vil oprette et event.");
            System.out.println("Tast 2 hvis du vil rette i et arrangement.");
            System.out.println("Tast 3 hvis du vil slette et arrangement.");
            int svar1 = der.nextInt();
            if(svar1 == 1) {
               
            }
               break;
         
         default:
            System.out.println("Indtast venligst et gyldigt nummer, tak.");
      }
      
     
   } // Her slutter main.  
}