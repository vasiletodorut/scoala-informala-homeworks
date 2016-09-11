package metricdistancecalculator;

public class MetricDistanceExpressionParser {
	
	private static final String MINUS = "-";
		private static final String PLUS = "\\+";
	
		public Distance [] parse(String expression)throws UnknownDistanceFormatException{
			// count the operands
			int operandCount = countSubStringOccurrences(expression, PLUS)+countSubStringOccurrences(expression, MINUS)+1;
			if(expression.startsWith("-")){
				operandCount--;
			}
			Distance distances[] = new Distance[operandCount];
			int index = 0;
			expression = expression.trim().replaceAll(" ", "").replaceAll("\t", ""); // loose the whitespace 
			while(expression.length()>0){
				int sign = 1;
				if(expression.startsWith(MINUS)){
					expression = expression.replaceFirst(MINUS, "");
					sign = -1;
				} else if (expression.startsWith("+")){
					expression = expression.replaceFirst(PLUS, "");
				}
				int nextOpPos = nextOperand(expression);
				String operator = null;
				if(nextOpPos==-1){// last operand
					operator = expression;
				} else {
					operator = expression.substring(0, nextOpPos);
				}
				expression = expression.replaceFirst(operator, "");
				distances[index++] = convertToDistance(operator, sign);
			}
			return distances;
		}
		
		 int nextOperand(String expression) {
			int plusPos = expression.indexOf("+");
			int minusPos = expression.indexOf("-");
			if(plusPos==-1){
				return minusPos;
			}
			if(minusPos==-1){
				return plusPos;
			}
			return plusPos<minusPos?plusPos:minusPos;
		}
	
		private Distance convertToDistance(String e, int sign)throws UnknownDistanceFormatException {
			if(e.endsWith(Distance.Miles)){
				return convertToDistance(e, sign, Distance.Miles);
			} else if (e.endsWith(Distance.Kilo_meters)){
				return convertToDistance(e, sign, Distance.Kilo_meters);
			} else if (e.endsWith(Distance.Mili_meters)){
					return convertToDistance(e, sign, Distance.Mili_meters);
			} else if (e.endsWith(Distance.Centi_meters)){
					return convertToDistance(e, sign, Distance.Centi_meters);
			} else if (e.endsWith(Distance.Meters)){
				return convertToDistance(e, sign, Distance.Meters);
			}
			 throw new UnknownDistanceFormatException("Can not parse ["+e+"] as a valid distance.");
		}
		
		private Distance convertToDistance(String e, double sign, String distanceFormat){
			return new Distance(distanceFormat, sign * Double.parseDouble(e.replace(distanceFormat, "")));
		}
	
		private int countSubStringOccurrences(String s, String sub){
			return s.length() - s.replaceAll(sub, "").length();
		}
	
	}

