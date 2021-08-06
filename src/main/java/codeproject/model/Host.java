package codeproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "host")
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotsId;

    @Column(name = "OrgName")
    private String OrgName;

    private String OrgEmail;
    private String OrgPhone;

    @Column(name = "averagePoint")
    private double averagePoint;

	public Long getHotsId() {
		return hotsId;
	}

	public void setHotsId(Long hotsId) {
		this.hotsId = hotsId;
	}

    
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "host_Id")
//    @JsonManagedReference
//    private List<Project> projects = new ArrayList<>();

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "location_Id")
//    private Location OrgAddress;

//    public void addProject(Project project) {
//        projects.add(project);
//    }
}
