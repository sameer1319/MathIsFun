package sample.view;

import javax.swing.JPanel;

import sample.controller.AppController;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class EndScreenPanel extends JPanel {
	private final JTextField textFieldForCode = new JTextField();
	private final JLabel lblPutThisCode = new JLabel("Put this code somewhere safe to try the same quiz again later!");
	private JLabel lblFishImage;

	/**
	 * Create the panel.
	 */
	public EndScreenPanel(AppController baseController, String panelType) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.ORANGE);
		mainPanel.setBounds(0, 0, 845, 610);
		add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblGot = new JLabel("You got: %");
		lblGot.setBounds(282, 78, 103, 22);
		mainPanel.add(lblGot);
		lblGot.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblJebTheFish = new JLabel("JEB THE FISH SAYS NICE JOB");
		lblJebTheFish.setBounds(282, 171, 264, 22);
		mainPanel.add(lblJebTheFish);
		lblJebTheFish.setFont(new Font("Tahoma", Font.BOLD, 18));
		
        double maxQuestion=0;
	    double correctAnswer=0;
	    double percentage=0;
		if (panelType.equals("NORMAL")) {
			 maxQuestion=baseController.getMainQuiz().getmaxQuestions();
			    correctAnswer=baseController.getCorrectAnswers();
			    percentage= ((correctAnswer/maxQuestion)*100);
		}else if(panelType.equals("PREMADE")) {
			maxQuestion=baseController.getPremadeQuiz().getMaxQuestions();
		    correctAnswer=baseController.getCorrectAnswers();
		    percentage= ((correctAnswer/maxQuestion)*100);
		}
		
		JLabel lblPercentage = new JLabel(""+percentage);
		lblPercentage.setBounds(396, 75, 107, 25);
		mainPanel.add(lblPercentage);
		lblPercentage.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel lblCongratulations = new JLabel("CONGRATULATIONS");
		lblCongratulations.setBounds(300, 11, 190, 25);
		mainPanel.add(lblCongratulations);
		lblCongratulations.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		
		lblFishImage = new JLabel("");
		mainPanel.add(lblFishImage);
		lblFishImage.setBounds(224, 204, 353, 206);
		lblFishImage.setIcon(new ImageIcon("images\\fishHappy.png"));
		lblPutThisCode.setBounds(246, 408, 388, 31);
		mainPanel.add(lblPutThisCode);
		
		textFieldForCode.setBounds(299, 458, 247, 31);
		mainPanel.add(textFieldForCode);
		textFieldForCode.setColumns(10);
		if(panelType.equals("NORMAL")) {
		textFieldForCode.setText(baseController.getMainQuiz().getSaveCode());
		}else if(panelType.equals("PREMADE")) {
			textFieldForCode.setText(baseController.getPremadeQuiz().getSaveCode());
		}
		}

	
	
	public JLabel getLblFishImage() {
		return lblFishImage;
	}

	public void setLblFishImage(JLabel lblFishImage) {
		this.lblFishImage = lblFishImage;
	}
}
