package ru.clevetec.plugin.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {

    public static StringBuilder getSqlScript(String filename) {
        String path = "plugin/src/main/resources/" + filename;
        StringBuilder resultSqlScript = new StringBuilder();

        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                resultSqlScript.append(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultSqlScript;
    }
}
