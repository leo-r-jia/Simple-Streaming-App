public abstract class DigitalContent implements Comparable<DigitalContent> {
	// private instance variables
	private String title;
	private String publisher;
	private String release;

	// DigitalContent constructor
	public DigitalContent(String title, String publisher, String release) {
		setTitle(title);
		setPublisher(publisher);
		setRelease(release);
	}

	// match method to search for query in parameters
	public boolean match(String query) {
		if (title.toLowerCase().contains(query.toLowerCase())) { // query is not case sensitive
			return true;
		}
		if (publisher.toLowerCase().contains(query.toLowerCase())) {
			return true;
		}
		if (release.toLowerCase().contains(query.toLowerCase())) {
			return true;
		}
		return false;
	}

	// compareTo method that compares title, used in StreamingService class
	public int compareTo(DigitalContent other) {
		return this.title.compareTo(other.title);
	}

	// toString method
	public String toString() {
		return "Title: " + this.title + ", Publisher: " + this.publisher + ", Release Date: " + this.release;
	}

	// get and set methods for instance variables
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public String getRelease() {
		return release;
	}
}
