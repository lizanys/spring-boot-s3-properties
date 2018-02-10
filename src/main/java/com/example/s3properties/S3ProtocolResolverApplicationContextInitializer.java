package com.example.s3properties;

import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.cloud.aws.core.io.s3.PathMatchingSimpleStorageResourcePatternResolver;
import org.springframework.cloud.aws.core.io.s3.SimpleStorageResourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class S3ProtocolResolverApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        AmazonS3Client s3Client = new AmazonS3Client();
        PathMatchingSimpleStorageResourcePatternResolver simpleStorageResourcePatternResolver = new PathMatchingSimpleStorageResourcePatternResolver(s3Client, new SimpleStorageResourceLoader(s3Client, applicationContext), applicationContext);
        S3ProtocolResolver s3ProtocolResolver = new S3ProtocolResolver(simpleStorageResourcePatternResolver);
        applicationContext.addProtocolResolver(s3ProtocolResolver);
    }
}
