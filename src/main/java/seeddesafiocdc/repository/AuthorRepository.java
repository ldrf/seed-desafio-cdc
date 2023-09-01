package seeddesafiocdc.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import seeddesafiocdc.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

	// Seguindo a conveção da JPA do Spring. (FINDBY + Atributo da classe)
	Optional<Author> findByEmail(String email);

}
