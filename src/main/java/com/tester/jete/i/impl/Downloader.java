package com.tester.jete.i.impl;

import com.tester.jete.i.Config;
import java.io.File;

/**
 * @ClassName Downloader
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 18:08
 */
public class Downloader {
    private final Randomizer random;

    public Downloader() {
        this(new Randomizer());
    }

    public Downloader(Randomizer random) {
        this.random = random;
    }

    public String randomFileName() {
        return random.text();
    }

    public File prepareTargetFile(Config config, String fileName) {
        File uniqueFolder = new File(config.downloadsFolder(), random.text());
        if (uniqueFolder.exists()) {
            throw new IllegalStateException("Unbelievable! Unique folder already exists: " + uniqueFolder.getAbsolutePath());
        }
        if (!uniqueFolder.mkdirs()) {
            throw new RuntimeException("Failed to create folder " + uniqueFolder.getAbsolutePath());
        }

        return new File(uniqueFolder, fileName);
    }
}
