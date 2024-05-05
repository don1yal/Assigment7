package PART2;

import java.util.HashMap;

public interface DocumentStorage {
    void uploadDocument(Document document);
    Document downloadDocument(String documentId);
    void editDocument(String documentId, String content);
    void deleteDocument(String documentId);
    HashMap<String, Document> searchDocuments(String query);
}
