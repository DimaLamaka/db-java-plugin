package ru.clevetec.plugin.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import ru.clevetec.plugin.util.FileUtil;
import ru.clevetec.plugin.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable extends DefaultTask {

    @TaskAction
    public void createTable() {
        StringBuilder sqlScript = FileUtil.getSqlScript("schema.sql");
        Connection connection = JDBCUtil.getConnection();

        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(sqlScript.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
