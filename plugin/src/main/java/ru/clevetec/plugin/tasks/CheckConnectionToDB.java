package ru.clevetec.plugin.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import ru.clevetec.plugin.util.JDBCUtil;

import java.sql.Connection;
import java.util.Objects;

public class CheckConnectionToDB extends DefaultTask {
    @TaskAction
    void checkConnection() {
        Connection connection = JDBCUtil.getConnection();
        if (Objects.isNull(connection)) {
            throw new NullPointerException("Connection failed");
        }
    }
}
