package com.proposta.aceita.notificationservice.exceptions;

public class RequestException extends RuntimeException {

    public RequestException(int status, String url, String reason) {
        super("Failed request to " + url + " with status:" + status +". Reason: " + reason);
    }
}
