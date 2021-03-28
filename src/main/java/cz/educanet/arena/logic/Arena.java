package cz.educanet.arena.logic;

import java.util.concurrent.TimeUnit;

public class Arena {

    private Gladiator gladiator1;
    private Gladiator gladiator2;

    private int round;

    public void fight() {
        System.out.println("##### < ROUND " + (round+1)  + " > #####");
        System.out.println();
        System.out.println(">> " + gladiator1.getName() + "'s HP: "+gladiator1.getHP());
        System.out.println(">> " + gladiator2.getName() + "'s HP: "+gladiator2.getHP());
        System.out.println();
        gladiator1.dealDamage(gladiator2);
        System.out.println("> " + gladiator1.getName() + " deals " + gladiator1.getDamage() + " damage to " + gladiator2.getName());
        gladiator2.dealDamage(gladiator1);
        System.out.println("> " + gladiator2.getName() + " deals " + gladiator2.getDamage() + " damage to " + gladiator1.getName());
        System.out.println();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        round++;
    }

    public Gladiator getWinner() {
        if (gladiator1.isDead()) return gladiator2;
        if (gladiator2.isDead()) return gladiator1;

        return null;
    }

    public void setGladiator1(Gladiator gladiator1) {
        this.gladiator1 = gladiator1;
    }

    public void setGladiator2(Gladiator gladiator2) {
        this.gladiator2 = gladiator2;
    }
}
