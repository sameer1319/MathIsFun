package sample.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sample.controller.AppController;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;

public class MainFrame {
	private JFrame frame;
	private GamePanel panel;
	private EndScreenPanel endScreenPanel;
	private MenuPanel menuPanel;
	private AppController baseController;
	private PremadeSamplePanel premadePanel;


	public MainFrame(AppController baseController) {
		this.baseController = baseController;
		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupMenuFrame(); // it will set menu's frame
		frame.setResizable(false); // it can't be resized
		frame.setVisible(true);
	}

	public void setupMenuFrame() {
		menuPanel = new MenuPanel(baseController);
		frame.add(menuPanel);
	}

	public void setupGameFrame() {
		panel = new GamePanel(baseController);
		frame.setContentPane(panel);
		frame.setVisible(true);

	}

	public void setupPremadeFrame() {
		premadePanel = new PremadeSamplePanel(baseController);
		frame.setContentPane(premadePanel);
		frame.setVisible(true);
	}

	public void setupEndFrame() {
		endScreenPanel = new EndScreenPanel(baseController, "NORMAL");
		frame.setContentPane(endScreenPanel);
		frame.setVisible(true);
	}
	public void setupPremadeEndFrame() {
		endScreenPanel = new EndScreenPanel(baseController, "PREMADE");
		frame.setContentPane(endScreenPanel);
		frame.setVisible(true);
	}

	public GamePanel getPanel() {
		return panel;
	}

	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}

	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	public AppController getBaseController() {
		return baseController;
	}

	public void setBaseController(AppController baseController) {
		this.baseController = baseController;
	}

	public PremadeSamplePanel getPremadePanel() {
		return premadePanel;
	}

	public void setPremadePanel(PremadeSamplePanel premadePanel) {
		this.premadePanel = premadePanel;
	}

	public EndScreenPanel getEndScreenPanel() {
		return endScreenPanel;
	}

	public void setEndScreenPanel(EndScreenPanel endScreenPanel) {
		this.endScreenPanel = endScreenPanel;
	}

}
