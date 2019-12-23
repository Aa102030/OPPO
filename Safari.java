package safari_pack;

import java.util.ArrayList;
import java.util.Scanner;

import animals_pack.Animal;

public class Safari {
	// Scanner definition
	static Scanner reader = new Scanner(System.in);

	// Data members
	private ArrayList<Rect>   safariRects;
	private ArrayList<Object> safariAnimals;

	// Contractors
	public Safari() {
		this.safariRects   = new ArrayList<Rect>();
		this.safariAnimals = new ArrayList<Object>();
	}

	// Getters and Setters
	public ArrayList<Rect> getSafariRects() {
		return (this.safariRects);
	}

	public void setSafariRects(ArrayList<Rect> safariRects) {
		this.safariRects = safariRects;
	}
	
	public ArrayList<Object> getSafariAnimals() {
		return (this.safariAnimals);
	}
	
	public void setSafariAnimals(ArrayList<Object> safariAnimals) {
		this.safariAnimals = safariAnimals;
	}

	// Methods
	private boolean isIntersects(Rect rectOther) {
		// Variables definition
		boolean isIntersect = false;

		// Run through all safari rects
		for (int rectIndex = 0; (rectIndex < this.safariRects.size()) && (!isIntersect);
				rectIndex++) {
			isIntersect = this.safariRects.get(rectIndex).isIntersects(rectOther);
		}

		return (isIntersect);
	}

	public void addSite() {
		// Variables definition
		Rect newSite;
		ClientInterface newClientInterface = new ClientInterface();

		// Get new site to add
		System.out.println("\nEntering the site details: ");
		System.out.println("===========================");
		newSite = newClientInterface.readRect();

		// Check if the new site intercets and re-enter if it does
		while (isIntersects(newSite)) {
			System.out.println();
			System.out.println("Rect intersects... Let's try again\n");
			newSite = newClientInterface.readRect();
		}

		// Add the new site to the safari
		this.safariRects.add(newSite);
		System.out.println("The site was added to the safari.");
	}

	public void removeSite() {
		// Variables definition
		Rect siteToRemove;
		ClientInterface newClientInterface = new ClientInterface();

		// Get new site to remove
		System.out.println("\nEnter the site details: ");
		System.out.println("========================");
		siteToRemove = newClientInterface.readRect();

		// Check if site exists and delete it if so
		if (this.safariRects.remove(siteToRemove)) {
			System.out.println("Site Deleted.");
		} 
		else {
			System.out.println("The site was not found in the safari.");
		}
	}

	public boolean clearSafari() {
		System.out.print("Are you sure you want to delete all the sites in the "
					   + "safari (y/n)? ");

		// Get user decision to clear the safari
		if (!(reader.nextLine().toLowerCase() == "y")) {
			System.out.println("Action aborted.");

			return (false);
		}

		// Clear the safari
		this.safariRects.clear();
		System.out.println("All sites deleted.");

		return (true);
	}

	public void viewSites() {
		// Variables definition
		ClientInterface newClientInterface = new ClientInterface();
		System.out.println("The quantity of sites is: " + this.safariRects.size());

		// Run through all the rects
		for (int siteIndex = 0; siteIndex < this.safariRects.size(); siteIndex++) {
			System.out.println("The data of site " + (siteIndex + 1) + ": ");
			newClientInterface.printRect(this.safariRects.get(siteIndex));
		}
	}

	public void safariLimits() {
		// Variables definition
		ClientInterface newClientInterface = new ClientInterface();

		// Check if there's 1 or less rects
		if (this.safariRects.size() <= 0) {
			System.out.println("0 - 0");
		} 
		else {
			Rect safari = new Rect(this.safariRects.get(0).getHorizontalInterval(),
					this.safariRects.get(0).getVerticalInterval());

			// Sum all the sites
			for (int siteIndex = 1; siteIndex < this.safariRects.size(); siteIndex++) {
				safari = safari.join(this.safariRects.get(siteIndex));
			}

			System.out.println("The safari limits area is: ");
			newClientInterface.printRect(safari);
		}
	}

	public void safariArea() {
		// Variables definition
		int area = 0;

		// Sum all the sites
		for (int siteIndex = 0; siteIndex < this.safariRects.size(); siteIndex++) {
			area += this.safariRects.get(siteIndex).area();
		}

		System.out.println("The safari area is: " + area);
	}

	public void addAnimal(Animal newAnimal) {
		// Variables definition
		Object obj = new Object();
		obj = (Object) newAnimal;

		// Add animal
		safariAnimals.add(obj);
	}
	
	public void printAllAnimals() {
		for (int i = 0; i < this.safariAnimals.size() - 1; i++) {
			System.out.println(this.safariAnimals.get(i));
		}
	}
}