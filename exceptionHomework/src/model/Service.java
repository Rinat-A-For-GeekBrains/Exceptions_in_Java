package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Service {
    StringBuilder stringBuilder = new StringBuilder();
    String lastName;

    public Service() {
    }

    public void save(String text) {

        stringBuilder.append(text);
        stringBuilder.append(" ");
    }

    public void saveLastname(String text) {
        lastName = text;
    }

    public void writeLine() {

        try (FileWriter writer = new FileWriter(lastName + ".txt", true);
             BufferedWriter bufferWriter = new BufferedWriter(writer);
        ) {
            stringBuilder.append("\n");
            bufferWriter.write(stringBuilder.toString());


        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
        finally {
            stringBuilder.delete(0,stringBuilder.length());
        }
    }

}
