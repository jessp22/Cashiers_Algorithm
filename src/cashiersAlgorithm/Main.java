package cashiersAlgorithm;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

	System.out.println("Welcome!");

	DecimalFormat df = new DecimalFormat("###.##");

	double totalCharge = getTotalAmountCharged();
		System.out.println("Your total amount due is: \t\t\t$" + df.format(totalCharge));

	double paymentGiven = getPaymentAmount(totalCharge);
		System.out.println("The amount you have given me is: \t$" + df.format(paymentGiven));

	double[] moneyDenominations = new double[] {20, 10, 5, 1, 0.5, .25, .10, .05, .01};
	int[] amountToGiveBack = new int [moneyDenominations.length];

	changeGivenBack(totalCharge, paymentGiven, moneyDenominations, amountToGiveBack);
	countMoneyBack(totalCharge, paymentGiven, moneyDenominations, amountToGiveBack);

        }

	private static void countMoneyBack(double totalCharge, double paymentGiven, double[] moneyDenominations, int[] amountToGiveBack) {
		double workingTotal = totalCharge;
    	DecimalFormat df = new DecimalFormat("###.##");
    	System.out.println("You gave me: \t\t\t\t\t\t$" + df.format(paymentGiven));
    	System.out.println("The total was: \t\t\t\t\t\t$" + df.format(workingTotal));


		for(int denominationIndex = moneyDenominations.length - 1; denominationIndex >= 0; denominationIndex--) {
			while(0 < amountToGiveBack[denominationIndex]) {
				amountToGiveBack[denominationIndex]--;
				workingTotal = workingTotal + moneyDenominations[denominationIndex];
				System.out.println("\t\tplus: $" + df.format(moneyDenominations[denominationIndex]) + "\t\t\tmakes: \t$" + df.format(workingTotal));
			}
		}

	}

	private static double getTotalAmountCharged() {
    	return (Math.random() * 200);
	}


	private static double getPaymentAmount( double totalCharge) {
    	double paymentGiven = getTotalAmountCharged();
		while (paymentGiven < totalCharge) {
			paymentGiven = getTotalAmountCharged();
		}
		return paymentGiven;
	}

	private static void changeGivenBack(double totalCharge, double paymentGiven, double[] moneyDenominations, int[] amountToGiveBack) {
		{
			double moneyBack = paymentGiven - totalCharge;
			DecimalFormat df = new DecimalFormat("###.##");
			System.out.println("Your change back is: \t\t\t\t$" + df.format(moneyBack));

			for(int denominationIndex = 0; denominationIndex < moneyDenominations.length; denominationIndex++)

			while (moneyBack > moneyDenominations[denominationIndex]) {
				amountToGiveBack[denominationIndex]++;
				moneyBack = moneyBack - moneyDenominations[denominationIndex];

			}
		}
	}

}
