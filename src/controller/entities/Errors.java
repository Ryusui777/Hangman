package controller.entities;

public enum Errors {
    CHARACTER_NOT_SUPPORTED("Character not supported", 0),
    WORDS_FILE_NOT_FOUND("Words file not found", 1),
    IMAGE_NOT_FOUND("Image not found", 2),
    WORD_LENGTH_EXCEEDED("Word length exceeded", 3),
    INTERNAL_ERROR_VIEW("Internal error in view", 4),
    ;



    final String errorMessage;
    final int errorCode;

    Errors(String message, int errorNumber){
        this.errorMessage = message;
        this.errorCode = errorNumber;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
    public int getErrorCode(){
        return errorCode;
    }

}
