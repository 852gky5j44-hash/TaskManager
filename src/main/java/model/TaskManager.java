package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public List<Task> getIncompleteTasks() {
        List<Task> nedokoncene = new ArrayList<>();
        for (Task ukol : tasks) {
            if (ukol.isCompleted() == false) {
                nedokoncene.add(ukol);
            }
        }
        return nedokoncene;
    }

    public void setTasks(List<Task> loadedTasks) {
        this.tasks = loadedTasks;
    }
}
