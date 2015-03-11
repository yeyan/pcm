package com.github.pcm.filesystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ye Yan on 3/11/2015.
 */

@Component
public class Scanner {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostConstruct
    void init() {
        logger.debug("************************");

        File x = new File(".");

        try {
            Files.walkFileTree(Paths.get("."), new Tester());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected class Tester extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            logger.debug("file = {}", file);

            return FileVisitResult.CONTINUE;
        }
    }

}
