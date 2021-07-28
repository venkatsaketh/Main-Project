package com.cts.security.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ExceptionDetails {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime localDateTime;

    private String message;

    public ExceptionDetails(LocalDateTime localDateTime, String message) {
        super();
        this.localDateTime = localDateTime;
        this.message = message;
    }

}
