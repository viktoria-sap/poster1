package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTestNonEmptyWithSetup {

    private Manager manager = new Manager();

    private Film first = new Film(1, 1, "first", "comedy");
    private Film second = new Film(2, 2, "second", "drama");
    private Film third = new Film(3, 3, "third", "action");


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.removeById(idToRemove);
        Film[] actual = manager.getAll();
        Film[] expected = new Film[]{third, second};
        assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldNotRemoveIfNotExists() {
//        int idToRemove = 4;
//        manager.removeById(idToRemove);
//        Film[] actual = manager.getAll();
//        Film[] expected = new Film[]{third, second, first};
//        assertArrayEquals(expected, actual);
//    }

    @Test
    public void shouldGetFilms() {

        Manager manager = new Manager(4);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetFilmsIfOne() {

        Manager manager = new Manager(1);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetNonFilms() {

        Manager manager = new Manager(0);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{};
        assertArrayEquals(expected, actual);
    }

}
