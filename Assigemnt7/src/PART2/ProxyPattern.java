package PART2;

import java.util.HashMap;

public class ProxyPattern {
    public static void main(String[] args) {
        DocumentStorage realDocumentStorage = new MockDocumentStorage();
        DocumentStorage proxy = new DocumentStorageProxy(realDocumentStorage);

        User user = new User();
        user.setUsername("user1");
        user.setPassword("password123");
        user.setRole("admin");

        ((DocumentStorageProxy) proxy).setCurrentUser(user);

        testDocumentOperations(proxy);
    }
    public static void testDocumentOperations(DocumentStorage proxy) {
        Document document = new Document("doc1", "Document Title", "John Doe", "Document content");
        proxy.uploadDocument(document);
        System.out.println("Document uploaded successfully.");

        Document downloadedDocument = proxy.downloadDocument("doc1");
        if (downloadedDocument != null) {
            System.out.println("Downloaded document: " + downloadedDocument.getTitle());
        } else {
            System.out.println("Document not found.");
        }

        proxy.editDocument("doc1", "Updated document content");
        System.out.println("Document edited successfully.");

         proxy.deleteDocument("doc1");
        System.out.println("Document deleted successfully.");

        HashMap<String, Document> searchResults = proxy.searchDocuments("keyword");
        if (searchResults != null) {
            System.out.println("Search results: " + searchResults.size());
        } else {
            System.out.println("No search results found.");
        }
    }
}