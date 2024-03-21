package com.pavel.pageCounter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class contains result of program execution
 * dirPath - requested directory
 * dirsCount - count of subdirectories
 * pagesCount - pages count of all supported documents
 * err - errors information
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageCountInfo {
    private String dirPath;
    private int dirsCount;
    private int pagesCount;
    private String err;
}
