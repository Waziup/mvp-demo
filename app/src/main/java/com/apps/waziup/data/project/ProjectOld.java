package com.apps.waziup.data.project;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;

/**
 * Created by KidusMT on 2/22/2018.
 */

@Entity
public class ProjectOld {

    @Id
    long id;

    @Index
    long project_id;

    String name;
    String description;
    String image;
    String country;
    String latitude;
    String longtidue;
    String type;
    String seansors;
    String notes;
    boolean isPublic;
}
