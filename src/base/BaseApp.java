package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseApp {

    public static int permission;
    public static final String path = "src/infor.txt";
    public static String userName = "";

    public static final Connection connectDB() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/sales_database?autoReconnect=true&useSSL=false",
                    "root", "");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(BaseApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static final String formatMoney(float value) {
        return String.format("%,.0f", value);
    }
    public static final boolean isValidDate(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
    public static final boolean isNumber(String number) {

        Pattern pattern = Pattern.compile("\\d*");
        Matcher matcherNumber = pattern.matcher(number);
        if (matcherNumber.matches()) {
            float value = Float.parseFloat(number);
            if (value >= 0) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
}
