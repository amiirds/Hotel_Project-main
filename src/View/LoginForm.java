/*
 * Created by JFormDesigner on Tue Dec 01 21:49:57 IRST 2020
 */

package View;

import Model.Repository.user_repo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author unknown
 */

public class LoginForm extends JFrame {
    private ImageIcon image;
    public int index;

    public LoginForm() {
        user_repo user_repository;
        initComponents();
        Showtime();
        try {
            user_repository = new user_repo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        image = new ImageIcon("src/login.png");
        label_image.setIcon(image);

    }
    Timer timer;
    void Showtime() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                DateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
                String time = timeformat.format(date);
                label_time.setText(time);

            }
        };
        timer = new Timer(1000, actionListener);
        timer.setInitialDelay(0);
        timer.start();
    }

    private void button_submitActionPerformed() {

        if (textField_username.getText().equals("") ){
            JOptionPane.showMessageDialog(null,"Username can't be empty","ERROR",2);

        }
        else if (passwordField1.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"password can't be empty","ERROR",2);
        }
        else {

            boolean exist = false;
            for (int i = 0; i < user_repo.usernames.size(); i++) {
                if (user_repo.usernames.get(i).equals(textField_username.getText()) && user_repo.passes.get(i).equals(passwordField1.getText())) {
                    exist = true;
                    break;
                }
            }
            if (exist == true) {
                MenuForm menuForm = new MenuForm();
                menuForm.setVisible(true);
                setVisible(false);
            }
            if (exist == false) {
                JOptionPane.showMessageDialog(null,"username or password doesn't exist or wrong","ERROR",2);

            }
        }
        }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label_image = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField_username = new JTextField();
        passwordField1 = new JPasswordField();
        button_submit = new JButton();
        label_time = new JLabel();

        //======== this ========
        setBackground(new Color(204, 51, 0));
        setTitle("Login");
        var contentPane = getContentPane();

        //---- label_image ----
        label_image.setBackground(Color.red);
        label_image.setFont(label_image.getFont().deriveFont(label_image.getFont().getStyle() | Font.BOLD, label_image.getFont().getSize() + 3f));

        //---- label2 ----
        label2.setText("USERNAME(Name) =");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
        label2.setBackground(Color.black);
        label2.setForeground(Color.black);

        //---- label3 ----
        label3.setText("PASSWORD(Meli code) =");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));
        label3.setForeground(Color.black);

        //---- textField_username ----
        textField_username.setForeground(Color.black);
        textField_username.setFont(textField_username.getFont().deriveFont(textField_username.getFont().getSize() + 3f));

        //---- passwordField1 ----
        passwordField1.setForeground(Color.black);
        passwordField1.setFont(passwordField1.getFont().deriveFont(passwordField1.getFont().getSize() + 3f));

        //---- button_submit ----
        button_submit.setText("submit");
        button_submit.setBackground(Color.darkGray);
        button_submit.addActionListener(e -> button_submitActionPerformed());

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label_time, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57)
                            .addComponent(label_image, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(110, Short.MAX_VALUE))
                        .addComponent(button_submit, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label3))
                            .addGap(35, 35, 35)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(textField_username)
                                .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 60, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label_time, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_image, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label2)
                        .addComponent(textField_username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(42, 42, 42)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(53, 53, 53)
                    .addComponent(button_submit, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label_image;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField_username;
    private JPasswordField passwordField1;
    private JButton button_submit;
    private JLabel label_time;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
