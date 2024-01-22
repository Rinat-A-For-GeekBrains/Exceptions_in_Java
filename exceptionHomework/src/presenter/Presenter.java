package presenter;

import exception.GenderException;
import exception.NameException;
import exception.PhoneException;
import model.Service;
import view.View;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Presenter {
    View consoleUI;
    Service service = new Service();

    public Presenter(View ui) {
        consoleUI = ui;
    }

    public void addName() throws NameException {
        consoleUI.print("Введите ФИО через пробел");
        String name = consoleUI.read();
        String[] fullName = name.split(" ");
        String lastName = fullName[0];
        if (fullName.length != 3){
            throw new NameException();

        }
        service.save(name);
        service.saveLastname(lastName);
    }

    public void addGender() throws GenderException {
        consoleUI.print("Введите пол. Если женский то F, если мужской то M");
        String gender = consoleUI.read();

            if (!(gender.equals("F")) && !(gender.equals("M"))) {
                throw new GenderException();
            }


        service.save(gender);
    }

    public void addBirthdayDate() throws ParseException {
        consoleUI.print("Введите дату рождения\"dd.mm.yyyy\"");
        String stringDate = consoleUI.read();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date dataDate = df.parse(stringDate);
        service.save(stringDate);
    }

    public void addPhoneNumber() throws PhoneException {
        consoleUI.print("Введите телефон без +");
        String phone = consoleUI.read();
        if (phone.length() != 11) {
           throw new PhoneException();
        }
        service.save(phone);
    }

    public void writeFile() {
        service.writeLine();
    }
}
