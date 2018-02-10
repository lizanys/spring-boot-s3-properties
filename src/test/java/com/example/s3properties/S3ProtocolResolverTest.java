package com.example.s3properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.cloud.aws.core.io.s3.PathMatchingSimpleStorageResourcePatternResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class S3ProtocolResolverTest {

    @InjectMocks
    private S3ProtocolResolver s3ProtocolResolver;

    @Mock
    private PathMatchingSimpleStorageResourcePatternResolver pathMatchingSimpleStorageResourcePatternResolver;

    @Test
    public void resolve_whenLocationStartsWithS3Prefix_usesPathMatchingSimpleStorageResourcePatternResolver() {
        String location = "s3://bucket/object";
        Resource resource = mock(Resource.class);

        when(pathMatchingSimpleStorageResourcePatternResolver.getResource(any()))
                .thenReturn(resource);

        Resource result = s3ProtocolResolver.resolve(location, mock(ResourceLoader.class));

        assertThat(result).isEqualTo(resource);

        verify(pathMatchingSimpleStorageResourcePatternResolver).getResource(location);
    }

    @Test
    public void resolve_whenLocationDoesNotStartWithS3Prefix_returnsNull() {
        String location = "classpath:file";

        Resource result = s3ProtocolResolver.resolve(location, mock(ResourceLoader.class));

        assertThat(result).isNull();

        verifyZeroInteractions(pathMatchingSimpleStorageResourcePatternResolver);
    }
}
