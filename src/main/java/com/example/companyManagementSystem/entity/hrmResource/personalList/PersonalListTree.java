package com.example.companyManagementSystem.entity.hrmResource.personalList;

import lombok.Data;

@Data
public class PersonalListTree {
    private PersonalListNode rootPersonalListNode;

    public PersonalListTree(PersonalListNode rootPersonalListNode) {
        this.rootPersonalListNode = rootPersonalListNode;
    }
}
