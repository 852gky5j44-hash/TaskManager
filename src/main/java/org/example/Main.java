package org.example;

import model.PersonalTask;
import model.Task;
import model.TaskManager;
import model.TaskStorage;
import model.WorkTask;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Správce úkolů");

        TaskManager manazer = new TaskManager();
        TaskStorage uloziste = new TaskStorage();

        List<Task> stareUkoly = uloziste.nactiData();
        manazer.setTasks(stareUkoly);

        WorkTask skola = new WorkTask("Velký Java projekt", "31.12.2026");
        PersonalTask jidlo = new PersonalTask("Sníst fazole", "Vysoká");
        WorkTask oprava = new WorkTask("Opravit chyby v kódu", "Zítra");

        manazer.addTask(skola);
        manazer.addTask(jidlo);
        manazer.addTask(oprava);

        skola.setCompleted(true);
        oprava.setCompleted(true);


        System.out.println("\nVšechny názvy úkolů");
        List<String> nazvy = manazer.getAllTaskTitles();
        for (String nazev : nazvy) {
            System.out.println("- " + nazev);
        }

        System.out.println("\nNedokončené úkoly");
        List<Task> nedokoncene = manazer.getIncompleteTasks();
        for (Task ukol : nedokoncene) {
            System.out.println("- " + ukol.getTitle());
        }

        System.out.println("\nHledání slova 'projekt'");
        List<Task> nalezene = manazer.findTasksByName("projekt");
        for (Task ukol : nalezene) {
            System.out.println("- " + ukol.getTitle());
        }

        System.out.println("\nStatistiky");
        long pocetHotovych = manazer.countCompletedTasks();
        System.out.println("Počet dokončených úkolů: " + pocetHotovych);

        uloziste.ulozData(manazer.getAllTasks());
        System.out.println("\nVšechna data úspěšně uložena");
    }
}