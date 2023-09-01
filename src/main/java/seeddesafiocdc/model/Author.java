package seeddesafiocdc.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	private String name;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Size(max = 400)
	private String description;
	private LocalDateTime instance;

	@Deprecated
	public Author() {

	}

	public Author(final String name, final String email, final String description) {
		this.name = name;
		this.email = email;
		this.description = description;
		instance = LocalDateTime.now();
	}

	public Author(final long id, final String name, final String email, final String description,
			final LocalDateTime instance) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.description = description;
		this.instance = instance;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public LocalDateTime getInstance() {
		return instance;
	}

	public void setInstance(final LocalDateTime instance) {
		this.instance = instance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Author [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", description=");
		builder.append(description);
		builder.append(", instance=");
		builder.append(instance);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		Author other = (Author) obj;
		return Objects.equals(email, other.email) && (id == other.id);
	}

}
