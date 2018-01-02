package com.atech.flight.app.api.error;

/**
 * Default API Error Code for endpoints
 *
 * @author  José Júnior <joselazarosiqueira@gmail.com>
 */
public class ApiError {

    private String errorMessage;

    private String errorCode;

    public ApiError() {}

    /**
     Use api error enum to create error message.
     If you want customized message, please use other constructor.
     **/
    public ApiError(ApiErrorCode apiErrorCode) {
        this.errorMessage = apiErrorCode.getMessage();
        this.errorCode = apiErrorCode.getCode();
    }

    public ApiError(ApiErrorCode apiErrorCode, String additionalMessage) {
        this.errorMessage = apiErrorCode.getMessage();
        this.errorCode = apiErrorCode.getCode();
        addMessage(additionalMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorCode(ApiErrorCode apiErrorCode) {
        this.errorCode = apiErrorCode.getCode();
    }

    public void addMessage(String message) {
        if (errorMessage == null) {
            errorMessage = message;
        } else
            errorMessage += message;

    }
}

