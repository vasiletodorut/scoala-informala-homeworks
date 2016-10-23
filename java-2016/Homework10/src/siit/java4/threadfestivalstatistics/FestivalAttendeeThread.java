/**
 *  The thread receives tickes and gate and  puts them into the queue
 */

package siit.java4.threadfestivalstatistics;

import java.util.Random;

	public class FestivalAttendeeThread extends Thread {

		private PosibleTicketsTypes ticket;
		private Gate gate;
		private Random t = new Random();
		

		public FestivalAttendeeThread(PosibleTicketsTypes ticket, Gate gate) {
		this.ticket = ticket;
		this.gate = gate;
		}
		

		@Override
		public void run() {
			
			try {
				synchronized (gate.ticketQueue) {
					gate.acceptance (ticket);
					gate.ticketQueue.notify();
				}
				
				Thread.sleep(t.nextInt(100) + 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
