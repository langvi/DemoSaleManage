package controller;

import base.BaseApp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginController {

    String queryUserName = "SELECT user_name FROM user";
    String queryPassword = "SELECT user_password FROM user";
    String queryPermission = "SELECT * FROM user";

    // Kiểm tra tính hợp lệ của thông tin đăng nhập
    public int CheckValidate(String txtUserName, String txtPassword) {
        if (isCheck(queryUserName, txtUserName, "user_name")
                && isCheck(queryPassword, txtPassword, "user_password")) {
            if (checkPermission(queryPermission, txtUserName)) {
                return 1; // admin
            } else {
                return 2; // user
            }
        }
        return 0;// failure

    }
    // Lưu mật khẩu của người dùng

    public void savePassword(String path, String userName, String user_password) {
        File file = new File(path);
        String[] data = {
            userName,
            user_password
        };
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

            for (String item : data) {
                outputStreamWriter.write(item);
                outputStreamWriter.write("\n");
            }
            outputStreamWriter.flush();
            outputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Lấy thông tin tài khoản và mật khẩu
    public void readUser(String path, JTextField txtUserName, JPasswordField txtPassword) {
        File file = new File(path);
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = "";
            String[] user = new String[2];
            int count = 0;
            while ((line = reader.readLine()) != null) {
                user[count] = line;
                count++;
            }
            inputStream.close();
            txtUserName.setText(user[0]);
            txtPassword.setText(user[1]);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isCheck(String query, String checkString, String columnName) {
        try {
            Statement stm = BaseApp.connectDB().createStatement();
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                if (result.getString(columnName).equals(checkString)) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Kiểm tra quyền của tài khoản đăng nhập
    public boolean checkPermission(String query, String userName) {
        String permissionString = "admin";
        try {
            Statement stm = BaseApp.connectDB().createStatement();
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                if (result.getString("user_name").equals(userName)) {
                    if (result.getString("user_permission").equals(permissionString)) {
                        return true;
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int getUserID(String userName) {
        String query = "SELECT user_ID FROM user WHERE user_name = '" + userName + "'";
        int id = 0;
        Statement stm;
        try {
            stm = BaseApp.connectDB().createStatement();
            ResultSet result = stm.executeQuery(query);
            result.first();
            id = result.getInt("user_ID");
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}
