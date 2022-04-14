package Presentation.View;

import Presentation.Controller.AddProductController;

import javax.swing.*;
import java.awt.*;

public class AddProductView extends JFrame{
    private JPanel panel;

    private JButton btnAdd;
    private JButton btnCancel;
    private JLabel lbl;
    private JLabel lblName;
    private JLabel lblStock;
    private JTextField nameFld;
    private JTextField stockFld;
    private AddProductController controller;
    public AddProductView()
    {
        super("Add product");
        controller = new AddProductController(this);
        this.setSize(new Dimension(330, 350));
        this.setLocation(630, 300);
        panel = new JPanel();
        panel.setLayout(null);

        createLabels();
        createTextFields();
        createButtons();

        this.setContentPane(panel);
        this.setVisible(true);
    }

    private void createLabels()
    {
        lbl = new JLabel("Add a new product");
        lbl.setFont(new Font("Lucia Grande", Font.BOLD, 20));
        Dimension sizeLbl = lbl.getPreferredSize();
        lbl.setBounds(75, 10, sizeLbl.width+20 ,sizeLbl.height);
        panel.add(lbl);

        lblName = new JLabel("Name:");
        lblName.setFont(new Font("Lucia Grande", Font.BOLD, 16));
        Dimension sizeName = lblName.getPreferredSize();
        lblName.setBounds(20, 70, sizeName.width+20 ,sizeName.height);
        panel.add(lblName);

        lblStock = new JLabel("Stock:");
        lblStock.setFont(new Font("Lucia Grande", Font.BOLD, 16));
        Dimension sizeStockLbl = lblStock.getPreferredSize();
        lblStock.setBounds(20, 100, sizeStockLbl.width+20 ,sizeStockLbl.height);
        panel.add(lblStock);
    }

    private void createTextFields()
    {
        nameFld = new JTextField(45);
        nameFld.setFont(new Font("Lucia Grande", Font.PLAIN, 15));
        nameFld.setBounds(140, 70, 150, 25);
        panel.add(nameFld);

        stockFld = new JTextField(10);
        stockFld.setFont(new Font("Lucia Grande", Font.PLAIN, 15));
        stockFld.setBounds(140, 100, 150, 25);
        panel.add(stockFld);
    }

    private void createButtons()
    {
        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnAdd = btnAdd.getPreferredSize();
        btnAdd.setBounds(20, 240, 120, sizeBtnAdd.height);
        btnAdd.addActionListener(controller);
        panel.add(btnAdd);

        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnCancel = btnCancel.getPreferredSize();
        btnCancel.setBounds(180, 240, 120 , sizeBtnCancel.height);
        btnCancel.addActionListener(controller);
        panel.add(btnCancel);
    }

    public JButton getBtnAdd()
    {
        return btnAdd;
    }

    public JButton getBtnCancel()
    {
        return btnCancel;
    }

    public String getName()
    {
        return nameFld.getText();
    }

    public String getCurrentStock()
    {
        return stockFld.getText();
    }

    public void showMessage(String msg)
    {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void close()
    {
        this.setVisible(false);
    }
}
