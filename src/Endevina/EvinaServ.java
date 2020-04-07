package Endevina;

import java.io.*; 
import java.net.*; 
import java.util.*; 


class EvinaServ { 
  public static void main(String args[]) throws Exception 
    { 
  
      // Create datagram socket at port 9876
	  DatagramSocket serverSocket = new DatagramSocket(9876); 
	  
	  Random rnd = new Random();
	  System.out.print("RANDOM:\t"+rnd);
	  
	  int secret = rnd.nextInt(100)+1;
	  System.out.println("\tSECRET:\t"+secret);
	  
	  
	  
	  
  
   
  
      while(true) 
        { 
          byte[] receiveData = new byte[1024]; 
          byte[] sendData  = new byte[1024]; 
    	  // Create space for received datagram
    	  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
    	  
    	  // Receive datagram
          serverSocket.receive(receivePacket);
          String sentence = new String(receivePacket.getData()); 
          
          System.out.println(sentence);
          
          
          StringTokenizer st = new StringTokenizer(sentence, ": ");
          
          
          //int numEntero = Integer.parseInt(numCadena);
          //String numCadena= Integer.toString(numEntero);
          
          
          String name=null, bet, resposta = null;
          
         
			name = st.nextToken();		    
		    bet = st.nextToken().trim();

		    System.out.print("b: "+bet);
		    System.out.print(" VS s: "+secret);
		    System.out.println(" -> "+bet.compareTo(Integer.toString(secret)));
		    
		   if((bet.compareTo(Integer.toString(secret)) != 0))
		    		if((bet.compareTo(Integer.toString(secret)) < 0))
		    			resposta = "+";
		    		else
		    			resposta = "-";
		   else
		   resposta = "=";
	    	
		   System.out.println("\tresult: "+resposta);
          

          resposta = name +": "+ resposta+"\n";
          System.out.println(resposta);
          
          
  
          // Get IP addr port #, of sender
          InetAddress IPAddress = receivePacket.getAddress(); 
          int port = receivePacket.getPort(); 
  
     //     String capitalizedSentence = sentence.toUpperCase(); 
     //     sendData = capitalizedSentence.getBytes(); 
          	sendData = resposta.getBytes();
          // Create datagram to send to client
          DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
  
          
          
          
          
      
          
          
          
          
          
          
          // Write out datagram to socket
          serverSocket.send(sendPacket); 
        } 
    } 
}  





/*
 
 
 	- Tasques:
 			modifiqueu el servidor per que triï un número aleatori entre 1 i 100
 
 			modifiqueu el codi per a que el client enviïn missatges al servidor del tipus "NickName: 37" 
 			i espera resposta. I així successivament fins que l'encerta.
 
 
 StringTokenizer st = new StringTokenizer(modifiedSentence, ": ");
		
  	    while (st.hasMoreTokens()) 
		{
			
		    System.out.print("NickName: "+st.nextToken());
		    System.out.println("Aposta: "+st.nextToken());
		    
		}
 
 
 
 
 
 
 
 
 */




























