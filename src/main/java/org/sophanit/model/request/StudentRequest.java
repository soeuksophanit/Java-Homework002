package org.sophanit.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Integer> courseId = new ArrayList<>();
}
