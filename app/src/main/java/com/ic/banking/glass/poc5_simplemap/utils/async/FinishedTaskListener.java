package com.ic.banking.glass.poc5_simplemap.utils.async;

public interface FinishedTaskListener<T> {

    public void onResult(T result);
}
