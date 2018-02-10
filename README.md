# spring-boot-s3-properties
Demo project for reading properties from S3 in a Spring Boot application

## Setup
1. Upload `s3-properties.properties` to an S3 bucket of your choice.
2. Enter values for the following properties in `src/main/resources/application.properties`:
    - `cloud.aws.credentials.accessKey`: AWS access key ID
    - `cloud.aws.credentials.secretKey`: AWS secret access key
    - `cloud.aws.region.static`: AWS region
    - `s3-properties.location`: Location of the properties file uploaded in Step 1, in the format `s3://<bucket>/object`

## Credits
- [@dsyer](https://github.com/dsyer) for suggesting the usage of a `ProtocolResolver` and `ApplicationContextInitializer`
- [@gonzalad](https://github.com/gonzalad) for providing a [reference solution](https://github.com/spring-cloud/spring-cloud-aws/issues/99#issuecomment-255072407) using a `ProtocolResolver`
- [@rgravina](https://github.com/rgravina) for pairing on many potential solutions
