
package base;

import java.util.Comparator;
import model.Product;

public class NameCompare implements Comparator<Product>{

    @Override
    public int compare(Product producOne, Product producTwo) {
        return producOne.getName().compareTo(producTwo.getName());
    }
    
}
