package base.template.template.api.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApiKeyInterceptor implements ClientHttpRequestInterceptor{
    private final String apiKey;

    public ApiKeyInterceptor(String apiKey){
        this.apiKey = apiKey; //The API Key itself will get passed in via environment variable when you provision the lambda 
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().set("X-Api-Key", apiKey);
        return execution.execute(request, body);
    }
}