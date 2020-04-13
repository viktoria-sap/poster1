package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AfishaManager {
    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    private int numberFilms = 10;
    private Film[] films = new Film[0];

    public AfishaManager(int numberFilms) {
        this.numberFilms = numberFilms;
    }

    public void add(Film film) {
        repository.save(film);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public Film[] getAll() {
        Film[] films = repository.findAll();
        Film[] result = new Film[films.length];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Film findById(int id) {
        return repository.findById(id);
    }

}