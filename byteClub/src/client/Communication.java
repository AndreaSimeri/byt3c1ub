package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import board.Move;

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
    //PENSARE A SOLUZIONE CON LISTA O ARRAY(OPPURE VALUE-1 PER LE RIGHE)
    private Move convertServerStringToMove(String serverString,byte turn) {
		int r=0,c=0;
		String rString="",cString="";
		String moveString=serverString.substring(serverString.indexOf(" ")+1);
		if(moveString.length()==3) {
			rString=moveString.substring(0, 2);
		}
		else {
			rString=""+moveString.charAt(0);
		}
		cString=""+moveString.charAt(moveString.length()-1);
		/*switch(rString) {
			case "1":{
				r=0;break;
			}
			case "2":{
				r=1;break;
			}
			case "3":{
				r=2;break;
			}
			case "4":{
				r=3;break;
			}
			case "5":{
				r=4;break;
			}
			case "6":{
				r=5;break;
			}
			case "7":{
				r=6;break;
			}
			case "8":{
				r=7;break;
			}
			case "9":{
				r=8;break;
			}
			case "10":{
				r=9;break;
			}
			case "11":{
				r=10;break;
			}
			case "12":{
				r=11;break;
			}
			case "13":{
				r=12;break;
			}
			case "14":{
				r=13;break;
			}
			case "15":{
				r=14;break;
			}
		}*/
		r=(Integer.parseInt(rString)-1);
		switch(cString) {
			case "A":{
				c=14;break;
			}
			case "B":{
				c=13;break;
			}
			case "C":{
				c=12;break;
			}
			case "D":{
				c=11;break;
			}
			case "E":{
				c=10;break;
			}
			case "F":{
				c=9;break;
			}
			case "G":{
				c=8;break;
			}
			case "H":{
				c=7;break;
			}
			case "I":{
				c=6;break;
			}
			case "J":{
				c=5;break;
			}
			case "K":{
				c=4;break;
			}
			case "L":{
				c=3;break;
			}
			case "M":{
				c=2;break;
			}
			case "N":{
				c=1;break;
			}
			case "O":{
				c=0;break;
			}
		}
		return new Move(r,c,turn);
	}
    
    private String convertMoveToServerString(Move move) {
    	StringBuilder sb=new StringBuilder(3);
    	/*switch(move.getR()) {
			case 0:{
				sb.append("1");break;
			}
			case 1:{
				sb.append("2");break;
			}
			case 2:{
				sb.append("3");break;
			}
			case 3:{
				sb.append("4");break;
			}
			case 4:{
				sb.append("5");break;
			}
			case 5:{
				sb.append("6");break;
			}
			case 6:{
				sb.append("7");break;
			}
			case 7:{
				sb.append("8");break;
			}
			case 8:{
				sb.append("9");break;
			}
			case 9:{
				sb.append("10");break;
			}
			case 10:{
				sb.append("11");break;
			}
			case 11:{
				sb.append("12");break;
			}
			case 12:{
				sb.append("13");break;
			}
			case 13:{
				sb.append("14");break;
			}
			case 14:{
				sb.append("15");break;
			}
    	}*/
    	sb.append(move.getR()+1);
    	switch(move.getC()) {
    		case 0:{
    			sb.append("O");break;
    		}
    		case 1:{
    			sb.append("N");break;
    		}
    		case 2:{
    			sb.append("M");break;
    		}
    		case 3:{
    			sb.append("L");break;
    		}
    		case 4:{
    			sb.append("K");break;
    		}
    		case 5:{
    			sb.append("J");break;
    		}
    		case 6:{
    			sb.append("I");break;
    		}
    		case 7:{
    			sb.append("H");break;
    		}
    		case 8:{
    			sb.append("G");break;
    		}
    		case 9:{
    			sb.append("F");break;
    		}
    		case 10:{
    			sb.append("E");break;
    		}
    		case 11:{
    			sb.append("D");break;
    		}
    		case 12:{
    			sb.append("C");break;
    		}
    		case 13:{
    			sb.append("B");break;
    		}
    		case 14:{
    			sb.append("A");break;
    		}
    	}
    	return sb.toString();
    }
    
    public void communicates() throws Exception{
    	String serverResponse;
    	serverResponse=in.readLine();
    	if(serverResponse.startsWith(WELCOME_STRING)) {
    		String color=serverResponse.substring(serverResponse.indexOf(" ")+1);
    		//Inizializza gioco e giocatore.
    		if(color.equalsIgnoreCase("white")) {
    			
    		}
    		else {
    			
    		}
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
