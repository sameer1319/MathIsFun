package sample.model;

import java.util.Random;

public class Question {
	private int factor1;
	private int factor2;
	private int product;
	private int missingEquals;
	private int questionNumber;

	public Question(int questionNo, int questionDifficulty) // main method
	{
		questionNumber = questionNo + 1;
		generateFactor(1, questionDifficulty); // generates and sets factor 1 based on question difficulty
		generateFactor(2, questionDifficulty); // generates and sets factor 2 based on question difficulty
		calcProduct(); // calculates and sets product (no variables)
		missingEquals=generateWhatsMissing(); // generates what is missing in the questions 1 stand for factor1, 2 for factor 2 and 3 for product
	}

	/*
	 * The below method will generates the factors based on which factor should be generated and the question difficulty
	 */
	public void generateFactor(int factor, int questionDifficulty) // handles random number generation																
	{
		Random rand = new Random();
		int n = 0;
		int valToReturn = 0;
			if (factor == 1) // if the factor is 1 it will generate the factor 1
			{
				n = rand.nextInt(3);
				if (questionDifficulty == 0) {
					if (n == 0) {
						valToReturn = 1;
					} else if (n == 1) {
						valToReturn = 2;
					} else if (n == 2) {
						valToReturn = 10;
					}

				} else if (questionDifficulty == 1) {
					if (n == 0) {
						valToReturn = 3;
					} else if (n == 1) {
						valToReturn = 4;
					} else if (n == 2) {
						valToReturn = 5;
					}
				} else if (questionDifficulty == 2) {
					if (n == 0) {
						valToReturn = 6;
					} else if (n == 1) {
						valToReturn = 7;
					} else if (n == 2) {
						valToReturn = 8;
					}
				} else if (questionDifficulty == 3) {
					if (n == 0) {
						valToReturn = 9;
					} else if (n == 1) {
						valToReturn = 11;
					} else if (n == 2) {
						valToReturn = 12;
					}
				}
				setFactor1(valToReturn); 
				
			} else if (factor == 2) // if the factor is 2 it will generate the factor 2 for it based on the question difficulty
			{
				if (questionDifficulty == 0) {
					n = rand.nextInt(6) + 1;
					if (n < 6) {
						valToReturn = n;
					} else if (n == 6) {
						valToReturn = 10;
					}

				} else if (questionDifficulty == 1) {
					n = rand.nextInt(6) + 1;
					if (n > 1) {
						valToReturn = n;
					} else if (n == 1) {
						valToReturn = 7;
					}
				} else if (questionDifficulty == 2) {
					n = rand.nextInt(8) + 1;
					if (n > 2) {
						valToReturn = n;
					} else if (n == 1) {
						valToReturn = 9;
					} else if (n == 2) {
						valToReturn = 8;
					}
				} else if (questionDifficulty == 3) {
					n = rand.nextInt(9) + 1;
					if (n > 3 && n != 10) {
						valToReturn = n;
					} else if (n == 1) {
						valToReturn = 9;
					} else if (n == 2) {
						valToReturn = 11;
					} else if (n == 3) {
						valToReturn = 12;
					}
				}
				setFactor2(valToReturn);
			}
	}

	public void calcProduct()
	{
		this.product = factor1 * factor2;
	}

	public int generateWhatsMissing() {
		Random randOneToThree = new Random();
		int missing = randOneToThree.nextInt(3) + 1;
		return missing;
	}

	/**
	 * Getters and setters below
	 */

	public int getFactor1() {
		return factor1;
	}

	public void setFactor1(int factor1) {
		this.factor1 = factor1;
	}

	public int getFactor2() {
		return factor2;
	}

	public void setFactor2(int factor2) {
		this.factor2 = factor2;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public int getmissingEquals() {
		return missingEquals;
	}

	public void setmissingEquals(int missingEquals) {
		this.missingEquals = missingEquals;
	}

	public int getQuestionNumber() {
		return questionNumber;
	}
}
