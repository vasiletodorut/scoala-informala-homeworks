package siit.java4.metricdistancecalculator;

public class MetricDistanceConverter {

	private static final Convertion [] CONVERTIONS = new Convertion[]{
					new Convertion(Distance.Kilo_meters, Distance.Meters, 1000),
					new Convertion(Distance.Meters, Distance.Kilo_meters, 0.001),
					
					new Convertion(Distance.Kilo_meters, Distance.Miles, 0.62),
					new Convertion(Distance.Miles, Distance.Kilo_meters, 1.609),
					
					new Convertion(Distance.Kilo_meters, Distance.Centi_meters, 100000),
					new Convertion(Distance.Centi_meters, Distance.Kilo_meters, 0.00001),
					
					new Convertion(Distance.Kilo_meters, Distance.Mili_meters, 1000000),
					new Convertion(Distance.Mili_meters, Distance.Kilo_meters, 0.000001),
					
				
					new Convertion(Distance.Miles, Distance.Meters, 1609),
					new Convertion(Distance.Meters, Distance.Miles, 0.00062),
					
					new Convertion(Distance.Miles, Distance.Centi_meters, 160934.4),
					new Convertion(Distance.Centi_meters, Distance.Miles, 0.0000062),
					
					new Convertion(Distance.Miles, Distance.Mili_meters, 1609344),
					new Convertion(Distance.Mili_meters, Distance.Miles, 0.00000062),
					
					new Convertion(Distance.Meters, Distance.Centi_meters, 100),
					new Convertion(Distance.Centi_meters, Distance.Meters, 0.01),
					
					new Convertion(Distance.Meters, Distance.Mili_meters, 1000),
					new Convertion(Distance.Mili_meters, Distance.Meters, 0.001),
					
					new Convertion(Distance.Centi_meters, Distance.Mili_meters, 10),
					new Convertion(Distance.Mili_meters, Distance.Centi_meters, 0.1),
					
										
				};
				
				public Distance convert(Distance distance, String toFormat)throws UnknownDistanceFormatException{
					if(distance.getFormatName().equals(toFormat)){
						return distance;
					}
					Convertion convertion = null;
					for(Convertion c : CONVERTIONS){
						if(c.fromFormat.equals(distance.getFormatName()) && c.toFormat.equals(toFormat)){
							convertion = c;
							break;
						}
					}
					if(convertion==null){
						throw new IllegalArgumentException("No rate found for "+ distance.getFormatName()+" - "+toFormat);
					}
					return new Distance(toFormat, distance.getValue()*convertion.rate);
				}
				
				private static class Convertion {
					double rate;
					String fromFormat;
					String toFormat;
					
					public Convertion(String fromFormat, String toFormat, double rate) {
						super();
						this.rate = rate;
						this.fromFormat = fromFormat;
						this.toFormat = toFormat;
					}
					
					
					
				}
}
