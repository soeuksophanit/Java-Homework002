package org.sophanit.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourseRequest {
    private String courseName;
    private String description;
    private Integer instructorId;
}
