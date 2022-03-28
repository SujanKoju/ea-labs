package customers;

public class CustomerService implements ICustomerService {
    private final ICustomerDAO customerDAO;
    private final IEmailSender emailService;

    public CustomerService(ICustomerDAO customerDAO, IEmailSender emailService) {
        this.customerDAO = customerDAO;
        this.emailService = emailService;
    }

    public void addCustomer(String name, String email, String street, String city, String zip) {
        Customer customer = new Customer(name, email);
        Address address = new Address(street, city, zip);
        customer.setAddress(address);
        customerDAO.save(customer);
        emailService.sendEmail(email, "Welcome " + name + " as a new customer");
    }
}
