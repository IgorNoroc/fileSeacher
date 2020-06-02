package ru.job4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class WriteFilesPaths {
    /**
     * Запись списка путей файлов в файл.
     *
     * @param paths список путей файлов.
     * @param out   фаил для записи.
     */
    public static void writeResult(List<Path> paths, String out) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(out))) {
            for (Path path : paths) {
                writer.write(path.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
