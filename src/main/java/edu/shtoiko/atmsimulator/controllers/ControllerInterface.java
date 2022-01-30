package edu.shtoiko.atmsimulator.controllers;

public abstract class ControllerInterface {

    /**
     * create withdraw request
     * redirects to Withdrawing
     * @param requestSum request sum to withdraw
     * @return (Object) Withdrawing
     */
    public static Object withdrawRequest(int requestSum){
        return new Withdrawing(requestSum);
    }
}
