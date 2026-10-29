package model;

public class PersonalTask implements Task {
    private String title;
    private boolean completed;
    private String priority;

    public PersonalTask(String title, String priority) {
        this.title = title;
        this.priority = priority;
        this.completed = false;
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public boolean isCompleted() { return completed; }

    @Override
    public void setCompleted(boolean completed) { this.completed = completed; }

    @Override
    public String getTaskType() { return "Personal"; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
}
