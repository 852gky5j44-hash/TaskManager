package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TaskManagerTest {

    @Test
    public void testPridaniUkolu() {
        TaskManager manazer = new TaskManager();
        WorkTask ukol = new WorkTask("Napsat testy", "Zítra");

        manazer.addTask(ukol);

        assertEquals(1, manazer.getAllTasks().size());
        assertEquals("Napsat testy", manazer.getAllTasks().get(0).getTitle());
    }

    @Test
    public void testFiltrovaniNedokoncenychUkolu() {
        TaskManager manazer = new TaskManager();

        WorkTask hotovyUkol = new WorkTask("Uklidit", "Dnes");
        hotovyUkol.setCompleted(true);
        PersonalTask nedokoncenyUkol = new PersonalTask("Udělat projekt", "Vysoká");

        manazer.addTask(hotovyUkol);
        manazer.addTask(nedokoncenyUkol);

        List<Task> nedokoncene = manazer.getIncompleteTasks();

        assertEquals(1, nedokoncene.size());
        assertEquals("Udělat projekt", nedokoncene.get(0).getTitle());
    }
}