package BusinessLogic;

import Exception.InvalidAttributeException;
import BusinessLogic.Validators.ProductStockValidator;
import BusinessLogic.Validators.Validator;
import DataAccess.ProductDAO;
import Model.Product;

import java.util.List;

public class ProductBLL {
    private ProductDAO productDAO;
    private Validator<Product> validator;

    public ProductBLL(){
        productDAO = new ProductDAO();
        validator = new ProductStockValidator();
    }

    public Product findProductById(int id){
        Product product = productDAO.findById(id);
        return product;
    }

    public List<Product> findAllProducts()
    {
        List<Product> products = productDAO.findAll();
        return products;
    }

    public void insertProduct(String name, int currentStock) throws InvalidAttributeException
    {
        Product product = new Product(name, currentStock);
        validator.validate(product);
        productDAO.insert(product);
    }

    public void updateProduct(int id, String name, int currentStock) throws InvalidAttributeException
    {
        Product product = findProductById(id);
        if(product == null) return;
        if(!name.equals(""))
            product.setName(name);
        if(currentStock!=-1)
            product.setCurrentStock(currentStock);
        validator.validate(product);
        productDAO.update(product);
    }

    public void deleteProduct(int id){
        productDAO.deleteById(id);
    }
}
