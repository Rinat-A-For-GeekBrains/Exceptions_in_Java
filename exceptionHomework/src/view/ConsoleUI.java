package view;

import exception.GenderException;
import exception.NameException;
import exception.PhoneException;
import presenter.Presenter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.Scanner;

public class ConsoleUI implements View {
    Presenter presenter;

    public ConsoleUI() {
        presenter = new Presenter(this);
    }

    @Override
    public String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        boolean x = true;
        while (x) {
            try {
                presenter.addName();
                presenter.addBirthdayDate();
                presenter.addPhoneNumber();
                presenter.addGender();
                presenter.writeFile();
            } catch (ParseException e) {
                System.out.println("Неправильно введена дата рождения");

            } catch (NameException | GenderException | PhoneException e) {
                System.out.println(e.getMessage());
            }
            x = false;
        }

    }

//    public void choose(int choice) {
//        switch (choice) {
//            case 1:
//
//                break;
//            case 2:
//        }
//    }
}
