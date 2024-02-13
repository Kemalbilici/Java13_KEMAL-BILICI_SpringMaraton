package com.kemal.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {

    INTERNAL_SERVER_ERROR(500, "Sunucu Hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(501, "Parametre Hatalı", HttpStatus.BAD_REQUEST),
    DOCTOR_NOT_FOUND(502, "Doktor bulunamadı.", HttpStatus.BAD_REQUEST),
    DUPLICATE_DOCTOR(503, "Girilen doktor zaten kayıtlı.", HttpStatus.BAD_REQUEST),
    DOCTOR_IS_FULL(504, "Bu doktorun randevu kapasitesi doludur.", HttpStatus.BAD_REQUEST),
    APPOINTMENT_IS_FULL(505, "Seçilen randevu doludur.", HttpStatus.BAD_REQUEST);

    int code;
    String message;
    HttpStatus httpStatus;
}