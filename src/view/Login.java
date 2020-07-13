package view;

import base.BaseApp;
import controller.LoginController;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    LoginController loginController;
    boolean isSavePassword = false;

    public Login() {
        super.setTitle("QUẢN LÍ BÁN HÀNG");
        loginController = new LoginController();
        initComponents();
        loginController.readUser(BaseApp.path, txtUserName, txtPassword);
        setCheckBox();
    }

    public final void setCheckBox() {
        savePassword.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    isSavePassword = true;
                } else {
                    isSavePassword = false;
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        savePassword = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(400, 200, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(31, 211, 210));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(Color.BLUE);
        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel4.setForeground(Color.BLUE
        );
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ĐĂNG NHẬP ");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setMinimumSize(new java.awt.Dimension(345, 20));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(Color.BLUE);
        jLabel5.setText("Tài khoản:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 249, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(Color.BLUE);
        jLabel6.setText("Mật khẩu:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 249, -1));

        savePassword.setForeground(Color.BLUE);
        savePassword.setText("Lưu mật khẩu");
        savePassword.setContentAreaFilled(false);
        savePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePasswordActionPerformed(evt);
            }
        });
        jPanel1.add(savePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 110, -1));

        jButton1.setForeground(Color.BLUE);
        jButton1.setText("Quên mật khẩu");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 120, 20));

        btnLogin.setBackground(Color.BLUE);
        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setText("Đăng nhập");
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLUE));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 110, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bglogin2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 250, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void savePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePasswordActionPerformed

    }//GEN-LAST:event_savePasswordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (BaseApp.connectDB() == null) {
            JOptionPane.showMessageDialog(this, "Không thể kết nối đến cơ sở dữ liệu");
        } else {
            if (loginController.CheckValidate(txtUserName.getText().trim(), txtPassword.getText().trim()) == 1) {
                BaseApp.permission = 1;
                dispose();
                if (isSavePassword) {
                    loginController.savePassword(BaseApp.path, txtUserName.getText().trim(), txtPassword.getText().trim());
                }
                BaseApp.userName = txtUserName.getText().trim();
                new Home().setVisible(true);
            } else if (loginController.CheckValidate(txtUserName.getText().trim(), txtPassword.getText().trim()) == 2) {
                BaseApp.permission = 2;
                dispose();
                if (isSavePassword) {
                    loginController.savePassword(BaseApp.path, txtUserName.getText().trim(), txtPassword.getText().trim());
                }
                BaseApp.userName = txtUserName.getText().trim();
                BaseApp.userID = loginController.getUserID(txtUserName.getText());
                new Home().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không đúng");
            }
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed

    }//GEN-LAST:event_btnLoginKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox savePassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
