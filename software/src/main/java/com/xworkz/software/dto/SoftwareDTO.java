package com.xworkz.software.dto;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class SoftwareDTO {


    private String software;
    private String currentVersion;
    private int developedYear;
    private String developedBy;
    private String openSource;
}
