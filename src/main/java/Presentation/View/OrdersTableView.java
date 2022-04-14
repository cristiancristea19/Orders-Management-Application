package Presentation.View;

import Presentation.Controller.TableController;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OrdersTableView extends JFrame {
    private final JPanel panel;
    private JLabel lbl;
    private JButton btnBack;
    private TableController controller;

    public OrdersTableView() {
        super("Orders table");
        controller = new TableController(this);
        this.setSize(new Dimension(800, 530));
        this.setLocation(400, 200);

        this.panel = new JPanel();
        panel.setLayout(null);

        createButtons();
        createLabels();

        this.add(panel);
        this.setVisible(true);
    }

    public void createLabels()
    {
        lbl = new JLabel("Orders table");
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

    public void createTable(Object[][] RS)
    {
        String columns[] = {"ID", "Client Name", "Product Name", "Quantity"};
        DefaultTableModel tableModel = new DefaultTableModel(RS, columns) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
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

    public JButton getBtnBack()
    {
        return btnBack;
    }

    public void close()
    {
        this.setVisible(false);
    }
}
