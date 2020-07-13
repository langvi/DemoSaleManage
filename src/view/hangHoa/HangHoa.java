package view.hangHoa;

import controller.HangHoaController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class HangHoa extends javax.swing.JPanel {
    
    String queryData = "SELECT product_name, product_ID, product_number, product_retail_price, product_category FROM product";
    HangHoaController hangHoa;
    
    public HangHoa() {
        initComponents();
//        choose_button_category();
        hangHoa = new HangHoaController();
        hangHoa.fetch_production_db(queryData, jTableProduct);
        setEvent();
        
    }
    
    public void setEvent() {
        comboBoxSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                Object index = comboBox.getSelectedIndex();
                if (index.equals(1)) {
                    hangHoa.sortProduct(1, jTableProduct);
                } else if (index.equals(2)) {
                    hangHoa.sortProduct(2, jTableProduct);
                } else if (index.equals(3)) {
                    hangHoa.sortProduct(3, jTableProduct);
                }
            }
        });
    }
    
    private void choose_button_category() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("--Danh mục--");
        model.addElement("Phụ kiện thời trang nam");
        model.addElement("Thời trang nam");
        model.addElement("Thời trang nữ");
        model.addElement("Balo-Ví-Túi xách");
//        cbCategory.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonView = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        jButtonSearch = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        text_search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboBoxSort = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("DANH SÁCH SẢN PHẨM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(618, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        jButtonView.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonView.setForeground(new java.awt.Color(153, 0, 153));
        jButtonView.setText("Cập nhật sản phẩm");
        jButtonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewActionPerformed(evt);
            }
        });

        jTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Mã sản phẩm", "Số lượng", "Giá bán(VND)", "Danh mục"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableProduct);

        jButtonSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonSearch.setForeground(new java.awt.Color(0, 0, 153));
        jButtonSearch.setText("Tìm kiếm");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 51, 0));
        jButton4.setText("Thêm sản phẩm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        text_search.setForeground(new java.awt.Color(102, 102, 102));
        text_search.setText("Tìm kiếm sản phẩm theo tên sản phẩm");
        text_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                text_searchMouseClicked(evt);
            }
        });
        text_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_searchActionPerformed(evt);
            }
        });

        jLabel2.setText("Sắp xếp:");

        comboBoxSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp theo", "Theo tên", "Giá từ thấp -> cao", "Giá từ cao -> thấp" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text_search, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButtonView, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_search, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonView, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewActionPerformed
        hangHoa.fetch_production_db(queryData, jTableProduct);
    }//GEN-LAST:event_jButtonViewActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        String text = text_search.getText();
        if (text.length() != 0) {
            hangHoa.searching_text_field_db(text, jTableProduct);
        } else {
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void text_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_searchMouseClicked
        text_search.setText("");
    }//GEN-LAST:event_text_searchMouseClicked

    private void text_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_searchActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new AddProduct().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxSort;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JTextField text_search;
    // End of variables declaration//GEN-END:variables
}
