package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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


        //Collections.sort(lines);
        /** Переводим список в масссив */
        String[] array = lines.toArray(new String[0]);
        /** Процедура сортировки коллекции */
        sort(array);
        /** Переводим массиы в список */
        lines = Arrays.asList(array);
        /** Поток записи в файл и последущая построчная запись отсортированной коллекции */
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Статичский метод сортировки
     * @param arr - имя обрабатываемого массива.
     */
    public static void sort(String[] arr)
    {
        for (int pass = 1; pass < arr.length; pass++)
        {
            int largestPos = max(arr, arr.length - pass);
            if (largestPos != arr.length - pass)
            {
                swap(arr, largestPos, arr.length - pass);
            }
        }
    }
    /**
     * Статичский метод большого значения
     * @param arr - имя обрабатываемого массива.
     */
    public static int max(String[] arr, int num)
    {
        int largestPos = 0;
        for (int i = 1; i <= num; i++)
        {
            if (arr[i].compareToIgnoreCase(arr[largestPos]) > 0)
            {
                largestPos = i;
            }
        }
        return largestPos;
    }

    /**
     * Статичский метод обмена позиций
     * @param arr - имя обрабатываемого массива.
     * @param first и
     * @param second - элементы обмена.
     */
    public static void swap(String[] arr, int first, int second)
    {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}


