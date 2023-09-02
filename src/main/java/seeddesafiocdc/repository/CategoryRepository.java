package seeddesafiocdc.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import seeddesafiocdc.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Optional<Category> findByName(String name);
}
