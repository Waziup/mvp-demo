package com.apps.waziup.data.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;

/**
 * Created by KidusMT on 2/22/2018.
 */

@Entity
public class Activity {

    @Id
    long id;

    @Index
    long activity_id;

    String name;
    String type;
    String detail;
    String project_id;
    String image;
    String video;
    String tags;
    String time;
    String location;
    String duration;
    String expense;
}
