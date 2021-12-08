package Logi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
	    
	  
	  static  ObjectOutputStream guardar;
	 static ObjectInputStream leer;
	 static FileOutputStream archivoResp;
	 
	 public static void main (String args[])
	  {
	    ServerSocket sfd = null;
	    
	    /*try
	    {
	     // sfd = new ServerSocket(7000);
	      System.out.println("ER MARDITO SERVIDOR FUNCIONA");
	    }
	    catch (IOException ioe)
	    {
	      System.out.println("Comunicación rechazada."+ioe);
	      System.exit(1);
	      
	      
	    }*/
	      
	    		  try {
	    			  
	    			  sfd = new ServerSocket(7000);
	    			  
	    			 while (true) {
	    				 System.out.println("ESRIBE ALGO");
	        Socket nsfd = sfd.accept();
	        leer = new ObjectInputStream(nsfd.getInputStream());
	        archivoResp = new FileOutputStream("respaldo/archivoDeRespZinio.dat");
	        System.out.println("Conexion aceptada de: "+nsfd.getInetAddress());
	       
	        guardar = new ObjectOutputStream(archivoResp);
				guardar.writeObject(leer.readObject());
			    guardar.close();
			    
	    		  }
			    
	    	  }
		    
	     
	      catch(IOException ioe)
	      {
	        System.out.println("Error: "+ioe);
	      } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	 

}
}

