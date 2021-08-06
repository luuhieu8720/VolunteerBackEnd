package codeproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Project")
public class Project {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long projectId;
//
//    private String nameOfProject;
//
//    private Long hostId;
//
//    private Date regDeadline;
//
//    private Date startDay;
//
//    private Date endDay;
//
//    @ManyToOne
//    private Host host;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

//    private String leaderFirstname;
//    private String leaderLastname;
//    private String emailEmail;
//    private String leaderPhone;

    
    @NotBlank(message = "Event name cannot be empty or Null")
    private String eventName;

    private Date eventStart;
    private Date eventEnd;

    @Lob
    private String eventDescription;

    @Lob
    private String eventReq;

    private int minPeople;
    private int maxPeople;
    private Date deadline;
    private String eventImg;
    private String reason;

    private Integer voteCount;

    //    private String orgName;
//    private String orgAddress;
//    private String orgEmail;
//    private String orgPhone;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "location")
//    private Location place;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hostId")
    private Host host;
    
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

    
//    public Project() {
//    }
//
//    public Project(String leaderFirstname, String leaderLastname, String emailEmail, String leaderPhone, String eventName, Date eventStart, Date eventEnd, String eventDescription, String eventReq, int minPeople, int maxPeople, Date deadline, File eventImg, Location place, Host host) {
//        this.leaderFirstname = leaderFirstname;
//        this.leaderLastname = leaderLastname;
//        this.emailEmail = emailEmail;
//        this.leaderPhone = leaderPhone;
//        this.eventName = eventName;
//        this.eventStart = eventStart;
//        this.eventEnd = eventEnd;
//        this.eventDescription = eventDescription;
//        this.eventReq = eventReq;
//        this.minPeople = minPeople;
//        this.maxPeople = maxPeople;
//        this.deadline = deadline;
//        this.eventImg = eventImg;
//        this.place = place;
//        this.host = host;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getLeaderFirstname() {
//        return leaderFirstname;
//    }
//
//    public void setLeaderFirstname(String leaderFirstname) {
//        this.leaderFirstname = leaderFirstname;
//    }
//
//    public String getLeaderLastname() {
//        return leaderLastname;
//    }
//
//    public void setLeaderLastname(String leaderLastname) {
//        this.leaderLastname = leaderLastname;
//    }
//
//    public String getEmailEmail() {
//        return emailEmail;
//    }
//
//    public void setEmailEmail(String emailEmail) {
//        this.emailEmail = emailEmail;
//    }
//
//    public String getLeaderPhone() {
//        return leaderPhone;
//    }
//
//    public void setLeaderPhone(String leaderPhone) {
//        this.leaderPhone = leaderPhone;
//    }
//
//    public String getEventName() {
//        return eventName;
//    }
//
//    public void setEventName(String eventName) {
//        this.eventName = eventName;
//    }
//
//    public Date getEventStart() {
//        return eventStart;
//    }
//
//    public void setEventStart(Date eventStart) {
//        this.eventStart = eventStart;
//    }
//
//    public Date getEventEnd() {
//        return eventEnd;
//    }
//
//    public void setEventEnd(Date eventEnd) {
//        this.eventEnd = eventEnd;
//    }
//
//    public String getEventDescription() {
//        return eventDescription;
//    }
//
//    public void setEventDescription(String eventDescription) {
//        this.eventDescription = eventDescription;
//    }
//
//    public String getEventReq() {
//        return eventReq;
//    }
//
//    public void setEventReq(String eventReq) {
//        this.eventReq = eventReq;
//    }
//
//    public int getMinPeople() {
//        return minPeople;
//    }
//
//    public void setMinPeople(int minPeople) {
//        this.minPeople = minPeople;
//    }
//
//    public int getMaxPeople() {
//        return maxPeople;
//    }
//
//    public void setMaxPeople(int maxPeople) {
//        this.maxPeople = maxPeople;
//    }
//
//    public Date getDeadline() {
//        return deadline;
//    }
//
//    public void setDeadline(Date deadline) {
//        this.deadline = deadline;
//    }
//
//    public File getEventImg() {
//        return eventImg;
//    }
//
//    public void setEventImg(File eventImg) {
//        this.eventImg = eventImg;
//    }
//
//    public Location getPlace() {
//        return place;
//    }
//
//    public void setPlace(Location place) {
//        this.place = place;
//    }
//
//    public Host getHost() {
//        return host;
//    }
//
//    public void setHost(Host host) {
//        this.host = host;
//    }

    //    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name = "PointForProject",
//                joinColumns = @JoinColumn(name = "projectId"),
//                inverseJoinColumns = @JoinColumn(name = "Id_User"))
//    private Collection<TestUser> users;

//    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
//    private Set<ProjectRating> point;
}
