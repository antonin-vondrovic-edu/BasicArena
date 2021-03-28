package cz.educanet.arena;

import cz.educanet.arena.data.GladiatorDatabase;
import cz.educanet.arena.presentation.ArenaCLI;

/**
 * Main entry point
 */
public class Main {

    public static void main(String[] args) {
        ArenaCLI cli = new ArenaCLI();
        cli.init();
        cli.renderLandingPage();
        cli.renderEntireFight();
    }

}
