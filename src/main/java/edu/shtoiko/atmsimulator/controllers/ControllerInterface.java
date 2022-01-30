package edu.shtoiko.atmsimulator.controllers;

public abstract class ControllerInterface {

    public static Object withdrawRequest(int requestSum){
        return new Withdrawing(requestSum);
    }
}
