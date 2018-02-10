package com.example.s3properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("s3-properties.properties")
public class S3Properties {

    private String title;
    private String description;
}
