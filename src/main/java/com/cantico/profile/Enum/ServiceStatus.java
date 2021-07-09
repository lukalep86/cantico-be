package com.cantico.profile.Enum;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ServiceStatus {
 
    CREATED_SUCCESS("CREATED", "Creato con successo"),
    UPDATED_SUCCESS("UPDATED", "Aggiornato con successo"),
    DELETED_SUCCESS("DELETED", "Eliminato con successo"),
    OTP_CREATED_SUCCESS("CREATED", "OTP creato con successo"),
    OTP_VALIDATED_SUCCESS("VALIDATED", "OTP validato con successo"),
    LOGIN_SUCCESS("LOGGED", "loggato con successo");
 
    private  String status;
    private  String message;

    //Enum constructor
    ServiceStatus(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString(){
        return ("ID: " + this.status + "MESSAGE: "+ this.message);
    }

    

}


