package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kojusujan1111@gmail.com 28/03/22
 */
@Service
public class ProductDao implements IProductDao{
    private final ILogger logger;

    @Autowired
    public ProductDao(ILogger logger) {
        this.logger = logger;
    }

    public void save(Product product) {
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ProductDao: saving product " + product.getName());
        logger.log("Product is saved in the DB: " + product.getName());
    }
}
