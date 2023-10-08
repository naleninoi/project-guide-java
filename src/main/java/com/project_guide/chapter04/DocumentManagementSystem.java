package com.project_guide.chapter04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentManagementSystem {

    private final Map<String, Importer> extensionsToImporter = new HashMap<>();

    private final List<Document> documents = new ArrayList<>();

    public DocumentManagementSystem() {
        extensionsToImporter.put("letter", new ImageImporter());
        extensionsToImporter.put("report", new ImageImporter());
        extensionsToImporter.put("jpg", new ImageImporter());
    }

    public void importFile(final String path) throws IOException {
        final File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException(path);
        }

        final int separatorIndex = path.lastIndexOf('.');
        if (separatorIndex != -1) {
            if (separatorIndex == path.length()) {
                throw new UnknownFileTypeException("No extension found for file: " + path);
            }
            final String extension = path.substring(separatorIndex + 1);
            final Importer importer = extensionsToImporter.get(extension);
            if (importer == null) {
                throw new UnknownFileTypeException("Cannot import files with extension: " + extension);
            }
            final Document document = importer.importFile(file);
            documents.add(document);
        } else {
            throw new UnknownFileTypeException("No extension found for file: " + path);
        }
    }

    public List<Document> contents() {
        return new ArrayList<>();
    }

}
