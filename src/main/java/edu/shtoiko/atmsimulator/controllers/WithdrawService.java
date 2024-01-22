package edu.shtoiko.atmsimulator.controllers;

import java.util.Map;

public interface WithdrawService {
    public Map<String, Integer> withdrawRequest(Map<String, Integer> availableBanknotes, int withdrawRequestSum);
}
