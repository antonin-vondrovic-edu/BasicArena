package cz.educanet.arena.presentation;

import cz.educanet.arena.data.GladiatorDatabase;
import cz.educanet.arena.logic.Arena;
import cz.educanet.arena.logic.Gladiator;

import java.util.Scanner;

public class ArenaCLI {

    private Arena logic;
    private Scanner sc;

    /**
     * Initialize all variables that are needed.
     */
    public void init() {
        logic = new Arena();
        sc = new Scanner(System.in);
    }

    public void renderLandingPage() {
        System.out.println("\n" +
                "  ___  ______ _____ _   _   ___  \n" +
                " / _ \\ | ___ \\  ___| \\ | | / _ \\ \n" +
                "/ /_\\ \\| |_/ / |__ |  \\| |/ /_\\ \\\n" +
                "|  _  ||    /|  __|| . ` ||  _  |\n" +
                "| | | || |\\ \\| |___| |\\  || | | |\n" +
                "\\_| |_/\\_| \\_\\____/\\_| \\_/\\_| |_/\n");
        System.out.println("---------------------------------");
        System.out.println("Welcome back to the arena! It's good to see you back");
        System.out.println("Do you want to create new gladiators? (Y/N)");
        String input1 = sc.nextLine().toLowerCase();
        if (input1.equals("yes") || input1.equals("y")) {
            renderGladiatorCreator();
        } else if (input1.equals("no") || input1.equals("n")) {
            renderGladiatorPicker();
        } else {
            System.out.println();
            System.out.println("Invalid input!");
            renderGladiatorCreator();
        }
    }

    public void renderGladiatorCreator() {
        Gladiator first = new Gladiator();
        System.out.println("What do you want to call your gladiator?");
        first.setName(sc.nextLine());
        System.out.println("How much HP should they have?");
        first.setMaxHP(Integer.parseInt(sc.nextLine()));
        System.out.println("How much Maximum Damage should they deal?");
        first.setMaxDamage(Integer.parseInt(sc.nextLine()));
        System.out.println("How much Minimal Damage should they deal?");
        first.setMinDamage(Integer.parseInt(sc.nextLine()));
        System.out.println();
        System.out.println("Created your gladiator:");
        System.out.println();
        System.out.println("Name: " + first.getName() + "\nHP: " + first.getMaxHP() + "\nMAX DMG: " + first.getMaxDamage() + "\nMIN DMG: " + first.getMinDamage());
        System.out.println();
        System.out.println("What a champion!");
        GladiatorDatabase.saveGladiator(first.getName().toLowerCase(),first);
        System.out.println("Do you want to create another one? (Y/N)");
        String input = sc.nextLine();
        if (input.equals("yes") || input.equals("y")) {
            renderGladiatorCreator();
        } else if (input.equals("no") || input.equals("n")) {
            renderGladiatorPicker();
        } else {
            System.out.println();
            System.out.println("Invalid input! - Bringing you back to the landing page :)");
            renderLandingPage();
        }
    }

    public void renderGladiatorPicker() {
        System.out.println("!!! Before you pick, make sure that the given fighter actually exists !!!");
        System.out.println();
        System.out.println("Pick your fighter #1 (fighters can be found in /fighters):");
        String gladiator1File = sc.nextLine().toLowerCase();
        System.out.println("Pick your fighter #2 (fighters can be found in /fighters):");
        String gladiator2File = sc.nextLine().toLowerCase();

        Gladiator gladiator1 = GladiatorDatabase.loadGladiator(gladiator1File);
        Gladiator gladiator2 = GladiatorDatabase.loadGladiator(gladiator2File);
        logic.setGladiator1(gladiator1);
        logic.setGladiator2(gladiator2);
    }

    public void renderEntireFight() {
        while (logic.getWinner() == null) {
            logic.fight();
        }
        System.out.println(">>> "+logic.getWinner().getName() + " IS THE ULTIMATE WINNER!!!");
    }

}
