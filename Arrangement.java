//Sidst redigeret: 22/10-20, 14:08

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
      temp[temp.length - 1] = newEvent(customer, eventAnsvarlig);
      arr = temp;
   }
   
   public Event newEvent(Virksomhed customer, Person eventAnsvarlig){
      Scanner console = new Scanner(System.in);
      System.out.print("Indtast event-navn: ");
      String navn = Scanner.nextLine();
      System.out.print("\nIndtast timetal: ");
      double tid = Scanner.nextDouble();
      console.nextLine();
      Virksomhed kunde = customer;
      System.out.println("\nSkal der være en facilitator til stede?");
      System.out.print("Indtast 'ja' eller 'nej': ");
      String facil = console.next();
      boolean facilitator = false;
      if(facil.equals("ja")){
         facilitator = true;
      }
      Person ansvarlig = eventAnsvarlig;
      System.out.println("\nFinder eventet sted i weekenden?");
      System.out.print("Indtast 'ja' eller 'nej': ");
      String weekE = console.next();
      boolean weekend = false;
      if(weekE.equals("ja")){
         weekend = true;
      }
      Event begivenhed = new Event(navn, tid, kunde, facilitator, ansvarlig, weekend);
   }
   
   public int totalPrice(){
      int price = 0;
      for(int i = 0; i < arr.length; i++){
         price += arr[i].udregnPris();
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
   //konstruktorer. Værdierne er adskildt af semikolon, hcilket en scanner med en delimitor kan genkende.
   public void saveArrangementToFile()throws FileNotFoundException{
      Scanner console = new Scanner(System.in);
      System.out.print("Enter file name. Exclude file extension: ");
      String filename = console.next() + ".txt";
      PrintStream save = new PrintStream(new File(filename));
      save.print(arr.length + ";");
      for(int i=0; 0<arr.length; i++){
         save.print(arr[i].saveToFile+";");
      }
   }
}