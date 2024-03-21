package com.pavel.pageCounter.process;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.IOException;

/**
 * Class cont pages in docx files
 * Docx files doesn't contain information about page count. The pages only can be count after rendering the document.
 * This class gets information about page count from metadata that stored by render engine (MS Word, .. etc)
 * But sometimes this metadata doesn't contain any information and page count always will be equal 1
 */
public class PageCounterDOCX implements IPageCounter {

    private static final Logger logger = LogManager.getLogger(PageCounterDOCX.class);

    public int countPages(File file) {

        int count = 0;

        try {
            XWPFDocument docx = new XWPFDocument(POIXMLDocument.openPackage(file.getAbsolutePath()));
            count = docx.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();
            logger.info("Number of pages: " + count);
        } catch (IOException ex) {
            logger.warn("File reading error");
            System.out.println("docx file error");
        }

        return count;
    }
}
