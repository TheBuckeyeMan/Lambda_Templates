package base.template.template.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import base.template.template.api.model.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


//Entire purpose of service is to consume the data from api, write to file

@Service
@RequiredArgsConstructor
@Slf4j
public class TemplateService {
    
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();//Add in object for the JSON Response Object

    //Make getter method for our model
    public List<Model> getModel(){
        log.info("Attempting to fetch model from external API...");
        String url = "<Api Url of Externsal API We are getting data from>";

        List<Model> model = null;
        try {
            String jsonResponse = restTemplate.getForObject(url, String.class);

            model = objectMapper.readValue(jsonResponse, new TypeReference<List<Model>>() {});

            log.info("Recieved JSON Response from external API: {}", jsonResponse);//Log the JSON Response from Extenral API
                if (model != null) {
                    log.info("Model Successful Build!");
                }
                } catch (HttpStatusCodeException e) {
                    log.error("Recieved an error response from API: {}", e.getResponseBodyAsString(), e);//log error if an error status code is returned
                } catch (Exception e) {
                    log.error("An Error Occured while making the reques tto external API: {}", e);
                }
       return model;
    }
    public void saveToFile(List<Model> model, String filePath) {
        String fullPath = "/tmp/" + filePath;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath))){
            //ADD IN ALL DATA POINTS TO WRITE TO FILE HERE - FOR BIG API'S WE WILL HAVE MORE HERE
            writer.write(objectMapper.writeValueAsString(model) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}