package com.madhu.vendormanagementsystem.exception;

public class DuplicateVendorNameException extends RuntimeException{
    public DuplicateVendorNameException(String msg)
    {
        super(msg);
    }
}
