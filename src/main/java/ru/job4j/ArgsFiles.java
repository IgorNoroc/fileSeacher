package ru.job4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Валидация агруменов для запуска.
 */
public class ArgsFiles {
    private String[] args;
    private Map<String, String> commands = new HashMap<>();

    public ArgsFiles(String[] args) {
        this.args = args;
        if (args.length < 7) {
            throw new IllegalArgumentException("Not enough arguments");
        }
        setCommands();
    }

    /**
     * Возвращаем директорию по аргументу.
     *
     * @return директория поиска.
     */
    public String getDir() {
        String dir = commands.get("-d");
        if (dir == null) {
            throw new IllegalArgumentException("Не найден указатель на директорию поиска.");
        }
        return dir;
    }

    /**
     * Возращаем название файла для поиска.
     *
     * @return название файла.
     */
    public String getNameSearch() {
        String nameFile = commands.get("-n");
        if (nameFile == null) {
            throw new IllegalArgumentException("Не найден аргумент указывающий на имя для поиска");
        }
        return nameFile;
    }

    /**
     * Смотрим конфигурацию поиска.
     * -m : поиск по маске.
     * -f : поиск по точному совпадению.
     *
     * @return нужная конфигурация поиска.
     */
    public String getSearchConf() {
        String config = commands.get("-f");
        if (config == null) {
            config = commands.get("-m");
            if (config != null) {
                return config;
            } else {
                throw new IllegalArgumentException("Не найден указатель на конфигурацию поиска.");
            }
        } else {
            return config;
        }
    }

    /**
     * Возвращаем имя файла для записи.
     *
     * @return имя файла.
     */
    public String getOutFile() {
        String out = commands.get("-o");
        if (out == null) {
            throw new IllegalArgumentException("Не найден аргумент указывающий на имя файла для записи");
        }
        return out;
    }

    /**
     * Устанавливаем команды и их значение в карту.
     */
    private void setCommands() {
        commands.put(args[0], args[1]);
        commands.put(args[2], args[3]);
        commands.put(args[4], args[4]);
        commands.put(args[5], args[6]);
    }
}
