package sample.model;

import java.util.ArrayList;

public class Quiz {
	private ArrayList<Question> questionList;
	private int questionCount = 0;
	private int maxQuestions;
	private int quizDifficulty;
	private String saveCode;

	public Quiz(int quizDifficulty, int maxQuestion) {
		this.quizDifficulty = quizDifficulty;
		this.maxQuestions = maxQuestion;
		questionList = new ArrayList<Question>(); // declare array of questions
		initiateSaveCode();
		makeQuiz(maxQuestion); // it will make a quiz which will have maxQuestion
		endSaveCode();
	}

	/*
	 * The makeQuiz method will make the quiz which will have the maximum number of
	 * question.
	 */
	public void makeQuiz(int maxQuestion) {
		int i = 0;
		while (maxQuestions > questionCount) {
			i = calcQuestionDiff(quizDifficulty);
			makeQuestion(i); // it will make question based on the difficulty of what variable "i" have
			questionCount++;
			String tempSaveCode = genSaveCodePart();
			addCodePart(tempSaveCode);
		}
	}

	/*
	 * Return the list of all questions
	 */
	public ArrayList<Question> getQuestionList() {
		return questionList;
	}

	public void setQuizDifficulty(int difficulty) {
		quizDifficulty = difficulty;
	}

	/*
	 * It will make questions based on the question Difficulty
	 */
	public boolean makeQuestion(int questionDifficulty) {
		boolean canMakeQuestion = false;
		if (maxQuestions > questionCount) {
			Question currentQuestion = new Question(questionCount, questionDifficulty);
			questionList.add(currentQuestion);
			canMakeQuestion = true;
		}
		return canMakeQuestion;
	}

	/*
	 * It will calculate the difficulty of the question based on the quiz difficulty
	 * and will return the question difficulty
	 */
	public int calcQuestionDiff(int quizDifficulty) {
		int questionNumber = questionCount + 1;
		int questionDifficulty = 0;

		if (quizDifficulty == 0) {
			// if the question is less than 70% of the way through the quiz
			if (questionNumber <= ((maxQuestions / 10) * 7)) 
			{
				questionDifficulty = 0;
			} 
			// if question is more than 70% of the way through the quiz
			else if (questionNumber > ((maxQuestions / 10) * 7)) 
			{
				questionDifficulty = 1;
			}
		} else if (quizDifficulty == 1) {
			// if the question is less than 30% of the way through the quiz
			if (questionNumber <= ((maxQuestions / 10) * 3)) 
			{
				questionDifficulty = 0;
			}
			// if the question is 40-80% of the way through the quiz
			else if (questionNumber <= ((maxQuestions / 10) * 8) && questionNumber >= ((maxQuestions / 10) * 4)) 
			{
				questionDifficulty = 1;
			} 
			// if question is more than 80% of the way through the quiz
			else if (questionNumber >= ((maxQuestions / 10) * 9)) 
			{
				questionDifficulty = 2;
			}
		} else if (quizDifficulty == 2) {
			 // if the question is less than 10% of the way through the quiz
			if (questionNumber <= ((maxQuestions / 10) * 1))
			{
				questionDifficulty = 0;
			}
			// if the questions is 10-30% of the way through the quiz
			else if (questionNumber <= ((maxQuestions / 10) * 3) && questionNumber >= ((maxQuestions / 10) * 2)) 
			{
				questionDifficulty = 1;
			} 
			// if questions is 30-70% of the way through the quiz
			else if (questionNumber <= ((maxQuestions / 10) * 7) && questionNumber >= ((maxQuestions / 10) * 4)) 
			{
				questionDifficulty = 2;
			} 
			// if question is more than 70% of the way through the quiz
			else if (questionNumber >= ((maxQuestions / 10) * 8)) 
			{
				questionDifficulty = 3;
			}
		} else if (quizDifficulty == 3) {
			// if the question is less than 10% of the way through the quiz
			if (questionNumber <= ((maxQuestions / 10) * 1)) 
			{
				questionDifficulty = 1;
			}
			// if the question is 10-40% of the way through the quiz
			else if (questionNumber <= ((maxQuestions / 10) * 4) && questionNumber >= ((maxQuestions / 10) * 2)) 
			{
				questionDifficulty = 2;
			}
			// if question is more than 40% of the way through the quiz
			else if (questionNumber >= ((maxQuestions / 10) * 5)) 
			{
				questionDifficulty = 3;
			}
		}
		return questionDifficulty;
	}

	/*
	 * It will add the settings for the quiz to the savecode string
	 */
	public void initiateSaveCode() {
		saveCode = "" + maxQuestions + ")" + quizDifficulty + ")";
	}

	public String genSaveCodePart() {
		int tempWhatsMissing = questionList.get(questionCount - 1).getmissingEquals();
		String codeSegment = "";
		int tempFac;
		if (tempWhatsMissing != 1) {
			tempFac = questionList.get(questionCount - 1).getFactor1();
			codeSegment = codeSegment + "" + tempFac + ",";
		} else {
			codeSegment = codeSegment + "?,";
		}
		if (tempWhatsMissing != 2) {
			tempFac = questionList.get(questionCount - 1).getFactor2();
			codeSegment = codeSegment + "" + tempFac + ",";
		} else {
			codeSegment = codeSegment + "?,";
		}
		if (tempWhatsMissing != 3) {
			tempFac = questionList.get(questionCount - 1).getProduct();
			codeSegment = codeSegment + "" + tempFac + "";
		} else {
			codeSegment = codeSegment + "?";
		}
		return codeSegment;
	}

	public void addCodePart(String codePart) {
		saveCode = saveCode + "^" + codePart;
	}

	public void endSaveCode() {
		saveCode = saveCode + "@";
	}

	public int getquestionCount() {
		return questionCount;
	}

	public int getmaxQuestions() {
		return maxQuestions;
	}

	public String getSaveCode() {
		return saveCode;
	}

	public void setSaveCode(String saveCode) {
		this.saveCode = saveCode;
	}
}
