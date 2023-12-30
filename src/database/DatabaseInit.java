package database;

import annotations.DBTable;

public class DatabaseInit {
    private static final String URL = "jdbc:sqlite:gbbo.db";

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
    }
}
