package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Adi on 28.04.2015.
 */
@Table(name = "locations")
public class Location {

    @Id(name = "location_id")
    private int id;

    @Column(name = "streetAddress")
    private String streetAddress;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "stateProvince")
    private String stateProvince;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getStateProvince() {

        return stateProvince;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getCity() {

        return city;
    }

    public void setPostalCode(String postalCode) {

        this.postalCode = postalCode;
    }

    public String getPostalCode() {

        return postalCode;
    }

    public void setStreetAddress(String streetAddress) {

        this.streetAddress = streetAddress;
    }

    public String getStreetAddress() {

        return streetAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != location.id) return false;
        if (streetAddress != null ? !streetAddress.equals(location.streetAddress) : location.streetAddress != null)
            return false;
        if (postalCode != null ? !postalCode.equals(location.postalCode) : location.postalCode != null) return false;
        if (city != null ? !city.equals(location.city) : location.city != null) return false;
        return !(stateProvince != null ? !stateProvince.equals(location.stateProvince) : location.stateProvince != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (stateProvince != null ? stateProvince.hashCode() : 0);
        return result;
    }
}
