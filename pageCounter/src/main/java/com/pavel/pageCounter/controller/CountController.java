package com.pavel.pageCounter.controller;

import com.pavel.pageCounter.model.PageCountInfo;
import com.pavel.pageCounter.process.PageCountProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountController implements IPageCountController {

    @Autowired
    PageCountProcessor pageCountProcessor;

    @Override
    public PageCountInfo getPagesCount(String dirPath) {
        return pageCountProcessor.processDirectory(dirPath);
    }
}
