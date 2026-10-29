package model;

public interface Task {
    String getTitle();
    boolean isCompleted();
    void setCompleted(boolean completed);
    String getTaskType();
}
