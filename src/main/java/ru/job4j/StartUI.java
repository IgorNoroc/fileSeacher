package ru.job4j;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StartUI {
    /**
     * Программа ищет в указаной директории файли по названию или окончанию.
     *
     * @param args Требутся задать агрументы:
     *             -d : директория где следует искать файлы.
     *             -n : название файла или окончание.
     *             -m : искать по маске *.
     *             -f : искать по точному совпадению.
     *             -o : файл куда будет записан результат.
     */
    public static void main(String[] args) {
        ArgsFiles argsFiles = new ArgsFiles(args);
        List<Path> result = Search.getFiles(
                Paths.get(argsFiles.getDir()),
                argsFiles.getNameSearch(),
                argsFiles.getSearchConf());
        WriteFilesPaths.writeResult(result, argsFiles.getOutFile());
    }
}
