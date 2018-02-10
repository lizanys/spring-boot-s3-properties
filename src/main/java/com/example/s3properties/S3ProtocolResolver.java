package com.example.s3properties;

import lombok.AllArgsConstructor;
import org.springframework.cloud.aws.core.io.s3.PathMatchingSimpleStorageResourcePatternResolver;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class S3ProtocolResolver implements ProtocolResolver {

    private static final String S3_PREFIX = "s3://";

    private PathMatchingSimpleStorageResourcePatternResolver simpleStorageResourcePatternResolver;

    @Override
    public Resource resolve(String location, ResourceLoader resourceLoader) {
        return location.startsWith(S3_PREFIX) ? simpleStorageResourcePatternResolver.getResource(location) : null;
    }
}
