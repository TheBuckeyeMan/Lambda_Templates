// package base.template.template.api.controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import base.template.template.api.model.Model;
// import base.template.template.service.TemplateService;
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
// import java.util.List;
// import base.template.template.service.S3Service;

// //Entire purpose of the controller is to expose the api endpoints and trigger the api

// //For the Purpose of the lambda


// @RestController
// @RequiredArgsConstructor
// @RequestMapping("/api")
// @Slf4j
// public class Controller {
//     private final TemplateService templateService;
//     private final S3Service s3Service;

//     @GetMapping("/facttrigger")
//     public List<Model> getModel(){
//         List<Model> model = templateService.getModel();
//         if (model != null) {
//             String filePath = "<Name of File Created From JSON Reponse>.<File Extension>";
//             templateService.saveToFile(model,filePath);
//             s3Service.uploadFile("<Name Of S3 Bucket We Are Saving The File To>", "<Name of File Created From JSON Reponse>.<File Extension>", filePath);
//         }
//         return model;
//     }
// }
