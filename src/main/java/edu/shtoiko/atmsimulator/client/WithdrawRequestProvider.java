package edu.shtoiko.atmsimulator.client;

import edu.shtoiko.atmsimulator.exception.WithdrawException;

public interface WithdrawRequestProvider {
    boolean withdraw(long accountNumber, short pinCode, long amount, String currencyCode) throws WithdrawException;
}
