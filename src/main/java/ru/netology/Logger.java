package ru.netology;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger logger = null;
    protected int num = 1;

    private Logger() {
    }

    // Получение одного и того же объекта класса Logger
    // при любом повторном вызове
    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    // Логгирование сообщения в консоль
    public void log(String msg) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String text = time.format(formatter);
        LocalDateTime parsedDate = LocalDateTime.parse(text, formatter);
        System.out.printf("[%s %d] %s\n", formatter.format(parsedDate), num, msg);
        num++;
    }
}
