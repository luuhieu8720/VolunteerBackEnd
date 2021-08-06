package codeproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long StatusId;

    private String nameOfStatus;

}
