package main.java;

/**
 * Основной рабочий класс с точкой входа.
 * @author N.S.Kolesnik
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        /** Имя рабочего файла */
        String fileName = "test2.txt";
        /** Запись в файл текста */
        TextWriter.textWriter(fileName);
        /** Построчная сортировка текста в файле */
        FileSorter.fileSort(fileName);
    }
}
