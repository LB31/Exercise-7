
public class HexCalcEngine extends CalcEngine {

	private int base;

	public HexCalcEngine() {
		setBase(16);
	}

	public void numberPressed(int number) {
		if (buildingDisplayValue) {
			// Incorporate this digit.

			displayValue = displayValue * getBase() + number;
		} else {
			// Start building a new number.
			displayValue = number;
			buildingDisplayValue = true;
		}
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getBase() {
		return base;
	}
}
