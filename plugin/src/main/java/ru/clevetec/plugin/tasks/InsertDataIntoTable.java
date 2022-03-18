package ru.clevetec.plugin.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import ru.clevetec.plugin.util.FileUtil;
import ru.clevetec.plugin.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataIntoTable extends DefaultTask {

    @TaskAction
    public void insertData() {
        StringBuilder sqlScript = FileUtil.getSqlScript("data.sql");
        Connection connection = JDBCUtil.getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlScript.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
