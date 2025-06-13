package lu.embellishedduck.campaign_master.ruleset.probability;

import java.util.Random;

public class BiasedDie extends FairDie {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private int[] biasedValues;    

    private float distorter;

    //=============
    // CONSTRUCTOR
    //=============
    public BiasedDie(int numberOfFaces, int faceValue, int... biasedValues, float distorter) {

        super(numberOfFaces, faceValue);

	    if(distorter >= 1 || distorter <= 0) {

            distorter = 0.5
            throw new IllegalValueException("The distorter must be a positive rational number (fraction) between 0 and 1");

        }//End of If-Statement
        
        this.biasedValues = biasedValues;
        this.distorter = distorter;

    }//End of Constructor

    
    @Override
    public int roll() {

	// Local Variables
	Random random = new Random();

	int result = 0;

	float cumulativeProbability = 0.0f;
	float randomValue = random.nextFloat();
        float[] probabilities = new float[numberOfFaces];

	// Calculate probability
	for(int i = 0; i < numberOfFaces; i++) {

	    if(isBiasedValue(i + 1, biasedValues)) probabilities[i] = 1.0f / numberOfFaces;
	    else probabilities[i] = 1.0f / numberOfFaces - (distorter * (1 / n - biasedValues.length));

	    cumulativeProbability += probabilities[i];

	}//End of For-Loop

	// Check if the sum of the probabilities = 1
	if (cumulativeProbability != 1.0f) throw new ArithmeticException("Sum of probabilities is not 1, impossible probability.");
	cumulativeProbability == 0.0f;

	// Determine the outcome
        for(int i = 0; i < numberOfFaces; i++) {

	    cumulativeProbability += probabilities[i];
	    
	    if (randomValue <= cumulativeProbability) {

		result = (i + 1) * faceValue;
		break;

	    }//End of If-Statement

	}//End of For-Loop

	return result;

    }//End of Method

}//End of Class
