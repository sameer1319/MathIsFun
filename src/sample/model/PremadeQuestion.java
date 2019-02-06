
package sample.model;

public class PremadeQuestion {
	public int factor1;
	public int factor2;
	public int product;
	public int missingEquals;
	public int questionNumber;
	// sets values for the question object
	public PremadeQuestion(int fac1, int fac2, int prod, int whatsMissing, int questionCount) {
		this.factor1 = fac1;
		this.factor2 = fac2;
		this.product = prod;
		this.missingEquals = whatsMissing+1;
		this.questionNumber = questionCount+1;
	}
	// getters and setters below
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

	public int getMissingEquals() {
		return missingEquals;
	}

	public void setMissingEquals(int missingEquals) {
		this.missingEquals = missingEquals;
	}

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

}
