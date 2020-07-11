package view.hoaDon;

import base.BaseApp;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.Customer;
import model.Employee;
import model.Order;
import model.OrderProduct;
import model.Product;
import java.awt.Font;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controller.HoaDonController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HoaDon extends javax.swing.JPanel {

    private Order od;
    private HoaDonController hoaDonController;
    private ArrayList<OrderProduct> order_product_list;
    private Customer ctm;
    private Employee epl;
    private ArrayList<Product> product_list;
    private String[] product_show;
    private float total_price;
    private float VAT;
    private int STT;
    private int choose_row;

    public HoaDon() {
        od = new Order();
        STT = 0;
        total_price = 0;
        order_product_list = new ArrayList<OrderProduct>();
        product_list = new ArrayList<Product>();
        hoaDonController = new HoaDonController();
        initComponents();
        setThongTinChung();
        set_date();

        set_order_ID();
    }

    public void setThongTinChung() {

        Employee employee = new Employee();

        String queryOrder = "SELECT MAX(order_ID) FROM orders";
        String queryUserID = "SELECT user_ID from user WHERE user_name = '" + BaseApp.userName + "'";
        String queryEmployee = "SELECT employee_name, employee_ID FROM employee WHERE user_ID = ";
        // lay ngay thang
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String dateString = formatter.format(date);
        // lay ma hoa don
//        String maHoaDon = hoaDonController.fetchData(queryOrder);
//        Integer maHoaDonMoi = Integer.parseInt(maHoaDon) + 1;
        // lay ten nhan vien
        int userId = Integer.parseInt(hoaDonController.fetchData(queryUserID));
        queryEmployee += userId;
        employee = hoaDonController.fetchDataEmployee(queryEmployee);
//        maHoaDon_TextField.setText(maHoaDonMoi.toString());
//        ngayXuat_TextField.setText(dateString);
        tenNhanVien_TextField.setText(employee.getName());
        maNhanVien_TextField.setText(employee.getId() + "");

    }

    private void set_date() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String formattedDateTime = currentDateTime.format(formatter);
        ngayXuat_TextField.setText(formattedDateTime);
    }

    private void set_order_ID() {
        od.setOrder_ID((hoaDonController.get_last_order_ID() + 1));
        maHoaDon_TextField.setText(Integer.toString(od.getOrder_ID()));
    }

    private void re_cal_VAT_price() {
        total_price = 0;
        for (int i = 0; i < order_JTable.getRowCount(); i++) {
            total_price += Float.parseFloat(order_JTable.getValueAt(i, 5).toString());
        }
        VAT = total_price / 10;
        total_price += VAT;
        VAT_TextField.setText(Float.toString(VAT));
        tongTien_TextField.setText(Float.toString(total_price));
        maSanPham_TextField.setText("");
        soLuong_TextField.setText("");
    }

    private void print_order() throws DocumentException {
        int confirm = JOptionPane.showConfirmDialog(this, "In hóa đơn?", "In hóa đơn", JOptionPane.OK_CANCEL_OPTION);
        if (confirm == 0) {
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            try {
                PdfWriter.getInstance(document, new FileOutputStream("D:\\test.pdf"));
                document.open();

                Paragraph congTy = new Paragraph("Cong ty TNHH TuVuTelecom");
                Paragraph diaChiCongTy = new Paragraph("So 1 Dai Co Viet, Hai Ba Trung, Ha Noi");
                Paragraph SDTCongTy = new Paragraph("0964.511.598");

                Paragraph tieuDe = new Paragraph("HOA DON BAN HANG", FontFactory.getFont(FontFactory.TIMES_ROMAN, 32, Font.BOLD, new CMYKColor(0, 255, 255, 17)));
                tieuDe.setAlignment(Element.ALIGN_CENTER);
                tieuDe.setSpacingAfter(15);

                Paragraph TT_hoaDon = new Paragraph("THONG TIN HOA DON", FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD, new CMYKColor(255, 0, 0, 17)));
                TT_hoaDon.setAlignment(Element.ALIGN_CENTER);
                TT_hoaDon.setSpacingBefore(15);

                Paragraph TT_khachHang = new Paragraph("THONG TIN KHACH HANG", FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD, new CMYKColor(255, 0, 0, 17)));
                TT_khachHang.setAlignment(Element.ALIGN_CENTER);
                TT_khachHang.setSpacingBefore(15);

                Paragraph chiTietHoaDon = new Paragraph("CHI TIET HOA DON", FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD, new CMYKColor(255, 0, 0, 17)));
                chiTietHoaDon.setAlignment(Element.ALIGN_CENTER);
                chiTietHoaDon.setSpacingBefore(15);

                Paragraph maHoaDon = new Paragraph("Ma hoa don: " + maHoaDon_TextField.getText());
                Paragraph ngayXuat = new Paragraph("Ngay mua: " + ngayXuat_TextField.getText());
                Paragraph nhanVien = new Paragraph("NV ban hang: " + tenNhanVien_TextField.getText());
                Paragraph tenKhachHang = new Paragraph("Khach hang: " + tenKhachHang_TextField.getText());
                Paragraph gioiTinh = new Paragraph("Gioi tinh: " + gioiTinh_TextField.getText());
                Paragraph soDienThoai = new Paragraph("SDT: " + soDienThoai_TextField.getText());
                Paragraph diaChi = new Paragraph("Dia chi: " + diaChi_TextField.getText());

                PdfPTable t = new PdfPTable(6);
                t.setSpacingAfter(10);
                t.setSpacingBefore(10);

                Phrase cot_1 = new Phrase("STT", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, new CMYKColor(255, 0, 0, 17)));
                Phrase cot_2 = new Phrase("Ten SP", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, new CMYKColor(255, 0, 0, 17)));
                Phrase cot_3 = new Phrase("Ma SP", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, new CMYKColor(255, 0, 0, 17)));
                Phrase cot_4 = new Phrase("So luong", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, new CMYKColor(255, 0, 0, 17)));
                Phrase cot_5 = new Phrase("Don gia", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, new CMYKColor(255, 0, 0, 17)));
                Phrase cot_6 = new Phrase("Thanh tien", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD, new CMYKColor(255, 0, 0, 17)));

                PdfPCell c_header[] = new PdfPCell[6];
                PdfPCell c_orders[][] = new PdfPCell[order_JTable.getRowCount()][order_JTable.getColumnCount()];

                c_header[0] = new PdfPCell(cot_1);
                t.addCell(c_header[0]);
                c_header[1] = new PdfPCell(cot_2);
                t.addCell(c_header[1]);
                c_header[2] = new PdfPCell(cot_3);
                t.addCell(c_header[2]);
                c_header[3] = new PdfPCell(cot_4);
                t.addCell(c_header[3]);
                c_header[4] = new PdfPCell(cot_5);
                t.addCell(c_header[4]);
                c_header[5] = new PdfPCell(cot_6);
                t.addCell(c_header[5]);

                for (int i = 0; i < order_JTable.getRowCount(); i++) {
                    for (int j = 0; j < order_JTable.getColumnCount(); j++) {
                        c_orders[i][j] = new PdfPCell(new Phrase((String) order_JTable.getValueAt(i, j)));
                        t.addCell(c_orders[i][j]);
                    }
                }

                Paragraph VAT_tongTien = new Paragraph("VAT: " + VAT_TextField.getText() + " (VND)       " + "Tong tien: " + tongTien_TextField.getText() + " (VND)");
                VAT_tongTien.setAlignment(Element.ALIGN_RIGHT);

                Paragraph tamBiet = new Paragraph("Xin cam on va hen gap lai quy khach vao mot ngay gan nhat !");
                tamBiet.setAlignment(Element.ALIGN_CENTER);
                tamBiet.setSpacingBefore(20);

                document.add(congTy);
                document.add(diaChiCongTy);
                document.add(SDTCongTy);
                document.add(tieuDe);
                document.add(TT_hoaDon);
                document.add(maHoaDon);
                document.add(ngayXuat);
                document.add(nhanVien);
                document.add(TT_khachHang);
                document.add(tenKhachHang);
                document.add(gioiTinh);
                document.add(soDienThoai);
                document.add(diaChi);
                document.add(chiTietHoaDon);
                document.add(t);
                document.add(VAT_tongTien);
                document.add(tamBiet);
                document.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        maNhanVien_TextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        gioiTinh_TextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        soDienThoai_TextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tenKhachHang_TextField = new javax.swing.JTextField();
        diaChi_TextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        hoaDonMoi_TextField = new javax.swing.JButton();
        themSanPham_Button = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        maHoaDon_TextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        inHoaDon_TextField = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tongTien_TextField = new javax.swing.JTextField();
        luuHoaDon_TextField = new javax.swing.JButton();
        xoaSanPham_Button = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ngayXuat_TextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tenNhanVien_TextField = new javax.swing.JTextField();
        soLuong_TextField = new javax.swing.JTextField();
        maSanPham_TextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        order_JTable = new javax.swing.JTable();
        VAT_TextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1113, 600));

        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Mã nhân viên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Thông tin sản phẩm");

        maNhanVien_TextField.setBackground(new java.awt.Color(240, 240, 240));
        maNhanVien_TextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        jLabel14.setText("Tổng tiền (VNĐ)");

        gioiTinh_TextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Tên nhân viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Thông tin chung");

        soDienThoai_TextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setBackground(new java.awt.Color(0, 0, 204));
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Mã hóa đơn");

        tenKhachHang_TextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tenKhachHang_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenKhachHang_TextFieldActionPerformed(evt);
            }
        });

        diaChi_TextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("Mã sản phẩm");

        hoaDonMoi_TextField.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        hoaDonMoi_TextField.setText("Hóa đơn mới");
        hoaDonMoi_TextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hoaDonMoi_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoaDonMoi_TextFieldActionPerformed(evt);
            }
        });

        themSanPham_Button.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        themSanPham_Button.setText("Thêm sản phẩm");
        themSanPham_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        themSanPham_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themSanPham_ButtonActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Số điện thoại");

        maHoaDon_TextField.setBackground(new java.awt.Color(240, 240, 240));
        maHoaDon_TextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        maHoaDon_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maHoaDon_TextFieldActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Tên khách hàng");
        jLabel8.setToolTipText("");

        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setText("Địa chỉ");

        inHoaDon_TextField.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        inHoaDon_TextField.setText("In hóa đơn");
        inHoaDon_TextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inHoaDon_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inHoaDon_TextFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NHẬP HÓA ĐƠN");

        luuHoaDon_TextField.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        luuHoaDon_TextField.setText("Lưu hóa đơn");
        luuHoaDon_TextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        luuHoaDon_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luuHoaDon_TextFieldActionPerformed(evt);
            }
        });

        xoaSanPham_Button.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        xoaSanPham_Button.setText("Xóa sản phẩm");
        xoaSanPham_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        xoaSanPham_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaSanPham_ButtonActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Ngày xuất");

        ngayXuat_TextField.setBackground(new java.awt.Color(240, 240, 240));
        ngayXuat_TextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("Thuế VAT (VNĐ)");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("Thông tin khách hàng");

        jLabel13.setForeground(new java.awt.Color(0, 0, 204));
        jLabel13.setText("Số lượng");

        tenNhanVien_TextField.setBackground(new java.awt.Color(240, 240, 240));
        tenNhanVien_TextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tenNhanVien_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenNhanVien_TextFieldActionPerformed(evt);
            }
        });

        soLuong_TextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        soLuong_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soLuong_TextFieldActionPerformed(evt);
            }
        });

        maSanPham_TextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        maSanPham_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maSanPham_TextFieldActionPerformed(evt);
            }
        });

        order_JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sản phẩm", "Mã sản phẩm", "Số lượng", "Đơn giá (VNĐ)", "Thành tiền (VNĐ)"
            }
        ));
        order_JTable.setAlignmentX(1.0F);
        order_JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                order_JTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                order_JTableMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(order_JTable);

        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("Giới tính");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VAT_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tongTien_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(hoaDonMoi_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(luuHoaDon_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(inHoaDon_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maSanPham_TextField)
                    .addComponent(soLuong_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(123, 123, 123)
                .addComponent(themSanPham_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(xoaSanPham_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(5, 5, 5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(maHoaDon_TextField)
                            .addComponent(tenNhanVien_TextField)
                            .addComponent(maNhanVien_TextField)
                            .addComponent(ngayXuat_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(267, 267, 267))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tenKhachHang_TextField)
                            .addComponent(soDienThoai_TextField)
                            .addComponent(gioiTinh_TextField)
                            .addComponent(diaChi_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(maHoaDon_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(ngayXuat_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tenNhanVien_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(maNhanVien_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenKhachHang_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(soDienThoai_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(gioiTinh_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(diaChi_TextField)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 58, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(maSanPham_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(themSanPham_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(xoaSanPham_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(soLuong_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tongTien_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(VAT_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(luuHoaDon_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hoaDonMoi_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inHoaDon_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tenKhachHang_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenKhachHang_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenKhachHang_TextFieldActionPerformed

    private void hoaDonMoi_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoaDonMoi_TextFieldActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Thông tin về hóa đơn trước sẽ bị mất hoàn toàn.\nBạn có chắc chắn?", "Tạo hóa đơn mới", JOptionPane.OK_CANCEL_OPTION);
        if (confirm == 0) {
            DefaultTableModel model = (DefaultTableModel) order_JTable.getModel();
            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            od.setOrder_ID(hoaDonController.get_last_order_ID() + 1);
            maHoaDon_TextField.setText(Integer.toString(od.getOrder_ID()));
            order_product_list.clear();
            product_list.clear();
            STT = 0;
            total_price = 0;
            VAT = 0;
            tenKhachHang_TextField.setText("");
            soDienThoai_TextField.setText("");
            gioiTinh_TextField.setText("");
            diaChi_TextField.setText("");
            maSanPham_TextField.setText("");
            soLuong_TextField.setText("");
            VAT_TextField.setText("");
            tongTien_TextField.setText("");
        }
    }//GEN-LAST:event_hoaDonMoi_TextFieldActionPerformed

    private void themSanPham_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themSanPham_ButtonActionPerformed
        // TODO add your handling code here:
        if (maSanPham_TextField.getText().isEmpty() || soLuong_TextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã sản phẩm hoặc số lượng");
        } else {
            int product_ID = Integer.parseInt(maSanPham_TextField.getText());
            int product_qty = Integer.parseInt(soLuong_TextField.getText());
            product_show = new String[6];
            Product pd = new Product(hoaDonController.get_product_name(product_ID), hoaDonController.get_product_retail_price(product_ID));
            product_list.add(pd);
            OrderProduct od_p = new OrderProduct(od.getOrder_ID(), product_ID, product_qty);
            order_product_list.add(od_p);
            STT += 1;
            product_show[0] = Integer.toString(STT);
            product_show[1] = pd.getName();
            product_show[2] = Integer.toString(product_ID);
            product_show[3] = Integer.toString(product_qty);
            product_show[4] = Float.toString(pd.getRetail_price());
            product_show[5] = Float.toString(product_qty * pd.getRetail_price());
            DefaultTableModel model = (DefaultTableModel) order_JTable.getModel();
            model.addRow(product_show);
            re_cal_VAT_price();
        }
    }//GEN-LAST:event_themSanPham_ButtonActionPerformed

    private void maHoaDon_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maHoaDon_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maHoaDon_TextFieldActionPerformed

    private void inHoaDon_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inHoaDon_TextFieldActionPerformed
        try {
            // TODO add your handling code here:
            print_order();
        } catch (DocumentException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_inHoaDon_TextFieldActionPerformed

    private void luuHoaDon_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luuHoaDon_TextFieldActionPerformed
        // TODO add your handling code here:
        od.setOrder_ID(Integer.parseInt(maHoaDon_TextField.getText()));
        od.setCustomer_phone_number(soDienThoai_TextField.getText());
        od.setEmployee_ID(Integer.parseInt(maNhanVien_TextField.getText()));
        int confirm = JOptionPane.showConfirmDialog(this, "Hóa đơn được lưu sẽ không thể chỉnh sửa\n Lưu hóa đơn?", "Lưu hóa đơn", JOptionPane.OK_CANCEL_OPTION);
        if (confirm == 0) {
            hoaDonController.store_order(od.getOrder_ID(), od.getCustomer_phone_number(), od.getEmployee_ID(), product_list, order_product_list);
        }
    }//GEN-LAST:event_luuHoaDon_TextFieldActionPerformed

    private void xoaSanPham_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaSanPham_ButtonActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Thông tin về sản phẩm này sẽ bị mất.\nBạn có chắc chắn?", "Xóa sản phẩm khỏi hóa đơn", JOptionPane.OK_CANCEL_OPTION);
        if (confirm == 0) {
            DefaultTableModel model = (DefaultTableModel) order_JTable.getModel();
            for (int i = choose_row + 1; i < STT; i++) {
                model.setValueAt(i, i, 0);
            }
            STT -= 1;
            model.removeRow(choose_row);
            product_list.remove(choose_row);
            order_product_list.remove(choose_row);
            re_cal_VAT_price();
        }
    }//GEN-LAST:event_xoaSanPham_ButtonActionPerformed

    private void tenNhanVien_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenNhanVien_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenNhanVien_TextFieldActionPerformed

    private void soLuong_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soLuong_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soLuong_TextFieldActionPerformed

    private void maSanPham_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maSanPham_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maSanPham_TextFieldActionPerformed

    private void order_JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_order_JTableMouseClicked
        // TODO add your handling code here:
        Point p = evt.getPoint();
        choose_row = order_JTable.rowAtPoint(p);
    }//GEN-LAST:event_order_JTableMouseClicked

    private void order_JTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_order_JTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_order_JTableMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField VAT_TextField;
    private javax.swing.JTextField diaChi_TextField;
    private javax.swing.JTextField gioiTinh_TextField;
    private javax.swing.JButton hoaDonMoi_TextField;
    private javax.swing.JButton inHoaDon_TextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton luuHoaDon_TextField;
    public javax.swing.JTextField maHoaDon_TextField;
    public javax.swing.JTextField maNhanVien_TextField;
    private javax.swing.JTextField maSanPham_TextField;
    public javax.swing.JTextField ngayXuat_TextField;
    private javax.swing.JTable order_JTable;
    private javax.swing.JTextField soDienThoai_TextField;
    private javax.swing.JTextField soLuong_TextField;
    private javax.swing.JTextField tenKhachHang_TextField;
    public javax.swing.JTextField tenNhanVien_TextField;
    private javax.swing.JButton themSanPham_Button;
    private javax.swing.JTextField tongTien_TextField;
    private javax.swing.JButton xoaSanPham_Button;
    // End of variables declaration//GEN-END:variables
}
