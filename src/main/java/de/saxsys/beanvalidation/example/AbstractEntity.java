package de.saxsys.beanvalidation.example;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {

	@Id
	private final String id;

	public AbstractEntity() {
		id = java.util.UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	@Override
	public final boolean equals(final Object o) {
		if (getId() == null) {
			return false;
		}

		if (o == null) {
			return false;
		}

		if (o == this) {
			return true;
		}

		if (!(o instanceof AbstractEntity)) {
			return false;
		}

		final AbstractEntity other = (AbstractEntity) o;

		if (!getId().equals(other.getId())) {
			return false;
		}

		return true;
	}


	@Override
	public final int hashCode() {
		if (getId() == null) {
			return 0;
		} else {
			return getId().hashCode();
		}
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[id=" + id + "]";
	}
}
