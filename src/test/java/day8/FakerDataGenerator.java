package day8;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDataGenerator {

    @Test
    void testGeneratorDummyData() {
        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        String username = faker.name().username();
        String password = faker.internet().password();
        String phoneNumber = faker.phoneNumber().cellPhone();
        String email = faker.internet().emailAddress();

        String creditCardExpiry = faker.business().creditCardExpiry();

        // Go to below URL for detail information about faker
        // https://github.com/DiUS/java-faker
    }
}
