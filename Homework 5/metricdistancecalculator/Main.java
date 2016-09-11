package metricdistancecalculator;

public class Main {

	public static void main(String[] args) throws UnknownDistanceFormatException {
				String s = "1km + 750m - 0.5mi + 25cm- 2mm";
				MetricDistanceCalculator calc = new MetricDistanceCalculator();
				System.out.println(calc.computeDistance(s, Distance.Meters));
			}
		
		}
