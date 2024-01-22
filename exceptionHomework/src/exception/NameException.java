package exception;

import javax.lang.model.element.Name;

public class NameException extends Throwable{
    public NameException(){
      super("Неправильно введено имя");

    }
}
