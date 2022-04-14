package Presentation.Controller;

import BusinessLogic.ClientBLL;
import BusinessLogic.ProductBLL;
import Presentation.View.DeleteProductView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProductController implements ActionListener {
    private DeleteProductView view;

    public DeleteProductController(DeleteProductView view)
    {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == view.getBtnDelete())
        {
            ProductBLL productBLL = new ProductBLL();
            int id=0;
            try{
                id=Integer.parseInt(view.getID());
            }catch(NumberFormatException ex){
                view.showMessage("Invalid id!");
                return;
            }
            productBLL.deleteProduct(id);
            view.showMessage("The product with id " + id + " was successfully deleted!");
        }
        view.close();
    }
}
