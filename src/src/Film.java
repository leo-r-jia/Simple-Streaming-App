public class Film extends DigitalContent {
	// cast instance variable for Film class
	private String cast;

	// Film class constructor that takes all instance variables
	public Film(String title, String publisher, String release, String cast) {
		super(title, publisher, release);
		setCast(cast);
	}

	// toString method that extends the DigitalContent toString
	@Override
	public String toString() {
		return super.toString() + ", Cast: " + this.cast;
	}

	// Overridden match method that extends match method from DigitalContent
	@Override
	public boolean match(String query) {
		if (cast.toLowerCase().contains(query.toLowerCase())) {
			return true;
		}
		if (super.match(query)) {
			return true;
		}
		return false;
	}

	// Get and set methods
	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}
}
