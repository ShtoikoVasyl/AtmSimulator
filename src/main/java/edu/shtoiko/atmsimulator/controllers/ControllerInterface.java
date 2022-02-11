package edu.shtoiko.atmsimulator.controllers;

public class ControllerInterface {
  private ControllerInterface(){}

  /**
   * create withdraw request redirects to Withdrawing
   *
   * @param requestSum request sum to withdraw
   * @return (Object) Withdrawing
   */
  public static Object withdrawRequest(int requestSum) {
    return new Withdrawing(requestSum);
  }
}
