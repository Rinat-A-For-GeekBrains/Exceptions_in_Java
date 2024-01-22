package exception;

public class GenderException extends Throwable{
    public GenderException(){
        super("Неправильно введен пол");
    }
}
