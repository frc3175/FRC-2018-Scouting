import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;
import acm.program.GraphicsProgramInterface;

public class Scouting extends GraphicsProgram {

	/** True after clicking the start button **/
	private boolean gameOn;

	/** First 15 seconds of the match **/
	private boolean isAuton;

	// data to record
	private String matchNumber = null;
	private Boolean isRed = null;
	private String teamNumber = null;
	private Boolean autoRun = null;
	private Integer autoSwitch = 0;
	private Integer autoScale = 0;
	private Integer mySwitch = 0;
	private Integer oppSwitch = 0;
	private Integer teleopScale = 0;
	private Integer vault = 0;
	private Boolean climb = null;
	private Boolean parked = null;

	// All the interactors that will be called more than once
	private GCanvas canvas = new GCanvas();
	private JTextField matchNum = new JTextField(5);
	private JTextField red1;
	private JTextField red2;
	private JTextField red3;
	private JTextField blue1;
	private JTextField blue2;
	private JTextField blue3;
	private JComboBox mode;
	private JButton start;
	private JButton reset;
	private JButton submit;
	private JButton blueLine;
	private JButton blueRung;
	private JButton blueVault;
	private JButton bottomScale;
	private JButton redBottomSwitch;
	private JButton blueBottomSwitch;
	private JButton redLine;
	private JButton redRung;
	private JButton redVault;
	private JButton topScale;
	private JButton redTopSwitch;
	private JButton blueTopSwitch;

	public void run() {
		initiation();
		addFieldComponents();
	}

	/**
	 * Adds all the graphics to canvas in the beginning.
	 **/
	private void initiation() {
		JLabel Red1 = new JLabel("RED 1");
		Red1.setForeground(Color.RED);
		JLabel Red2 = new JLabel("RED 2");
		Red2.setForeground(Color.RED);
		JLabel Red3 = new JLabel("RED 3");
		Red3.setForeground(Color.RED);
		JLabel Blue1 = new JLabel("BLUE 1");
		Blue1.setForeground(Color.BLUE);
		JLabel Blue2 = new JLabel("BLUE 2");
		Blue2.setForeground(Color.BLUE);
		JLabel Blue3 = new JLabel("BLUE 3");
		Blue3.setForeground(Color.BLUE);

		setCanvasSize(1000, 457);
		canvas.setSize(1000, 457);
		add(canvas, 0, 0);

		GImage field = new GImage("res/field.JPG");
		field.setSize(1000, 427);
		canvas.add(field, 0, 30);
		JLabel match = new JLabel("Match");
		match.setFont(new Font("Sans Serif", Font.BOLD | Font.ITALIC, 20));
		JLabel selectMode = new JLabel("Mode");
		selectMode.setFont(new Font("Sans Serif", Font.BOLD, 20));

		canvas.add(selectMode, getWidth() / 2 - 100, 5);
		canvas.add(match, 30, 5);
		canvas.add(Red1, 20, 130);
		canvas.add(Red2, 20, 225);
		canvas.add(Red3, 20, 320);
		canvas.add(Blue3, 890, 130);
		canvas.add(Blue2, 890, 225);
		canvas.add(Blue1, 890, 320);

		addInteractors();
		System.out.println("Initialized...");
	}

