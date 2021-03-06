package andrius.apringframework.netfilxexample.repositories;

import andrius.apringframework.netfilxexample.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
