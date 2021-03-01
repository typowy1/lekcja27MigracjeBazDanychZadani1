package pl.javastart.migracje;


import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Profile("dev")// to się dzieje tylko na profilu dev
@Component
public class TestDataProvider {

    private UserRepository userRepository;

    public TestDataProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventListener(ApplicationStartedEvent.class) //zaraz po starcie aplikacji zostaną dodane do niej dane testowe i ap zacznie działać
    public void addTestData() {

        User user = new User();
        user.setName("Dominika");
        user.setSurname("Babacka");
        user.setBirthday(LocalDate.now().withDayOfMonth(2)); //z dniem miesiąca drugim

        userRepository.save(user);

    }
}
