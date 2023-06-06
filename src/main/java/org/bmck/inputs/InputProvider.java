package org.bmck.inputs;

public interface InputProvider extends AutoCloseable {
    String getInput();
}
