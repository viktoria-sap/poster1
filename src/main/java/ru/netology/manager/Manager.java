package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Manager {
    private int numberFilms = 10;
    private Film[] films = new Film[0];

    public Manager(int numberFilms) {
        this.numberFilms = numberFilms;
    }

    public void add(Film film) {
        // создаём новый массив размером на единицу больше
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Film[] getFilms() {
        int resultSize = films.length;
        if (resultSize > numberFilms) {
            resultSize = numberFilms;
        }

        Film[] result = new Film[resultSize];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public Film[] getAll() {
        Film[] result = new Film[films.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        Film[] tmp = new Film[length];
        int index = 0;
        for (Film film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        // меняем наши элементы
        films = tmp;
    }
}