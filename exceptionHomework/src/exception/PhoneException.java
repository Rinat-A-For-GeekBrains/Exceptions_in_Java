package exception;

public class PhoneException extends Exception {
    public PhoneException(){
        super("Неправильно набран номер телефона");
    }
}
