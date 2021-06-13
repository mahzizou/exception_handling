package com.afaqy;

public enum ErrorCode {

    EMPTY_FILE (809);

    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
