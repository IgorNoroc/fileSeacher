package ru.job4j;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    /**
     * Поиск нужных файлов в директории.
     *
     * @param dir старт поиска.
     * @param search имя файла или маска.
     * @param config конфигурация поиска.
     * @return список найденных файлов.
     */
    public static List<Path> getFiles(Path dir, String search, String config) {
        SearchFiles searchFiles = new SearchFiles(getPredicate(search, config));
        try {
            Files.walkFileTree(dir, searchFiles);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchFiles.getPaths();
    }

    /**
     * Возращаем нужный предикат в зависимости от конфигурации.
     *
     * @param search имя файла или маска.
     * @param config аргумент.
     * @return предикат.
     */
    private static Predicate<Path> getPredicate(String search, String config) {
        Predicate<Path> predicate = null;
        if (config.equals("-m")) {
            predicate = path -> path.toFile().getName().endsWith(search.substring(2));
        } else if (config.equals("-f")) {
            predicate = path -> path.toFile().getName().equals(search);
        }
        return predicate;
    }
}
