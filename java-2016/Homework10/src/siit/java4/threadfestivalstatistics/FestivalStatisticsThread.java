/**
 * This class starts a thread every 5 seconds while list is not empty
 */


package siit.java4.threadfestivalstatistics;


	public class FestivalStatisticsThread extends Thread {
		private Gate gate;

		public FestivalStatisticsThread(Gate gate) {
			this.gate = gate;
		}

		@Override
		public void run() {
			
			try {
				while (true) {
					Thread.sleep(5001);
					synchronized (gate.ticketQueue) {
						while (gate.ticketQueue.isEmpty()) {
							gate.ticketQueue.wait();
						}
					int total_tickets = 0;
					int full_tickets = 0;
					int full_vip_tickets = 0;
					int free_pas_tickets = 0;
					int one_day_tickets = 0;
					int one_day_vip_tickets = 0;

					for (PosibleTicketsTypes t : gate.ticketQueue) {
							total_tickets = total_tickets + 1;
							
				switch (t) {
						case full:
							full_tickets = full_tickets + 1;
							break;
						case one_day_vip:
							one_day_vip_tickets = one_day_vip_tickets + 1;
							break;
						case full_vip:
							full_vip_tickets = full_vip_tickets + 1;
							break;
						case one_day:
							one_day_tickets = one_day_tickets + 1;
							break;
						case free_pas:
							free_pas_tickets = free_pas_tickets + 1;
							break;
							
							}
						}
				System.out.println(total_tickets + " people entered \n");
				System.out.println(full_tickets + "  people have full tickets");
				System.out.println(free_pas_tickets + " have free passes");
				System.out.println(full_vip_tickets + " have full VIP passes");
				System.out.println(one_day_tickets + " have one-day passes");
				System.out.println(one_day_vip_tickets + " have one-day VIP passes \n");
					gate.ticketQueue.notify();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

	}
}
