package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Communication {

	private static final String WELCOME_STRING = "WELCOME";
    private static final String MESSAGE_STRING = "MESSAGE";
    private static final String OPPONENT_STRING = "OPPONENT_MOVE";
    private static final String YOURTURN_STRING = "YOUR_TURN";
    private static final String VALIDMOVE_STRING = "VALID_MOVE";
    private static final String INVALIDMOVE_STRING = "INVALID_MOVE";
    private static final String VICTORY_STRING = "VICTORY";
    private static final String DEFEAT_STRING = "DEFEAT";
    private static final String TIE_STRING = "TIE";
    
    private static final short MOVE_TIME=3;
    
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;
    
    //GAME
    //PLAYER
    
    public Communication(String serverAddress, int port) throws Exception {
        // Setup networking
        socket = new Socket(serverAddress, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }
    
    public void communicates() throws Exception{
    	String serverResponse;
    	serverResponse=in.readLine();
    	if(serverResponse.startsWith(WELCOME_STRING)) {
    		String color=serverResponse.substring(serverResponse.indexOf(" ")+1);
    		//Inizializza gioco e giocatore.
    	}
    	while(true) {
    		serverResponse=in.readLine();
    		//valutare l'utilizzo di if (prestare attenzione all'ordine posizionale)
    		switch(serverResponse) {
    			case(YOURTURN_STRING):{
    				//Fai la tua mossa
    				break;
    			}
    			case(OPPONENT_STRING):{
    				//Aggiorna il gioco
    				break;
    			}
    			case(VALIDMOVE_STRING):{
    				break;
    			}
    			case(INVALIDMOVE_STRING):{
    				break;
    			}
    			case(MESSAGE_STRING):{
    				break;
    			}
    			default: break;
    		}
    		if(serverResponse==VICTORY_STRING) {
    			break;
    		}
    		else if(serverResponse==TIE_STRING) {
    			break;
    		}
    		else if(serverResponse==DEFEAT_STRING) {
    			break;
    		}
    	}//while
    	socket.close();
    	System.exit(0);
    }
    
    public static void main(String[] args) throws Exception {
        String serverAddress = (args.length == 0) ? "localhost" : args[0];
        int serverPort = (args.length == 0) ? 8901 : Integer.valueOf(args[1]);
        System.out.println("ip: "+serverAddress);
        System.out.println("port: "+serverPort);
        Communication communication=new Communication(serverAddress,serverPort);
        communication.communicates();
    }
    
}//Communication
