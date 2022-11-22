package com.firstSpringBoot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity(name = "replies")
public class Reply {
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Getter @Setter
	private String message;
	@Getter @Setter
	@ManyToOne
	private Category category;
	@Getter @Setter
	private LocalDateTime creationDate = LocalDateTime.now();
	@Getter @Setter
	@ManyToOne
	private User user;
	@Getter @Setter
	private Boolean solution = false;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reply other = (Reply) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
