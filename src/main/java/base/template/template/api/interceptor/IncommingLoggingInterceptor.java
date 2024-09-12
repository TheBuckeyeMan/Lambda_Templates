package base.template.template.api.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.IOException;

//The Entire purpose of this interceptor is to sit between the client and this application to intercept the HTTP Request and log what the request is for debugging purposes
//You can remove if needed, however, this is not recomended as thease logs can help with bug fixing

@Component
public class IncommingLoggingInterceptor implements ClientHttpRequestInterceptor{
    private static final Logger log = LoggerFactory.getLogger(IncommingLoggingInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logIncommingRequestDetails(request, body); // Log incoming request details
        return execution.execute(request, body); // Proceed with the request
    }

    private void logIncommingRequestDetails(HttpRequest request, byte[] body) throws IOException {
        String requestBody = new String(body, "UTF-8"); //Convert request body to JSON
        //Log Request Details
        log.info("Inbound Request URL: {}", request.getURI());
        log.info("Inbound Request Method: {}", request.getMethod());
        log.info("Inbound Request Headers: {}", request.getHeaders());
        log.info("Inbound Request Body: {}", requestBody);
    }
}