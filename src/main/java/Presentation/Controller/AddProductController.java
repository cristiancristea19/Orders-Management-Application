package Presentation.Controller;

import BusinessLogic.ProductBLL;
import Exception.InvalidAttributeException;
import Presentation.View.AddProductView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductController implements ActionListener {
    private AddProductView view;

    public AddProductController(AddProductView view)
    {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == view.getBtnAdd())
        {
            ProductBLL productBLL = new ProductBLL();
            String name = view.getName();
            if(name.equals(""))
            {
                view.showMessage("Field Name is mandatory!");
                return;
            }
            int currentStock = 0;
            try{
                currentStock = Integer.parseInt(view.getCurrentStock());
            }catch(NumberFormatException ex)
            {
                view.showMessage("Invalid stock.");
                return;
            }
            try{
                productBLL.insertProduct(name, currentStock);
            }catch (InvalidAttributeException ex){
                view.showMessage(ex.getMessage());
                return;
            }
            view.showMessage("Product " + name + " was successfully added!");
            view.close();
        }
        else if(source == view.getBtnCancel())
        {
            view.close();
        }
    }
}
