package com.example.companyManagementSystem.entity.hrmResource.personalList;

import com.example.companyManagementSystem.entity.hrmResource.Department;
import com.example.companyManagementSystem.entity.hrmResource.Personal;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PersonalListNode {
    private Department department;
    private List<PersonalListNode> juniorPersonalListNodes;
    private List<Personal> personals;

    public PersonalListNode() {
        this.department = null;
        this.juniorPersonalListNodes = new ArrayList<>();
        this.personals = new ArrayList<>();
    }

    public PersonalListNode(Department department) {
        this.department = department;
        this.juniorPersonalListNodes = new ArrayList<>();
        this.personals = new ArrayList<>();
    }
}
