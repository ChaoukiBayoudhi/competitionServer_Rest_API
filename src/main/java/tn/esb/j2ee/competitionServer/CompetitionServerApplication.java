package tn.esb.j2ee.competitionServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompetitionServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompetitionServerApplication.class, args);
	}



//	@Bean
//	ApplicationRunner showAllPlayer(playerRepository plRepos)
//	{
//		return args -> {
//			System.out.println("List of Players :");
//			plRepos.findAll().forEach(System.out::println);
//		};
//	}
}