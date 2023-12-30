package database;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import annotations.DBField;
import annotations.DBTable;

/**
 * This class serves as the database initializer for the Fantasy Great British
 * Bake-Off League application.
 * It automates the process of creating database tables based on the annotated
 * model classes.
 * <p>
 * The initializer uses Java Reflection to read {@link DBTable} and
 * {@link DBField} annotations on model classes.
 * This approach facilitates the dynamic generation of SQL create table
 * statements, ensuring that the database schema
 * is consistent with the defined data models. It supports a modular and
 * scalable design by allowing for easy addition
 * or modification of model classes without requiring manual updates to the
 * database schema.
 * <p>
 * To use this class, model classes must be annotated with {@link DBTable} at
 * the class level and {@link DBField} at
 * the field level. The {@link #init()} method then iterates over these classes,
 * constructing and executing
 * the SQL statements to create the corresponding tables in the SQLite database.
 */
public class DatabaseInit {
    public static void init() {
        // write models here to loop through when setting up DB
        Class<?>[] models = {
                models.Player.class
        };

        for (Class<?> model : models) {
            createTableForEachModel(model);
        }

    }

    private static void createTableForEachModel(Class<?> c) {
        if (!c.isAnnotationPresent(DBTable.class)) {
            return;
        }

        DBTable tableAnnotation = c.getAnnotation(DBTable.class);
        String tableName = tableAnnotation.name();
        StringBuilder sql = new StringBuilder("CREATE TABLE IF NOT EXISTS " + tableName + " (");

        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(DBField.class)) {
                DBField fieldAnnotation = field.getAnnotation(DBField.class);
                sql.append(fieldAnnotation.name()).append(" ");
                sql.append(getSqlType(field.getType()));
                if (fieldAnnotation.primaryKey()) {
                    sql.append(" PRIMARY KEY");
                }
                sql.append(", ");
            }
        }
        sql.setLength(sql.length() - 2); // Removes the last comma and space after loop
        sql.append(");");

        executeSql(sql.toString());
    }

    private static String getSqlType(Class<?> type) {
        if (type.equals(int.class) || type.equals(Integer.class)) {
            return "INTEGER";
        } else if (type.equals(String.class)) {
            return "TEXT";
        }
        return "TEXT";
    }

    private static void executeSql(String sql) {
        try (Connection connection = DatabaseConnector.connect();
                Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Executed SQL: " + sql);
        } catch (SQLException e) {
            System.out.println("Error executing SQL: " + e.getMessage());
        }
    }
}
