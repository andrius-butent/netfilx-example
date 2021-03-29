package andrius.apringframework.netfilxexample.services;

import andrius.apringframework.netfilxexample.domain.Movie;
import andrius.apringframework.netfilxexample.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    Flux<MovieEvent> events(String movieId);

    Mono<Movie> getMovieById(String id);

    Flux<Movie> getAllMovies();
}