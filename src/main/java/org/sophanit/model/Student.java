package org.sophanit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Student {
    private Integer studentId;
    private String studentName;
    private String email;
    private String phoneNumber;

}
