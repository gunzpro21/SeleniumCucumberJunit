package models;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DegreeGrid {
	String degreeName;
	String university;
	String universityCountry;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DegreeGrid other = (DegreeGrid) obj;
		return Objects.equals(degreeName, other.degreeName) && Objects.equals(university, other.university)
				&& Objects.equals(universityCountry, other.universityCountry);
	}
	
}
