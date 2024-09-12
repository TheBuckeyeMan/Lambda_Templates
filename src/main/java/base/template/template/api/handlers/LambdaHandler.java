package base.template.template.api.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import base.template.template.service.S3Service;
import base.template.template.service.TemplateService;
import base.template.template.api.model.Model;
import java.util.List;

//The lambda handler is responsable for kicking off the lambda function. Essentially, do this when the lmbda is triggered

public class LambdaHandler implements RequestHandler<Object, String> {

    private final TemplateService templateService;
    private final S3Service s3Service;

    public LambdaHandler(TemplateService templateService, S3Service s3Service) {
        this.templateService = templateService;
        this.s3Service = s3Service;
    }

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Lambda function invoked: Starting automatic process");
        runAutomaticProcess(context);  // Automatically fetch API data when Lambda starts
        return "Success";
    }

    private void runAutomaticProcess(Context context) {
        context.getLogger().log("Fetching data from API and saving to S3...");
        List<Model> model = templateService.getModel();  // Fetch data from API
        if (model != null) {
            String filePath = "<Name of File Created From JSON Reponse>.<File Extension>";
            templateService.saveToFile(model, filePath);  // Save data to file
            s3Service.uploadFile("<Your S3 Bucket Name>", "<Name of File Created From JSON Reponse>.<File Extension>", filePath);  // Upload to S3
            context.getLogger().log("Data successfully fetched and saved to S3");
        } else {
            context.getLogger().log("No data received from API");
        }
    }
}