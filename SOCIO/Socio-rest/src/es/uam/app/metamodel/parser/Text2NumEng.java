package es.uam.app.metamodel.parser;

public class Text2NumEng {
	

	

	private int units(String numero) {
		int num=-1;
		switch (numero) {
		case "nine":
			num = 9;
			break;
		case "eight":
			num = 8;
			break;
		case "seven":
			num = 7;
			break;
		case "six":
			num = 6;
			break;
		case "five":
			num = 5;
			break;
		case "four":
			num = 4;
			break;
		case "three":
			num = 3;
			break;
		case "two":
			num = 2;
			break;
		case "one":
			num = 1;
			break;
		case "a":
			num = 1;
			break;
		case "zero":
			num = 0;
			break;
		default:
			return ten(numero);
		}
		return num;
	}
	
	private int ten(String numero) {
		int num=-1;
		switch (numero) {
		case "ten":
			num = 10;
			break;
		case "eleven":
			num = 11;
			break;
		case "twelve":
			num = 12;
			break;
		case "thirteen":
			num = 13;
			break;
		case "fourteen":
			num = 14;
			break;
		case "fifteen":
			num = 15;
			break;
		case "sixteen":
			num = 16;
			break;
		case "seventeen":
			num = 17;
			break;
		case "eighteen":
			num = 18;
			break;
		case "nineteen":
			num = 19;
			break;
		default:
			return tens(numero);
		}
		return num;
	}

	private int tens(String numero) {
		int num=-1;
		switch (numero) {
		case "twenty":
			num = 20;
			break;
		case "thirty":
			num = 30;
			break;
		case "fourty":
			num = 40;
			break;
		case "fifty":
			num = 50;
			break;
		case "sixty":
			num = 60;
			break;
		case "seventy":
			num = 70;
			break;
		case "eighty":
			num = 80;
			break;
		case "ninety":
			num = 90;
			break;
		default:
			return hundreds(numero);
		}
		return num;
	}

	private int hundreds(String numero) {
		if (numero.equals("hundred")){
			return 100;
		}
		return thousands(numero);
	}

	private int thousands(String numero) {
		if (numero.equals("thousand")){
			return 1000;
		}
		return millions(numero);
	}

	private int millions(String numero) {
		if (numero.equals("million")){
			return 1000000;
		}
		return -1;
	}

	public int parserInt(String numero) {
		numero=numero.replace("-", " ");
		numero=numero.replace(" and ", " ");
		String[] split= numero.split(" ");
		
		return convertirLetras(split, split.length-1, -1);
	}
	
	private int convertirLetras(String[] numero, int start, int end) {
		int num=0;
		for (int i=start; i>end; i--){
			if (millions(numero[i])!=-1){
				int numAux=convertirLetras(numero, i-1, end);
				if (numAux!=-1){
					num+=(numAux*1000000);
				}else{
					return -1;
				}
				i=-1;
			}else if (thousands(numero[i])!=-1){
				int j=getThousandprev(numero, i-1);
				int numAux=convertirLetras(numero, i-1, j);
				if (numAux!=-1){
					num+=(numAux*1000);
				}else{
					return -1;
				}
				i=j+1;
			}else if (hundreds(numero[i])!=-1 ){
				int j=gethundredprev(numero, i-1);
				int numAux=convertirLetras(numero, i-1, j);
				if (numAux!=-1){
					num+=(numAux*100);
				}else{
					return -1;
				}
				i=j+1;
			}else{
				if (units(numero[i])==-1){
					return -1;
				}
				num+=units(numero[i]);
			}
				
		}
		return num;
	}
	
	
	private int getThousandprev(String[] nums, int index){
		for (int i=index; i>-1; i--){
			if (nums[i].equals("million")){
				return i;
			}
		}
		return -1;
		
	}
	
	private int gethundredprev(String[] nums, int index){
		for (int i=index; i>-1; i--){
			if (nums[i].equals("million") || nums[i].equals("thousand")){
				return i;
			}
		}
		return -1;
		
	}
	

	
}
