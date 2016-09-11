package metricdistancecalculator;

import org.junit.Assert;
import org.junit.Test;

public class MetricDistanceCalculatorIntegrationTest {
	
	@Test
	public void weightCalculatorWorksWithCorrectInput() throws UnknownDistanceFormatException {
		// given
		String s = "2km+500m+100cm";
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		// when
		Distance result = calc.computeDistance(s, Distance.Meters);
		// then
		Distance expected = new Distance(Distance.Meters, 2501);
		Assert.assertEquals(expected, result);		
	}

}