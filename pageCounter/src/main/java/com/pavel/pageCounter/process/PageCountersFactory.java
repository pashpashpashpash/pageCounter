package com.pavel.pageCounter.process;

import org.springframework.stereotype.Component;

/**
 * Factory class for getting instance of specific page counter
 */
@Component
public class PageCountersFactory {

    public IPageCounter getPageCounter(PageCounterEnum pageCounterEnum)
    {
        return pageCounterEnum.getInstance();
    }
}
