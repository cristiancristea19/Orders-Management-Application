package Presentation.Controller;

import Presentation.View.OrdersTableView;
import Presentation.View.TableView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableController implements ActionListener {
    private OrdersTableView view;
    private TableView tableView;

    public TableController(OrdersTableView view)
    {
        this.view = view;
    }

    public TableController(TableView tableView)
    {
        this.tableView = tableView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(view != null)
            view.close();
        else
            tableView.close();
    }
}
