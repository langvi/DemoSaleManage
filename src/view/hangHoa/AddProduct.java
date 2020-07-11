package view.hangHoa;

import base.BaseApp;
import controller.HangHoaController;
import javax.swing.DefaultComboBoxModel;
import model.Product;

public class AddProduct extends javax.swing.JFrame {

    HangHoaController hangHoa;

    public AddProduct() {
        initComponents();
        choose_category();
        setBounds(250, 60, 1000, 600);
        hangHoa = new HangHoaController();
    }

    private void choose_category() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("");
        model.addElement("Phụ kiện thời trang nam");
        model.addElement("Thời trang nam");
        model.addElement("Thời trang nữ");
        model.addElement("Balo-Ví-Túi xách");
        choose_category.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField6 = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        btnAddProduct = new javax.swing.JButton();
        dialog_number = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        retail_price = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        choose_category = new javax.swing.JComboBox<>();
        button_remove_all = new javax.swing.JButton();
        entry_price = new javax.swing.JTextField();
        dialog_category = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        dialog_entry_price = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        notify_name = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        product_name = new javax.swing.JTextField();
        dialog_retail_price = new javax.swing.JLabel();
        dialog_name = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        notify_names = new javax.swing.JLabel();
        product_number = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        product_unit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dialog_ID = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        jPasswordField1.setText("jPasswordField1");

        jTextField6.setText("jTextField6");

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("SẢN PHẨM MỚI");

        btnAddProduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(255, 0, 0));
        btnAddProduct.setText("Thêm sản phẩm");
        btnAddProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddProductMouseClicked(evt);
            }
        });
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        dialog_number.setForeground(new java.awt.Color(255, 0, 0));

        jLabel7.setText("   GÍA SẢN PHẨM ");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        jLabel10.setForeground(new java.awt.Color(0, 0, 102));
        jLabel10.setText("Giá nhập");

        retail_price.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retail_priceMouseClicked(evt);
            }
        });
        retail_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retail_priceActionPerformed(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(0, 0, 102));
        jLabel18.setText("SP");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel3.setText("   SẢN PHẨM MỚI");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        choose_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        choose_category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choose_categoryMouseClicked(evt);
            }
        });
        choose_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choose_categoryActionPerformed(evt);
            }
        });

        button_remove_all.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        button_remove_all.setForeground(new java.awt.Color(255, 0, 0));
        button_remove_all.setText("Hoàn tác");
        button_remove_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_remove_allActionPerformed(evt);
            }
        });

        entry_price.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                entry_priceMouseClicked(evt);
            }
        });
        entry_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entry_priceActionPerformed(evt);
            }
        });

        dialog_category.setForeground(new java.awt.Color(255, 0, 0));

        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("VND");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        dialog_entry_price.setForeground(new java.awt.Color(255, 0, 0));

        jLabel17.setText("   KHO HÀNG");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        jLabel9.setForeground(new java.awt.Color(0, 0, 102));
        jLabel9.setText("Ghi chú");

        product_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_nameMouseClicked(evt);
            }
        });
        product_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_nameActionPerformed(evt);
            }
        });

        dialog_retail_price.setForeground(new java.awt.Color(255, 0, 0));

        dialog_name.setForeground(new java.awt.Color(255, 0, 0));

        jLabel11.setForeground(new java.awt.Color(0, 0, 102));
        jLabel11.setText("Số lượng");

        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Tên sản phẩm(*)");

        notify_names.setForeground(new java.awt.Color(255, 0, 0));

        product_number.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_numberMouseClicked(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Danh mục sản phẩm");

        product_unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_unitActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Gía bán lẻ ");

        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("VND");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        dialog_ID.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dialog_name, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(dialog_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(notify_names)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notify_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(choose_category, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dialog_category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(retail_price, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dialog_retail_price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addGap(84, 84, 84)
                        .addComponent(dialog_entry_price, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(231, 231, 231))
                            .addComponent(entry_price, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(product_unit, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dialog_number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(product_number, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_remove_all, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(notify_name)
                    .addComponent(notify_names)
                    .addComponent(dialog_name)
                    .addComponent(dialog_category))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(product_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choose_category))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dialog_ID)
                .addGap(29, 29, 29)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(dialog_retail_price)
                    .addComponent(dialog_entry_price))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retail_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(entry_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(21, 21, 21)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(dialog_number))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(product_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(product_unit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_remove_all, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddProductMouseClicked


    }//GEN-LAST:event_btnAddProductMouseClicked

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        if (product_name.getText().trim().isEmpty()
                && retail_price.getText().trim().isEmpty() && entry_price.getText().trim().isEmpty()
                && product_number.getText().trim().isEmpty()) {
            dialog_name.setText("Bạn nhập thiếu tên");
            dialog_category.setText("Hãy chọn danh mục");
            dialog_retail_price.setText("Bạn nhập thiếu giá bán");
            dialog_entry_price.setText("Bạn nhập thiếu giá nhập vào");
            dialog_number.setText("Bạn chưa nhập số lượng");
        } else if (product_name.getText().trim().isEmpty()) {
            dialog_name.setText("Bạn nhập thiếu tên");
        } else if (choose_category.getItemAt(choose_category.getSelectedIndex()).trim().isEmpty()) {
            dialog_category.setText("Hãy chọn danh mục");
        } else if (retail_price.getText().trim().isEmpty()) {
            dialog_retail_price.setText("Bạn nhập thiếu giá bán");
        } else if (entry_price.getText().trim().isEmpty()) {
            dialog_entry_price.setText("Bạn nhập thiếu giá nhập vào");
        } else if (product_number.getText().trim().isEmpty()) {
            dialog_number.setText("Bạn chưa nhập số lượng");
        } else {

            if (!BaseApp.isNumber(retail_price.getText().trim())) {
                dialog_retail_price.setText("Giá bán không hợp lệ");
            } else if (!BaseApp.isNumber(entry_price.getText().trim())) {
                dialog_entry_price.setText("Giá nhập không hợp lệ");
            } else if (!BaseApp.isNumber(entry_price.getText().trim())) {
                dialog_number.setText("Số lượng không hợp lệ");
            } else {
                Product base_product = new Product();
                base_product.setName((product_name.getText()));
                base_product.setCategory(choose_category.getItemAt(choose_category.getSelectedIndex()));
                base_product.setRetail_price(Integer.parseInt(retail_price.getText()));
                base_product.setEntry_price(Integer.parseInt(entry_price.getText()));
                base_product.setProduct_number(Integer.parseInt(product_number.getText()));

                hangHoa.add_info_product_db(base_product);
            }
        }
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void retail_priceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retail_priceMouseClicked
        dialog_retail_price.setText("");
    }//GEN-LAST:event_retail_priceMouseClicked

    private void retail_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retail_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_retail_priceActionPerformed

    private void choose_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_categoryMouseClicked
        dialog_category.setText("");
    }//GEN-LAST:event_choose_categoryMouseClicked

    private void choose_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choose_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_choose_categoryActionPerformed

    private void button_remove_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_remove_allActionPerformed
        product_name.setText("");
        retail_price.setText("");
        entry_price.setText("");
        product_number.setText("");
        product_unit.setText("");
    }//GEN-LAST:event_button_remove_allActionPerformed

    private void entry_priceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entry_priceMouseClicked
        dialog_entry_price.setText("");
    }//GEN-LAST:event_entry_priceMouseClicked

    private void entry_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entry_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entry_priceActionPerformed

    private void product_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_nameMouseClicked
        dialog_name.setText("");
    }//GEN-LAST:event_product_nameMouseClicked

    private void product_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_product_nameActionPerformed

    private void product_numberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_numberMouseClicked
        dialog_number.setText("");
    }//GEN-LAST:event_product_numberMouseClicked

    private void product_unitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_unitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_product_unitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton button_remove_all;
    private javax.swing.JComboBox<String> choose_category;
    private javax.swing.JLabel dialog_ID;
    private javax.swing.JLabel dialog_category;
    private javax.swing.JLabel dialog_entry_price;
    private javax.swing.JLabel dialog_name;
    private javax.swing.JLabel dialog_number;
    private javax.swing.JLabel dialog_retail_price;
    private javax.swing.JTextField entry_price;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel notify_name;
    private javax.swing.JLabel notify_names;
    private javax.swing.JTextField product_name;
    private javax.swing.JTextField product_number;
    private javax.swing.JTextField product_unit;
    private javax.swing.JTextField retail_price;
    // End of variables declaration//GEN-END:variables
}
