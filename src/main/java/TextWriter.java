package main.java;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextWriter {
    public static void textWriter(String fileName) {

        /* Откроем потоки записи в файл
        и чтения из консоли */
        try (FileWriter writer = new FileWriter(
                fileName, true);
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(System.in))) {
            System.out.println("Введите строку");
            String testText = reader.readLine();

            /* Продолжаем запись пока не получим пустую строку */
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
