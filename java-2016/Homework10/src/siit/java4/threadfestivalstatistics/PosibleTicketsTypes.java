/**
 * This class random generates tickets
 */

package siit.java4.threadfestivalstatistics;

import java.util.Random;

public enum PosibleTicketsTypes {

	full_vip, one_day_vip, full, one_day, free_pas;

	static final PosibleTicketsTypes[] values = PosibleTicketsTypes.values();
	static final Random random = new Random();

	public static PosibleTicketsTypes getRandomTicket() {
		return values[random.nextInt(values.length)];
	}
}
