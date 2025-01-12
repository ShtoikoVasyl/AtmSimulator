package edu.shtoiko.atmsimulator.client.implementation;

import edu.shtoiko.atmsimulator.client.DiscoveryClient;
import edu.shtoiko.atmsimulator.exception.InstancesNotFoundException;
import edu.shtoiko.atmsimulator.model.discovery.Application;
import edu.shtoiko.atmsimulator.model.discovery.DiscoveryServerCredentialsHolder;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.shtoiko.atmsimulator.model.discovery.Instance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.List;

public class EurekaClient implements DiscoveryClient {
    private final String SERVICE_NAME;
    private final URL discoveryServerUrl;
    private final HttpURLConnection connection;
    private final String RAW_ADDRESS;

    public EurekaClient(DiscoveryServerCredentialsHolder discoveryCredentials, String serviceName) {
        this.SERVICE_NAME = serviceName;
        try {
            RAW_ADDRESS = "http://" + discoveryCredentials.getServerHost() + ":" + discoveryCredentials.getServerPort()
                + "/eureka/apps/" + SERVICE_NAME;
            this.discoveryServerUrl = new URL(RAW_ADDRESS);
            this.connection = createConnection(discoveryCredentials.getDiscoveryUsername(),
                discoveryCredentials.getDiscoveryPassword());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private HttpURLConnection createConnection(String discoveryUsername, String discoveryPassword) throws IOException {
        String auth = discoveryUsername + ":" + discoveryPassword;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
        String authHeaderValue = "Basic " + encodedAuth;
        HttpURLConnection newConnection = (HttpURLConnection) discoveryServerUrl.openConnection();
        newConnection.setRequestMethod("GET");
        newConnection.setRequestProperty("Authorization", authHeaderValue);
        newConnection.setRequestProperty("Accept", "application/json");
        return newConnection;
    }

    @Override
    public List<Instance> getInstances() {
        Application application;
        String rawTextResult = getServiceInstances();
        application = deserializeJsonToApplication(rawTextResult);
        if (application == null) {
            throw new InstancesNotFoundException(
                "Instances of " + SERVICE_NAME + " were not found at the " + RAW_ADDRESS);
        } else {
            return application.getInstances();
        }
    }

    private String getServiceInstances() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Application deserializeJsonToApplication(String json) {
        Application application = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            application = mapper.readValue(json, Application.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return application;
    }
}
