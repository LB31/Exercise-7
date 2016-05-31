import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Write a description of class HexUserInterface here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class HexUserInterface extends UserInterface {

	private JCheckBox hexCheckbox;
	private JPanel buttonPanel2;
	private String input = "";

	public HexUserInterface(CalcEngine engine) {
		super(engine);
	}

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();

		if (command.equals("=")) {
			System.out.println(input);
			calc.equals(input);
		} else if (command.equals("CLR")) {
			calc.clear();
			input = "";
		} else if (command.equals("?")) {
			showInfo();
		} else if (command.equals("HIDE")) {
			if (hexCheckbox.isSelected()) {
				((HexCalcEngine) calc).setBase(10);
			} else {
				((HexCalcEngine) calc).setBase(16);
			}

			buttonPanel2.setVisible(!hexCheckbox.isSelected());

			redisplay();
		}

		else {
			int length = command.length();
			int number = 0;

			if (length == 1) {
				char charCommand = command.charAt(0);

				if (Character.isLetter(charCommand) || Character.isDigit(charCommand)) {
					number = Integer.parseInt(command, 16);
					input += "" + number;
					System.out.println(input);
					((HexCalcEngine) calc).numberPressed(number);
				} else {
					input += command;
					System.out.println(input);
				}
			}

		}
		// else unknown command.

		redisplay();
	}

	protected void redisplay() {
		if (((HexCalcEngine) calc).getBase() == 16)
			display.setText("" + Integer.toHexString(calc.getDisplayValue()).toUpperCase());
		else
			display.setText("" + calc.getDisplayValue());
	}

	protected void makeFrame() {
		frame = new JFrame(calc.getTitle());

		JPanel contentPane = (JPanel) frame.getContentPane();

		contentPane.setLayout(new BorderLayout(8, 8));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		display = new JTextField();
		contentPane.add(display, BorderLayout.NORTH);

		JPanel motherOfAllPanels = new JPanel(new GridLayout(2, 1));

		JPanel buttonPanel = new JPanel(new GridLayout(5, 4));

		addButton(buttonPanel, "7");
		addButton(buttonPanel, "8");
		addButton(buttonPanel, "9");
		addButton(buttonPanel, "CLR");

		addButton(buttonPanel, "4");
		addButton(buttonPanel, "5");
		addButton(buttonPanel, "6");
		addButton(buttonPanel, "?");

		addButton(buttonPanel, "1");
		addButton(buttonPanel, "2");
		addButton(buttonPanel, "3");

		// buttonPanel.add(new JLabel(" "));
		addButton(buttonPanel, "*");

		addButton(buttonPanel, "0");
		addButton(buttonPanel, "+");
		addButton(buttonPanel, "-");

		addButton(buttonPanel, "=");

		buttonPanel2 = new JPanel(new GridLayout(2, 4));

		addButton(buttonPanel2, "A");
		addButton(buttonPanel2, "B");
		addButton(buttonPanel2, "C");
		buttonPanel2.add(new JLabel(" "));

		addButton(buttonPanel2, "D");
		addButton(buttonPanel2, "E");
		addButton(buttonPanel2, "F");

		hexCheckbox = addCheckbox(buttonPanel, "HIDE");

		motherOfAllPanels.add(buttonPanel);
		motherOfAllPanels.add(buttonPanel2);

		contentPane.add(motherOfAllPanels, BorderLayout.CENTER);

		status = new JLabel(calc.getAuthor());
		contentPane.add(status, BorderLayout.SOUTH);

		frame.pack();
	}

	/**
	 * Add a checkbox to the button panel.
	 * 
	 * @param panel
	 *            The panel to receive the checkbox.
	 * @param checkboxText
	 *            The text for the checkbox.
	 * @return
	 */
	protected JCheckBox addCheckbox(Container panel, String checkboxText) {
		JCheckBox checkbox = new JCheckBox(checkboxText);
		checkbox.addActionListener(this);
		panel.add(checkbox);

		return checkbox;
	}

}
