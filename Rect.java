package safari_pack;

import static safari_pack.Interval.*;

public class Rect {
	// Data members
	private Interval horizontalInterval;
	private Interval verticalInterval;
	
	// Default ctor
	public Rect() {
		this.horizontalInterval = new Interval(DEFAULT_START_POINT, DEFAULT_END_POINT);
		this.verticalInterval = new Interval(DEFAULT_START_POINT, DEFAULT_END_POINT);
	}
	
	// Ctor with reference values
	public Rect(Interval horizontalInterval, Interval verticalInterval) {
		this.horizontalInterval = new Interval(horizontalInterval.getStartPoint(),
				horizontalInterval.getEndPoint());
		this.verticalInterval = new Interval(verticalInterval.getStartPoint(),
				verticalInterval.getEndPoint());
	}
	
	// Create new Rect using other 
	public Rect(Rect otherRect) {
		this.horizontalInterval = new Interval(otherRect.getHorizontalInterval());
		this.verticalInterval = new Interval(otherRect.getVerticalInterval());
	}

	// Getters
	public Interval getHorizontalInterval() {
		return this.horizontalInterval;
	}

	public Interval getVerticalInterval() {
		return this.verticalInterval;
	}
	
	// Methods
	
	// Get the area of the Rect
	public int area() {
		return (this.horizontalInterval.length() * this.verticalInterval.length());
	}
	
	// Print Rect details
	@Override
	public String toString() {
		return "Horizontal data: " + horizontalInterval +
				"\nVertical data: " + verticalInterval;
	}
	
	// Equation between two Rects
	public boolean equals(Rect otherRect) {
		return otherRect.horizontalInterval.equals(this.horizontalInterval) 
				&& otherRect.verticalInterval.equals(this.verticalInterval);
	}

	// Return true or false whether the Rect's are intersects or not
	public boolean isIntersects(Rect otherRect) {
		return (this.horizontalInterval.isIntersects(otherRect.horizontalInterval)
				|| this.verticalInterval.isIntersects(otherRect.verticalInterval));
	}
	
	// Return the perimeter of two Rect's
	public Rect join(Rect otherRect) {
		// Join the length and the width, return as new Rect
		return (new Rect(this.horizontalInterval.join(otherRect.horizontalInterval),
				this.verticalInterval.join(otherRect.verticalInterval)));
	}	
}