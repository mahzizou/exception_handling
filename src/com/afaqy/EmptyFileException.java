package com.afaqy;

public class EmptyFileException extends RuntimeException{

    private Integer errorCode;

    public EmptyFileException(){
        super("Can not read empty file");
//        super();
    }

    public EmptyFileException(String message){
        super(message);
//        super();
    }

    public EmptyFileException(ErrorCode errorCode){
        super("ERROR_CODE_"+ errorCode.getCode() + "_" + errorCode +" Can not read empty file");
//        super();
        this.errorCode = errorCode.getCode();
    }

    public EmptyFileException(Throwable cause, ErrorCode errorCode){
        super("Can not read empty file", cause);
        this.errorCode = errorCode.getCode();
    }

    public EmptyFileException(String fileName, ErrorCode errorCode){
        super("ERROR_CODE_"+ errorCode.getCode() + "_" + errorCode +" Can not read empty file: " + fileName);
//        super();
        this.errorCode = errorCode.getCode();
    }

    public EmptyFileException(String message, Throwable cause, ErrorCode errorCode){
        super(message, cause);
        this.errorCode = errorCode.getCode();
    }

    public Integer getErrorCode() {
        return errorCode;
    }

}
