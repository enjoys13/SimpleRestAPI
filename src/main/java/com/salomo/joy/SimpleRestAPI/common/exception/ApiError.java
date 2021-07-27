/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salomo.joy.SimpleRestAPI.common.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import static com.salomo.joy.SimpleRestAPI.common.constant.ApiConstans.DATE_FORMAT;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 *
 * @author Joy Salomo S
 */

class ApiError {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private String path;

    private ApiError()
    {
        timestamp = LocalDateTime.now();
    }

    ApiError( HttpStatus status )
    {
        this();
        this.status = status;
    }

    ApiError( HttpStatus status, Throwable ex )
    {
        this(status);
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    ApiError( HttpStatus status, String message, Throwable ex )
    {
        this(status,ex);
        this.message = message;
    }

    ApiError( HttpStatus status, String message,String path, Throwable ex )
    {
        this(status,message,ex);
        this.path = path;

    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
