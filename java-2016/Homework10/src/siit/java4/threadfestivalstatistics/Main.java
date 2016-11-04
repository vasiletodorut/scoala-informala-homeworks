package siit.java4.threadfestivalstatistics;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Gate gate = new Gate();

		FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
		statsThread.start();

		for (int i = 0; i < 658; i++) {

			PosibleTicketsTypes ticketType = PosibleTicketsTypes.getRandomTicket();
			FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(ticketType, gate);
			festivalAttendee.start();
			festivalAttendee.join();
		}

}
}
