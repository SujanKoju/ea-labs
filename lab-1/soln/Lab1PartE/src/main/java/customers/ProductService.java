package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kojusujan1111@gmail.com 28/03/22
 */
@Service
public class ProductService implements IProductService {
    private final IProductDao productDao;
    private final IEmailSender emailService;

    @Autowired
    public ProductService(IProductDao productDao, IEmailSender emailService) {
        this.productDao = productDao;
        this.emailService = emailService;
    }

    public void addProduct(String name, String description, double price) {
        Product product = new Product(name, description, price);
        productDao.save(product);
        emailService.sendEmail("kojusujan1111@gmail.com", name + " added success ");
    }
}
