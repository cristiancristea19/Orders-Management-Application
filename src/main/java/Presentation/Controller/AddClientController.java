package Presentation.Controller;
import BusinessLogic.ClientBLL;
import Exception.InvalidAttributeException;
import Presentation.View.AddClientView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClientController implements ActionListener {
    private AddClientView view;

    public AddClientController(AddClientView view)
    {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == view.getBtnAdd())
        {
            ClientBLL clientBLL = new ClientBLL();
            String name = view.getName();
            if(name.equals(""))
            {
                view.showMessage("Field Name is mandatory!");
                return;
            }
            int year = 0;
            try{
                year = Integer.parseInt(view.getYear());
            }catch(NumberFormatException ex)
            {
                view.showMessage("Invalid year.");
                return;
            }
            String address = view.getAddress();
            try{
                clientBLL.insertClient(name, year, address);
            }catch (InvalidAttributeException ex){
                view.showMessage(ex.getMessage());
                return;
            }
            view.showMessage("Client " + name +" was successfully added!");
            view.close();
        }
        else if(source == view.getBtnCancel())
        {
            view.close();
        }
    }
}
