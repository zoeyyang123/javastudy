package insurance.ic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by admin on 2017/11/18.
 */
@SpringBootApplication
@EnableCaching
public class InsuranceCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceCommunityApplication.class, args);
    }
}
