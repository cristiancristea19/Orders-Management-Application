package Presentation.View;

import Presentation.Controller.EditClientController;

import javax.swing.*;
import java.awt.*;

public class EditClientView extends JFrame{

    private JPanel panel;

    private JButton btnEdit;
    private JButton btnCancel;
    private JLabel lbl;
    private JLabel lblName;
    private JLabel lblYear;
    private JLabel lblAddress;
    private JLabel lblID;
    private JTextField IDFld;
    private JTextField nameFld;
    private JTextField yearFld;
    private JTextField addressFld;
    private EditClientController controller;

    public EditClientView()
    {
        super("Edit Client");
        controller = new EditClientController(this);
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
        lbl = new JLabel("Edit a client");
        lbl.setFont(new Font("Lucia Grande", Font.BOLD, 20));
        Dimension sizeLbl = lbl.getPreferredSize();
        lbl.setBounds(110, 10, sizeLbl.width+20 ,sizeLbl.height);
        panel.add(lbl);

        lblID = new JLabel("ID:");
        lblID.setFont(new Font("Lucia Grande", Font.BOLD, 16));
        Dimension sizeID = lblID.getPreferredSize();
        lblID.setBounds(20, 70, sizeID.width+20 ,sizeID.height);
        panel.add(lblID);

        lblName = new JLabel("New name:");
        lblName.setFont(new Font("Lucia Grande", Font.BOLD, 16));
        Dimension sizeName = lblName.getPreferredSize();
        lblName.setBounds(20, 100, sizeName.width+20 ,sizeName.height);
        panel.add(lblName);

        lblYear = new JLabel("New year:");
        lblYear.setFont(new Font("Lucia Grande", Font.BOLD, 16));
        Dimension sizeYearLbl = lblYear.getPreferredSize();
        lblYear.setBounds(20, 130, sizeYearLbl.width+20 ,sizeYearLbl.height);
        panel.add(lblYear);

        lblAddress = new JLabel("New address:");
        lblAddress.setFont(new Font("Lucia Grande", Font.BOLD, 16));
        Dimension sizeAddressLbl = lblAddress.getPreferredSize();
        lblAddress.setBounds(20, 160, sizeAddressLbl.width+20 ,sizeAddressLbl.height);
        panel.add(lblAddress);
    }

    private void createTextFields()
    {
        IDFld = new JTextField(45);
        IDFld.setFont(new Font("Lucia Grande", Font.PLAIN, 15));
        IDFld.setBounds(140, 70, 150, 25);
        panel.add(IDFld);

        nameFld = new JTextField(45);
        nameFld.setFont(new Font("Lucia Grande", Font.PLAIN, 15));
        nameFld.setBounds(140, 100, 150, 25);
        panel.add(nameFld);

        yearFld = new JTextField(10);
        yearFld.setFont(new Font("Lucia Grande", Font.PLAIN, 15));
        yearFld.setBounds(140, 130, 150, 25);
        panel.add(yearFld);

        addressFld = new JTextField(10);
        addressFld.setFont(new Font("Lucia Grande", Font.PLAIN, 15));
        addressFld.setBounds(140, 160, 150, 25);
        panel.add(addressFld);
    }

    private void createButtons()
    {
        btnEdit = new JButton("Edit");
        btnEdit.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnEdit = btnEdit.getPreferredSize();
        btnEdit.setBounds(20, 240, 120, sizeBtnEdit.height);
        btnEdit.addActionListener(controller);
        panel.add(btnEdit);

        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnCancel = btnCancel.getPreferredSize();
        btnCancel.setBounds(180, 240, 120 , sizeBtnCancel.height);
        btnCancel.addActionListener(controller);
        panel.add(btnCancel);
    }

    public JButton getBtnCancel()
    {
        return btnCancel;
    }

    public JButton getBtnEdit()
    {
        return btnEdit;
    }

    public String getID()
    {
        return IDFld.getText();
    }

    public String getName()
    {
        return nameFld.getText();
    }

    public String getYear()
    {
        return yearFld.getText();
    }

    public String getAddress()
    {
        return addressFld.getText();
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
