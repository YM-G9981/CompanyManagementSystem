package com.example.companyManagementSystem.entity.mission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mission_types")
@Data
public class MissionType {
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "missionId")
    @JsonIgnore
    List<Mission> missions;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_type_id")
    private long missionTypeId;
    @Column(name = "mission_type_title")
    @NonNull
    private String missionTypeTitle;
    @Column(name = "mission_type_context")
    @NonNull
    private String missionTypeContext;

    public MissionType() {

    }
}
