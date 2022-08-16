import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client implements Play {
	// Private instance variables
	private StreamingService streamService;
	private DigitalContent currentlyStreamed = null;

	// Client constructor
	public Client(StreamingService s) {
		this.streamService = s;
		this.currentlyStreamed = null;
	}

	// Stop method to clear currentlyStreamed
	@Override
	public void stop() {
		this.currentlyStreamed = null;
	}

	// Method to return currentlyStreamed DigitalContent
	@Override
	public DigitalContent getCurrentStream() {
		return this.currentlyStreamed;
	}

	// Invokes match method and sets the first match to currentlyStreamed, and
	// prints a message if no matches are found
	@Override
	public void stream(String query) {
		try {
			DigitalContent firstMatch = streamService.match(query).get(0);
			this.currentlyStreamed = firstMatch;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No Digital Content matches your search");
			return;
		}
	}

	// Main method instantiates Client with a StreamingService, populated with
	// DigitalContent objects in an ArrayList. Implements a menu interface which
	// repeatedly presents a menu
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Create new StreamingService object and populates with instances of Film and
		// Music objects
		ArrayList<DigitalContent> myFavourites = new ArrayList<DigitalContent>();
		myFavourites.add(new Film("Call Me By Your Name", "Warner Bros. Pictures", "2018",
				"Timothee Chalamet, Armie Hammer, Michael Stuhlbarg, Esther Garrel"));
		myFavourites.add(new Film("Parasite", "CJ Entertainment", "2019",
				"Yeo-jeong Cho, Choi Woo-shik, Park Seo-Joon, Park So-dam"));
		myFavourites.add(new Music("N95", "PGLang", "2022", "Kendrick Lamar"));
		myFavourites.add(new Music("The Time is Now", "Echo", "2000", "Moloko"));
		myFavourites.add(new Music("Lovers Rock", "", "2014", "TV Rock"));
		myFavourites.add(new Music("Easy", "EMI", "2019", "Troye Sivan"));
		myFavourites.add(new Film("Terminator 2: Judgement Day", "TriStar Pictures", "1991",
				"Arnold Schwarzenegger, Linda Hamilton, Edward Furlong"));
		myFavourites.add(new Film("Spirited Away", "Toho Co.", "2001", "Rumi Hiiragi, Miyu Irino, Mari Natsuki"));
		myFavourites.add(new Film("Hi, Mom", "China Film Co.", "2021", "Jia Ling, Shen Teng, Zhang Xiaofei, Chen He"));
		myFavourites.add(new Music("Physical", "Warner Records", "2020", "Dua Lipa"));
		myFavourites.add(new Music("No Better", "Universal", "2013", "Lorde"));

		StreamingService lStreams = new StreamingService(myFavourites);
		Client c = new Client(lStreams);

		// Initialize scanner and input char
		Scanner keyboard = new Scanner(System.in);
		char action = 'F';

		// while user does not input E - quit application
		while (action != 'E') {
			System.out.println("A. Display Digital Content library\nB. Display currently streaming Digital Content"
					+ "\nC. Match Digital Content to Stream\nD. Stop streaming \nE. Quit Client Application");
			// try and catch blocks for InputMisMatchException
			try {
				action = keyboard.next().charAt(0);
			} catch (InputMismatchException inputMismatchException) {
				// ignores input, clears scanner, and returns back to the while loop
				keyboard.next();
				return;
			}
			// prints contents of StreamingService lStreams
			if (action == 'A') {
				System.out.println(lStreams + "\n");
			}
			// prints currently playing Digital Content, or a message if null
			if (action == 'B') {
				if (c.getCurrentStream() == null) {
					System.out.println("No Digital Content streaming currently\n");
				} else {
					System.out.println("Currently playing:\n" + c.getCurrentStream());
				}
			}
			// finds best match with user input and invokes streaming
			if (action == 'C') {
				Scanner query = new Scanner(System.in);
				System.out.println("Search media:");

				String querySearch = query.nextLine();
				c.stream(querySearch);

				// if no match found, print user friendly message
				if (c.getCurrentStream() == null) {
					System.out.println("No Digital Content streaming currently\n");
				} else {
					System.out.println("Currently streaming: " + c.getCurrentStream());
				}
			}
			// stops streaming and prints user friendly message
			if (action == 'D') {
				if (c.getCurrentStream() == null) {
					System.out.println("No Digital Content streaming currently\n");
				} else {
					System.out.println("Streaming of: \n" + c.getCurrentStream() + "\nstopped");
					c.stop();
				}
			}
		}
		System.exit(0);
	}
}
