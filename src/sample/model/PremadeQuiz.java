
/**
 * 

 */

package sample.model;

import java.util.ArrayList;

public class PremadeQuiz {
	private ArrayList<PremadeQuestion> QuestionList;
	private String saveCode;
	private int maxQuestions;
	private int quizDifficulty;
	private int questionCount;
	private int whatsMissing;
	
	// default constructor
	public PremadeQuiz(String saveCode){
		this.saveCode = saveCode;
		questionCount = 0;
		String justQuestions = seperateSettings() + '^';
		

		QuestionList = new ArrayList<PremadeQuestion>(); // declare array of questions
		int charPosInQuestionList = 0;
		// while i have less questions than i want
		while (questionCount < maxQuestions )
		{

			
			String question = seperateQuestion(justQuestions,charPosInQuestionList);	// Separate out a question from the string of all questions

			int factor1 = seperatefactor(question, 1);									// Separate out factor 1
			int factor2 = seperatefactor(question, 2);									// Separate out factor2
			int prod = seperatefactor(question, 3);										// Separate out product
			PremadeQuestion currentQuestion = new PremadeQuestion(factor1,factor2,prod,whatsMissing,questionCount);	// create a new question with these variables
			QuestionList.add(currentQuestion);																		// add it to the array of questions
			
			charPosInQuestionList = charPosInQuestionList + question.length() +1;;		// move to next question character position
			questionCount++;															// increment
		}
	}
	// separate out settings from the save code
	public String seperateSettings(){													
		int charPos = 0;
		String justQuestions= "";
		String charHolder = "";
		String part = "maxQuestions";
		while (saveCode.charAt(charPos) != ')')
		{
			charHolder = charHolder + saveCode.charAt(charPos);
			charPos++;
		}
		maxQuestions = Integer.parseInt(charHolder);
		charHolder = "";
		part = "quizDifficulty";
		charPos++;
		while (saveCode.charAt(charPos) != ')')
		{
			charHolder = charHolder + saveCode.charAt(charPos);
			charPos++;
		}
		quizDifficulty = Integer.parseInt(charHolder);
		charPos++;
		part = "questions";
		while (saveCode.charAt(charPos) != '@')
		{
			justQuestions = justQuestions + saveCode.charAt(charPos);
			charPos++;
		}
		return justQuestions;
	}
	// separate out a question from all questions
	public String seperateQuestion (String allQuestions, int startPos) {
		String question = "";
		startPos++;
		while (allQuestions.charAt(startPos) != '^' && startPos < allQuestions.length())
		{
			question = question + allQuestions.charAt(startPos);
			startPos++;
		}
		
		return question;
	}
	// separate out factors / products from a question
	public int seperatefactor(String question, int partWanted) {
		String stringFactor1 ="0";
		String stringFactor2 = "0";
		String stringProd = "0";
		int factor1=0;
		int factor2=0;
		int prod=0;
		int trigger = 0;
		
		int genericCounter = 0;
		int returnValue = 0;
		// separate factor1
		while (question.charAt(genericCounter) != ',')
		{
			if (question.charAt(genericCounter) == '?')
			{
				trigger = 1;
			}
			stringFactor1 = stringFactor1 + question.charAt(genericCounter);
			genericCounter++;
		}
		genericCounter++;
		// separate factor2
		while (question.charAt(genericCounter) != ',')
		{
			if (question.charAt(genericCounter) == '?')
			{
				trigger = 2;
			}
			stringFactor2 = stringFactor2 +question.charAt(genericCounter);
			genericCounter++;
		}
		genericCounter++;
		// separate product
		while (genericCounter < question.length())
		{
			if (question.charAt(genericCounter) == '?')
			{
				trigger = 3;
			}
			stringProd =stringProd +question.charAt(genericCounter);
			genericCounter++;
		}
		// set what's missing
		if (trigger == 1)
		{
			factor2 = Integer.parseInt(stringFactor2);

			prod = Integer.parseInt(stringProd);
			factor1 = prod / factor2;
			whatsMissing=0;
		}else if (trigger == 2)
		{
			factor1 = Integer.parseInt(stringFactor1);
			prod = Integer.parseInt(stringProd);

			factor2 = prod / factor1;
			whatsMissing=1;
		}else if (trigger == 3)
		{
			factor1 = Integer.parseInt(stringFactor1);
			factor2 = Integer.parseInt(stringFactor2);
			prod = factor1 * factor2;
			whatsMissing=2;
		}

		

		// return what wanted
		if (partWanted == 1)
		{
			returnValue = factor1;
			
		}else if (partWanted == 2)
		{
			returnValue = factor2;
		}else if (partWanted == 3)
		{
			returnValue = prod;
		}

		return returnValue;
		
		
		
	}
	// decide what is missing
	public int decideWhatsMissing(int fac1, int fac2, int prod){
		int missing = 0;
		if (fac1 == '?')
		{
			missing = 1;
		}else if (fac2 == '?')
		{
			missing = 2;
		}else if (prod == '?')
		{
			missing = 3;
		}
		return missing;
	}
	// getters and setters below
	public String getSaveCode() {
		return saveCode;
	}


	public void setSaveCode(String saveCode) {
		this.saveCode = saveCode;
	}

	public ArrayList<PremadeQuestion> getQuestionList() {
		return QuestionList;
	}

	public void setQuestionList(ArrayList<PremadeQuestion> questionList) {
		QuestionList = questionList;
	}

	public int getMaxQuestions() {
		return maxQuestions;
	}

	public void setMaxQuestions(int maxQuestions) {
		this.maxQuestions = maxQuestions;
	}

	public int getQuizDifficulty() {
		return quizDifficulty;
	}

	public void setQuizDifficulty(int quizDifficulty) {
		this.quizDifficulty = quizDifficulty;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}
	
	
	
	
	
}
