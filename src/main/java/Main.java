package main.java;

public class Main {
    public static void main(String[] args) {
        //Имя рабочего файла
        String fileName = "test2.txt";
        //Запись в файл текста
        TextWriter.textWriter(fileName);
        //Построчная сортировка текста в файле
        FileSorter.fileSort(fileName);
    }
}
