package andrius.apringframework.netfilxexample.bootstrap;

import andrius.apringframework.netfilxexample.domain.Movie;
import andrius.apringframework.netfilxexample.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class BootstrapCLR implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public BootstrapCLR(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // clear all data
        movieRepository.deleteAll();

        Flux.just("Silence of the Lambs", "Red Dragon", "Hannibal", "Back to the Future", "Harry Potter", "Accountant")
                .map(title -> new Movie(title, UUID.randomUUID().toString()))
                .flatMap(movieRepository::save)
                .subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(System.out::println);
                });
    }
}
