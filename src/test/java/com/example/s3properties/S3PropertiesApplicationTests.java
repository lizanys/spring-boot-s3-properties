package com.example.s3properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class S3PropertiesApplicationTests {

    @Autowired
    private S3Properties s3Properties;

    @Test
    public void contextLoads() {
        assertThat(s3Properties)
                .extracting("title", "description")
                .containsExactly("Title", "Description");
    }

}
