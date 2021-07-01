package by.leverx.pets.repository;

import org.apache.http.client.methods.HttpUriRequest;

import java.io.IOException;

/**
 *
 * @author aliaksei.babashau
 */
public interface DestinationRepository {

    void destination(HttpUriRequest httpUriRequest) throws IOException;
}
