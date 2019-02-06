package sample.view;

import sample.controller.AppController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

	private JPanel menuPanel;
	private AppController baseController;
	private int maxQuestion;
	private JTextField textFieldForCode;
	private JButton buttonStartQuiz;
	private JLabel lblWhatDifficulty;
	private JLabel lblHowManyQuestion;
	private JComboBox comboBoxLevel;
	private JComboBox comboBoxMaxQuestion;
	private JLabel lblMathFun;
	private JLabel lblLoadQuiz;
	private JLabel lblOr;
	private JButton btnLoadAQuiz;

	public MenuPanel(AppController baseController) {
		this.baseController = baseController;
		
		makePanel();
	}

	public void makePanel() {
		menuPanel = new JPanel();
		setBackground(Color.ORANGE);
		menuPanel.setLayout(new GridLayout(1, 1, 0, 0));
		menuPanel.setBounds(0, 0, 800, 600);

		buttonStartQuiz = new JButton();
		buttonStartQuiz.setLocation(295, 353);
		buttonStartQuiz.setText("Start Quiz!");
		buttonStartQuiz.setSize(187, 90);
		add(buttonStartQuiz);

	
		lblWhatDifficulty = new JLabel("What difficulty would you like?");
		lblWhatDifficulty.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblWhatDifficulty.setBounds(83, 279, 214, 14);
		add(lblWhatDifficulty);
		
		lblHowManyQuestion = new JLabel("How many question would you like?");
		lblHowManyQuestion.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblHowManyQuestion.setBounds(73, 322, 226, 20);
		add(lblHowManyQuestion);
		
		comboBoxLevel = new JComboBox();
		comboBoxLevel.setBounds(349, 276, 73, 20);
		comboBoxLevel.setModel(new DefaultComboBoxModel(new String[] { "Easy", "Medium", "Hard", "Very Hard" }));
		setLayout(null);
		add(comboBoxLevel);
		
		comboBoxMaxQuestion = new JComboBox();
		comboBoxMaxQuestion.setBounds(360, 322, 55, 20);
		comboBoxMaxQuestion.setMaximumRowCount(5);
		comboBoxMaxQuestion.setModel(new DefaultComboBoxModel(new String[] { "10", "20", "30", "40", "50" }));
		add(comboBoxMaxQuestion);
		
	    lblMathFun = new JLabel("");
		lblMathFun.setIcon(new ImageIcon("images\\math_is_fun.jpg"));
		lblMathFun.setBounds(310, 11, 422, 214);
		add(lblMathFun);
		
		textFieldForCode = new JTextField();
		textFieldForCode.setBounds(353, 504, 86, 20);
		textFieldForCode.setColumns(10);
		add(textFieldForCode);
	
		lblLoadQuiz = new JLabel("load up a quiz from earlier with your savecode!");
		lblLoadQuiz.setBounds(275, 479, 294, 20);
		add(lblLoadQuiz);
		
		lblOr = new JLabel("OR");
		lblOr.setBounds(382, 454, 33, 14);
		add(lblOr);
		
		btnLoadAQuiz = new JButton("Load a Quiz!");
		btnLoadAQuiz.setBounds(330, 535, 125, 23);
		add(btnLoadAQuiz);
	
		//in a case when button is pressed the below codes will be executed
		buttonStartQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				checkUserSelectedDifficulty(); //it will check which difficulty of the quiz the user chosen 
				baseController.getAppFrame().setupGameFrame();
			}
		});
	 	
	 	btnLoadAQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
			        String saveCode = textFieldForCode.getText();
			        baseController.makePremadeQuiz(saveCode);
			        baseController.getAppFrame().setupPremadeFrame();
			}
		});
	}
	
	public void checkUserSelectedDifficulty () {
		int quizDiff = 0;
        String selectedLevel = (String) comboBoxLevel.getSelectedItem();
        String selectedMaxQuestion = (String) comboBoxMaxQuestion.getSelectedItem();
          maxQuestion=Integer.parseInt(selectedMaxQuestion);
        if (selectedLevel.equals("Easy")) {
            quizDiff = 0;
        } else if (selectedLevel.equals("Medium")) {
        	 quizDiff = 1;
        }
        else if (selectedLevel.equals("Hard")) {
        	 quizDiff = 2;
        }
        else {
        	 quizDiff = 3;
        }
        baseController.makeMainQuiz(quizDiff,maxQuestion);
	}
}