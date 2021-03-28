package cz.educanet.arena.logic;

import java.util.Random;

public class Gladiator {

    private String name;
    private int HP;
    private int maxHP;
    private int damage;
    private int maxDamage;
    private int minDamage;

    public boolean isDead() {
        return getHP() <= 0;
    }

    public void dealDamage(Gladiator enemy) { // THE RNG CODE
        int rng = (int) (Math.random() * (maxDamage - minDamage) + minDamage);
        setDamage(rng);
        enemy.setHP(enemy.getHP()-damage);
    }

    // GET
    public String getName() { return name; }
    public int getHP() { return HP; }
    public int getMaxHP() { return maxHP; }
    public int getDamage() { return damage; }
    public int getMaxDamage() { return maxDamage; }
    public int getMinDamage() { return minDamage; }

    // SET
    public void setName(String name) { this.name = name; }
    public void setHP(int HP) { this.HP = HP; }
    public void setMaxHP(int maxHP) { this.maxHP = maxHP; this.HP = maxHP; }
    public void setDamage(int damage) { this.damage = damage; }
    public void setMaxDamage(int maxDamage) { this.maxDamage = maxDamage; }
    public void setMinDamage(int minDamage) { this.minDamage = minDamage; }
}
