package sample.view;

import javax.swing.*;

import sample.controller.AppController;
import sample.model.Question;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GamePanel extends JPanel {
	private AppController baseController;
	private JPanel mainPanel;
	public int currentQuestionID;
	private int correctAnswers;
	private int whatsMissing;
	private int questionNumber;
	private int maxQuestions;
	private String stringFactor1;
	private String stringFactor2;
	private String stringProduct;
	private Question tempQuestion;
	private ArrayList<Question> refrenceList;
	private JLabel lblPercentage;
	private JLabel lblQuestionNumber;
	private JLabel lblImageAnimal;
	private JLabel factor1;
	private JLabel multiplier;
	private JLabel factor2;
	private JLabel equal;
	private JLabel product;
	private JTextField textField;
	private JButton btnCheckAwnser;
	private JProgressBar progressBar;

	public GamePanel(AppController baseController) {
		this.baseController = baseController;
		setBackground(Color.ORANGE);
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.ORANGE);
		mainPanel.setBounds(0, 0, 800, 600);
		setLayout(null);

		currentQuestionID = 0;
		correctAnswers = 0;
		maxQuestions = baseController.getMainQuiz().getmaxQuestions();
		refrenceList = new ArrayList<Question>();
		refrenceList = baseController.getMainQuiz().getQuestionList();
		tempQuestion = new Question(0, 0);
		tempQuestion = refrenceList.get(currentQuestionID);
		int tempFactor1 = tempQuestion.getFactor1();
		stringFactor1 = "" + tempFactor1;
		int tempFactor2 = tempQuestion.getFactor2();
		stringFactor2 = "" + tempFactor2;
		int tempProduct = tempQuestion.getProduct();
		stringProduct = "" + tempProduct;
		whatsMissing = tempQuestion.getmissingEquals();
		questionNumber = tempQuestion.getQuestionNumber();

		// make components
		lblImageAnimal = new JLabel("");
		factor1 = new JLabel(stringFactor1);
		multiplier = new JLabel("X");
		factor2 = new JLabel(stringFactor2);
		equal = new JLabel("=");
		product = new JLabel(stringProduct);
		btnCheckAwnser = new JButton("Check");
		lblPercentage = new JLabel("PERCENTAGE:");
		progressBar = new JProgressBar(0, maxQuestions);
		textField = new JTextField();
		lblQuestionNumber = new JLabel("Question #: 1");

		// set bounds
		lblImageAnimal.setBounds(290, 340, 317, 227);
		factor1.setBounds(93, 186, 38, 37);
		multiplier.setBounds(141, 196, 12, 25);
		factor2.setBounds(191, 186, 44, 37);
		equal.setBounds(245, 186, 22, 37);
		product.setBounds(288, 186, 50, 37);
		btnCheckAwnser.setBounds(447, 200, 89, 23);
		lblPercentage.setBounds(287, 11, 117, 14);
		progressBar.setBounds(414, 10, 146, 17);
		textField.setBounds(343, 186, 75, 35);
		lblQuestionNumber.setBounds(34, 11, 112, 14);

		// set fonts
		factor1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		multiplier.setFont(new Font("Tahoma", Font.PLAIN, 20));
		factor2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		equal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		product.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPercentage.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
		lblQuestionNumber.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));

		// set colours
		factor1.setBackground(Color.CYAN);
		factor1.setForeground(Color.BLACK);
		multiplier.setBackground(Color.BLACK);
		factor2.setBackground(Color.GRAY);
		factor2.setForeground(Color.BLACK);
		equal.setBackground(Color.GRAY);
		equal.setForeground(Color.BLACK);
		product.setBackground(Color.BLACK);
		product.setForeground(Color.BLACK);

		// additional settings
		progressBar.setStringPainted(true);
		textField.setColumns(4);
		lblImageAnimal.setIcon(new ImageIcon("images\\fishOpenMouth.png"));
		// add to panel
		add(mainPanel);
		mainPanel.setLayout(null);
		
		mainPanel.add(lblImageAnimal);
		mainPanel.add(factor1);
		mainPanel.add(multiplier);
		mainPanel.add(factor2);
		mainPanel.add(equal);
		mainPanel.add(product);
		mainPanel.add(lblPercentage);
		mainPanel.add(progressBar);
		mainPanel.add(btnCheckAwnser);
		mainPanel.add(textField);
		mainPanel.add(lblQuestionNumber);

		// final changes
		hideQuestion();
		setupListeners();
	}

	private void setupListeners() {
		btnCheckAwnser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				baseController.buttonPressed();
			}
		});
	}

	public void hideQuestion() {
		if (whatsMissing == 1) {
			factor1.setText("?");
		} else if (whatsMissing == 2) {
			factor2.setText("?");
		} else if (whatsMissing == 3) {
			product.setText("?");
		}
	}

	public int getWhatsMissing() {
		return whatsMissing;
	}

	public void setWhatsMissing(int whatsMissing) {
		this.whatsMissing = whatsMissing;
	}

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getStringFactor1() {
		return stringFactor1;
	}

	public void setStringFactor1(String stringFactor1) {
		this.stringFactor1 = stringFactor1;
	}

	public String getStringFactor2() {
		return stringFactor2;
	}

	public void setStringFactor2(String stringFactor2) {
		this.stringFactor2 = stringFactor2;
	}

	public String getStringProduct() {
		return stringProduct;
	}

	public void setStringProduct(String stringProduct) {
		this.stringProduct = stringProduct;
	}

	public JLabel getLblQuestionNumber() {
		return lblQuestionNumber;
	}

	public void setLblQuestionNumber(JLabel lblQuestionNumber) {
		this.lblQuestionNumber = lblQuestionNumber;
	}

	public JLabel getFactor1() {
		return factor1;
	}

	public void setFactor1(JLabel factor1) {
		this.factor1 = factor1;
	}

	public JLabel getFactor2() {
		return factor2;
	}

	public void setFactor2(JLabel factor2) {
		this.factor2 = factor2;
	}

	public JLabel getProduct() {
		return product;
	}

	public void setProduct(JLabel product) {
		this.product = product;
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	public JLabel getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(JLabel multiplier) {
		this.multiplier = multiplier;
	}

	public JLabel getEqual() {
		return equal;
	}

	public void setEqual(JLabel equal) {
		this.equal = equal;
	}

	public JLabel getLblImageAnimal() {
		return lblImageAnimal;
	}

	public void setLblImageAnimal(JLabel lblImageAnimal) {
		this.lblImageAnimal = lblImageAnimal;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public JButton getBtnCheckAwnser() {
		return btnCheckAwnser;
	}

	public void setBtnCheckAwnser(JButton btnCheckAwnser) {
		this.btnCheckAwnser = btnCheckAwnser;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

}
