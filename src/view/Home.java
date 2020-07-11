package view;

import base.BaseApp;
import javax.swing.JOptionPane;
import view.hoaDon.HoaDon;
import view.khachHang.KhachHang;
import view.hangHoa.HangHoa;
import view.NhanVien.Manager;
import view.NhanVien.NhanVien;
import view.thongKe.ThongKe;

public class Home extends javax.swing.JFrame {
    
    HangHoa khoHang;
    KhachHang khachHang;
//    NhanVien nhanVien;
//    Schedule schedule;
    NhanVien newEmployee;
    Manager newManager;
    HoaDon hoaDon;
//    ThongKe thongKe;
    ThongKe newThongKe;
    
    public Home() {
        super.setTitle("QUẢN LÍ BÁN HÀNG");
        initComponents();
        khoHang = new HangHoa();
        khachHang = new KhachHang();
        newEmployee = new NhanVien();
        newManager = new Manager();
//        nhanVien = new NhanVien();
//        schedule = new Schedule();

        hoaDon = new HoaDon();
//        thongKe = new ThongKe();
        newThongKe = new ThongKe();
        TabbedPaneHome.addTab("Kho hàng", khoHang);
        TabbedPaneHome.addTab("Khách hàng", khachHang);
        if (BaseApp.permission == 1) {
            TabbedPaneHome.addTab("Nhân viên", newManager);
        } else {
            TabbedPaneHome.addTab("Nhân viên", newEmployee);
            
        }
        TabbedPaneHome.addTab("Hóa đơn", hoaDon);
        TabbedPaneHome.addTab("Thống kê", newThongKe);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHome = new javax.swing.JPanel();
        TabbedPaneHome = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1310, 800));

        PanelHome.setPreferredSize(new java.awt.Dimension(1000, 800));
        PanelHome.setLayout(new java.awt.BorderLayout());

        TabbedPaneHome.setToolTipText("");
        PanelHome.add(TabbedPaneHome, java.awt.BorderLayout.CENTER);

        btnLogOut.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogOut.setText("ĐĂNG XUẤT");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLogOut))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnLogOut)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        PanelHome.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelHome, javax.swing.GroupLayout.DEFAULT_SIZE, 1310, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelHome, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed

        int value = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không", "Đăng xuất", JOptionPane.OK_CANCEL_OPTION);
        if (value == 0) {
            dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btnLogOutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelHome;
    private javax.swing.JTabbedPane TabbedPaneHome;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
