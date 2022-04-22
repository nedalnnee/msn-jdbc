package com.msnit.msn_dbl.db;

import java.sql.Connection;

public interface Database {
    Connection getConnection();

    boolean connect(String username, String password, String url);

    boolean connect(String url);


}
