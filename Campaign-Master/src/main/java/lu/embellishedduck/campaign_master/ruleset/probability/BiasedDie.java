package lu.embellishedduck.campaign_master.ruleset.probability;

import java.util.Arrays;
import java.util.Random;

public class BiasedDie extends FairDie {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private final int[] biasedFaceValues;

	private final double distorter;


	//=============
	// CONSTRUCTOR
	//=============
	public BiasedDie(int numberOfFaces, double faceValue, double distorter, int... biasedValues) {

		super(numberOfFaces, faceValue);

		this.biasedFaceValues = biasedValues;
		if (distorter <= 0) throw new IllegalArgumentException("The value of the distorter must be a positive decimal number between 1 and 0. Please input a valid value.");
		this.distorter = distorter;

	}//End of Constructor


	@Override
	public double roll() {

		// Local Variables
		Random random = new Random();

		int numberOfFaces = getNumberOfFaces();

		double result = 0;
		double cumulativeProbability = 0.0d;
		double randomValue = random.nextDouble();
		double[] probabilities = new double[numberOfFaces];

		// Calculate the probabilities of each face
		for (int index = 0; index < numberOfFaces; index++) {

			if (index == Arrays.binarySearch(biasedFaceValues, index)) probabilities[index] = 1.0d / numberOfFaces;// If the index or face number is one of the biased face values then calculate the biased probability.
			else probabilities[index] = 1.0d / numberOfFaces - (distorter * (1.0d / numberOfFaces - biasedFaceValues.length));// Otherwise calculate the uniform probability.

			cumulativeProbability += probabilities[index];// Add all the calculated probabilities, this is needed in the next step.

		}//End of For-Loop

		// The next step is to check if the sum of the probabilities (cumulativeProbability) is = 1, if not something is wrong because the sum of all probabilities must be 1.
		if (cumulativeProbability != 1.0d) throw new ArithmeticException("Sum of probabilities is not 1, impossible probability");
		cumulativeProbability = 0.0d;// Resetting the cumulative probability to use in the next step.

		// Determine the outcome of the dice roll, including the biased face values
		for (int index = 0; index < numberOfFaces; index++) {

			cumulativeProbability += probabilities[index];

			if (randomValue <= cumulativeProbability) {

				result = (index + 1) * getFaceValue();
				break;

			}//End of If-Statement

		}//End of For-Loop

		return result;

	}//End of Method

}//End of Class
