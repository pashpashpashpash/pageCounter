package com.pavel.pageCounter.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class of request to rest service
 * dirPath - directory path to process
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageCountRequest {
    @NotBlank(message="Please provide a valid dirPath")
    private String dirPath;
}
