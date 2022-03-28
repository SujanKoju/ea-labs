package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kojusujan1111@gmail.com 28/03/22
 */
@Configuration
public class AppConfig {
    @Bean
    public ICustomerService customerService() {
        return new CustomerService(getCustomerDao(), getEmailService());
    }

    @Bean
    public ICustomerDAO getCustomerDao() {
        return new CustomerDAO(getLogger());
    }

    @Bean
    public IEmailSender getEmailService() {
        return new EmailSender(getLogger());
    }

    @Bean
    public ILogger getLogger() {
        return new Logger();
    }
}
