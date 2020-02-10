package com.example.spatial;

import lombok.SneakyThrows;
import oracle.jdbc.driver.OracleConnection;
import org.geolatte.geom.codec.db.oracle.ConnectionFinder;
import org.springframework.stereotype.Component;

import java.sql.Connection;

/**
 * @description:
 * @author: dinglw
 * @date: 2020-01-21 16:29
 */
@Component
public class MyConnectionFinder implements ConnectionFinder {

    @SneakyThrows
    @Override
    public Connection find(Connection con) {
        // TODO Auto-generated method stub
        if (con == null) {
            return null;
        }
        if (con.isWrapperFor(OracleConnection.class)) {
            return con.unwrap(OracleConnection.class);
        }
        throw new RuntimeException("Couldn't get at the OracleSpatial Connection object from the PreparedStatement.");

    }
}
