package org.example;

import model.PersonalTask;
import model.Task;
import model.TaskManager;
import model.TaskStorage;
import model.WorkTask;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manazer = new TaskManager();
        TaskStorage uloziste = new TaskStorage();
        Scanner skener = new Scanner(System.in);

        // 1. Načtení dat při startu
        manazer.setTasks(uloziste.nactiData());
        System.out.println("Správce úkolů! Načteno " + manazer.getAllTasks().size() + " úkolů.");

        boolean bezi = true;
        while (bezi) {
            System.out.println("\nMENU");
            System.out.println("1. Přidat nový úkol");
            System.out.println("2. Zobrazit nedokončené úkoly (Stream API)");
            System.out.println("3. Vyhledat úkol podle slova (Stream API)");
            System.out.println("4. Označit úkol jako hotový");
            System.out.println("5. Uložit a ukončit");
            System.out.print("Vyber možnost (1-5): ");

            String volba = skener.nextLine();

            switch (volba) {
                case "1":
                    System.out.print("Typ úkolu (1 = Pracovní, 2 = Osobní): ");
                    String typ = skener.nextLine();
                    System.out.print("Název úkolu: ");
                    String nazev = skener.nextLine();

                    if (typ.equals("1")) {
                        System.out.print("Zadej deadline: ");
                        String deadline = skener.nextLine();
                        manazer.addTask(new WorkTask(nazev, deadline));
                    } else {
                        System.out.print("Zadej prioritu (Nízká/Střední/Vysoká): ");
                        String priorita = skener.nextLine();
                        manazer.addTask(new PersonalTask(nazev, priorita));
                    }
                    System.out.println("Úkol byl přidán!");
                    break;

                case "2":
                    System.out.println("\nNedokončené úkoly");
                    List<Task> nedokoncene = manazer.getIncompleteTasks();
                    if (nedokoncene.isEmpty()) {
                        System.out.println("Všechno máš hotové!");
                    } else {
                        for (Task ukol : nedokoncene) {
                            System.out.println("- " + ukol.getTitle() + " (" + ukol.getTaskType() + ")");
                        }
                    }
                    break;

                case "3":
                    System.out.print("Zadej hledané slovo: ");
                    String slovo = skener.nextLine();
                    List<Task> nalezene = manazer.findTasksByName(slovo);
                    System.out.println("\nVýsledky hledání");
                    for (Task ukol : nalezene) {
                        String stav = ukol.isCompleted() ? "[HOTOVO]" : "[ ]";
                        System.out.println(stav + " " + ukol.getTitle());
                    }
                    break;

                case "4":
                    System.out.print("Zadej přesný název úkolu, který chceš dokončit: ");
                    String hledanyNazev = skener.nextLine();
                    List<Task> shody = manazer.findTasksByName(hledanyNazev);

                    if (!shody.isEmpty()) {
                        shody.get(0).setCompleted(true);
                        System.out.println("Úkol '" + shody.get(0).getTitle() + "' byl úspěšně odškrtnut.");
                    } else {
                        System.out.println("Takový úkol nebyl nalezen.");
                    }
                    break;

                case "5":
                    uloziste.ulozData(manazer.getAllTasks());
                    System.out.println("Data byla úspěšně uložena do mojedata.txt. Měj se!");
                    bezi = false;
                    break;

                default:
                    System.out.println("Neplatná volba, zkus to znovu.");
            }
        }
        skener.close();
    }
}