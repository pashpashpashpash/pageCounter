package com.pavel.pageCounter.process;

import com.pavel.pageCounter.model.PageCountInfo;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

/**
 * Class for processing directory structure of given folder, finding files and delegating page counting to specific page counters to
 * count pages of files with different extensions
 */
@Component
public class PageCountProcessor {

    private static final Logger logger = LogManager.getLogger(PageCountProcessor.class);
    @Autowired
    private PageCountersFactory pageCountersFactory;
    private int folderCount = 0;
    private int allPagesCount = 0;

    /**
     * Method to process given directory
     * @param dirPath
     * @return PageCountInfo
     */
    public PageCountInfo processDirectory(String dirPath) {
        PageCountInfo pageCountInfo;
        Path path = Paths.get(dirPath);
        if (!Files.exists(path)) {
            logger.info("Directory is not exist (" + dirPath + ")");
            return new PageCountInfo(dirPath , folderCount, allPagesCount, "Directory is not exist");
        }
        process(new File(dirPath));
        pageCountInfo = new PageCountInfo(dirPath, folderCount, allPagesCount,"");
        logger.info("Folders count: " + folderCount + " " + "Pages count: " + allPagesCount);
        folderCount = 0;
        allPagesCount = 0;
        return pageCountInfo;
    }

    /**
     * Method goes recursively through folders and passes files to specific processors according to file extension
     * @param file
     */
    private void process(File file) {
        File[] files = file.listFiles();
        String fileExtension;

        for(int i = 0; i<files.length; i++) {

            if(files[i].isDirectory()) {
                folderCount++;
                process(files[i]);
            }

            if(files[i].isFile()) {
                fileExtension = FilenameUtils.getExtension(files[i].getName()).toLowerCase(Locale.ROOT);
                logger.info("Filename: "+ files[i].getName() + "  File extension: " + fileExtension);

                if(("pdf").equals(fileExtension)) {
                    IPageCounter pageCounterPDF = pageCountersFactory.getPageCounter(PageCounterEnum.PDF);
                    allPagesCount+=pageCounterPDF.countPages(files[i]);
                }
                if(("doc").equals(fileExtension)) {
                    IPageCounter pageCounterDOC = pageCountersFactory.getPageCounter(PageCounterEnum.DOC);
                    allPagesCount+=pageCounterDOC.countPages(files[i]);
                }
                if(("docx").equals(fileExtension)) {
                    IPageCounter pageCounterDOCX = pageCountersFactory.getPageCounter(PageCounterEnum.DOCX);
                    allPagesCount+=pageCounterDOCX.countPages(files[i]);
                }

            }
        }
    }
}
