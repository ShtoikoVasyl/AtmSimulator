package edu.shtoiko.atmsimulator.model.discovery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Application {
    @JsonProperty("application")
    private ApplicationData applicationData;

    public List<Instance> getInstances() {
        return applicationData.getInstance();
    }

    public ApplicationData getApplicationData() {
        return applicationData;
    }

    public void setApplicationData(ApplicationData applicationData) {
        this.applicationData = applicationData;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class ApplicationData {
    private List<Instance> instance;

    public List<Instance> getInstance() {
        return instance;
    }

    public void setInstance(List<Instance> instance) {
        this.instance = instance;
    }
}
