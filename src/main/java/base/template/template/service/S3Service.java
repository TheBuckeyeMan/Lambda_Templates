package base.template.template.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import java.nio.file.Paths;

//The entire point of this service is to store the json response to s3 bucket

@Service
public class S3Service {
    private final S3Client s3Client;

    public S3Service(@Value("${AWS_REGION:us-east-2}") String region){
        // Use the default credentials provider, which works with IAM roles in Lambda
        this.s3Client = S3Client.builder()
            .region(Region.of(region))
            .build();  // No need for explicit credentials
    }

    public void uploadFile(String bucketName, String key, String filePath){
        String fullPath = "/tmp/" + filePath;
        try {
            PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();
            s3Client.putObject(request, Paths.get(fullPath));
            System.out.println("File Successfully Uploaded to S3");
        } catch (S3Exception e) {
            e.printStackTrace();
        }
    }
}