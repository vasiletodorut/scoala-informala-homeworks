package siit.java4.enums;

import java.util.regex.Pattern;

public class Split {

	String name;
	String position;
	int hoursworked;
	int daysoff;
	int prepaidsales;
	int postpaidsales;

	public Employee fragmenter(String line) {

		String[] output = line.split(Pattern.quote("|"));
		name = output[0];
		position = output[1];
		hoursworked = Integer.parseInt(output[2]);
		daysoff = Integer.parseInt(output[3]);
		if (output.length < 5) {
			prepaidsales = 0;

		} else {
			prepaidsales = Integer.parseInt(output[4]);
		}

		if (output.length < 6) {
			postpaidsales = 0;
		} else {

			postpaidsales = Integer.parseInt(output[5]);
		}

		return new Employee(name, position, hoursworked, daysoff, prepaidsales, postpaidsales, 0);

	}
}
