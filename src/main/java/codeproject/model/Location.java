package codeproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    @Column(name = "address")
    private String address;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "location_id")
//    @JsonManagedReference
//    private Set<Host> hosts;

//    public Location(String address, String district, String city) {
//        this.address = address;
//        this.district = district;
//        this.city = city;
//    }

//    public Long getLocationId() {
//        return locationId;
//    }
//
//    public void setLocationId(Long locationId) {
//        this.locationId = locationId;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getDistrict() {
//        return district;
//    }
//
//    public void setDistrict(String district) {
//        this.district = district;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public Set<Host> getHosts() {
//        return hosts;
//    }
//
//    public void setHosts(Set<Host> hosts) {
//        this.hosts = hosts;
//    }
}
