package com.example.companyManagementSystem.entity.mission;

import com.example.companyManagementSystem.entity.hrmResource.User;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "missions")
@Entity
public class Mission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mission_id")
    private long missionId;
    @Column(name = "mission_title")
    @NonNull
    private String missionTitle;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_type", referencedColumnName = "mission_type_id")
    @NonNull
    private MissionType missionType;
    @Column(name = "mission_time")
    @NonNull
    private Date missionTime;
    @Column(name = "mission_context")
    @NonNull
    private String missionContext;
    @Column(name = "deadline_time")
    @NonNull
    private Date deadlineTime;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "missio_initiate_user", referencedColumnName = "user_id")
    private User missionInitiateUser;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(name = "mission_user",
            joinColumns = @JoinColumn(name = "mission_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"mission_id", "user_id"}))
    private List<User> missionUser;
    @Column(name = "mission_state")
    @NonNull
    private boolean missionState;

    public Mission() {
    }
}
