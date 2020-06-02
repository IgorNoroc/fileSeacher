package ru.job4j;

/**
 * Валидация агруменов для запуска.
 */
public class ArgsFiles {
    private String[] args;

    public ArgsFiles(String[] args) {
        this.args = args;
        if (args.length < 7) {
            throw new IllegalArgumentException("Not enough arguments");
        }
    }

    /**
     * Возвращаем директорию по аргументу.
     *
     * @return директория поиска.
     */
    public String getDir() {
        int arg = findByArg("-d");
        return args[arg + 1];
    }

    /**
     * Возращаем название файла для поиска.
     *
     * @return название файла.
     */
    public String getNameSearch() {
        int arg = findByArg("-n");
        if (arg == -1) {
            throw new IllegalArgumentException("Не найден аргумент указывающий на имя для поиска");
        }
        return args[arg + 1];
    }

    /**
     * Смотрим конфигурацию поиска.
     * -m : поиск по маске.
     * -f : поиск по точному совпадению.
     *
     * @return нужная конфигурация поиска.
     */
    public String getSearchConf() {
        int arg = findByArg("-f");
        if (arg == -1) {
            arg = findByArg("-m");
            if (arg != -1) {
                return "-m";
            } else {
                throw new IllegalArgumentException("Не найден указатель на конфигурацию поиска.");
            }
        } else {
            return "-f";
        }
    }

    /**
     * Возвращаем имя файла для записи.
     *
     * @return имя файла.
     */
    public String getOutFile() {
        int arg = findByArg("-o");
        if (arg == -1) {
            throw new IllegalArgumentException("Не найден аргумент указывающий на имя файла для записи");
        }
        return args[arg + 1];
    }

    /**
     * Поиск индекса по названию.
     *
     * @param arg название команды.
     * @return индекс команды.
     */
    public int findByArg(String arg) {
        int result = -1;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(arg)) {
                result = i;
                break;
            }
        }
        return result;
    }
}
