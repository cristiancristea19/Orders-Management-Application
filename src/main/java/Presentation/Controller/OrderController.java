package Presentation.Controller;

import BusinessLogic.ClientBLL;
import BusinessLogic.OrderBLL;
import BusinessLogic.ProductBLL;
import Model.Client;
import Model.Product;
import Presentation.View.OrderView;
import Exception.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OrderController implements ActionListener, ListSelectionListener {

    private OrderView view;
    private List<Client> clients;
    private List<Product> products;

    public OrderController(OrderView view) {

        this.view = view;
        getClients();
        view.setClientsList(clients);
        getProducts();
        view.setProductsList(products);
    }

    public void getClients()
    {
        ClientBLL clientBLL = new ClientBLL();
        clients = clientBLL.findAllClients();
    }

    public void getProducts()
    {
        ProductBLL productBLL = new ProductBLL();
        products = productBLL.findAllProducts();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == view.getOrderBtn())
        {
            int indexClient = view.getSelectedIndexClient();
            int indexProduct = view.getSelectedIndexProduct();
            if(indexClient == -1 || indexProduct == -1)
            {
                view.showMessage("Please select a client and a product!");
                return;
            }
            int quantity = view.getQuantity();
            if(quantity == 0)
            {
                view.showMessage("This product is not available! Please choose another one!");
                return;
            }
            int idClient = clients.get(indexClient).getId();
            int idProduct = products.get(indexProduct).getId();
            OrderBLL orderBLL = new OrderBLL();
            orderBLL.insertOrder(idClient, idProduct ,quantity);
            ProductBLL productBLL = new ProductBLL();
            int stock = products.get(indexProduct).getCurrentStock() - quantity;
            products.get(indexProduct).setCurrentStock(stock);
            view.setSpinnerRange(products.get(indexProduct).getCurrentStock());
            try{
                productBLL.updateProduct(idProduct, "", stock);
            }catch (InvalidAttributeException ex) {
            }
            view.showMessage("Order successfully placed!");
        }
        else
        {
            view.close();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Object source = e.getSource();
        if(source == view.getProductsList())
        {
            int index = view.getSelectedIndexProduct();
            if(products.get(index).getCurrentStock() == 0)
            {
                view.showMessage("This product is not available! Please choose another one!");
            }
            view.setSpinnerRange(products.get(index).getCurrentStock());
        }
    }
}
