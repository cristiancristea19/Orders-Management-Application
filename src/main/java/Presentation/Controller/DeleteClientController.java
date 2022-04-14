package Presentation.Controller;

import BusinessLogic.ClientBLL;
import Presentation.View.DeleteClientView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteClientController implements ActionListener {
    private DeleteClientView view;

    public DeleteClientController(DeleteClientView view)
    {
        this.view = view;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == view.getBtnDelete())
        {
            ClientBLL clientBLL = new ClientBLL();
            int id=0;
            try{
                id=Integer.parseInt(view.getID());
            }catch(NumberFormatException ex){
                view.showMessage("Invalid id!");
                return;
            }
            clientBLL.deleteClient(id);
            view.showMessage("The client with id " + id + " was successfully deleted!");
        }
        view.close();
    }
}
