package base;

import java.util.Comparator;
import model.Product;

public class PriceCompare implements Comparator<Product> {

    private boolean isReverse;

    public PriceCompare(boolean reverse) {
        this.isReverse = reverse;
    }

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getRetail_price() == o2.getRetail_price()) {
            return 0;
        } else if (o1.getRetail_price() > o2.getRetail_price()) {
            if (isReverse) {
                return -1;

            } else {
                return 1;
            }
        } else {
            if (isReverse) {
                return 1;

            } else {
                return -1;
            }

        }
    }

}
