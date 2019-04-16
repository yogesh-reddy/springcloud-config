package com.myapp.makemyfood.common;

public class UnsupportedStateTransitionException extends RuntimeException {
  public UnsupportedStateTransitionException(Enum state) {
    super("current state: " + state);
  }
}
