package sample.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import sample.model.PremadeQuiz;
import sample.model.Question;
import sample.model.Quiz;
import sample.view.MainFrame;

public class AppController 
{
	private MainFrame appFrame;
	private Quiz mainQuiz;
	private PremadeQuiz premadeQuiz;
	private int currentQuestion;
	private int correctAnswers;
	private String exampleSaveCode = "10)0)^10,3,?^2,4,?^2,3,?^2,4,?^?,2,4^2,?,2^?,4,8^3,?,9^4,5,?^3,3,?@";
	
	public void  makeMainQuiz(int quizDifficulty,int maxQuestion) {
		mainQuiz = new Quiz(quizDifficulty,maxQuestion);
		currentQuestion = 1;
	}
	
	public void  makePremadeQuiz(String saveCode) {
		premadeQuiz = new PremadeQuiz(saveCode);
		currentQuestion = 1;
	}
	
	
	public void displayNextQuestion(){
		appFrame.getPanel();
	}
	
	public void buttonPressed() {
		if (currentQuestion < mainQuiz.getmaxQuestions())
		{
			checkAnswer();
		}else {
			// this is the place when the quiz is ended so the fish will move
			checkFinalAnswer();
			appFrame.getPanel().getTextField().setText("");
			moveAnimal();
		}
}
	

	
	public void UpdateQuestion() {
		int tempFactor1 =mainQuiz.getQuestionList().get(currentQuestion).getFactor1();
		appFrame.getPanel().setStringFactor1(""+tempFactor1);
		int tempFactor2 =mainQuiz.getQuestionList().get(currentQuestion).getFactor2();
		appFrame.getPanel().setStringFactor2(""+tempFactor2);
		int tempProduct =mainQuiz.getQuestionList().get(currentQuestion).getProduct();
		appFrame.getPanel().setStringProduct(""+tempProduct);
		appFrame.getPanel().setWhatsMissing(mainQuiz.getQuestionList().get(currentQuestion).getmissingEquals());
		appFrame.getPanel().setQuestionNumber(mainQuiz.getQuestionList().get(currentQuestion).getQuestionNumber());
		appFrame.getPanel().getLblQuestionNumber().setText("Question #:"+mainQuiz.getQuestionList().get(currentQuestion).getQuestionNumber());
		appFrame.getPanel().getFactor1().setText(""+tempFactor1);
		appFrame.getPanel().getFactor2().setText(""+tempFactor2);
		appFrame.getPanel().getProduct().setText(""+tempProduct);
		hideQuestion();
		this.currentQuestion = currentQuestion + 1;
		appFrame.getPanel().getTextField().setText("");
	}
	
	
	public void checkAnswer() {
		String theirAnswer = appFrame.getPanel().getTextField().getText();
		int whatsMissing = mainQuiz.getQuestionList().get(currentQuestion-1).getmissingEquals();
		if (whatsMissing == 1) {
			if (theirAnswer.equals(""+mainQuiz.getQuestionList().get(currentQuestion-1).getFactor1()))
			{
				correctAnswers = correctAnswers + 1;
				appFrame.getPanel().getProgressBar().setValue(correctAnswers);
				dropQuestion(true);	
			}else {
				UpdateQuestion();
				makeFishSad();
			}
		}else if (whatsMissing == 2) {
			if (theirAnswer.equals(""+mainQuiz.getQuestionList().get(currentQuestion-1).getFactor2()))
			{
				correctAnswers = correctAnswers + 1;
				appFrame.getPanel().getProgressBar().setValue(correctAnswers);
				dropQuestion(true);	
			}else {
				UpdateQuestion();
				makeFishSad();
			}
		}else if (whatsMissing == 3) {
			if (theirAnswer.equals(""+mainQuiz.getQuestionList().get(currentQuestion-1).getProduct()))
			{
				correctAnswers = correctAnswers + 1;
				appFrame.getPanel().getProgressBar().setValue(correctAnswers);
				dropQuestion(true);	
			}else {
				UpdateQuestion();
				makeFishSad();
				
				
			}
		}
	}
	
	
	public void checkFinalAnswer() {
		String theirAnswer = appFrame.getPanel().getTextField().getText();
		int whatsMissing = mainQuiz.getQuestionList().get(currentQuestion-1).getmissingEquals();
		if (whatsMissing == 1) {
			if (theirAnswer.equals(""+mainQuiz.getQuestionList().get(currentQuestion-1).getFactor1()))
			{
				correctAnswers = correctAnswers + 1;
				appFrame.getPanel().getProgressBar().setValue(correctAnswers);
				
			}
		}else if (whatsMissing == 2) {
			if (theirAnswer.equals(""+mainQuiz.getQuestionList().get(currentQuestion-1).getFactor2()))
			{
				correctAnswers = correctAnswers + 1;
				appFrame.getPanel().getProgressBar().setValue(correctAnswers);
				
			}
		}else if (whatsMissing == 3) {
			if (theirAnswer.equals(""+mainQuiz.getQuestionList().get(currentQuestion-1).getProduct()))
			{
				correctAnswers = correctAnswers + 1;
				appFrame.getPanel().getProgressBar().setValue(correctAnswers);
				
			}
		}
	}
	
