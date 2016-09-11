package metricdistancecalculator;

public class MetricDistanceCalculator {
	
	private MetricDistanceExpressionParser parser;
	private MetricDistanceConverter converter;
	
	public MetricDistanceCalculator() {
		this(new MetricDistanceExpressionParser(), new MetricDistanceConverter());
	}
	
	MetricDistanceCalculator(MetricDistanceExpressionParser parser, MetricDistanceConverter converter) {
		this.parser = parser;
		this.converter = converter;
}
	
		public Distance computeDistance(String expression, String resultDistanceFormat) throws UnknownDistanceFormatException{
			Distance[] distances = parser.parse(expression);
			Distance result = new Distance (resultDistanceFormat, 0);
			
			for(Distance distance :  distances){
				Distance converted = converter.convert(distance, resultDistanceFormat);
				result.add(converted.getValue());
			}
			return result;
		}
	
}
