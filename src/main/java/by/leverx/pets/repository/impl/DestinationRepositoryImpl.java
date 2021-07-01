package by.leverx.pets.repository.impl;

import by.leverx.pets.repository.DestinationRepository;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestination;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.stereotype.Repository;

import java.io.IOException;

import static com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor.getDestination;
import static com.sap.cloud.sdk.cloudplatform.connectivity.HttpClientAccessor.getHttpClient;

/**
 *
 * @author aliaksei.babashau
 */
@Repository
public class DestinationRepositoryImpl implements DestinationRepository {

    private String destinationName;

    @Override public void destination(HttpUriRequest httpUriRequest) throws IOException {
        HttpDestination destination = getDestination(destinationName).asHttp();
        HttpClient client = getHttpClient(destination);

        client.execute(httpUriRequest);
    }
}
