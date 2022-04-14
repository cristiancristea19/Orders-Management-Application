package Presentation.Controller;

import BusinessLogic.ClientBLL;
import Presentation.View.EditClientView;
import Exception.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditClientController implements ActionListener {
    private EditClientView view;

    public EditClientController(EditClientView view)
    {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == view.getBtnEdit())
        {
            ClientBLL clientBLL = new ClientBLL();
            int id=0;
            String name;
            int year;
            String address;
            try{
                id = Integer.parseInt(view.getID());
            }catch (NumberFormatException ex) {
                view.showMessage("Invalid id!");
                return;
            }
            name = view.getName();
            try{
                year = Integer.parseInt(view.getYear());
            }catch (NumberFormatException ex){
                year = -1;
            }
            address = view.getAddress();
            try{
                clientBLL.updateClient(id, name, year, address);
            }catch (InvalidAttributeException ex)
            {
                view.showMessage(ex.getMessage());
                return;
            }
            view.close();
            view.showMessage("The client with id " + id + " was successfully edited!");
        }
        else
        {
            view.close();
        }
    }
}
