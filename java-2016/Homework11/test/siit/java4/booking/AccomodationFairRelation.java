package test.siit.java4.booking;

public class AccomodationFairRelation {

	int id;
	int id_accomodation;
	int id_room_fair;

	public AccomodationFairRelation(int id, int id_accomodation, int id_room_fair) {
		this.id = id;
		this.id_accomodation = id_accomodation;
		this.id_room_fair = id_room_fair;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + id_accomodation;
		result = prime * result + id_room_fair;
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
		AccomodationFairRelation other = (AccomodationFairRelation) obj;
		if (id != other.id)
			return false;
		if (id_accomodation != other.id_accomodation)
			return false;
		if (id_room_fair != other.id_room_fair)
			return false;
		return true;
	}
}
