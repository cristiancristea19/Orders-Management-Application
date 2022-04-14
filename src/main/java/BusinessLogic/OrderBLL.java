package BusinessLogic;

import DataAccess.OrderDAO;
import Model.Order;
import Presentation.FileWriterClass;

import java.util.List;


public class OrderBLL {
    private OrderDAO orderDAO;

    public OrderBLL(){
        orderDAO = new OrderDAO();
    }

    public String[][] findAllOrders() {
        List<String[]> info = orderDAO.returnOrders();
        String[][] result = new String[info.size()][4];
        for(int i=0; i<info.size(); i++)
        {
            for(int j=0; j<4; j++)
            {
                result[i][j] = info.get(i)[j];
            }
        }
        return result;
    }

    public void insertOrder(int clientId, int productId, int quantity)
    {
        Order order = new Order(clientId, productId, quantity);
        FileWriterClass writerClass = new FileWriterClass();
        writerClass.writeToFile(order);
        orderDAO.insert(order);
    }
}
