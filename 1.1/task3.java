import java.util.Scanner;

public class SumOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		float sum = 0;
		float product = 1;

        System.out.println("Give the first number:");
		float first = Integer.parseInt(scanner.nextLine());
		sum += first;
		product *= first;

        System.out.println("Give the second number:");
		float second = Integer.parseInt(scanner.nextLine());
		sum += second;
		product *= second;

        System.out.println("Give the third number:");
		float third = Integer.parseInt(scanner.nextLine());
		sum += third;
		product *= third;

		// The variables must be float in the average calculation
		// to avoid integer division which gives 4.0 instead of 4.33333
		float avg = sum/3;
		System.out.println("Sum: " + sum + 
						   "\nProduct: " + product + 
						   "\nAverage: " + avg);
    }
}
