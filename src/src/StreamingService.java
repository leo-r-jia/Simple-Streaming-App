import java.util.ArrayList;
import java.util.Collections;

public class StreamingService {
	private ArrayList<DigitalContent> list;

	// StreamingService constructor
	public StreamingService(ArrayList<DigitalContent> list) {
		this.list = list;
	}

	// add method that adds a DigitalContent object to the list
	public void add(DigitalContent d) {
		if (d != null) {
			this.list.add(d);
		}
	}

	// match method that invokes match on each DigitalConent object
	ArrayList<DigitalContent> match(String query) {
		// initialize output array
		ArrayList<DigitalContent> matches = new ArrayList<DigitalContent>();
		for (DigitalContent dc : list) {
			// if match, add to output array
			if (dc.match(query) == true) {
				matches.add(dc);
			}
		}
		return matches;
	}

	// toString method that returns an organized string
	public String toString() {
		// Sort list by title
		Collections.sort(list);
		// Initialize output string
		String s = "";
		for (DigitalContent dc : list) {
			s = s + "\n" + dc;
		}
		return s;
	}
}