	public void hideQuestion() {
		if (mainQuiz.getQuestionList().get(currentQuestion).getmissingEquals() == 1)
		{
			appFrame.getPanel().getFactor1().setText("?");
		}else if(mainQuiz.getQuestionList().get(currentQuestion).getmissingEquals() == 2)
		{
			appFrame.getPanel().getFactor2().setText("?");
		}else if(mainQuiz.getQuestionList().get(currentQuestion).getmissingEquals() == 3)
		{
			appFrame.getPanel().getProduct().setText("?");
		}
	}
	
	public void dropQuestion(boolean isCorrect) {
		Thread thread = new Thread(() -> {
			if (isCorrect == true) {
			int a = 0;
			int x=0;
		    while (a<120) {
		    	
		        try {
		            Thread.sleep(10);
		            appFrame.getPanel().getFactor1().setBounds(93, 186+x, 38, 37);
		            appFrame.getPanel().getMultiplier().setBounds(141, 196+x, 12, 25);
		            appFrame.getPanel().getFactor2().setBounds(191, 186+x, 44, 37);
		            appFrame.getPanel().getEqual().setBounds(245, 186+x, 22, 37);
		            appFrame.getPanel().getProduct().setBounds(288, 186+x, 50, 37);
		        
		            
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		         }
		        a++;
		        x=x+2;
		        if(a==120) {
		        	int innerLoop=3;
		            while(innerLoop<300) {
		            	try {
		            		Thread.sleep(10);
		            		
		            	    appFrame.getPanel().getFactor1().setBounds(93+innerLoop, 186+x, 38, 37);
		            		
				            appFrame.getPanel().getMultiplier().setBounds(141+innerLoop, 196+x, 12, 25);
				            if(innerLoop < 220) {
				            appFrame.getPanel().getFactor2().setBounds(191+innerLoop, 186+x, 44, 37);
				            }else {
				            	 appFrame.getPanel().getFactor2().setVisible(false);
				            }
				            if(innerLoop < 180) {
				            appFrame.getPanel().getEqual().setBounds(245+innerLoop, 186+x, 22, 37);
				            }else {
				            	 appFrame.getPanel().getEqual().setVisible(false);
				            }
				            if(innerLoop < 150) {
				            appFrame.getPanel().getProduct().setBounds(288+innerLoop, 186+x, 50, 37);
				            }else {
				            	  appFrame.getPanel().getProduct().setVisible(false);
				            }
				            
		            		
		            	}catch (InterruptedException e) {
				            e.printStackTrace();
				         }
		            	innerLoop=innerLoop+3;
		            	if(innerLoop>=298) {
		            		appFrame.getPanel().getLblImageAnimal().setIcon(new ImageIcon("images\\fishCloseMouth.png"));
		            		try {
								Thread.sleep(500);
								appFrame.getPanel().getLblImageAnimal().setIcon(new ImageIcon("images\\fishHappy.png"));
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
		            		try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
		            	}
		 
		            }
		        }
		    }
		    
			
		    appFrame.getPanel().getFactor1().setBounds(93, 186, 38, 37);
		    appFrame.getPanel().getMultiplier().setBounds(141, 196, 12, 25);
		    appFrame.getPanel().getFactor2().setBounds(191, 186, 44, 37);
		    appFrame.getPanel().getEqual().setBounds(245, 186, 22, 37);
		    appFrame.getPanel().getProduct().setBounds(288, 186, 50, 37);
		    appFrame.getPanel().getEqual().setVisible(true);
		    appFrame.getPanel().getProduct().setVisible(true);
		    appFrame.getPanel().getFactor2().setVisible(true);
		    appFrame.getPanel().getLblImageAnimal().setIcon(new ImageIcon("images\\fishOpenMouth.png"));
		    UpdateQuestion();
			}
		});
		thread.start();
	}
	
	public void moveAnimal() {
		Thread thread = new Thread(() -> {
			appFrame.getPanel().getLblImageAnimal().setIcon(new ImageIcon("images\\happyFishRight.png"));
			int a = 0;
			int b=0;
		    while (a<300) {
		        try {
		            Thread.sleep(10);
		            appFrame.getPanel().getLblImageAnimal().setBounds(59+b, 340, 317, 227);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		         }
		        a++;
		        b=b+3;
		    }
			appFrame.getPanel().getMainPanel().remove(appFrame.getPanel().getLblImageAnimal());
			appFrame.setupEndFrame();
		});
		thread.start();

	}
	
	private void makeFishSad() {
		Thread thread = new Thread(() -> {
			appFrame.getPanel().getLblImageAnimal().setIcon(new ImageIcon("images\\fishSad.png"));
			try {
				Thread.sleep(500);
				appFrame.getPanel().getLblImageAnimal().setIcon(new ImageIcon("images\\fishOpenMouth.png"));
				Thread.sleep(500);;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		thread.start();
	}
	

	
	public void premadeButtonPressed() {
		if (currentQuestion < premadeQuiz.getMaxQuestions())
		{
			premadeCheckAnswer();
		}else {
			// end of quiz
			premadeCheckFinalAnswer();
			appFrame.getPremadePanel().getTextField().setText("");
			premadeMoveAnimal();
		}
}
	
	
	
	public void premadeCheckAnswer() {
		String theirAnswer = appFrame.getPremadePanel().getTextField().getText();
		int whatsMissing = premadeQuiz.getQuestionList().get(currentQuestion-1).getMissingEquals();
		if (whatsMissing == 1) {
			if (theirAnswer.equals(""+premadeQuiz.getQuestionList().get(currentQuestion-1).getFactor1()))
			{
				correctAnswers = correctAnswers + 1;
				appFrame.getPremadePanel().getProgressBar().setValue(correctAnswers);
				premadeDropQuestion(true);	
			}else {
				premadeUpdateQuestion();
				premadeMakeFishSad();
			}
		}else if (whatsMissing == 2) {
			if (theirAnswer.equals(""+premadeQuiz.getQuestionList().get(currentQuestion-1).getFactor2()))
			{
				correctAnswers = correctAnswers + 1;
				appFrame.getPremadePanel().getProgressBar().setValue(correctAnswers);
				premadeDropQuestion(true);	
			}else {
				premadeUpdateQuestion();
				premadeMakeFishSad();
			}
		}else if (whatsMissing == 3) {
			if (theirAnswer.equals(""+premadeQuiz.getQuestionList().get(currentQuestion-1).getProduct()))
			{
				correctAnswers = correctAnswers + 1;
				appFrame.getPremadePanel().getProgressBar().setValue(correctAnswers);
				premadeDropQuestion(true);	
			}else {
				premadeUpdateQuestion();
				premadeMakeFishSad();
			}
		}
	}
	
	public void premadeCheckFinalAnswer() {
		String theirAnswer = appFrame.getPremadePanel().getTextField().getText();
		int whatsMissing = premadeQuiz.getQuestionList().get(currentQuestion-1).getMissingEquals();
		if (whatsMissing == 1) {
			if (theirAnswer.equals(""+premadeQuiz.getQuestionList().get(currentQuestion-1).getFactor1()))
			{
				correctAnswers = correctAnswers + 1;
				appFrame.getPremadePanel().getProgressBar().setValue(correctAnswers);
			}else {
			}
		}else if (whatsMissing == 2) {
			if (theirAnswer.equals(""+premadeQuiz.getQuestionList().get(currentQuestion-1).getFactor2()))
			{
				correctAnswers = correctAnswers + 1;
				appFrame.getPremadePanel().getProgressBar().setValue(correctAnswers);
			}else {
			}
		}else if (whatsMissing == 3) {
			if (theirAnswer.equals(""+premadeQuiz.getQuestionList().get(currentQuestion-1).getProduct()))
			{
				correctAnswers = correctAnswers + 1;
				appFrame.getPremadePanel().getProgressBar().setValue(correctAnswers);

			}else {
			}
		}
	}
	
	
	public void premadeUpdateQuestion() {
		
		int tempFactor1 =premadeQuiz.getQuestionList().get(currentQuestion).getFactor1();
		appFrame.getPremadePanel().setStringFactor1(""+tempFactor1);
		int tempFactor2 =premadeQuiz.getQuestionList().get(currentQuestion).getFactor2();
		appFrame.getPremadePanel().setStringFactor2(""+tempFactor2);
		int tempProduct =premadeQuiz.getQuestionList().get(currentQuestion).getProduct();
		appFrame.getPremadePanel().setStringProduct(""+tempProduct);
		appFrame.getPremadePanel().setWhatsMissing(premadeQuiz.getQuestionList().get(currentQuestion).getMissingEquals());
		appFrame.getPremadePanel().setQuestionNumber(premadeQuiz.getQuestionList().get(currentQuestion).getQuestionNumber());
		appFrame.getPremadePanel().getLblQuestionNumber().setText("Question #:"+premadeQuiz.getQuestionList().get(currentQuestion).getQuestionNumber());
		appFrame.getPremadePanel().getFactor1().setText(""+tempFactor1);
		appFrame.getPremadePanel().getFactor2().setText(""+tempFactor2);
		appFrame.getPremadePanel().getProduct().setText(""+tempProduct);
		premadeHideQuestion();
		this.currentQuestion = currentQuestion + 1;
		appFrame.getPremadePanel().getTextField().setText("");
	}
	
	
	
	
	public void premadeHideQuestion() {
		if (premadeQuiz.getQuestionList().get(currentQuestion).getMissingEquals() == 1)
		{
			appFrame.getPremadePanel().getFactor1().setText("?");
		}else if(premadeQuiz.getQuestionList().get(currentQuestion).getMissingEquals() == 2)
		{
			appFrame.getPremadePanel().getFactor2().setText("?");
		}else if(premadeQuiz.getQuestionList().get(currentQuestion).getMissingEquals() == 3)
		{
			appFrame.getPremadePanel().getProduct().setText("?");
		}
	}
	
	public void premadeDropQuestion(boolean isCorrect) {
		Thread thread = new Thread(() -> {
			if (isCorrect == true) {
			int a = 0;
			int x=0;
		    while (a<120) {
		    	
		        try {
		            Thread.sleep(10);
		            appFrame.getPremadePanel().getFactor1().setBounds(93, 186+x, 38, 37);
		            appFrame.getPremadePanel().getMultiplier().setBounds(141, 196+x, 12, 25);
		            appFrame.getPremadePanel().getFactor2().setBounds(191, 186+x, 44, 37);
		            appFrame.getPremadePanel().getEqual().setBounds(245, 186+x, 22, 37);
		            appFrame.getPremadePanel().getProduct().setBounds(288, 186+x, 50, 37);
		        
		            
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		         }
		        a++;
		        x=x+2;
		        if(a==120) {
		        	int innerLoop=3;
		            while(innerLoop<300) {
		            	try {
		            		Thread.sleep(10);
		            		
		            	    appFrame.getPremadePanel().getFactor1().setBounds(93+innerLoop, 186+x, 38, 37);
		            		
				            appFrame.getPremadePanel().getMultiplier().setBounds(141+innerLoop, 196+x, 12, 25);
				            if(innerLoop < 220) {
				            appFrame.getPremadePanel().getFactor2().setBounds(191+innerLoop, 186+x, 44, 37);
				            }else {
				            	 appFrame.getPremadePanel().getFactor2().setVisible(false);
				            }
				            if(innerLoop < 180) {
				            appFrame.getPremadePanel().getEqual().setBounds(245+innerLoop, 186+x, 22, 37);
				            }else {
				            	 appFrame.getPremadePanel().getEqual().setVisible(false);
				            }
				            if(innerLoop < 150) {
				            appFrame.getPremadePanel().getProduct().setBounds(288+innerLoop, 186+x, 50, 37);
				            }else {
				            	  appFrame.getPremadePanel().getProduct().setVisible(false);
				            }
				            
		            		
		            	}catch (InterruptedException e) {
				            e.printStackTrace();
				         }
		            	innerLoop=innerLoop+3;
		            	if(innerLoop>=298) {
		            		appFrame.getPremadePanel().getLblImageAnimal().setIcon(new ImageIcon("images\\fishCloseMouth.png"));
		            		try {
								Thread.sleep(500);
								appFrame.getPremadePanel().getLblImageAnimal().setIcon(new ImageIcon("images\\fishHappy.png"));
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
		            		try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
		            	}
		 
		            }
		        }
		    }
		    
			
		    appFrame.getPremadePanel().getFactor1().setBounds(93, 186, 38, 37);
		    appFrame.getPremadePanel().getMultiplier().setBounds(141, 196, 12, 25);
		    appFrame.getPremadePanel().getFactor2().setBounds(191, 186, 44, 37);
		    appFrame.getPremadePanel().getEqual().setBounds(245, 186, 22, 37);
		    appFrame.getPremadePanel().getProduct().setBounds(288, 186, 50, 37);
		    appFrame.getPremadePanel().getEqual().setVisible(true);
		    appFrame.getPremadePanel().getProduct().setVisible(true);
		    appFrame.getPremadePanel().getFactor2().setVisible(true);
		    appFrame.getPremadePanel().getLblImageAnimal().setIcon(new ImageIcon("images\\fishOpenMouth.png"));
		    premadeUpdateQuestion();
			}
		});
		thread.start();
	}
	
	public void premadeMoveAnimal() {
		Thread thread = new Thread(() -> {
			appFrame.getPremadePanel().getLblImageAnimal().setIcon(new ImageIcon("images\\happyFishRight.png"));
			int a = 0;
			int b=0;
		    while (a<300) {
		        try {
		            Thread.sleep(10);
		            appFrame.getPremadePanel().getLblImageAnimal().setBounds(59+b, 340, 317, 227);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		         }
		        a++;
		        b=b+3;
		    }
			appFrame.getPremadePanel().getMainPanel().remove(appFrame.getPremadePanel().getLblImageAnimal());
			appFrame.setupPremadeEndFrame();
		});
		thread.start();

	}
	
	private void premadeMakeFishSad() {
		Thread thread = new Thread(() -> {
			appFrame.getPremadePanel().getLblImageAnimal().setIcon(new ImageIcon("images\\fishSad.png"));
			try {
				Thread.sleep(500);
				appFrame.getPremadePanel().getLblImageAnimal().setIcon(new ImageIcon("images\\fishOpenMouth.png"));
				Thread.sleep(500);;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		thread.start();
	}
	

	
	
	
	public Quiz getMainQuiz()
	{
		return mainQuiz;
	}
	
	
	public void start() {
		appFrame = new MainFrame(this);
		
	}
	public MainFrame getAppFrame() {
		return appFrame;
	}
	public int getCorrectAnswers() {
		return correctAnswers;
	}
	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	public PremadeQuiz getPremadeQuiz() {
		return premadeQuiz;
	}
	public void setPremadeQuiz(PremadeQuiz premadeQuiz) {
		this.premadeQuiz = premadeQuiz;
	}
	

}
