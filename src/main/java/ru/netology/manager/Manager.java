package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Poster;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Manager {

    private Poster[] films = new Poster[0];
    public void add(Poster film) {
        // создаём новый массив размером на единицу больше
        int length = films.length + 1;
        Poster[] tmp = new Poster[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }
    public Poster[] getAll() {
        Poster[] result = new Poster[films.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
            System.out.println(films[i]);
        }
        return result;
    }
    // наивная реализация
    public void removeById(int id) {
        int length = films.length - 1;
        Poster[] tmp = new Poster[length];
        int index = 0;
        for (Poster film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        // меняем наши элементы
        films = tmp;
    }
}