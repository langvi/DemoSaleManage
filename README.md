# Manage_Sales
Thay đường dẫn database trong class BaseApp, thuộc package base hàm connectDB()
 conn = DriverManager.getConnection("jdbc:mysql://localhost/sales_database?autoReconnect=true&useSSL=false",
"root", "");

Thay đường dẫn in hóa đơn 
trong class HoaDon, thuộc package view.hoaDon, hàm print_order()

PdfWriter.getInstance(document, new FileOutputStream("D:\\test.pdf"));

Thêm thư viện itextpdf-5.5.4, mysql-connector-java và j-calendar

import file sales_database.sql vào database