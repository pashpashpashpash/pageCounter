package com.pavel.pageCounter.process;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hwpf.HWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Class cont pages in doc files
 * Doc files doesn't contain information about page count. The pages only can be count after rendering the document.
 * This class gets information about page count from metadata that stored by render engine (MS Word, .. etc)
 * But sometimes this metadata doesn't contain any information and page count always will be equal 1
 */
public class PageCounterDOC implements IPageCounter {

    private static final Logger logger = LogManager.getLogger(PageCounterDOC.class);

    public int countPages(File file) {

        int count = 0;

        try {
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument document = new HWPFDocument(fis);
            count = document.getSummaryInformation().getPageCount();
            logger.info("Number of pages: " + count);
        } catch (IOException ex) {
            logger.warn("File reading error");
        }

        return count;
    }
}
