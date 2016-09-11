package metricdistancecalculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class MetricDistanceExpressionParserTest {

	@Test
	public void nextOperatorTest1() {
		// given
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String s = "123-";	
		// when
		int opPos = parser.nextOperand(s);
		//then
		assertEquals(3, opPos);
	}

	@Test
	public void nextOpPosNotFound() {
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String s = "123";
		assertEquals(-1, parser.nextOperand(s));
	}

	@Test
	public void nextOperatorTestCorrectWithMultipleOps() {
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String s = "123-+-";
		assertEquals(3, parser.nextOperand(s));
	}

	@Test
	public void nextOperatorTestWithJustOp() {
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String s = "+";
		assertEquals(0, parser.nextOperand(s));
	}

	@Test
	public void correctFormatIsParsed() throws UnknownDistanceFormatException {
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String s = "1m+1m";
		Distance[] expected = new Distance[] { new Distance(Distance.Meters, 1), new Distance(Distance.Meters, 1) };
		Distance[] actual = parser.parse(s);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void correctFormatWithMinusIsParsed() throws UnknownDistanceFormatException {
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String s = "1m-1m";
		Distance[] expected = new Distance[] { new Distance(Distance.Meters, 1), new Distance(Distance.Meters, -1) };
		Distance[] actual = parser.parse(s);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void correctFormatIsParsed2() throws UnknownDistanceFormatException {
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String s = "1m-13m";
		Distance[] expected = new Distance[] { new Distance(Distance.Meters, 1), new Distance(Distance.Meters, -13) };
		Distance[] actual = parser.parse(s);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void correctFormatWithMultipleOpsAndNegativeSignAtStartIsParsed() throws UnknownDistanceFormatException {
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String s = "-1m+5m-3cm";
		Distance[] expected = new Distance[] { new Distance(Distance.Meters, -1), new Distance(Distance.Meters, 5),
				new Distance(Distance.Centi_meters, -3) };
		Distance[] actual = parser.parse(s);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void correctFormatWithMultipleOpsIsParsed() throws UnknownDistanceFormatException {
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String s = "1m+5m-3cm";
		Distance[] expected = new Distance[] { new Distance(Distance.Meters, 1), new Distance(Distance.Meters, 5),
				new Distance(Distance.Centi_meters, -3) };
		Distance[] actual = parser.parse(s);
		assertArrayEquals(expected, actual);
	}
	
	@Test(expected=UnknownDistanceFormatException.class)
	public void parsingFailsWithInvalidDistanceFormat() throws UnknownDistanceFormatException {
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String s = "-1m+5m-3s";
		parser.parse(s);
	}

}
