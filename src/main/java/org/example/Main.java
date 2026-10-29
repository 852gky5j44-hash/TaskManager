package org.example;

import model.PersonalTask;
import model.Task;
import model.TaskManager;
import model.TaskStorage;
import model.WorkTask;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Spravce ukolu");

        TaskManager manazer = new TaskManager();
        TaskStorage uloziste = new TaskStorage();

        List<Task> stareUkoly = uloziste.nactiData();
        manazer.setTasks(stareUkoly);

        WorkTask projekt = new WorkTask("velky projekt", "31.12.2026");
        PersonalTask fazole = new PersonalTask("snist fazole", "Vysoka");

        manazer.addTask(projekt);
        manazer.addTask(fazole);

        projekt.setCompleted(true);

        System.out.println("\nnedokoncene ukoly: ");
        List<Task> nedokoncene = manazer.getIncompleteTasks();
        for (Task ukol : nedokoncene) {
            System.out.println("- " + ukol.getTitle());
        }

        uloziste.ulozData(manazer.getAllTasks());

        System.out.println("ulozeno");
    }
}