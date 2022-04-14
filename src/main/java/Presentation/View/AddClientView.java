package Presentation.View;
import Presentation.Controller.AddClientController;

import javax.swing.*;

import java.awt.*;

public class AddClientView extends JFrame{
    private JPanel panel;
    private AddClientController controller;
    private JButton btnAdd;
    private JButton btnCancel;
    private JLabel lbl;
    private JLabel lblName;
    private JLabel lblYear;
    private JLabel lblAddress;
    private JTextField NameFld;
    private JTextField YearFld;
    private JTextField AddressFld;

    public AddClientView()
    {
        super("Add Client");
        controller = new AddClientController(this);
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
        lbl = new JLabel("Add a new client");
        lbl.setFont(new Font("Lucia Grande", Font.BOLD, 20));
        Dimension sizeLbl = lbl.getPreferredSize();
        lbl.setBounds(90, 10, sizeLbl.width+20 ,sizeLbl.height);
        panel.add(lbl);

        lblName = new JLabel("Name:");
        lblName.setFont(new Font("Lucia Grande", Font.BOLD, 16));
        Dimension sizeName = lblName.getPreferredSize();
        lblName.setBounds(20, 70, sizeName.width+20 ,sizeName.height);
        panel.add(lblName);

        lblYear = new JLabel("Year of birth:");
        lblYear.setFont(new Font("Lucia Grande", Font.BOLD, 16));
        Dimension sizeYearLbl = lblYear.getPreferredSize();
        lblYear.setBounds(20, 100, sizeYearLbl.width+20 ,sizeYearLbl.height);
        panel.add(lblYear);

        lblAddress = new JLabel("Address:");
        lblAddress.setFont(new Font("Lucia Grande", Font.BOLD, 16));
        Dimension sizeAddressLbl = lblAddress.getPreferredSize();
        lblAddress.setBounds(20, 130, sizeAddressLbl.width+20 ,sizeAddressLbl.height);
        panel.add(lblAddress);
    }

    private void createTextFields()
    {
        NameFld = new JTextField(45);
        NameFld.setFont(new Font("Lucia Grande", Font.PLAIN, 15));
        NameFld.setBounds(140, 70, 150, 25);
        panel.add(NameFld);

        YearFld = new JTextField(10);
        YearFld.setFont(new Font("Lucia Grande", Font.PLAIN, 15));
        YearFld.setBounds(140, 100, 150, 25);
        panel.add(YearFld);

        AddressFld = new JTextField(10);
        AddressFld.setFont(new Font("Lucia Grande", Font.PLAIN, 15));
        AddressFld.setBounds(140, 130, 150, 25);
        panel.add(AddressFld);
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
        return NameFld.getText();
    }

    public String getYear()
    {
        return YearFld.getText();
    }

    public String getAddress()
    {
        return AddressFld.getText();
    }

    public void close()
    {
        this.setVisible(false);
    }

    public void showMessage(String msg)
    {
        JOptionPane.showMessageDialog(this, msg);
    }
}
