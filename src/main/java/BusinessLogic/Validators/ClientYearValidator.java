package BusinessLogic.Validators;

import Model.Client;
import Exception.*;

public class ClientYearValidator implements Validator<Client>{
    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2021;
    @Override
    public void validate(Client client) throws InvalidAttributeException {
        if(client.getYear() < MIN_YEAR || client.getYear() > MAX_YEAR)
        {
            throw new InvalidAttributeException("Invalid year! It should be between " + MIN_YEAR + " and " + MAX_YEAR + ".");
        }
    }
}
