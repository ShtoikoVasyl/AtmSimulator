package edu.shtoiko.atmsimulator.services;

import edu.shtoiko.atmsimulator.exception.WithdrawException;

import java.util.Map;

public interface WithdrawService {
    public Map<String, Integer> withdrawRequest(Map<String, Integer> availableBanknotes, int withdrawRequestSum)
        throws WithdrawException;
}
