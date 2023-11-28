package ba.edu.iub.newsletterscf.functions;

import ba.edu.iub.newsletterscf.model.Subscriber;
import ba.edu.iub.newsletterscf.service.SubscriberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
public class Subscribers {
    private static final Logger LOG = LoggerFactory.getLogger(Subscriber.class);
    private final SubscriberService subscriberService;

    public Subscribers(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    // Get list of subscribers through Supplier -> read more
    @Bean
    public Supplier<List<Subscriber>> findAll() {
        LOG.info("Subscriber.findAll");
        return () -> subscriberService.findAll();
    }

    // It consumes the string and creating the subscriber
    @Bean
    public Consumer<String> create() {
        LOG.info("Subscriber.create");
        return (email) -> subscriberService.create(email);
    }
}
