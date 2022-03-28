package customers;

public class CustomerService implements ICustomerService {
	private  ICustomerDAO customerDAO;
	private  IEmailSender emailService;

	public void setCustomerDAO(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public void setEmailService(IEmailSender emailService) {
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
