package com.tercertiempo.sistemarugby.modelo.util;

import java.lang.reflect.Field;
import java.util.Collection;

public class FormatoTexto {

    public static String format(Object obj) {
        if (obj == null) {
            return "null";
        }

        if (obj instanceof Collection<?>) {
            return formatCollection((Collection<?>) obj);
        }

        return formatEntity(obj);
    }

    private static String formatCollection(Collection<?> collection) {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------------------------\n");
        for (Object item : collection) {
            sb.append(formatEntity(item)).append("\n");
        }
        sb.append("---------------------------------------------------");
        return sb.toString();
    }

    private static String formatEntity(Object obj) {
        StringBuilder sb = new StringBuilder();
        Field[] fields = obj.getClass().getDeclaredFields();
        
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                sb.append(String.format("%-10s ", field.get(obj))); // Formato de columna ajustado
            } catch (IllegalAccessException e) {
                sb.append("ERROR      ");
            }
        }
        return sb.toString();
    }
}