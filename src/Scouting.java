import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;

public class Scouting extends GraphicsProgram {
	
	private boolean gameOn;
	private boolean isAuton;
	
	private GCanvas canvas = new GCanvas();
	private JTextField matchNum = new JTextField(5);
	private JTextField red1 = new JTextField(10);
	private JTextField red2 = new JTextField(10);
	private JTextField red3 = new JTextField(10);
	private JTextField blue1 = new JTextField(10);
	private JTextField blue2 = new JTextField(10);
	private JTextField blue3 = new JTextField(10);
	private JLabel Red1 = new JLabel("RED 1");
	private JLabel Red2 = new JLabel("RED 2");
	private JLabel Red3 = new JLabel("RED 3");
	private JLabel Blue1 = new JLabel("BLUE 1");
	private JLabel Blue2 = new JLabel("BLUE 2");
	private JLabel Blue3 = new JLabel("BLUE 3");
	private JLabel pending = new JLabel("Pending");
	private JLabel auton = new JLabel("Autonomous");
	private JLabel teleop = new JLabel("Teleop");
	private JButton start = new JButton("Start");
	private JButton reset = new JButton("Reset");
	
	public void run() {
		initiation();
	}
	
	private void initiation() {
		setCanvasSize(1000, 457);
		canvas.setSize(1000, 457);
		add(canvas, 0, 0);
		GImage field = new GImage("res/field.JPG");
		field.setSize(1000, 427);
		canvas.add(field, 0, 30);
		JLabel match = new JLabel("Match");
		match.setFont(new Font("Sans Serif", Font.BOLD | Font.ITALIC, 20));
		canvas.add(match, 5, 5);
		canvas.add(matchNum, 75, 10);
		canvas.add(Red1, 20, 130);
		canvas.add(red1, 20, 145);
		canvas.add(Red2, 20, 225);
		canvas.add(red2, 20, 240);
		canvas.add(Red3, 20, 320);
		canvas.add(red3, 20, 335);
		canvas.add(Blue1, 890, 130);
		canvas.add(blue1, 890, 145);
		canvas.add(Blue2, 890, 225);
		canvas.add(blue2, 890, 240);
		canvas.add(Blue3, 890, 320);
		canvas.add(blue3, 890, 335);
		pending.setFont(new Font("Sans Serif", Font.BOLD, 20));
		pending.setForeground(Color.RED);
		auton.setFont (new Font ("Sans Serif", Font.BOLD, 20));
		auton.setForeground(Color.ORANGE);
		teleop.setFont (new Font ("Sans Serif", Font.BOLD, 20));
		teleop.setForeground(Color.GREEN);
		canvas.add(pending, getWidth() / 4, 5);
		canvas.add(start, getWidth() - 200, 10);
		canvas.add(reset, getWidth() - 100, 10); 
		addActionListeners();
	}
	
}