package org.sophanit.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Response<T> {
    private String message;
    private T payload;
    private HttpStatus httpStatus;
    private Timestamp timestamp;
}