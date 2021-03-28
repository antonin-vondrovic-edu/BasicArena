package cz.educanet.arena.data;

import cz.educanet.arena.logic.Gladiator;

import java.io.*;

public class GladiatorDatabase {

    public static Gladiator loadGladiator(String filename) {
        Gladiator load = new Gladiator();
        try {
            BufferedReader br = new BufferedReader(new FileReader("fighters/" + filename));

            load.setName(br.readLine());
            load.setMaxHP(Integer.parseInt(br.readLine()));
            load.setMaxDamage(Integer.parseInt(br.readLine()));
            load.setMinDamage(Integer.parseInt(br.readLine()));

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return load;
    }

    public static void saveGladiator(String filename, Gladiator gladiator) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("fighters/" + filename));

            bw.write(gladiator.getName()+"");
            bw.newLine();
            bw.write(gladiator.getMaxHP()+"");
            bw.newLine();
            bw.write(gladiator.getMaxDamage()+"");
            bw.newLine();
            bw.write(gladiator.getMinDamage()+"");

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
