package DataAccess;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;

public class AbstractDAO<T>{
    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private String createSelectQuery(String field){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM ");
        stringBuilder.append(type.getSimpleName());
        stringBuilder.append(" WHERE " + field + " =?");
        return stringBuilder.toString();
    }

    private String createSelectAllQuery()
    {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM `warehouse`.");
        stringBuilder.append(type.getSimpleName());
        return stringBuilder.toString();

    }

    private String createInsertQuery(String[] fields)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO `warehouse`.");
        stringBuilder.append(type.getSimpleName());
        stringBuilder.append(" (");
        for(int i=1; i<fields.length-1; i++)
        {
            stringBuilder.append(fields[i] + " ,");
        }
        stringBuilder.append(fields[fields.length-1] + " ) ");
        stringBuilder.append(" VALUES (");
        for(int i=1; i<fields.length-1; i++)
        {
            stringBuilder.append(" ?, ");
        }
        stringBuilder.append("?)");
        return stringBuilder.toString();
    }

    private String createUpdateQuery(String[] fields, String field)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" UPDATE ");
        stringBuilder.append(type.getSimpleName());
        stringBuilder.append(" SET ");
        for(int i=1; i<fields.length-1; i++)
        {
            stringBuilder.append(fields[i]);
            stringBuilder.append(" =?,");
        }
        stringBuilder.append(fields[fields.length-1]);
        stringBuilder.append(" =? ");
        stringBuilder.append(" WHERE " + field + " =?" );
        return stringBuilder.toString();
    }

    private String createDeleteQuery(String field)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE FROM ");
        stringBuilder.append(type.getSimpleName());
        stringBuilder.append(" WHERE " + field + " =?");
        return stringBuilder.toString();
    }

    public T findById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            List<T> list = createObjects(resultSet);
            if(list.size() != 0) {
                return list.get(0);
            }
            else return null;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] constructors = type.getDeclaredConstructors();
        Constructor constructor = null;
        for (int i = 0; i < constructors.length; i++) {
            constructor = constructors[i];
            if (constructor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                constructor.setAccessible(true);
                T instance = (T) constructor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    private String[] getFieldsName(Field[] fields)
    {
        String[] fieldsName = new String[fields.length];
        int i=0;
        for(Field field: fields)
        {
            fieldsName[i++] = field.getName();
        }
        return fieldsName;
    }

    public void insert(T t){
        Field[] fields = type.getDeclaredFields();
        String[] fieldsName = getFieldsName(fields);
        String query = createInsertQuery(fieldsName);
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            for(int i=1; i<fields.length; i++){
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fields[i].getName(), type);
                Method method = propertyDescriptor.getReadMethod();
                Object value = method.invoke(t);
                Type fieldType = fields[i].getType();
                if (fieldType == String.class) {
                    statement.setString(i, (String) value);
                } else if (fieldType == int.class) {
                    statement.setInt(i, (Integer) value);
                }
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    public void update(T t){
        Field[] fields = type.getDeclaredFields();
        String[] fieldsName = getFieldsName(fields);
        String query = createUpdateQuery(fieldsName, "id");
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            for(int i=1; i<fields.length; i++){
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fields[i].getName(), type);
                Method method = propertyDescriptor.getReadMethod();
                Object value = method.invoke(t);
                Type fieldType = fields[i].getType();
                if (fieldType == String.class) {
                    statement.setString(i, (String) value);
                } else if (fieldType == int.class) {
                    statement.setInt(i, (Integer) value);
                }
            }
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fields[0].getName(), type);
            Method method = propertyDescriptor.getReadMethod();
            Object value = method.invoke(t);
            Type fieldType = fields[0].getType();
            statement.setInt(fields.length, (Integer) value);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    public void deleteById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createDeleteQuery("id");
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    public List<T> findAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
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
