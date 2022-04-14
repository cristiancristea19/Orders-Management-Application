package Presentation.Controller;

import BusinessLogic.ProductBLL;
import Presentation.View.EditProductView;
import Exception.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProductController implements ActionListener {
    private EditProductView view;

    public EditProductController(EditProductView view)
    {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == view.getBtnEdit())
        {
            ProductBLL productBLL = new ProductBLL();
            int id=0;
            String name;
            int currentStock;
            try{
                id = Integer.parseInt(view.getID());
            }catch (NumberFormatException ex) {
                view.showMessage("Invalid id!");
                return;
            }
            name = view.getName();
            try{
                currentStock = Integer.parseInt(view.getStock());
            }catch (NumberFormatException ex){
                currentStock = -1;
            }
            try {
                productBLL.updateProduct(id, name, currentStock);
            }catch (InvalidAttributeException ex)
            {
                view.showMessage(ex.getMessage());
                return;
            }
            view.showMessage("The product with id " + id + " was successfully edited!");
            view.close();
        }
        else
        {
            view.close();
        }
    }
}
