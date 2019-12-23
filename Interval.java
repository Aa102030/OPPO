package safari_pack;

public class Interval {
	// Const definition
	static final int DEFAULT_END_POINT = 1;
	static final int DEFAULT_START_POINT = 0;
	
	// Data members
	private int startPoint;
	private int endPoint;
	
	// Default Ctor
	public Interval() {
		this.startPoint = DEFAULT_START_POINT;
		this.endPoint = DEFAULT_END_POINT;
	}
	
	// Ctor with reference values
	public Interval(int startPoint, int endPoint) {
		// Correction
		if (!(isPointsValid(startPoint, endPoint) && startPoint >= 0)) {
			System.out.println("Error. points set as default");

			// If wrong, points will set as default.
			this.startPoint = DEFAULT_START_POINT;
			this.endPoint = DEFAULT_END_POINT;
		} 
		else {
			// If values are correct, create by references
			this.startPoint = startPoint;
			this.endPoint = endPoint;
		}
	}
	
	// Copy Ctor
	public Interval(Interval intrCopy) {
		this.startPoint = intrCopy.startPoint;
		this.endPoint = intrCopy.endPoint;
	}
	
	// Getters
	public int getStartPoint() {
		return this.startPoint;
	}

	public int getEndPoint() {
		return this.endPoint;
	}
	
	// Methods
	
	// Get the length of the interval
	public int length() {
		return (this.endPoint - this.startPoint);
	}
	
	// Checks if the points are valid for creation
	public static boolean isPointsValid(int startPoint, int endPoint) {
		// Variable definition
		boolean isValid = false;

		// Checks if the points are valid
		if (endPoint > startPoint) {
			isValid = true;
		}

		return (isValid);
	}

	// Return true if the interval are intersects
	public boolean isIntersects (Interval otherInterval) {
		return (Math.max(this.endPoint, otherInterval.endPoint) 
				- Math.min(this.startPoint, otherInterval.startPoint) 
				<= (length()) 
				+ (otherInterval.endPoint - otherInterval.startPoint));
	}

	// Connecting two intervals together
	public Interval join(Interval otherInterval) {
		// Returning the combined intervals as one 
		return (new Interval(this.startPoint,otherInterval.endPoint));
	}

	@Override
	// Printing interval details 
	public String toString() {
		return (startPoint + "-" + endPoint);
	}

	// Checks if the intervals are equal
	public boolean equals(Interval otherInterval) {
		// If they're equal return true otherwise, false
		if((this.length()) == otherInterval.length()) {
			return (true);
		}
		else {
			return (false);
		}
	}
}