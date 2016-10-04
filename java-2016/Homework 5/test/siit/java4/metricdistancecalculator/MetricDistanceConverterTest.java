package test.siit.java4.metricdistancecalculator;

import org.junit.Test;

import siit.java4.metricdistancecalculator.Distance;
import siit.java4.metricdistancecalculator.MetricDistanceConverter;
import siit.java4.metricdistancecalculator.UnknownDistanceFormatException;

import org.junit.Assert;

public class MetricDistanceConverterTest {
	
	@Test
	public void centimetersToMetersConvertion() throws UnknownDistanceFormatException{
		Distance m1000 = new Distance(Distance.Centi_meters, 100);
		MetricDistanceConverter distanceConverter = new MetricDistanceConverter();
		
		Distance result = distanceConverter.convert(m1000, Distance.Meters);
		Distance expected = new Distance(Distance.Meters, 1);
		
		Assert.assertEquals("Convertion from centi_meters to meters is incorrect.", expected,  result);
	}
	
	@Test
	public void KilometersToMetersConvertion() throws UnknownDistanceFormatException{
		Distance m1 = new Distance(Distance.Kilo_meters, 1);
		MetricDistanceConverter distanceConverter = new MetricDistanceConverter();
		
		Distance result = distanceConverter.convert(m1, Distance.Meters);
		Distance expected = new Distance(Distance.Meters, 1000);
		
		Assert.assertEquals("Convertion from km to m is incorrect.", expected,  result);
	}
	
	@Test(expected=UnknownDistanceFormatException.class)
	public void convertionFailsWhenUnknownFormatIsPassed() throws UnknownDistanceFormatException{
		Distance m1 = new Distance(Distance.Meters, 1);
		MetricDistanceConverter weightConverter = new MetricDistanceConverter();
		weightConverter.convert(m1, "kg");
	}
	

}