package com.example.spatial.domain;

import lombok.Data;
import org.geolatte.geom.Geometry;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:
 * @author: dinglw
 * @date: 2020-01-21 11:43
 */
@Data
@Entity
@Table(name = "META_USER")
public class META_USER {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name="position")
    private Geometry position;


}
