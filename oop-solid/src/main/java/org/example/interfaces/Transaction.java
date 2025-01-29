package org.example.interfaces;

public interface Transaction {
    void execute() throws Exception;
    void undo() throws Exception;
}
