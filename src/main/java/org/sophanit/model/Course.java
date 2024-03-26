package org.sophanit.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Course {
    private int courseId;
    private String courseName;
    private String description;
    private Instructor instructor;
}
