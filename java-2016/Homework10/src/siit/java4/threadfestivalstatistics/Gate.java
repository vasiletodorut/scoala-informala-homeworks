/**
* This class have a list where the thread will fill with informations
*/
package siit.java4.threadfestivalstatistics;

import java.util.ArrayList;

public class Gate {
	
	ArrayList<PosibleTicketsTypes> ticketQueue = new ArrayList<>();

	public void acceptance (PosibleTicketsTypes ticket) {
		ticketQueue.add(ticket);
	}

}
