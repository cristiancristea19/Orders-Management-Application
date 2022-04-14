package Presentation.View;

import Presentation.Controller.DeleteClientController;
import Presentation.Controller.DeleteProductController;

import javax.swing.*;
import java.awt.*;

public class DeleteProductView extends JFrame {
    private JPanel panel;

    private JButton btnDelete;
    private JButton btnCancel;
    private JLabel lbl;
    private JLabel lblID;
    private JTextField IDFld;
    private DeleteProductController controller;

    public DeleteProductView()
    {
        super("Delete Product");
        controller = new DeleteProductController(this);
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
        lbl = new JLabel("Delete a product");
        lbl.setFont(new Font("Lucia Grande", Font.BOLD, 20));
        Dimension sizeLbl = lbl.getPreferredSize();
        lbl.setBounds(90, 10, sizeLbl.width+20 ,sizeLbl.height);
        panel.add(lbl);

        lblID = new JLabel("ID:");
        lblID.setFont(new Font("Lucia Grande", Font.BOLD, 16));
        Dimension sizeID = lblID.getPreferredSize();
        lblID.setBounds(20, 70, sizeID.width+20 ,sizeID.height);
        panel.add(lblID);
    }

    private void createTextFields()
    {
        IDFld = new JTextField(45);
        IDFld.setFont(new Font("Lucia Grande", Font.PLAIN, 15));
        IDFld.setBounds(140, 70, 150, 25);
        panel.add(IDFld);
    }

    private void createButtons()
    {
        btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnDelete = btnDelete.getPreferredSize();
        btnDelete.setBounds(20, 240, 120, sizeBtnDelete.height);
        btnDelete.addActionListener(controller);
        panel.add(btnDelete);

        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Lucia Grande", Font.PLAIN, 16));
        Dimension sizeBtnCancel = btnCancel.getPreferredSize();
        btnCancel.setBounds(180, 240, 120 , sizeBtnCancel.height);
        btnCancel.addActionListener(controller);
        panel.add(btnCancel);
    }

    public JButton getBtnCancel(){
        return btnCancel;
    }

    public JButton getBtnDelete(){
        return btnDelete;
    }

    public String getID() {
        return IDFld.getText();
    }

    public void showMessage(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }

    public void close()
    {
        this.setVisible(false);
    }
}
