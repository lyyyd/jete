package com.tester.jete.proxy;

import java.io.File;
import java.util.Map;

/**
 * @ClassName DownloadedFile
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 18:06
 */
public class DownloadedFile {
    private final File file;
    private final Map<String, String> headers;

    /**
     * @param file the downloaded file
     * @param headers map of http headers. NB! Map keys (header names) are LOWER CASE!
     */
    public DownloadedFile(File file, Map<String, String> headers) {
        this.file = file;
        this.headers = headers;
    }

    public File getFile() {
        return file;
    }

    public boolean hasContentDispositionHeader() {
        return headers.containsKey("content-disposition");
    }

    public String getContentType() {
        return headers.get("content-type");
    }
}
