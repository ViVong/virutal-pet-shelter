package virtualpetshelter;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class VirutalPetShelterApp {
	
	public static void main(String[] args) {
		int choice = 0, food, water, mood;
		String who, descript;
		VirtualPetShelter cleve = new VirtualPetShelter();
		Scanner input = new Scanner(System.in);
		cleve.admit("Fido", "is a fine pupper.");
		cleve.admit("Diaper", "is a really stinky doggo.", 25, 30, 25);
		cleve.admit("Lionel", "is a fancy smancy kitty.", 40, 40, 10);
		System.out.println("Welcome to Cleveland's premier animal shelter/petting zoo.");
		while (choice != 7) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();			
			}
			System.out.println("The current status of our animals are:");
			cleve.allPets();
			System.out.println("\nWhat would you like to do with them?\n\n1. Feed the Animals.\n2. Give the Animals water.\n3. Play with an Animal.\n4. Clean one of the pens.\n5. Adopt an animal.\n6. Admit an animal.\n7. Quit");
			choice = Integer.parseInt(input.next());
			switch (choice) {
				case 1:
					cleve.feedPets();
					System.out.println("You give every pet a bit of food.");
					cleve.tick();
					break;
				case 2:
					cleve.waterPets();
					System.out.println("You let all the pets drinks some water.");
					cleve.tick();
					break;
				case 3:
					System.out.println("Who do you want to play with?\n");
					for (Map.Entry<String, VirtualPet> entry: cleve.shelter().entrySet()) {
						System.out.println(entry.getValue().name + " " + entry.getValue().descrip);
					}
					who = input.next().toLowerCase();
					cleve.playWith(who);
					System.out.println("You pick up " + who + " and play with them for a bit.");
					cleve.tick();
					break;
				case 4:
					System.out.println("Whose pen do you want to clean?");
					for (Map.Entry<String, VirtualPet> entry: cleve.shelter().entrySet()) {
						System.out.println(entry.getValue().name + " " + entry.getValue().descrip);
					}
					who = input.next().toLowerCase();
					cleve.cleanCage(who);
					System.out.println("You take " + who + " out and scrub that pen clean.");
					cleve.tick();
					break;
				case 5:
					System.out.println("Which animal did you want to adopt?\n");
					for (Map.Entry<String, VirtualPet> entry: cleve.shelter().entrySet()) {
						System.out.println(entry.getValue().name + " " + entry.getValue().descrip);
					}
					who = input.next().toLowerCase();
					cleve.adopt(who);
					System.out.println("Congratulation, You are now the proud owner of " + who + ".");
					cleve.tick();
					break;
				case 6:
					cleve.tick();
					System.out.println("What is the name of the animal you want to admit?");
					who = input.next();
					System.out.println("Please give a short description of them.");
					descript = input.next() + input.nextLine();
					System.out.println("Would you like to enter more info?\n1. Yes\n2. No");
					if (input.next().equals("1")) {
						System.out.println("On a scale from 1-50 how hungry is " + who + "?");
						food = Integer.parseInt(input.next());
						System.out.println("On a scale from 1-50 how thirsty is " + who + "?");
						water = Integer.parseInt(input.next());
						System.out.println("On a scale from 1-50 how much does " + who + " like people?");
						mood = Integer.parseInt(input.next());
						cleve.admit(who, descript, food, water, mood);
					}
					else {
						cleve.admit(who, descript);
					}
					System.out.println( who + " is now a not so proud occupant of our zoo.");
					break;
				case 7:
					System.out.println("Quitting.....");
					System.exit(0);
				default:
					System.out.println("Invalid Input.");
			}
		}
		input.close();
	}
}
