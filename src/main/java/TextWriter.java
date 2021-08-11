package main.java;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс, содержащий метод реализующий запись и создание файла
 * @author N.S.Kolesnik
 * @version 1.0
 */

public class TextWriter {
    public static void textWriter(String fileName) {

        /** Поток записи в файл и поток чтения из консоли
         * @param fileName - имя файла для записи.
         */
        try (FileWriter writer = new FileWriter(
                fileName, true);
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(System.in))) {
            System.out.println("Введите строку");
            String testText = reader.readLine();

            /** Процедура записи в файл
             * проводится до первой пустой строки.
             */
            while (testText.length() > 0) {
                System.out.println("Введите строку, для закрытия набора введите пустую строку");
                writer.write(testText + "\n");
                testText = reader.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
