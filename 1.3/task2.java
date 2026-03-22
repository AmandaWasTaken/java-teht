import java.util.Scanner;

class main {

	// too lazy to type out "System.out.println" every time
	private static void print(final String str){
		System.out.println(str);
	}

	private static int to_decimal(final String bin){
		
		int decimal = 0;
		for(int i = 0; i < bin.length(); i++){
			if(bin.charAt(i) == '1'){
				int ex = bin.length() - 1 - i;
				decimal += (int)Math.pow(2, ex);
			}
		}
		return decimal;
	}

	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String bin;
		print("Input a binary number");
		bin = sc.nextLine(); 
		int decimal = to_decimal(bin);
		print("Decimal: " + decimal);
	}
}
