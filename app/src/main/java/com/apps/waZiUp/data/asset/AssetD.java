package com.apps.waZiUp.data.asset;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;

/**
 * Created by KidusMT on 2/22/2018.
 */

@Entity
public class AssetD {

    @Id
    long id;

    @Index
    long asset_id;

    String name;
    String description;
    String image;
    String type;
    String unit;
    String position;
    String latitude;
    String longitude;
    String group;
    String association;
    String note;
    String isPublic;
}
