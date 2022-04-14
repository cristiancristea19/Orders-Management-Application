package Presentation.Controller;

import BusinessLogic.ClientBLL;
import BusinessLogic.OrderBLL;
import BusinessLogic.ProductBLL;
import Model.Client;
import Model.Product;
import Presentation.View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    private MainView mainView;
    public MainController(MainView mainView)
    {
        this.mainView = mainView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == mainView.getBtnViewClient())
        {
            ClientBLL clientBLL = new ClientBLL();
            TableView<Client> table = new TableView<>(Client.class);
            table.createTable(clientBLL.findAllClients());
        }
        else if(source == mainView.getBtnInsertClient())
        {
            new AddClientView();
        }
        else if(source == mainView.getBtnUpdateClient())
        {
            new EditClientView();
        }
        else if(source == mainView.getBtnDeleteClient())
        {
            new DeleteClientView();
        }
        else if(source == mainView.getBtnViewProduct())
        {
            ProductBLL productBLL = new ProductBLL();
            TableView<Product> table = new TableView<>(Product.class);
            table.createTable(productBLL.findAllProducts());
        }
        else if(source == mainView.getBtnInsertProduct())
        {
            new AddProductView();
        }
        else if(source == mainView.getBtnUpdateProduct())
        {
            new EditProductView();
        }
        else if(source == mainView.getBtnDeleteProduct())
        {
            new DeleteProductView();
        }
        else if(source == mainView.getBtnViewOrder())
        {
            OrderBLL orderBLL = new OrderBLL();
            OrdersTableView ordersTable = new OrdersTableView();
            ordersTable.createTable(orderBLL.findAllOrders());
        }
        else if(source == mainView.getBtnMakeAnOrder())
        {
            new OrderView();
        }
    }
}
