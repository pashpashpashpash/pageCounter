package com.pavel.pageCounter.process;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

/**
 * Class for counting pages in pdf documents
 */
public class PageCounterPDF implements IPageCounter{

    private static final Logger logger = LogManager.getLogger(PageCounterPDF.class);

    public int countPages(File file) {

        int count = 0;

        try {
            PDDocument doc = PDDocument.load(file);
            count = doc.getNumberOfPages();
            doc.close();
            logger.info("Number of pages: " + count);
        } catch (IOException ex) {
            logger.warn("File reading error");
        }

        return count;

    }
}
