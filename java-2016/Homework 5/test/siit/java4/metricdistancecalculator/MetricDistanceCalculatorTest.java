package test.siit.java4.metricdistancecalculator;

import org.junit.Test;

import siit.java4.metricdistancecalculator.Distance;
import siit.java4.metricdistancecalculator.MetricDistanceCalculator;
import siit.java4.metricdistancecalculator.MetricDistanceConverter;
import siit.java4.metricdistancecalculator.MetricDistanceExpressionParser;
import siit.java4.metricdistancecalculator.UnknownDistanceFormatException;

import static org.junit.Assert.*;

public class MetricDistanceCalculatorTest {
	
	@Test
	public void simpleExpressionIsCalculated() throws UnknownDistanceFormatException{
		// given
		MetricDistanceExpressionParser mockParser = new MetricDistanceExpressionParser(){
			@Override
			public Distance[] parse(String expression) throws UnknownDistanceFormatException {
				return new Distance[]{new Distance(Distance.Kilo_meters, 1), new Distance(Distance.Meters, 1)};
			}	
		};
		MetricDistanceConverter mockConverter = new MetricDistanceConverter(){
			@Override
			public Distance convert(Distance distance, String toFormat) throws UnknownDistanceFormatException {
				if(distance.getFormatName().equals(Distance.Kilo_meters)){
					return new Distance(Distance.Meters, 1000);
				} else {
					return distance;
				}
			}
		};
		MetricDistanceCalculator calc = new MetricDistanceCalculator(mockParser, mockConverter);
		
		// when
		Distance actual = calc.computeDistance("1km+1m", Distance.Meters);
		
		// then
		Distance expected = new Distance(Distance.Meters, 1001);
		assertEquals(expected, actual);
	}

}