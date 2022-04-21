package com.team34.sidedish;

import javax.sql.DataSource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JdbcTest {

    @Autowired
    DataSource dataSource;

    @Test
    void jdbcTest() {
        Assertions.assertThat(dataSource).isNotNull();
    }
}
