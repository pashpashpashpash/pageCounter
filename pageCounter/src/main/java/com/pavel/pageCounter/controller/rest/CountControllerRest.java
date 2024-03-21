package com.pavel.pageCounter.controller.rest;

import com.pavel.pageCounter.controller.IPageCountController;
import com.pavel.pageCounter.model.PageCountInfo;
import com.pavel.pageCounter.model.PageCountRequest;
import com.pavel.pageCounter.model.PageCountResponse;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountControllerRest {

    private static final Logger logger = LogManager.getLogger(CountControllerRest.class);

    @Autowired
    IPageCountController pageCountController;

    /**
     * POST Rest method responsible for count document pages and subdirectories of given directory located on server
     * @param pageCountRequest
     * @return PageCountResponse
     */
    @PostMapping("/count")
    PageCountResponse count(@RequestBody @Valid PageCountRequest pageCountRequest) {
        logger.info("Requested dir path: " + pageCountRequest.getDirPath());
        PageCountInfo pageCountInfo = pageCountController.getPagesCount(pageCountRequest.getDirPath());
        return new PageCountResponse(pageCountInfo.getDirPath(),
                pageCountInfo.getDirsCount(),
                pageCountInfo.getPagesCount(),
                pageCountInfo.getErr());
    }
}
