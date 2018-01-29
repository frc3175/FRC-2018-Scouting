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
	private Integer teleSwitch = 0;
	private Integer teleScale = 0;
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
	private JButton redPark;
	private JButton bluePark;

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
		blueLine = new JButton();
		blueLine.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		blueLine.setContentAreaFilled(true);
		blueRung = new JButton();
		blueRung.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		blueRung.setContentAreaFilled(true);
		blueVault = new JButton("Vault");
		blueVault.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		blueVault.setBackground(Color.BLUE);
		bottomScale = new JButton("Scale");
		bottomScale.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		bottomScale.setBackground(Color.BLUE);
		blueBottomSwitch = new JButton("Switch");
		blueBottomSwitch.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		blueBottomSwitch.setOpaque(true);
		blueBottomSwitch.setBackground(Color.BLUE);
		redBottomSwitch = new JButton("Switch");
		redBottomSwitch.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		redBottomSwitch.setOpaque(true);
		redBottomSwitch.setBackground(Color.BLUE);
		redLine = new JButton();
		redLine.setBorder(BorderFactory.createLineBorder(Color.RED));
		redLine.setContentAreaFilled(true);
		redRung = new JButton();
		redRung.setBorder(BorderFactory.createLineBorder(Color.RED));
		redRung.setContentAreaFilled(true);
		redVault = new JButton("Vault");
		redVault.setBorder(BorderFactory.createLineBorder(Color.RED));
		redVault.setBackground(Color.RED);
		topScale = new JButton("Scale");
		topScale.setBorder(BorderFactory.createLineBorder(Color.RED));
		topScale.setBackground(Color.RED);
		blueTopSwitch = new JButton("Switch");
		blueTopSwitch.setBorder(BorderFactory.createLineBorder(Color.RED));
		blueTopSwitch.setOpaque(true);
		blueTopSwitch.setBackground(Color.RED);
		redTopSwitch = new JButton("Switch");
		redTopSwitch.setBorder(BorderFactory.createLineBorder(Color.RED));
		redTopSwitch.setOpaque(true);
		redTopSwitch.setBackground(Color.RED);
		redPark = new JButton("Park");
		redPark.setBorder(BorderFactory.createLineBorder(Color.RED));
		redPark.setOpaque(true);
		redPark.setBackground(Color.RED);
		bluePark = new JButton("Park");
		bluePark.setBorder(BorderFactory.createLineBorder(Color.RED));
		bluePark.setOpaque(true);
		bluePark.setBackground(Color.RED);

		redPark.setSize(40, 100);
		canvas.add(redPark, 430, 190);
		bluePark.setSize(40, 100);
		canvas.add(bluePark, 535, 190);
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
			teleSwitch = 0;
			teleScale = 0;
			vault = 0;
			climb = null;
			parked = null;
		} else if (event.getSource() == submit) {
			// sends the data over
			if (gameOn && matchNumber != null && teamNumber != null) {
				gameOn = false;
				isAuton = true;
				submitData();
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
				teleSwitch = 0;
				teleScale = 0;
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
				// autonomous mode
				if (event.getSource() == blueLine || event.getSource() == redLine) {
					autoRun = true;
				}
				if (isRed) {
					// on red alliance
					if (event.getSource() == redTopSwitch || event.getSource() == blueTopSwitch) {
						autoSwitch++;
					}
					if (event.getSource() == topScale) {
						autoScale++;
					}
				} else {
					// on the blue alliance
					if (event.getSource() == redBottomSwitch || event.getSource() == blueBottomSwitch) {
						autoSwitch++;
					}
					if (event.getSource() == bottomScale) {
						autoScale++;
					}
				}
			} else {
				// teleop
				if (isRed) {
					// on red alliance
					if (event.getSource() == redTopSwitch || event.getSource() == blueTopSwitch) {
						teleSwitch++;
					}
					if (event.getSource() == topScale) {
						teleScale++;
					}
					if (event.getSource() == redVault) {
						vault++;
					}
				} else {
					// on the blue alliance
					if (event.getSource() == redBottomSwitch || event.getSource() == blueBottomSwitch) {
						teleSwitch++;
					}
					if (event.getSource() == bottomScale) {
						teleScale++;
					}
					if (event.getSource() == blueVault) {
						vault++;
					}
				}
				// end game
				if (isRed) {
					if (event.getSource() == redPark) {
						parked = true;
					}
					if (event.getSource() == redRung) {
						climb = true;
					}
				} else {
					if (event.getSource() == bluePark) {
						parked = true;
					}
					if (event.getSource() == blueRung) {
						climb = true;
					}
				}
			}
		}

	}

	/*
	 * Sends the stats of one match to an excel spreadsheet
	 */
	private void submitData() {
	}

}