	/**
	 * Makes the game elements that can earn points.
	 **/
	private void addFieldComponents() {
		blueLine = new JButton(new ImageIcon("res/blueLine.JPG"));
		blueLine.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		blueLine.setContentAreaFilled(true);
		blueLine.addMouseListener(this);
		blueRung = new JButton(new ImageIcon("res/blueRung.JPG"));
		blueRung.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		blueRung.setContentAreaFilled(true);
		blueRung.addMouseListener(this);
		blueVault = new JButton(new ImageIcon("res/blueVault.JPG"));
		blueVault.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		blueVault.setContentAreaFilled(true);
		blueVault.addMouseListener(this);
		bottomScale = new JButton(new ImageIcon("res/bottomScale.JPG"));
		bottomScale.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		bottomScale.setBackground(Color.BLUE);
		bottomScale.addMouseListener(this);
		blueBottomSwitch = new JButton();
		blueBottomSwitch.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		blueBottomSwitch.setOpaque(true);
		blueBottomSwitch.setBackground(Color.BLUE);
		blueBottomSwitch.addMouseListener(this);
		redBottomSwitch = new JButton();
		redBottomSwitch.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		redBottomSwitch.setOpaque(true);
		redBottomSwitch.setBackground(Color.BLUE);
		redBottomSwitch.addMouseListener(this);
		redLine = new JButton(new ImageIcon("res/redLine.JPG"));
		redLine.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		redLine.setContentAreaFilled(true);
		redLine.addMouseListener(this);
		redRung = new JButton(new ImageIcon("res/redRung.JPG"));
		redRung.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		redRung.setContentAreaFilled(true);
		redRung.addMouseListener(this);
		redVault = new JButton(new ImageIcon("res/redVault.JPG"));
		redVault.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		redVault.setContentAreaFilled(true);
		redVault.addMouseListener(this);
		topScale = new JButton(new ImageIcon("res/topScale.JPG"));
		topScale.setBorder(BorderFactory.createLineBorder(Color.RED));
		bottomScale.setBackground(Color.RED);
		topScale.addMouseListener(this);
		blueTopSwitch = new JButton();
		blueTopSwitch.setBorder(BorderFactory.createLineBorder(Color.RED));
		blueTopSwitch.setOpaque(true);
		blueTopSwitch.setBackground(Color.RED);
		blueTopSwitch.addMouseListener(this);
		redTopSwitch = new JButton();
		redTopSwitch.setBorder(BorderFactory.createLineBorder(Color.RED));
		redTopSwitch.setOpaque(true);
		redTopSwitch.setBackground(Color.RED);
		redTopSwitch.addMouseListener(this);
		addMouseListeners();

		blueLine.setSize(10, 410);
		canvas.add(blueLine, 720, 40);
		blueRung.setSize(20, 30);
		canvas.add(blueRung, 505, 230);
		blueVault.setSize(85, 65);
		canvas.add(blueVault, 810, 255);
		bottomScale.setSize(60, 45);
		canvas.add(bottomScale, 470, 297);
		blueBottomSwitch.setSize(65, 50);
		redBottomSwitch.setSize(65, 50);
		canvas.add(redBottomSwitch, 300, 280);
		canvas.add(blueBottomSwitch, 640, 280);
		redLine.setSize(10, 410);
		canvas.add(redLine, 274, 40);
		redRung.setSize(20, 30);
		canvas.add(redRung, 477, 230);
		redVault.setSize(85, 65);
		canvas.add(redVault, 115, 170);
		topScale.setSize(60, 45);
		canvas.add(topScale, 474, 144);
		blueTopSwitch.setSize(65, 50);
		redTopSwitch.setSize(65, 50);
		canvas.add(redTopSwitch, 300, 156);
		canvas.add(blueTopSwitch, 640, 157);
	}

	/**
	 * Adds the interactors to the screen.
	 **/
	private void addInteractors() {
		start = new JButton("Start");
		reset = new JButton("Reset");
		submit = new JButton("Submit");

		red1 = new JTextField(10);
		red2 = new JTextField(10);
		red3 = new JTextField(10);
		blue1 = new JTextField(10);
		blue2 = new JTextField(10);
		blue3 = new JTextField(10);

		String[] modes = { "Pending", "Autonomous", "Teleop" };
		mode = new JComboBox(modes);
		mode.setSelectedIndex(0);

		canvas.add(matchNum, 100, 10);
		canvas.add(mode, getWidth() / 2, 10);
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
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == start) {
			// When the match starts
			gameOn = true;
			isAuton = true;
			mode.setSelectedIndex(1);
			matchNumber = matchNum.getText();
			if (!red1.getText().equals("")) {
				isRed = true;
				teamNumber = red1.getText();
			}
			if (!red2.getText().equals("")) {
				isRed = true;
				teamNumber = red2.getText();
			}
			if (!red3.getText().equals("")) {
				isRed = true;
				teamNumber = red3.getText();
			}
			if (!blue1.getText().equals("")) {
				isRed = false;
				teamNumber = blue1.getText();
			}
			if (!blue2.getText().equals("")) {
				isRed = false;
				teamNumber = blue2.getText();
			}
			if (!blue3.getText().equals("")) {
				isRed = false;
				teamNumber = blue3.getText();
			}
		} else if (event.getSource() == reset) {
			// When the match resets
			gameOn = false;
			isAuton = true;
			mode.setSelectedIndex(0);
			matchNum.setText("");
			red1.setText("");
			red2.setText("");
			red3.setText("");
			blue1.setText("");
			blue2.setText("");
			blue3.setText("");
			matchNumber = null;
			isRed = null;
			teamNumber = null;
			autoRun = null;
			autoSwitch = 0;
			autoScale = 0;
			mySwitch = 0;
			oppSwitch = 0;
			teleopScale = 0;
			vault = 0;
			climb = null;
			parked = null;
		} else if (event.getSource() == submit) {
			if (matchNumber != null && teamNumber != null) {
				gameOn = false;
				isAuton = true;
				mode.setSelectedIndex(0);
				matchNum.setText("");
				red1.setText("");
				red2.setText("");
				red3.setText("");
				blue1.setText("");
				blue2.setText("");
				blue3.setText("");
				matchNumber = null;
				isRed = null;
				teamNumber = null;
				autoRun = null;
				autoSwitch = 0;
				autoScale = 0;
				mySwitch = 0;
				oppSwitch = 0;
				teleopScale = 0;
				vault = 0;
				parked = null;
			}
		} else if (event.getSource() == mode) {
			if (mode.getSelectedIndex() == 3) {
				// TeleOp mode
				isAuton = false;
			}
		}
		if (gameOn) {
			if (isAuton) {
				if (event.getSource() == blueLine || event.getSource() == redLine) {
					autoRun = true;
				}
				// if (event.getSource() == )
			} else {

			}
		}

	}

}
