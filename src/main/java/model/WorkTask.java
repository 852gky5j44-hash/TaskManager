package model;

public class WorkTask implements Task {
    private String title;
    private boolean completed;
    private String deadline;

    public WorkTask(String title, String deadline) {
        this.title = title;
        this.deadline = deadline;
        this.completed = false;
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public boolean isCompleted() { return completed; }

    @Override
    public void setCompleted(boolean completed) { this.completed = completed; }

    @Override
    public String getTaskType() { return "Work"; }

    public String getDeadline() { return deadline; }
    public void setDeadline(String deadline) { this.deadline = deadline; }
}
