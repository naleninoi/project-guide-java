package com.project_guide.chapter04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentManagementSystem {

    private final Map<String, Importer> extensionsToImporter = new HashMap<>();

    public DocumentManagementSystem() {
        extensionsToImporter.put("letter", new ImageImporter());
        extensionsToImporter.put("report", new ImageImporter());
        extensionsToImporter.put("jpg", new ImageImporter());
    }

    public void importFile(String path) {
    }

    public List<Document> contents() {
        return new ArrayList<>();
    }

}
