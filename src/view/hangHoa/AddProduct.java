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
        dialog_entry_price = new javax.swing.JLabel();
        dialog_name = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        retail_price = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        entry_price = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        product_number = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        noti_retail = new javax.swing.JLabel();
        noti_entry = new javax.swing.JLabel();
        noti_number = new javax.swing.JLabel();
        btnAddProduct = new javax.swing.JButton();
        dialog_category = new javax.swing.JLabel();
        notify_names = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        product_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        choose_category = new javax.swing.JComboBox<>();
        add_new_category = new javax.swing.JButton();
        noti_name = new javax.swing.JLabel();
        noti_cat = new javax.swing.JLabel();
        dialog_number = new javax.swing.JLabel();
        notify_name = new javax.swing.JLabel();
        dialog_retail_price = new javax.swing.JLabel();
        dialog_ID = new javax.swing.JLabel();
        button_remove_all = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        jPasswordField1.setText("jPasswordField1");

        jTextField6.setText("jTextField6");

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("SẢN PHẨM MỚI");

        dialog_entry_price.setForeground(new java.awt.Color(255, 0, 0));

        dialog_name.setForeground(new java.awt.Color(255, 0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GIÁ SẢN PHẨM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Gía bán lẻ(*)");

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

        jLabel10.setForeground(new java.awt.Color(0, 0, 102));
        jLabel10.setText("Giá nhập(*)");

        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("VND");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

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

        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("VND");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        product_number.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_numberMouseClicked(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(0, 0, 102));
        jLabel11.setText("Số lượng(*)");

        jLabel18.setForeground(new java.awt.Color(0, 0, 102));
        jLabel18.setText("SP");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        noti_retail.setForeground(new java.awt.Color(255, 0, 0));

        noti_entry.setForeground(new java.awt.Color(255, 0, 0));

        noti_number.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noti_retail))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(retail_price, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noti_number))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(noti_entry))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(product_number, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(entry_price, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel18))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(noti_retail)
                    .addComponent(noti_entry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retail_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(entry_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(noti_number))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(product_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap())
        );

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

        dialog_category.setForeground(new java.awt.Color(255, 0, 0));

        notify_names.setForeground(new java.awt.Color(255, 0, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SẢN PHẨM MỚI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Tên sản phẩm(*)");

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

        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Danh mục sản phẩm(*)");

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

        add_new_category.setText("+");
        add_new_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_new_categoryActionPerformed(evt);
            }
        });

        noti_name.setForeground(new java.awt.Color(255, 0, 0));

        noti_cat.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noti_name)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noti_cat))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(choose_category, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_new_category)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(add_new_category))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(noti_name)
                            .addComponent(noti_cat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choose_category)
                            .addComponent(product_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 55, Short.MAX_VALUE))
        );

        dialog_number.setForeground(new java.awt.Color(255, 0, 0));

        dialog_retail_price.setForeground(new java.awt.Color(255, 0, 0));

        dialog_ID.setForeground(new java.awt.Color(255, 0, 0));

        button_remove_all.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        button_remove_all.setForeground(new java.awt.Color(255, 0, 0));
        button_remove_all.setText("Hoàn tác");
        button_remove_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_remove_allActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dialog_name, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dialog_ID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(notify_names)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notify_name)
                        .addGap(106, 106, 106)
                        .addComponent(dialog_category, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dialog_number, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(dialog_retail_price, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(251, 251, 251)
                                .addComponent(dialog_entry_price, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 295, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208)
                .addComponent(button_remove_all, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(notify_name)
                                    .addComponent(notify_names)
                                    .addComponent(dialog_name)
                                    .addComponent(dialog_category)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(dialog_ID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dialog_retail_price)
                                    .addComponent(dialog_entry_price)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_remove_all, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addComponent(dialog_number)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retail_priceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retail_priceMouseClicked
        noti_retail.setText("");
    }//GEN-LAST:event_retail_priceMouseClicked

    private void retail_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retail_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_retail_priceActionPerformed

    private void entry_priceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entry_priceMouseClicked
        noti_entry.setText("");
    }//GEN-LAST:event_entry_priceMouseClicked

    private void entry_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entry_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entry_priceActionPerformed

    private void product_numberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_numberMouseClicked
        noti_number.setText("");
    }//GEN-LAST:event_product_numberMouseClicked

    private void btnAddProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddProductMouseClicked

    }//GEN-LAST:event_btnAddProductMouseClicked

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        if (product_name.getText().trim().isEmpty()
            && retail_price.getText().trim().isEmpty() && entry_price.getText().trim().isEmpty()
            && product_number.getText().trim().isEmpty()) {
            noti_name.setText("Bạn nhập thiếu tên");
            noti_cat.setText("Hãy chọn danh mục");
            noti_retail.setText("Bạn nhập thiếu giá bán");
            noti_entry.setText("Bạn nhập thiếu giá nhập vào");
            noti_number.setText("Bạn chưa nhập số lượng");
        } else if (product_name.getText().trim().isEmpty()) {
            noti_name.setText("Bạn nhập thiếu tên");
        } else if (choose_category.getItemAt(choose_category.getSelectedIndex()).trim().isEmpty()) {
            noti_cat.setText("Hãy chọn danh mục");
        } else if (retail_price.getText().trim().isEmpty()) {
            noti_retail.setText("Bạn nhập thiếu giá bán");
        } else if (entry_price.getText().trim().isEmpty()) {
            noti_entry.setText("Bạn nhập thiếu giá nhập vào");
        } else if (product_number.getText().trim().isEmpty()) {
            noti_number.setText("Bạn chưa nhập số lượng");
        } else {
            if (!BaseApp.isNumber(retail_price.getText().trim())) {
                noti_retail.setText("Giá bán không hợp lệ");
            } else if (!BaseApp.isNumber(entry_price.getText().trim())) {
                noti_entry.setText("Giá nhập không hợp lệ");
            } else if (!BaseApp.isNumber(entry_price.getText().trim())) {
                noti_number.setText("Số lượng không hợp lệ");
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

    private void product_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_nameMouseClicked
        noti_name.setText("");
    }//GEN-LAST:event_product_nameMouseClicked

    private void product_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_product_nameActionPerformed

    private void choose_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_categoryMouseClicked
        noti_cat.setText("");

    }//GEN-LAST:event_choose_categoryMouseClicked

    private void choose_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choose_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_choose_categoryActionPerformed

    private void add_new_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_new_categoryActionPerformed
        new Add_new_category(choose_category).setVisible(true);
        //        dispose();
    }//GEN-LAST:event_add_new_categoryActionPerformed

    private void button_remove_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_remove_allActionPerformed
        product_name.setText("");
        retail_price.setText("");
        entry_price.setText("");
        product_number.setText("");
        //        product_unit.setText("");
    }//GEN-LAST:event_button_remove_allActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_new_category;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel noti_cat;
    private javax.swing.JLabel noti_entry;
    private javax.swing.JLabel noti_name;
    private javax.swing.JLabel noti_number;
    private javax.swing.JLabel noti_retail;
    private javax.swing.JLabel notify_name;
    private javax.swing.JLabel notify_names;
    private javax.swing.JTextField product_name;
    private javax.swing.JTextField product_number;
    private javax.swing.JTextField retail_price;
    // End of variables declaration//GEN-END:variables
}
