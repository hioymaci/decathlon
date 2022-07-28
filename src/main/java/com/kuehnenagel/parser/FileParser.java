package com.kuehnenagel.parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileParser {

    List<String[]> parseFile(File file) throws IOException;

}
