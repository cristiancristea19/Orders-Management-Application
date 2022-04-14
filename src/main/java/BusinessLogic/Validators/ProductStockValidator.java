package BusinessLogic.Validators;

import Exception.*;
import Model.Product;

public class ProductStockValidator implements Validator<Product> {
    private static final int MIN_STOCK = 0;
    private static final int MAX_STOCK = Integer.MAX_VALUE;
    @Override
    public void validate(Product product) throws InvalidAttributeException {
        if(product.getCurrentStock() < MIN_STOCK || product.getCurrentStock() > MAX_STOCK)
        {
            throw new InvalidAttributeException("Invalid stock. It should be between " + MIN_STOCK + " and " + MAX_STOCK);
        }
    }
}
