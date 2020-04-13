package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.domain.Film;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class RepositoryTest {

    private AfishaRepository repository = new AfishaRepository();

    private Film first = new Film(1, 1, "first", "comedy");
    private Film second = new Film(2, 2, "second", "drama");
    private Film third = new Film(3, 3, "third", "action");


    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        repository.removeById(idToRemove);
        Film[] actual = repository.getAll();
        Film[] expected = new Film[]{third, second};
        assertArrayEquals(expected, actual);
    }
//
//    @Test
//    public void shouldNotRemoveIfNotExists() {
//        int idToRemove = 4;
//        repository.removeById(idToRemove);
//        Film[] actual = repository.getAll();
//        Film[] expected = new Film[]{third, second, first};
//        assertArrayEquals(expected, actual);
//    }

    @Test
    public void shouldRemoveAll() {

        repository.removeAll();
        Film[] actual = repository.getAll();
        Film[] expected = new Film[]{};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindById() {
        int idToFind = 3;

        Film expected = third;
        Film actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdNonExists() {
        int idToFind = 4;

        Film expected = null;
        Film actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

}