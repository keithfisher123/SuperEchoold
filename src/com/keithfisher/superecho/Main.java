package com.keithfisher.superecho;

import com.noelportugal.amazonecho.AmazonEchoApi;
import java.io.IOException;

public class Main {

  private static AmazonEchoApi amazonEchoApi;
   // private static Insteon insteonHub;
  
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
      amazonEchoApi = new AmazonEchoApi("https://pitangui.amazon.com","keithfisher@gmail.com", "password");
      amazonEchoApi.httpLogin();
     //   insteonHub= new Insteon("192.168.1.110","20105","password","admin");      
      // amazonEchoApi.getLatestTodo();
     // amazonEchoApi.getLatestHistory();
        while(true){
            String command="";
            try {
            command = amazonEchoApi.getLatestTodo();
              System.out.println("command="+command);
            } catch (Exception e) {
                System.out.println(e);
            }
           
            if (command != null){
                System.out.println(command);
                if (command.equalsIgnoreCase("Turn the living room lights on")){
                // insteonHub.setDevice("foo", 1);
                }
                 if (command.equalsIgnoreCase("Turn on the living room lights")){
               //  insteonHub.setDevice("foo", 1);
                }
                 if (command.equalsIgnoreCase("Turn the living room lights off")){
               //  insteonHub.setDevice("foo", 2);   
                }
                   if (command.equalsIgnoreCase("Turn off the living room lights")){
               //  insteonHub.setDevice("foo", 2);   
                }
                
               
            }else{
                System.out.println("No new commands");
            }
                           
            Thread.sleep(10000);
        }  
        
    }    
}