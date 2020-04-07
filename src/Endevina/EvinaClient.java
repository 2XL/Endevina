package Endevina;

import java.io.*; 
import java.net.*; 
import java.util.StringTokenizer;
  
class EvinaClient { 
    public static void main(String args[]) throws Exception, IOException 
    { 
  
    	final int TTL = 3000;	// 3 mili-segons
    	byte [] ip = {(byte) 10, (byte) 50, (byte) 238, (byte) 20};	// com inicialitzar una ip
  /***************************************************************************/ 
    	 
    	
    	
    	
    	
    	
      // Create input stream
      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 
  
      // Create client socket
      DatagramSocket clientSocket = new DatagramSocket(); 
  
      // Translate hostname to IP address using DNS
      // cal substituir hostname pel nom del host del vostre company, ex: d602.labdeim.net
      //InetAddress IPAddress = InetAddress.getByName("hostname");
      InetAddress IPAddress = InetAddress.getByName("XxX");
  
      byte[] sendData = new byte[1024]; 
      byte[] receiveData = new byte[1024]; 

      
      boolean encert = false;    
      
do{       
      
      String sentence = inFromUser.readLine()+"\n"; 
      sendData = sentence.getBytes();
   
      
      
  /***************************************************************************/        
      // CREATE DATAGRAM & SEND THEN CREATE RECEIVE DATAGRAM & RECEIVE
  
      // Create datagram with data-to-send, length, IP addr, port
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876); 
   
      
    
  try{    
       // Send datagram to server
      clientSocket.send(sendPacket);
  }
  catch (IOException e)
  {
	  e.printStackTrace();
  }
      
      

   
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
      // Read datagram from server
      
      
      
      
      clientSocket.setSoTimeout(TTL);
      
      
      try{
      clientSocket.receive(receivePacket); 
      }
      catch (SocketTimeoutException timeout)
      {
    	  timeout.printStackTrace();
      }
      
      
 /***************************************************************************/     
      // DECRYPT DATAGRAM
      
   
   
      String modifiedSentence = new String(receivePacket.getData()); 
      
  //    System.out.println("FROM SERVER:" + modifiedSentence);
      System.out.println(modifiedSentence);
      
      
      StringTokenizer st = new StringTokenizer(modifiedSentence, ": ");
		
      
      String name=null, result=null;
	  name = st.nextToken();    
	  result = st.nextToken().trim();
	  

	  if(result.equals("="))
	   	  encert = true;
      
      
      
      
      
      
      
      
  	}while(!encert);
      





      
      clientSocket.close(); 
       } 
 } 























