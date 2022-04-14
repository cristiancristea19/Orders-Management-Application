package Presentation.View;

import Model.Client;
import Model.Product;
import Presentation.Controller.OrderController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OrderView extends JFrame {
    private JPanel panel;
    private JLabel clientLbl;
    private JLabel productLbl;
    private JLabel quantityLbl;
    private JButton orderBtn;
    private JButton cancelBtn;
    private JSpinner spinner;
    private JScrollPane scrollPane;
    private JList<String> clientsList;
    private JList<String> productsList;
    private OrderController controller;

    public OrderView()
    {
        super("Make an order");
        this.setSize(new Dimension(800, 530));
        this.setLocation(400, 200);
        panel = new JPanel();
        panel.setLayout(null);

        createLabels();
        createLists();
        createSpinner();

        controller = new OrderController(this);
        productsList.addListSelectionListener(controller);
        clientsList.addListSelectionListener(controller);
        createButtons();
        this.setContentPane(panel);
        this.setVisible(true);
    }

    private void createLabels()
    {
        clientLbl = new JLabel("Select a client:");
        clientLbl.setFont(new Font("Lucia Grande", Font.BOLD, 20));
        Dimension sizeLbl = clientLbl.getPreferredSize();
        clientLbl.setBounds(20, 15, sizeLbl.width+20 ,sizeLbl.height);
        panel.add(clientLbl);

        productLbl = new JLabel("Select a product:");
        productLbl.setFont(new Font("Lucia Grande", Font.BOLD, 20));
        sizeLbl = productLbl.getPreferredSize();
        productLbl.setBounds(300, 15, sizeLbl.width+20 ,sizeLbl.height);
        panel.add(productLbl);

        quantityLbl = new JLabel("Select the quantity:");
        quantityLbl.setFont(new Font("Lucia Grande", Font.PLAIN, 15));
        sizeLbl = clientLbl.getPreferredSize();
        quantityLbl.setBounds(600, 170, sizeLbl.width+20 ,sizeLbl.height);
        panel.add(quantityLbl);
    }

    private void createLists()
    {
        clientsList = new JList<String>();
        scrollPane = new JScrollPane(clientsList);
        clientsList.setFont(new Font("Lucia Grande", Font.PLAIN, 15));
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) clientsList.getCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        scrollPane.setBounds(20, 40, 250, 400);
        clientsList.setSelectedIndex(0);
        panel.add(scrollPane);

        productsList = new JList<String>();
        scrollPane = new JScrollPane(productsList);
        productsList.setFont(new Font("Lucia Grande", Font.PLAIN, 15));
        renderer = (DefaultListCellRenderer) productsList.getCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        productsList.setSelectedIndex(0);
        scrollPane.setBounds(300, 40, 250, 400);
        panel.add(scrollPane);
    }

    public void setClientsList(List<Client> clients)
    {
        String[] names = new String[clients.size()];
        for(int i=0; i<clients.size(); i++)
        {
            names[i] = clients.get(i).getName();
        }
        clientsList.setListData(names);
    }

    public void setProductsList(List<Product> products)
    {
        String[] names = new String[products.size()];
        for(int i=0; i<products.size(); i++)
        {
            names[i] = products.get(i).getName();
        }
        productsList.setListData(names);
    }

    public void createSpinner()
    {
        spinner = new JSpinner();
        spinner.setBounds(640, 200, 50, 30);
        ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
        panel.add(spinner);
    }

    private void createButtons()
    {
        orderBtn = new JButton("Order");
        orderBtn.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtn = orderBtn.getPreferredSize();
        orderBtn.setBounds(600, 240, 120, sizeBtn.height);
        panel.add(orderBtn);
        orderBtn.addActionListener(controller);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        cancelBtn.setBounds(600, 410, 120, sizeBtn.height);
        cancelBtn.addActionListener(controller);
        panel.add(cancelBtn);
    }

    public int getSelectedIndexClient()
    {
        return clientsList.getSelectedIndex();
    }

    public int getSelectedIndexProduct()
    {
        return productsList.getSelectedIndex();
    }

    public JList<String> getProductsList()
    {
        return productsList;
    }

    public void setSpinnerRange(int maxVal)
    {
        SpinnerNumberModel value;
        if(maxVal == 0)
            value = new SpinnerNumberModel(0, 0, 0, 0);
        else
            value = new SpinnerNumberModel(1, 0, maxVal, 1);
        spinner.setModel(value);
        ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
    }

    public JButton getOrderBtn()
    {
        return orderBtn;
    }

    public JButton getCancelBtn()
    {
        return cancelBtn;
    }

    public void close()
    {
        this.setVisible(false);
    }

    public int getQuantity()
    {
        return (int) spinner.getValue();
    }

    public void showMessage(String msg)
    {
        JOptionPane.showMessageDialog(this, msg);
    }
}
