package safari_pack;

import java.util.Scanner;

public class ClientInterface {
	// Scanner definition
	static Scanner reader = new Scanner(System.in);

	public Interval readInterval() {
		// Variables definition
		int startingPoint;
		int endPoint;

		// Get minimum value
		System.out.println("Enter minimun value: ");
		startingPoint = this.readInteger();

		// Get minimum value
		System.out.println("Enter maximum value: ");
		endPoint = this.readInteger();

		// Run until inputs are valid
		while (!Interval.isPointsValid(startingPoint, endPoint)) {
			System.out.println("Maximum must be larger...");

			// Re-enter input
			System.out.println("Enter minimun value: ");
			startingPoint = this.readInteger();
			System.out.println("Enter maximum value: ");
			endPoint = this.readInteger();
		}

		return (new Interval(startingPoint, endPoint));
	}

	public void printInterval(Interval intervalToPrint) {
		System.out.println(intervalToPrint.toString());
	}

	public Rect readRect() {
		// Variables definition
		Interval horizontalInterval;
		Interval verticalInterval;

		// Get horiznotal value
		System.out.println("Enter horizontal values: ");
		horizontalInterval = readInterval();

		// Get vertical value
		System.out.println("Enter vertical values: ");
		verticalInterval = readInterval();

		return (new Rect(horizontalInterval, verticalInterval));
	}

	public void printRect(Rect RectToPrint) {
		System.out.println(RectToPrint.toString());
	}

	private int readInteger() {
		// Variables definition
		int number;

		// Get value
		number = Integer.parseInt(reader.nextLine());

		// Run until value is valid
		while (number < 0) {
			System.out.println("The number must be positive, enter again:");
			number = Integer.parseInt(reader.nextLine());
		}

		return (number);
	}
}
