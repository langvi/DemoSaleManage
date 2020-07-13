package view.thongKe;

import controller.ThongKeController;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class ThongKe extends javax.swing.JPanel {

    ThongKeController DB;

    public ThongKe() {
        initComponents();
        DB = new ThongKeController();
    }

    public boolean isDate(String date) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean isDateExist(String date) {
        String queryCreateAt = "SELECT order_create_at FROM orders WHERE order_create_at = '" + date + "'";
        if (DB.getDate(queryCreateAt).equals("")) {
            return false;
        } else {
            return true;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        profitValue = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        choseBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        productValue = new javax.swing.JLabel();
        day_tf = new javax.swing.JTextField();
        product = new javax.swing.JLabel();
        year_tf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        month_tf = new javax.swing.JTextField();
        totalMoney = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        table = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        totalProfit = new javax.swing.JLabel();
        moneyValue = new javax.swing.JLabel();

        title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Thống Kê Bán Hàng");
        title.setToolTipText("");

        jLabel1.setText("Năm");

        choseBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        choseBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng", "Năm" }));

        jLabel3.setText("Ngày");

        updateBtn.setText("Cập Nhật");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        day_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                day_tfActionPerformed(evt);
            }
        });

        product.setText("Lượng Hàng bán ra:");

        year_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year_tfActionPerformed(evt);
            }
        });

        jLabel2.setText("Tháng");

        month_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                month_tfActionPerformed(evt);
            }
        });

        totalMoney.setText("Tổng tiền thu về:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tìm Kiếm:");

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hàng Hóa", "Tên Hàng Hóa", "Loại Hàng", "Số Lượng Bán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setViewportView(jTable7);

        totalProfit.setText("Tổng tiền lãi:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(table)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalProfit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(moneyValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                            .addComponent(productValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(profitValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(year_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(month_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(day_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(choseBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choseBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(month_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(year_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productValue, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(moneyValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profitValue, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalProfit, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String date = year_tf.getText() + "-" + month_tf.getText() + "-" + day_tf.getText();
        if (!isDate(date)) {
            JOptionPane.showMessageDialog(this, "Giá trị ngày tháng không hợp lệ");
        } else {
            if (!isDateExist(date)) {
                JOptionPane.showMessageDialog(this, "Không có dữ liệu");
            } else {
                Calendar day = Calendar.getInstance();
                int d = day.get(Calendar.DAY_OF_MONTH);
                int m = day.get(Calendar.MONTH);
                int y = day.get(Calendar.YEAR);
                String date_day = "";
                String date_month = "";
                String date_year = "";
                if (year_tf.getText().equals("") && month_tf.getText().equals("") && day_tf.getText().equals("")) {
                    if (m < 10 && d < 10) {
                        date_day = day.get(Calendar.YEAR) + "-0" + (day.get(Calendar.MONTH) + 1) + "-0" + day.get(Calendar.DAY_OF_MONTH);
                        date_month = day.get(Calendar.YEAR) + "-0" + (day.get(Calendar.MONTH) + 1) + "%";
                        date_year = day.get(Calendar.YEAR) + "%";
                    } else if (m < 10) {
                        date_day = day.get(Calendar.YEAR) + "-0" + (day.get(Calendar.MONTH) + 1) + "-" + day.get(Calendar.DAY_OF_MONTH);
                        date_month = day.get(Calendar.YEAR) + "-0" + (day.get(Calendar.MONTH) + 1) + "%";
                        date_year = day.get(Calendar.YEAR) + "%";
                    } else if (d < 10) {
                        date_day = day.get(Calendar.YEAR) + "-" + (day.get(Calendar.MONTH) + 1) + "-0" + day.get(Calendar.DAY_OF_MONTH);
                        date_month = day.get(Calendar.YEAR) + "-" + (day.get(Calendar.MONTH) + 1) + "%";
                        date_year = day.get(Calendar.YEAR) + "%";
                    } else {
                        date_day = day.get(Calendar.YEAR) + "-" + (day.get(Calendar.MONTH)) + "-" + day.get(Calendar.DAY_OF_MONTH);
                        date_month = day.get(Calendar.YEAR) + "-" + (day.get(Calendar.MONTH)) + "%";
                        date_year = day.get(Calendar.YEAR) + "%";
                    }

                    String chose = (String) choseBox.getSelectedItem();
                    int index = choseBox.getSelectedIndex();
                    switch (index) {
                        case (0): {
                            String query_day = "select order_ID from orders where order_create_at = '" + date_day + "';";
                            DB.callDataDay(query_day, jTable7, productValue, moneyValue, profitValue);
                            break;
                        }
                        case (1): {
                            String query_month = "select order_ID from orders where order_create_at like '" + date_month + "';";
                            DB.callDataDay(query_month, jTable7, productValue, moneyValue, profitValue);
                            break;
                        }
                        case (2): {
                            String query_year = "select order_ID from orders where order_create_at like '" + date_year + "';";
                            DB.callDataDay(query_year, jTable7, productValue, moneyValue, profitValue);
                        }
                    }
                } else if (year_tf.getText().equals("") && month_tf.getText().equals("")) {
                    int dy = Integer.parseInt(day_tf.getText());
                    System.out.println(dy);
                    if (dy < 10) {
                        date_day = day.get(Calendar.YEAR) + "-" + (day.get(Calendar.MONTH) + 1) + "-0" + dy;
                        String query_day = "select order_ID from orders where order_create_at = '" + date_day + "';";
                    } else {
                        date_day = day.get(Calendar.YEAR) + "-" + (day.get(Calendar.MONTH) + 1) + "-" + dy;
                        String query_day = "select order_ID from orders where order_create_at = '" + date_day + "';";
                    }
                } else if (year_tf.getText().equals("")) {
                    int dy = Integer.parseInt(day_tf.getText());
                    int mth = Integer.parseInt(month_tf.getText());
                    if (mth < 10 && dy < 10) {
                        date_day = day.get(Calendar.YEAR) + "-0" + mth + "-0" + dy;
                        String query_day = "select order_ID from orders where order_create_at = '" + date_day + "';";
                        DB.callDataDay(query_day, jTable7, productValue, moneyValue, profitValue);
                    } else if (mth < 10) {
                        date_day = day.get(Calendar.YEAR) + "-0" + mth + "-" + dy;
                        String query_day = "select order_ID from orders where order_create_at = '" + date_day + "';";
                        DB.callDataDay(query_day, jTable7, productValue, moneyValue, profitValue);
                    } else if (dy < 10) {
                        date_day = day.get(Calendar.YEAR) + "-" + mth + "-0" + dy;
                        String query_day = "select order_ID from orders where order_create_at = '" + date_day + "';";
                        DB.callDataDay(query_day, jTable7, productValue, moneyValue, profitValue);
                    } else {
                        date_day = day.get(Calendar.YEAR) + "-" + mth + "-" + dy;
                        String query_day = "select order_ID from orders where order_create_at = '" + date_day + "';";
                        DB.callDataDay(query_day, jTable7, productValue, moneyValue, profitValue);
                    }
                } else if (day_tf.getText().equals("") && month_tf.getText().equals("")) {
                    int yr = Integer.parseInt(year_tf.getText());
                    date_year = yr + "%";
                    String query_year = "select order_ID from orders where order_create_at like '" + date_year + "';";
                    DB.callDataDay(query_year, jTable7, productValue, moneyValue, profitValue);
                } else if (day_tf.getText().equals("")) {
                    int mth = Integer.parseInt(month_tf.getText());
                    int yr = Integer.parseInt(year_tf.getText());
                    if (mth < 10) {
                        date_month = day.get(Calendar.YEAR) + "-0" + mth + "%";
                        String query_month = "select order_ID from orders where order_create_at like '" + date_month + "';";
                        DB.callDataDay(query_month, jTable7, productValue, moneyValue, profitValue);
                    } else {
                        date_month = day.get(Calendar.YEAR) + "-" + mth + "%";
                        String query_month = "select order_ID from orders where order_create_at like '" + date_month + "';";
                        DB.callDataDay(query_month, jTable7, productValue, moneyValue, profitValue);
                    }
                } else {
                    int dy = Integer.parseInt(day_tf.getText());
                    int mth = Integer.parseInt(month_tf.getText());
                    int yr = Integer.parseInt(year_tf.getText());
                    if (mth < 10 && dy < 10) {
                        date_day = yr + "-0" + mth + "-0" + dy;
                        String query_day = "select order_ID from orders where order_create_at = '" + date_day + "';";
                        DB.callDataDay(query_day, jTable7, productValue, moneyValue, profitValue);
                    } else if (m < 10) {
                        date_day = yr + "-0" + mth + "-" + dy;
                        String query_day = "select order_ID from orders where order_create_at = '" + date_day + "';";
                        DB.callDataDay(query_day, jTable7, productValue, moneyValue, profitValue);
                    } else if (d < 10) {
                        date_day = yr + "-" + mth + "-0" + dy;
                        String query_day = "select order_ID from orders where order_create_at = '" + date_day + "';";
                        DB.callDataDay(query_day, jTable7, productValue, moneyValue, profitValue);
                    } else {
                        date_day = yr + "-" + mth + "-" + dy;
                        String query_day = "select order_ID from orders where order_create_at = '" + date_day + "';";
                        DB.callDataDay(query_day, jTable7, productValue, moneyValue, profitValue);
                    }
                }
            }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void day_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_day_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_day_tfActionPerformed

    private void year_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_year_tfActionPerformed

    private void month_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_month_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_month_tfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> choseBox;
    private javax.swing.JTextField day_tf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTable jTable7;
    private javax.swing.JLabel moneyValue;
    private javax.swing.JTextField month_tf;
    private javax.swing.JLabel product;
    private javax.swing.JLabel productValue;
    private javax.swing.JLabel profitValue;
    private javax.swing.JScrollPane table;
    private javax.swing.JLabel title;
    private javax.swing.JLabel totalMoney;
    private javax.swing.JLabel totalProfit;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField year_tf;
    // End of variables declaration//GEN-END:variables
}
