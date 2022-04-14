package BusinessLogic.Validators;
import Exception.*;

public interface Validator<T>{
    public void validate(T t) throws InvalidAttributeException;
}
