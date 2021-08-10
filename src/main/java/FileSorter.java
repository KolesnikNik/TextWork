package main.java;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileSorter {
    public static void fileSort(String fileName) {
        List<String> lines = new ArrayList<>();

        /* Откроем поток чтения из файла
        и перезапишем построчно текст в List */
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName)))) {

            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        /* Отсортируем List стандартным
        методом библиотеки Collections */
        Collections.sort(lines);

        /* Откроем поток записи в файл
        и построчно запишем отсортированный List */
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
