package by.leverx.pets.service.impl;

import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestination;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

import static com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor.getDestination;
import static com.sap.cloud.sdk.cloudplatform.connectivity.HttpClientAccessor.getHttpClient;

public class DestinationService {

    @Value("${destination.name}")
    private String destinationName;

    @Value("${destination.uri}")
    private HttpUriRequest google;

    public void destination() {
        HttpDestination destination = getDestination(destinationName).asHttp();
        HttpClient client = getHttpClient(destination);

        try {
            client.execute(google);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
