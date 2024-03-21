# pageCounter

Web application for getting page count of all supported documents (at this moment pdf, doc, docx)
Doc and docx page counting don't work well because of these types of documents don't contain any information about page count,
application tries to get this information from metadata that stored by rendering engines (Ms Word) after document rendering.

To count pages send POST request to this url:

http://localhost:8080/count

payload example:

{
    "dirPath": "A:\\testDir"
}

Response example:

{
    "dirPath": "A:\\testDir",
    "dirCount": 3,
    "pagesCount": 278,
    "err": ""
}


dirCount - count of subdirectories;  
pagesCount - count of pages of all supported documents;  
err - information about some errors
