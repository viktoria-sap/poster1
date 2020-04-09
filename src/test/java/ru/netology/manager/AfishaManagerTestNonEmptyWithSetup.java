package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class AfishaManagerTestNonEmptyWithSetup {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager afishaManager;

    private Film first = new Film(1, 1, "first", "comedy");
    private Film second = new Film(2, 2, "second", "drama");
    private Film third = new Film(3, 3, "third", "action");


    @BeforeEach
    public void setUp() {
        afishaManager.add(first);
        afishaManager.add(second);
        afishaManager.add(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        // настройка заглушки
        Film[] returned = new Film[]{second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        afishaManager.removeById(idToRemove);
        Film[] expected = new Film[]{third, second};
        Film[] actual = afishaManager.getAll();
        assertArrayEquals(expected, actual);

        // удостоверяемся, что заглушка была вызвана с нужным значением
        // но это уже проверка "внутренней" реализации
        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        Film[] returned = new Film[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        afishaManager.removeById(idToRemove);
        Film[] expected = new Film[]{third, second, first};
        Film[] actual = afishaManager.getAll();

        assertArrayEquals(expected, actual);
        // удостоверяемся, что заглушка была вызвана с нужным значением
        // но это уже проверка "внутренней" реализации
        verify(repository).removeById(idToRemove);
      }

    @Test
    public void shouldRemoveAll() {
        Film[] returned = new Film[]{};
        doReturn(returned).when(repository).removeAll();

        afishaManager.removeAll();
        Film[] expected = new Film[]{};
        Film[] actual = afishaManager.removeAll();

        assertArrayEquals(expected, actual);
        // удостоверяемся, что заглушка была вызвана с нужным значением
        // но это уже проверка "внутренней" реализации
        verify(repository).removeAll();
    }

    @Test
    public void shouldFindById() {
        int idToFind = 3;
        // настройка заглушки
        Film[] returned = new Film[]{third};
        doReturn(returned).when(repository).findById(idToFind);

        afishaManager.findById(idToFind);
        Film[] expected = new Film[]{third};
        Film[] actual = afishaManager.findById(idToFind);
        assertArrayEquals(expected, actual);

        // удостоверяемся, что заглушка была вызвана с нужным значением
        // но это уже проверка "внутренней" реализации
        verify(repository).removeById(idToFind);
    }

}
