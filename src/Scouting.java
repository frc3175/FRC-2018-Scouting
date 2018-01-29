import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Scouting extends GraphicsProgram {

	@SuppressWarnings("unused")
	private boolean gameOn; // True after clicking the start button
	@SuppressWarnings("unused")
	private boolean isAuton; // First 15 seconds of the match

	// All the interactors that will be called more than once
	private GCanvas canvas = new GCanvas();
	private JTextField matchNum = new JTextField(5);
	private JTextField red1;
	private JTextField red2;
	private JTextField red3;
	private JTextField blue1;
	private JTextField blue2;
	private JTextField blue3;
	private JLabel Red1 = new JLabel("RED 1");
	private JLabel Red2 = new JLabel("RED 2");
	private JLabel Red3 = new JLabel("RED 3");
	private JLabel Blue1 = new JLabel("BLUE 1");
	private JLabel Blue2 = new JLabel("BLUE 2");
	private JLabel Blue3 = new JLabel("BLUE 3");
	private JLabel pending;
	private JLabel auton;
	private JLabel teleop;
	private JButton start;
	private JButton reset;
	private JButton submit;

	public void run() {
		initiation();
	}

	
	/**
	 * Adds all graphics to the canvas in the beginning.
	 **/
	private void initiation() {
		setCanvasSize(1000, 457);
		canvas.setSize(1000, 457);
		add(canvas, 0, 0);
		GImage field = new GImage("res/field.JPG");
		field.setSize(1000, 427);
		canvas.add(field, 0, 30);
		JLabel match = new JLabel("Match");
		match.setFont(new Font("Sans Serif", Font.BOLD | Font.ITALIC, 20));
		canvas.add(match, 30, 5);
		canvas.add(Red1, 20, 130);
		canvas.add(Red2, 20, 225);
		canvas.add(Red3, 20, 320);
		canvas.add(Blue3, 890, 130);
		canvas.add(Blue2, 890, 225);
		canvas.add(Blue1, 890, 320);
		addInteractors();
	}

	/*
	 * adds the interactors to the screen
	 */
	private void addInteractors() {
		pending = new JLabel("Pending");
		auton = new JLabel("Autonomous");
		teleop = new JLabel("Teleop");
		start = new JButton("Start");
		reset = new JButton("Reset");
		submit = new JButton("Submit");
		red1 = new JTextField(10);
		red2 = new JTextField(10);
		red3 = new JTextField(10);
		blue1 = new JTextField(10);
		blue2 = new JTextField(10);
		blue3 = new JTextField(10);
		pending.setFont(new Font("Sans Serif", Font.BOLD, 20));
		pending.setForeground(Color.RED);
		auton.setFont(new Font("Sans Serif", Font.BOLD, 20));
		auton.setForeground(Color.ORANGE);
		teleop.setFont(new Font("Sans Serif", Font.BOLD, 20));
		teleop.setForeground(Color.GREEN);
		canvas.add(pending, getWidth() / 2 - 100, 5);
		canvas.add(matchNum, 100, 10);
		canvas.add(red1, 20, 145);
		canvas.add(red2, 20, 240);
		canvas.add(red3, 20, 335);
		canvas.add(blue3, 890, 145);
		canvas.add(blue2, 890, 240);
		canvas.add(blue1, 890, 335);
		canvas.add(start, getWidth() - 300, 10);
		canvas.add(reset, getWidth() - 200, 10);
		canvas.add(submit, getWidth() - 100, 10);
		addActionListeners();
	}

	
	/**
	 * Listens for and responds to action commands.
	 **/
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == start) {
			// When the match starts
			gameOn = true;
			isAuton = true;
			
		} else if (event.getSource() == reset) {
			// When the match resets
		}
	}

	
	/**
	 * Keep statistics for one match.
	 **/
	private void recordOneGame() {
		
	}

}