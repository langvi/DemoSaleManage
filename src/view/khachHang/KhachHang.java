package view.khachHang;

import base.BaseApp;
import controller.KhachHangController;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Customer;

public class KhachHang extends javax.swing.JPanel {

    KhachHangController controller;
    String phoneNumber = "";
    String querySQL = "SELECT `customer_phone_number`,`customer_name`,`customer_sex`,`customer_birth`,"
            + "`customer_address` FROM customer";

    public KhachHang() {
        initComponents();
        controller = new KhachHangController();
        controller.fetchDataCustomer(tbkhachhang, querySQL);
        setTotalCustomer();
    }

    public void ProcessCrt(boolean b) {

        this.btEdit.setEnabled(b);
    }

    public void setTotalCustomer() {
        String queryTotal = "SELECT COUNT(*) FROM customer";
        totalCustomer.setText(Integer.toString(controller.getTotalCustomer(queryTotal)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLook = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btLook = new javax.swing.JButton();
        txtNS = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btRefesh = new javax.swing.JButton();
        txtTKH = new javax.swing.JTextField();
        btEdit = new javax.swing.JButton();
        txtDC = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbkhachhang = new javax.swing.JTable();
        khTong = new javax.swing.JLabel();
        btnew = new javax.swing.JButton();
        txtSDT = new javax.swing.JTextField();
        txtGT = new javax.swing.JTextField();
        totalCustomer = new javax.swing.JLabel();

        jLabel1.setText("Số Điện Thoại");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Quản Lý Khách Hàng");

        jLabel4.setText("Địa chỉ");

        txtLook.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLookActionPerformed(evt);
            }
        });

        jLabel5.setText("Ngày sinh");

        jLabel6.setText("Giới Tính");

        btLook.setText("Tìm kiếm số điện thoại");
        btLook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLookActionPerformed(evt);
            }
        });

        txtNS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNSActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên Khách hàng");

        btRefesh.setText("Cập Nhật dữ liệu");
        btRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefeshActionPerformed(evt);
            }
        });

        txtTKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTKHActionPerformed(evt);
            }
        });

        btEdit.setText("Sửa khách hàng");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        tbkhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Năm sinh", "Số Điện Thoại", "Địa Chỉ", "Giới Tính"
            }
        ));
        tbkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbkhachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbkhachhang);

        khTong.setText("Tổng số Khách hàng");

        btnew.setText("Nhập khách hàng mới");
        btnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnewActionPerformed(evt);
            }
        });

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        txtGT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGTActionPerformed(evt);
            }
        });

        totalCustomer.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(khTong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLook, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNS, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 430, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btLook)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btRefesh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnew)))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnew)
                        .addGap(30, 30, 30)
                        .addComponent(btRefesh)
                        .addGap(41, 41, 41)
                        .addComponent(btEdit)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLook)
                    .addComponent(khTong)
                    .addComponent(totalCustomer))
                .addContainerGap(145, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtLookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLookActionPerformed

    private void btLookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLookActionPerformed
        String phoneValue = txtLook.getText().trim();
        DefaultTableModel tableModel = (DefaultTableModel) tbkhachhang.getModel();
        tableModel.setRowCount(0);
        String[] data = new String[5];
        Customer customer = new Customer();
        controller.searchCustomer(phoneValue, customer);
        data[0] = customer.getCustomer_name();
        data[1] = customer.getCustomer_birth();
        data[2] = customer.getCustomer_phone_number();
        data[3] = customer.getCustomer_address();
        data[4] = customer.getCustomer_sex();
        tableModel.addRow(data);
        tbkhachhang.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }//GEN-LAST:event_btLookActionPerformed

    private void txtNSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNSActionPerformed

    private void btRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefeshActionPerformed
        controller.fetchDataCustomer(tbkhachhang, querySQL);
    }//GEN-LAST:event_btRefeshActionPerformed

    private void txtTKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTKHActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        if (this.txtSDT.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "so dien thoại không được bỏ trống", "Thông báo", 1);
        } else if (this.txtSDT.getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "số điện thoạikhông được vượt quá 10 ký tự", "Thông báo", 1);
        } else if (this.txtTKH.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Tên khách hàng không được bỏ trống", "Thông báo", 1);
        } else {
            if (!BaseApp.isNumber(txtSDT.getText())) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            } else if (!BaseApp.isNumber(txtNS.getText())) {
                JOptionPane.showMessageDialog(this, "Năm sinh không hợp lệ");
            } else {
                Customer customer = new Customer();
                customer.setCustomer_phone_number(txtSDT.getText());
                customer.setCustomer_name(txtTKH.getText());
                customer.setCustomer_sex(txtGT.getText());
                customer.setCustomer_birth(txtNS.getText());
                customer.setCustomer_address(txtDC.getText());
                controller.UpdateKH(customer, phoneNumber);
            }
        }
    }//GEN-LAST:event_btEditActionPerformed

    private void tbkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbkhachhangMouseClicked

        ProcessCrt(true);

        int row = this.tbkhachhang.getSelectedRow();
        phoneNumber = (this.tbkhachhang.getModel().getValueAt(row, 2)).toString();
        Customer customer = new Customer();
        // Tim kiem so dien thoai khach hang trong db
        controller.searchCustomer(phoneNumber, customer);
        //
        txtSDT.setText(customer.getCustomer_phone_number());
        txtTKH.setText(customer.getCustomer_name());
        txtDC.setText(customer.getCustomer_address());
        txtGT.setText(customer.getCustomer_sex());
        txtNS.setText(customer.getCustomer_birth());
    }//GEN-LAST:event_tbkhachhangMouseClicked

    private void btnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnewActionPerformed
        // TODO add your handling code here:
        new ThemKhachHang().setVisible(true);
    }//GEN-LAST:event_btnewActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtGTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btLook;
    private javax.swing.JButton btRefesh;
    private javax.swing.JButton btnew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel khTong;
    private javax.swing.JTable tbkhachhang;
    private javax.swing.JLabel totalCustomer;
    private javax.swing.JTextField txtDC;
    private javax.swing.JTextField txtGT;
    private javax.swing.JTextField txtLook;
    private javax.swing.JTextField txtNS;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTKH;
    // End of variables declaration//GEN-END:variables
}
