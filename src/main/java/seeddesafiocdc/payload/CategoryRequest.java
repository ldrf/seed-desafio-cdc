package seeddesafiocdc.payload;

import java.util.Objects;

import jakarta.validation.constraints.NotEmpty;
import seeddesafiocdc.model.Category;

public class CategoryRequest {

	@NotEmpty(message = "The category is obligatory.")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CategoryRequest [name=").append(name).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		CategoryRequest other = (CategoryRequest) obj;
		return Objects.equals(name, other.name);
	}

	public Category toModel() {
		Category category = new Category(getName());
		return category;

	}

}
