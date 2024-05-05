package PART2;

import java.util.HashMap;

public class MockDocumentStorage implements DocumentStorage {
    private HashMap<String, Document> documents = new HashMap<>();

    @Override
    public void uploadDocument(Document document) {
        documents.put(document.getId(), document);
    }

    @Override
    public Document downloadDocument(String documentId) {
        return documents.get(documentId);
    }

    @Override
    public void editDocument(String documentId, String content) {
        Document document = documents.get(documentId);
        if (document != null) {
            document.setContent(content);
        }
    }

    @Override
    public void deleteDocument(String documentId) {
        documents.remove(documentId);
    }

    @Override
    public HashMap<String, Document> searchDocuments(String query) {
        HashMap<String, Document> searchResults = new HashMap<>();
        for (Document document : documents.values()) {
            if (document.getTitle().contains(query) || document.getContent().contains(query)) {
                searchResults.put(document.getId(), document);
            }
        }
        return searchResults;
    }
}
