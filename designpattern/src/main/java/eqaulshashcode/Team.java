package eqaulshashcode;

public class Team {

    String city;
    String department;

    public Team(String city, String department) {
        this.city = city;
        this.department = department;
    }

    @Override
    public final boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Team)) return false;
        Team other = (Team) o;
        boolean cityEquals = (this.city == null && other.city == null) || (this.city != null && this.city.equals(other.city));
        return this.department == other.department && cityEquals;
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if (city != null) {
            result = 31 * result + city.hashCode();
        }
        if (department != null) {
            result = 31 * result + department.hashCode();
        }
        return result;
    }
}