package lu.embellishedduck.campaign_master.ruleset.probability;

import java.util.Random;

public class FairDie {

    //=======================
    // PRE-DEFINED INSTANCES
    //=======================
    public static final FairDie coin = new FairDie(2, 1);
    public static final FairDie d4 = new FairDie(4, 1);
    public static final FairDie d6 = new FairDie(6, 1);
    public static final FairDie d8 = new FairDie(8, 1);
    public static final FairDie d10 = new FairDie(10, 1);
    public static final FairDie d12 = new FairDie(12, 1);
    public static final FairDie d20 = new FairDie(20, 1);
    public static final FairDie d100 = new FairDie(100, 1);
    
    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private int numberOfFaces;
    private int faceValue;

    
    //=============
    // CONSTRUCTOR
    //=============
    public FairDie(int numberOfFaces, int faceValue) {

        if (faceValue < 1) {

            faceValue = 1;
            throw new IllegalValueException("You cannot have a face value less than 1, please input a valid number");

        }//End of If-Statement
        if (numberOfFaces < 2) {

            numberOfFaces = 2
            throw new IllegalValueException("You cannot have a die with " + numberOfFaces + " faces!\nPlease input a positive integer greater than or equal to 2");

        }//End of If-Statement

        this.numberOfFaces = numberOfFaces,
        this.faceValue = faceValue;
        this.faceValues = new int[numberOfFaces];

    }//End of Constructor


    /**
     * Generates a random number within the bounds of the die's faces. Multiplies it by the face value and returns the result
     * @returns The result of the roll
     */
    public int roll() {

        Random random = new Random();
        return (random.nextInt(numberOfFaces - 1) + 1) * faceValue;

    }//End of Method


    //=========
    // GETTERS
    //=========
    public int getNumberOfFaces() {return numberOfFaces;}
    public int getFaceValue() {return faceValue;}

}//End of Class
