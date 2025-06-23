package lu.embellishedduck.campaign_master.ruleset.probability;

import java.util.Random;

public class FairDie {

    //=======================
    // INSTANTIATE VARIABLES
    //=======================
    private final int numberOfFaces;

    private final double faceValue;


    //=============
    // CONSTRUCTOR
    //=============
    public FairDie(int numberOfFaces, double faceValue) {

        if (numberOfFaces < 2) throw new IllegalArgumentException("A die cannot have less than 2 faces. Please input a positive integer value.");
        this.numberOfFaces = numberOfFaces;
        if (faceValue <= 0.0d) throw new IllegalArgumentException("The face of a die cannot have a face value of less than 0. Please input a valid integer or decimal value");
        this.faceValue = faceValue;

    }//End of Constructor


    public double roll() {

        Random random = new Random();
        return (random.nextInt(numberOfFaces - 1) + 1) * faceValue;

    }//End of Method


    //=========
    // GETTERS
    //=========
    public int getNumberOfFaces() {return numberOfFaces;}
    public double getFaceValue() {return faceValue;}

}//End of Class