package Presentation.View;

import Presentation.Controller.TableController;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;

import java.util.List;

public class TableView<T> extends JFrame{

    private final Class<T> type;
    private final JPanel panel;
    private JButton btnBack;
    private JLabel lbl;
    private TableController controller;

    @SuppressWarnings("unchecked")
    public TableView(Class<T> type)
    {
        super(type.getSimpleName() + "s table");
        this.type = type;
        controller = new TableController(this);
        this.setSize(new Dimension(800, 530));
        this.setLocation(400, 200);
        panel = new JPanel();
        panel.setLayout(null);

        createLabels();
        createButtons();

        this.add(panel);
        this.setVisible(true);

    }

    public void createLabels()
    {
        lbl = new JLabel(type.getSimpleName() + "s table");
        lbl.setFont(new Font("Lucia Grande", Font.BOLD, 20));
        Dimension sizeUser = lbl.getPreferredSize();
        lbl.setBounds(330, 15, sizeUser.width+20 ,sizeUser.height);
        panel.add(lbl);
    }

    public void createButtons()
    {
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnBack = btnBack.getPreferredSize();
        btnBack.setBounds(610, 420, 120 , sizeBtnBack.height);
        btnBack.addActionListener(controller);
        panel.add(btnBack);
    }

    public void createTable(List<T> data)
    {
        String[] columns = new String[type.getDeclaredFields().length];
        int i=0;
        for(Field field: type.getDeclaredFields())
        {
            columns[i++] = field.getName();
        }
        Object[][] objects = new Object[data.size()][columns.length];
        i=0;
        int j=0;
        for(T obj: data)
        {
            for(String column: columns)
            {
                try {
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(column, type);
                    Method method = propertyDescriptor.getReadMethod();
                    Object value = method.invoke(obj);
                    objects[i][j++] = value;
                } catch (IntrospectionException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            i++;
            j=0;
        }
        DefaultTableModel tableModel = new DefaultTableModel(objects, columns) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable table = new JTable();
        table.setModel(tableModel);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(String.class)).setHorizontalAlignment(SwingConstants.CENTER);
        table.setPreferredScrollableViewportSize(new Dimension(30, 70));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 50, 720, 350);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(scrollPane);
        this.setContentPane(panel);
    }

    public void close()
    {
        this.setVisible(false);
    }
}
