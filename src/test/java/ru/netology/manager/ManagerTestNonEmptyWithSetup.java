package ru.netology.manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
public class ManagerTestNonEmptyWithSetup {
    private Manager manager = new Manager();
    private Poster first = new Poster(1, 1, "first", "comedy");
    private Poster second = new Poster(2, 2, "second", "drama");
    private Poster third = new Poster(3, 3, "third", "action");
    private Poster fourth = new Poster(1, 1, "first", "comedy");
    private Poster fifth = new Poster(2, 2, "second", "drama");
    private Poster sixth = new Poster(3, 3, "third", "action");
    private Poster seventh = new Poster(1, 1, "first", "comedy");
    private Poster eighth = new Poster(2, 2, "second", "drama");
    private Poster ninth = new Poster(3, 3, "third", "action");
    private Poster tenth = new Poster(1, 1, "first", "comedy");
    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
    }
    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.removeById(idToRemove);
        Poster[] actual = manager.getAll();
        Poster[] expected = new Poster[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        manager.removeById(idToRemove);
        Poster[] actual = manager.getAll();
        Poster[] expected = new Poster[]{tenth, ninth, eighth, seventh, sixth, fifth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}