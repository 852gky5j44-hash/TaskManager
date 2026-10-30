package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void setTasks(List<Task> loadedTasks) {
        this.tasks = loadedTasks;
    }

    public List<Task> getIncompleteTasks() {
        return tasks.stream()
                .filter(ukol -> !ukol.isCompleted())
                .collect(Collectors.toList());
    }

    public List<Task> findTasksByName(String keyword) {
        return tasks.stream()
                .filter(ukol -> ukol.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<String> getAllTaskTitles() {
        return tasks.stream()
                .map(Task::getTitle)
                .collect(Collectors.toList());
    }

    public long countCompletedTasks() {
        return tasks.stream()
                .filter(Task::isCompleted)
                .count();
    }
}