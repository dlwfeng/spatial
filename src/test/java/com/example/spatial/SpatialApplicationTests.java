package com.example.spatial;

import com.example.spatial.domain.META_USER;
import com.example.spatial.domain.QMETA_USER;
import com.example.spatial.repo.UserRepo;
import com.querydsl.core.BooleanBuilder;
import org.geolatte.geom.Point;
import org.geolatte.geom.codec.Wkt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.text.ParseException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SpatialApplicationTests {

    @Test
    void contextLoads() {
    }


    @Resource
    private UserRepo repo;

    @Test
    void setGeo() {
        Point position = (Point) Wkt.fromWkt("point(115 35)");
        META_USER METAUSER = new META_USER();
        METAUSER.setId("12345");
        METAUSER.setPosition(position);
        repo.save(METAUSER);
    }

    @Test
    void getGeo() {
        QMETA_USER qmeta_user = QMETA_USER.mETA_USER;
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(qmeta_user.id.eq("123"));
        Optional<META_USER> one = repo.findOne(booleanBuilder);
        System.out.println(one.get().getPosition().getGeometryType().name());
    }

}
