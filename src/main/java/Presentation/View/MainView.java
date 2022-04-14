package Presentation.View;

import Presentation.Controller.MainController;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;


public class MainView extends JFrame{
    private JPanel panel;
    private JPanel clientPanel;
    private JPanel productPanel;
    private JPanel orderPanel;
    private JButton btnInsertClient;
    private JButton btnUpdateClient;
    private JButton btnDeleteClient;
    private JButton btnViewClient;
    private JButton btnInsertProduct;
    private JButton btnUpdateProduct;
    private JButton btnDeleteProduct;
    private JButton btnViewProduct;
    private JButton btnViewOrder;
    private JButton btnMakeAnOrder;
    private MainController controller;
    public MainView()
    {
        super("Orders management application");
        controller = new MainController(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 530));
        this.setLocation(400, 200);
        panel = new JPanel();
        panel.setLayout(null);

        createPanels();
        createButtons();

        this.setContentPane(panel);

        this.setVisible(true);
    }

    private void createPanels()
    {
        clientPanel = new JPanel();
        clientPanel.setLayout(null);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        clientPanel.setBorder(BorderFactory.createTitledBorder(border, "Client operations" , TitledBorder.LEFT, TitledBorder.TOP,new Font("Lucia Grande", Font.BOLD, 18), Color.BLACK));
        clientPanel.setBounds(20, 30, 350, 240);
        panel.add(clientPanel);

        productPanel = new JPanel();
        productPanel.setLayout(null);
        productPanel.setBorder(BorderFactory.createTitledBorder(border, "Product operations" , TitledBorder.LEFT, TitledBorder.TOP,new Font("Lucia Grande", Font.BOLD, 18), Color.BLACK));
        productPanel.setBounds(400, 30, 350, 240);
        panel.add(productPanel);

        orderPanel = new JPanel();
        orderPanel.setLayout(null);
        orderPanel.setBorder(BorderFactory.createTitledBorder(border, "Order operations" , TitledBorder.LEFT, TitledBorder.TOP,new Font("Lucia Grande", Font.BOLD, 18), Color.BLACK));
        orderPanel.setBounds(225, 300, 350, 150);
        panel.add(orderPanel);
    }



    private void createButtons()
    {
        btnViewClient = new JButton("View all clients");
        btnViewClient.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnBack = btnViewClient.getPreferredSize();
        btnViewClient.setBounds(50, 50, 250, sizeBtnBack.height);
        btnViewClient.addActionListener(controller);
        clientPanel.add(btnViewClient);

        btnInsertClient = new JButton("Add new client");
        btnInsertClient.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnInsert = btnInsertClient.getPreferredSize();
        btnInsertClient.setBounds(50, 90, 250 , sizeBtnInsert.height);
        btnInsertClient.addActionListener(controller);
        clientPanel.add(btnInsertClient);

        btnUpdateClient = new JButton("Edit a client");
        btnUpdateClient.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnUpdate = btnUpdateClient.getPreferredSize();
        btnUpdateClient.setBounds(50, 130, 250 , sizeBtnUpdate.height);
        btnUpdateClient.addActionListener(controller);
        clientPanel.add(btnUpdateClient);


        btnDeleteClient = new JButton("Delete a client");
        btnDeleteClient.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnDelete = btnDeleteClient.getPreferredSize();
        btnDeleteClient.setBounds(50, 170, 250 , sizeBtnDelete.height);
        btnDeleteClient.addActionListener(controller);
        clientPanel.add(btnDeleteClient);

        btnViewProduct = new JButton("View all products");
        btnViewProduct.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnViewProduct = btnViewProduct.getPreferredSize();
        btnViewProduct.setBounds(50, 50, 250, sizeBtnViewProduct.height);
        btnViewProduct.addActionListener(controller);
        productPanel.add(btnViewProduct);

        btnInsertProduct = new JButton("Add new product");
        btnInsertProduct.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnInsertProduct = btnInsertProduct.getPreferredSize();
        btnInsertProduct.setBounds(50, 90, 250 , sizeBtnInsertProduct.height);
        btnInsertProduct.addActionListener(controller);
        productPanel.add(btnInsertProduct);

        btnUpdateProduct = new JButton("Edit a product");
        btnUpdateProduct.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnUpdateProduct = btnUpdateProduct.getPreferredSize();
        btnUpdateProduct.setBounds(50, 130, 250 , sizeBtnUpdateProduct.height);
        btnUpdateProduct.addActionListener(controller);
        productPanel.add(btnUpdateProduct);


        btnDeleteProduct = new JButton("Delete a product");
        btnDeleteProduct.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnDeleteProduct = btnDeleteProduct.getPreferredSize();
        btnDeleteProduct.setBounds(50, 170, 250 , sizeBtnDeleteProduct.height);
        btnDeleteProduct.addActionListener(controller);
        productPanel.add(btnDeleteProduct);

        btnViewOrder = new JButton("View all orders");
        btnViewOrder.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnBackOrder = btnViewOrder.getPreferredSize();
        btnViewOrder.setBounds(50, 50, 250, sizeBtnBackOrder.height);
        btnViewOrder.addActionListener(controller);
        orderPanel.add(btnViewOrder);

        btnMakeAnOrder = new JButton("Make an order");
        btnMakeAnOrder.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnMakeAnOrder = btnMakeAnOrder.getPreferredSize();
        btnMakeAnOrder.setBounds(50, 90, 250 , sizeBtnMakeAnOrder.height);
        btnMakeAnOrder.addActionListener(controller);
        orderPanel.add(btnMakeAnOrder);
    }

    public JButton getBtnInsertClient() {
        return btnInsertClient;
    }

    public JButton getBtnUpdateClient() {
        return btnUpdateClient;
    }

    public JButton getBtnDeleteClient() {
        return btnDeleteClient;
    }

    public JButton getBtnViewClient() {
        return btnViewClient;
    }

    public JButton getBtnInsertProduct() {
        return btnInsertProduct;
    }

    public JButton getBtnUpdateProduct() {
        return btnUpdateProduct;
    }

    public JButton getBtnDeleteProduct() {
        return btnDeleteProduct;
    }

    public JButton getBtnViewProduct() {
        return btnViewProduct;
    }

    public JButton getBtnViewOrder() {
        return btnViewOrder;
    }

    public JButton getBtnMakeAnOrder() {
        return btnMakeAnOrder;
    }

    public MainController getController() {
        return controller;
    }
}
