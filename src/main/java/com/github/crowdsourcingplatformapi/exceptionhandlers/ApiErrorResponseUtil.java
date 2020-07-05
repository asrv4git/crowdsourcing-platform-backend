package com.github.crowdsourcingplatformapi.exceptionhandlers;

public class ApiErrorResponseUtil {
    public static String getErrorResponseMessage(int code) {
        switch (code) {
            case 400:
                return "Invalid parameter or invalid operation";
            case 404:
                return "The requested resource was not found";
            case 500:
                return "Internal Server Error";
            case 401:
                return "Authorization token not provided or invalid";
            case 403:
                return "This user is prohibited from performing this operation";
            default:
                return null;
        }
    }
}
