package model;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {

    public void ulozData(List<Task> seznamUkolu) {
        try {
            FileWriter zapisovac = new FileWriter("mojedata.txt");

            for (Task ukol : seznamUkolu) {

                String radek = ukol.getTaskType() + ", " + ukol.getTitle() + ", " + ukol.isCompleted();

                if (ukol.getTaskType().equals("Work")) {
                    WorkTask pracUkol = (WorkTask) ukol;
                    radek = radek + ", " + pracUkol.getDeadline();
                }

                if (ukol.getTaskType().equals("Personal")) {
                    PersonalTask osobniUkol = (PersonalTask) ukol;
                    radek = radek + ", " + osobniUkol.getPriority();
                }

                zapisovac.write(radek + "\n");
            }

            zapisovac.close();

        } catch (Exception chyba) {
            System.out.println(chyba.getMessage());
        }
    }
    ///////////
     ///
     ///
    public List<Task> nactiData() {
        List<Task> nacteneUkoly = new ArrayList<>();

        try {
            File soubor = new File("mojedata.txt");
            Scanner ctecta = new Scanner(soubor);

            while (ctecta.hasNextLine()) {
                String radek = ctecta.nextLine();

                String[] slova = radek.split(",");

                String typ = slova[0];
                String nazev = slova[1];
                String hotovoText = slova[2];
                String detail = slova[3];

                boolean jeHotovo = false;
                if (hotovoText.equals("true")) {
                    jeHotovo = true;
                }

                if (typ.equals("Work")) {
                    WorkTask novy = new WorkTask(nazev, detail);
                    novy.setCompleted(jeHotovo);
                    nacteneUkoly.add(novy);
                }

                if (typ.equals("Personal")) {
                    PersonalTask novy = new PersonalTask(nazev, detail);
                    novy.setCompleted(jeHotovo);
                    nacteneUkoly.add(novy);
                }
            }
            ctecta.close();

        } catch (Exception chyba) {
            System.out.println("soubor neexistuje");
        }

        return nacteneUkoly;
    }
}