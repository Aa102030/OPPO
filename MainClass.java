package safari_pack;

import java.util.Scanner;

import animals_pack.Cuttlefish;
import animals_pack.Pufferfish;

public class MainClass {
	// Scanner definition
	static Scanner reader = new Scanner(System.in);

	// Const Definition
	public static final int SITE   = 1;
	public static final int DELETE = 2;
	public static final int CLEAR  = 3;
	public static final int VIEW   = 4;
	public static final int LIMITS = 5;
	public static final int AREA   = 6;
	public static final int ANIMAL = 7;
	public static final int EXIT   = 8;
	
	// Global variables definition
	public static Safari manageSafari;
	public static int    index = 0;
	
	public static void main(String[] args) {
		// Variables definition
		manageSafari = new Safari();
		int userChoice = manageSafari();

		// Run until the user quits
		while (userChoice != EXIT) {
			switch (userChoice) {
				case (SITE): {
					manageSafari.addSite();
	
					break;
				}
				case (DELETE): {
					manageSafari.removeSite();
	
					break;
				}
				case (CLEAR): {
					manageSafari.clearSafari();
	
					break;
				}
				case (VIEW): {
					manageSafari.viewSites();
	
					break;
				}
				case (LIMITS): {
					manageSafari.safariLimits();
	
					break;
				}
				case (AREA): {
					manageSafari.safariArea();
	
					break;
				}
				case(ANIMAL): {
					readAnimal();
					
					break;
				}
				default: {
					break;
				}
			}

			// Get use choice
			userChoice = MainClass.manageSafari();
		}
	}

	private static void readAnimal() {
		// Const definition
		final int CUTTLEFISH = 1;
		final int PUFFERFISH = 2;

		// Variables definition
		int 	animalChoice;
		int     numOfLegs;
		int     age;
		int     soundDecibel;
		String  name;
		String  color;
		String  food;
		boolean isVegeterian;
		boolean hasFishScales;
		double  CoordinateX;
		double  CoordinateY;
		double  height;
		double  maxDiveDepth;
		double  swimSpeed;

		// Get sea animal data members
		System.out.print("Enter the following:\n"
				+ "1) Number of legs\n"
				+ "2) Name\n"
				+ "3) Age\n"
				+ "4) If vegeterian or not\n"
				+ "5) Color\n"
				+ "6) Sound decibel\n"
				+ "7) Food\n"
				+ "8) X coordinate\n"
				+ "9) Y coordinate\n"
				+ "10) Height\n"
				+ "11) Maximum diving depth\n"
				+ "12) If has fish scales or not\n"
				+ "13) Swim speed");

		numOfLegs  = reader.nextInt();
		name 		  = reader.next();
		age           = reader.nextInt();
		isVegeterian  = reader.nextBoolean();
		color         = reader.next();
		soundDecibel  = reader.nextInt();
		food          = reader.next();
		CoordinateX   = reader.nextDouble();
		CoordinateY   = reader.nextDouble();
		height        = reader.nextDouble();
		maxDiveDepth  = reader.nextDouble();
		hasFishScales = reader.nextBoolean();
		swimSpeed     = reader.nextDouble();	
		
		// Get animal choise
		System.out.println("Choose animal:\n"
						  + CUTTLEFISH + " - Cuttlefish\n"
						  + PUFFERFISH + " - Pufferfish");
		animalChoice = reader.nextInt();
		
		// Choose animal
		switch(animalChoice) {
			case (CUTTLEFISH): {
				// Variables definition
				String inkColor;
				double inkQuantity;
				Cuttlefish newCuttlefish;

				// Get ink color & quantity
				System.out.println("Enter ink's color, ink's quantity");
				inkColor    = reader.next();
				inkQuantity = reader.nextDouble();

				// Create new cuttlefish
				newCuttlefish = new Cuttlefish(numOfLegs, name, age, isVegeterian,
						color, soundDecibel, food, CoordinateX, CoordinateY, height,
						maxDiveDepth, hasFishScales, swimSpeed, inkColor, inkQuantity);

				// Add animal to safari
				manageSafari.addAnimal(newCuttlefish);
				((Cuttlefish) manageSafari.getSafariAnimals().get(index)).print();
				index++;
				
				break;
			}
			case (PUFFERFISH): {
				// Variables definition
				double maxInflation;
				int numOfThorns;
				Pufferfish newPufferfish;

				// Get maximum inflation & number of thorns
				System.out.println("Enter maximum inflation, number of throns");
				maxInflation = reader.nextDouble();
				numOfThorns  = reader.nextInt();
				
				// Create new pufferfish
				newPufferfish = new Pufferfish(numOfLegs, name, age,
						isVegeterian, color, soundDecibel, food, CoordinateX,
						CoordinateY, height, maxDiveDepth,
						hasFishScales,swimSpeed,maxInflation, numOfThorns);
	
				// Add animal to safari
				manageSafari.addAnimal(newPufferfish);
				((Pufferfish) manageSafari.getSafariAnimals().get(index)).print();
				index++;
				
				break;
			}
		}
	}

	private static int manageSafari() {
		// Variables definition
		int userChoice            = EXIT;
		boolean isUserChoiceValid = false;
		
		// Run while choice is valid
		while (!isUserChoiceValid) {
			System.out.println("\n     ***** SafariPlan Menu *****");
			System.out.println("\nPick an option:");
			System.out.println("  1. Add a new site to the safari");
			System.out.println("  2. Remove a site from the safari");
			System.out.println("  3. Remove all the sites from the safari");
			System.out.println("  4. View the list of the safari sites");
			System.out.println("  5. View the limits of the safari");
			System.out.println("  6. View the area of the safari");
			System.out.println("  7. Add animal to the safari");
			System.out.println("  8. Exit SafariPlan");
			System.out.println("\nYour choice:");
			
			// Get user choice
			userChoice = reader.nextInt();

			// Check choice validation
			if ((userChoice < SITE) || (userChoice > EXIT)) {
				System.out.println("You entered an invalid option.");
				System.out.println("Please enter the number of your choice...\n");
			} 
			else {
				isUserChoiceValid = true;
			}
		}

		return (userChoice);
	}
}