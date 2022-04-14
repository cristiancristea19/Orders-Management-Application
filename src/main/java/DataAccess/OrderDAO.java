package DataAccess;

import Model.Order;
import Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends AbstractDAO<Order> {
    public List<String[]> returnOrders()
    {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT warehouse.order.id, warehouse.client.name, warehouse.product.name, warehouse.order.quantity\n" +
                "FROM warehouse.order INNER JOIN warehouse.client INNER JOIN warehouse.product\n" +
                "ON warehouse.order.idClient = warehouse.client.id and warehouse.order.idProduct = warehouse.product.id;";
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            List<String[]> info = new ArrayList<String[]>();
            while(resultSet.next())
            {
                String[] row = new String[4];
                row[0] = resultSet.getString(1);
                row[1] = resultSet.getString(2);
                row[2] = resultSet.getString(3);
                row[3] = resultSet.getString(4);
                info.add(row);
            }
            return info;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
}
