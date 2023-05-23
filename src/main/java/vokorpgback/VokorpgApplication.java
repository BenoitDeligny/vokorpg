package vokorpgback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class VokorpgApplication {

	public static void main(String[] args) {
//		SpringApplication.run(VokorpgApplication.class, args);
		Random random = new Random(123);
		System.out.println(random.nextInt(10));
		System.out.println(random.nextInt(10));
		System.out.println(random.nextInt(10));
	}

}
