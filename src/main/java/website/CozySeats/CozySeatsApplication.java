package website.CozySeats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CozySeatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CozySeatsApplication.class, args);
	}

}
