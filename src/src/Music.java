public class Music extends DigitalContent {
	// artist instance variable for Music class
	private String artist;

	// Music constructor that takes all instance variables
	public Music(String title, String publisher, String release, String artist) {
		super(title, publisher, release);
		setArtist(artist);
	}

	// Overridden match method that extends match method from DigitalContent
	@Override
	public boolean match(String query) {
		if (artist.toLowerCase().contains(query.toLowerCase())) {
			return true;
		}
		if (super.match(query)) {
			return true;
		}
		return false;
	}

	// toString method that extends the DigitalContent toString method
	@Override
	public String toString() {
		return super.toString() + ", Artist: " + this.artist;
	}

	// Get and set methods
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
}
