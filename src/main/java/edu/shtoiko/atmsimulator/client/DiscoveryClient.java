package edu.shtoiko.atmsimulator.client;

import edu.shtoiko.atmsimulator.model.discovery.Instance;

import java.util.List;

public interface DiscoveryClient {
    List<Instance> getInstances();
}
