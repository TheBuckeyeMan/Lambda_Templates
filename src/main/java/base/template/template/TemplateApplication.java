package base.template.template;

import base.template.template.service.TemplateService;
import base.template.template.service.S3Service;
import base.template.template.api.model.Model;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.RequiredArgsConstructor;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class TemplateApplication implements CommandLineRunner {

    private final TemplateService templateService;
    private final S3Service s3Service;

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }
	//I am convnced that the lambda is working because we have it invoked here
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting automatic process to fetch data and upload to S3...");

        // Trigger API call to fetch fun fact and upload to S3
        List<Model> model = templateService.getModel();
        if (model != null) {
            String filePath = "<Name of File Created From JSON Reponse>.<File Extension>";
            templateService.saveToFile(model, filePath);
            s3Service.uploadFile("<Your S3 Bucket>", "<Name of File Created From JSON Reponse>.<File Extension>", filePath);
            System.out.println("Data successfully fetched and saved to S3.");
        } else {
            System.out.println("No data received from API.");
        }
    }
}