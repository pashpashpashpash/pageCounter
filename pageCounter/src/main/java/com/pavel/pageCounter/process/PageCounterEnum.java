package com.pavel.pageCounter.process;

/**
 * Enum of different page counters for different file extensions
 * Can be extended by adding new page counter for specific extension
 */
public enum PageCounterEnum {

        PDF {

            @Override
            public PageCounterPDF getInstance() {
                return new PageCounterPDF ();
            }

        },
        DOC {

            @Override
            public PageCounterDOC getInstance() {
                return new PageCounterDOC();
            }

        },
        DOCX {

            @Override
            public PageCounterDOCX getInstance() {
            return new PageCounterDOCX();
        }

        };

        public abstract IPageCounter getInstance();

}
