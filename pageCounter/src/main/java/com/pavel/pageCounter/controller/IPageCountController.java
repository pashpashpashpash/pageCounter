package com.pavel.pageCounter.controller;

import com.pavel.pageCounter.model.PageCountInfo;

public interface IPageCountController {
    /**
     * Returns pages count of documents in given directory
     * @param dirPath
     * @return
     */
    PageCountInfo getPagesCount(String dirPath);
}
