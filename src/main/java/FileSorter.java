package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Класс, содержащий метод реализующий чтение из переданного файла
 * с последующей построчной сортировкой этого файла.
 * @author N.S.Kolesnik
 * @version 1.0
 */

public class FileSorter {
    /**
     * Статичский метод обеспечивающие требуюмую логику
     * @param fileName - имя обрабатываемого файла.
     */
    public static void fileSort(String fileName) {

        /** Коллекция, используемая для хранения и
         * сортировки строк из файла
         */
        List<String> lines = new ArrayList<>();

        /** Поток чтения из требуемого файла */
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName)))) {

        /** Процедура записи строк в коллекцию */
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        /** Процедура сортировки коллекции */
        Collections.sort(lines);

        /** Поток записи в файл и последущая построчная запись отсортированной коллекции */
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
