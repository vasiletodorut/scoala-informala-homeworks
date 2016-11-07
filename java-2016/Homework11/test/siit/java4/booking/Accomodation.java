package test.siit.java4.booking;

public class Accomodation {

	int id;
	String type;
	String bed_type;
	int max_guests;
	String description;

	public Accomodation(int id, String type, String bed_type, int max_guests, String description) {
		this.id = id;
		this.type = type;
		this.bed_type = bed_type;
		this.max_guests = max_guests;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Accomodation [id=" + id + ", type=" + type + ", bed_type=" + bed_type + ", max_guests=" + max_guests
				+ ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bed_type == null) ? 0 : bed_type.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + max_guests;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Accomodation other = (Accomodation) obj;
		if (bed_type == null) {
			if (other.bed_type != null)
				return false;
		} else if (!bed_type.equals(other.bed_type))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (max_guests != other.max_guests)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
