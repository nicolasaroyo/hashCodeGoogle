package problem;

public class Ride {
	private Coordinate start;
	private Coordinate finish;

	private int earliestStart;
	private int latestFinish;

	public Coordinate getStart() {
		return this.start;
	}

	public void setStart(final Coordinate start) {
		this.start = start;
	}

	public Coordinate getFinish() {
		return this.finish;
	}

	public void setFinish(final Coordinate finish) {
		this.finish = finish;
	}

	public int getEarliestStart() {
		return this.earliestStart;
	}

	public void setEarliestStart(final int earliestStart) {
		this.earliestStart = earliestStart;
	}

	public int getLatestFinish() {
		return this.latestFinish;
	}

	public void setLatestFinish(final int latestFinish) {
		this.latestFinish = latestFinish;
	}
}
