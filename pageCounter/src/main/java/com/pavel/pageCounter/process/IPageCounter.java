package com.pavel.pageCounter.process;

import java.io.File;

/**
 * Common interface of all page counters
 */
public interface IPageCounter {

    int countPages(File file);
}
