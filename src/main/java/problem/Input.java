package problem;

import java.util.List;

public class Input {

	private int nbRows;
	private int nbColumns;
	private int nbVehicles;

	private List<Ride> rides;

	private int bonusForStartingTime;
	private int nbSteps;

	public int getNbRows() {
		return this.nbRows;
	}

	public void setNbRows(final int nbRows) {
		this.nbRows = nbRows;
	}

	public int getNbColumns() {
		return this.nbColumns;
	}

	public void setNbColumns(final int nbColumns) {
		this.nbColumns = nbColumns;
	}

	public int getNbVehicles() {
		return this.nbVehicles;
	}

	public void setNbVehicles(final int nbVehicles) {
		this.nbVehicles = nbVehicles;
	}

	public List<Ride> getRides() {
		return this.rides;
	}

	public void setRides(final List<Ride> rides) {
		this.rides = rides;
	}

	public int getBonusForStartingTime() {
		return this.bonusForStartingTime;
	}

	public void setBonusForStartingTime(final int bonusForStartingTime) {
		this.bonusForStartingTime = bonusForStartingTime;
	}

	public int getNbSteps() {
		return this.nbSteps;
	}

	public void setNbSteps(final int nbSteps) {
		this.nbSteps = nbSteps;
	}
}
