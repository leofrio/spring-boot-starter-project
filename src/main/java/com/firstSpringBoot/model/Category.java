package com.firstSpringBoot.model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity(name = "categories")
public class Category {
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Getter @Setter
	private String title;
	@Getter @Setter
	private String message;
	@Getter @Setter
	private LocalDateTime creationDate = LocalDateTime.now();
	@Getter @Setter
	@Enumerated(EnumType.STRING)
	private Status status = Status.NOT_ANSWERED;
	@Getter @Setter
	@ManyToOne
	private User user;
	@Getter @Setter
	@ManyToOne
	private Course course;
	@Getter @Setter
	@OneToMany(mappedBy = "category")
	private List<Reply> replies = new ArrayList<>();


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
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
