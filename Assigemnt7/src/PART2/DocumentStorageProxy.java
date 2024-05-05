package PART2;

import java.util.HashMap;

public class DocumentStorageProxy implements DocumentStorage {
    private DocumentStorage documentStorage;
    private User currentUser;

    public DocumentStorageProxy(DocumentStorage documentStorage) {
        this.documentStorage = documentStorage;
    }

    private boolean authenticateUser(User user) {
        if (user != null) return true;
         else return false;
    }
    private void manageSession(User user) {
        if (user != null)  System.out.println("Session managed for user: " + user.getUsername());
        else System.out.println("Invalid user for session management.");
    }
    private Document filterDocument(Document document, User user) {
        if (user != null)  return document;
         else {
            System.out.println("Invalid user for document filtering.");
            return null;
        }
    }

    private void logActivity(User user, String action) {
        if (user != null) {
            System.out.println("User '" + user.getUsername() + "' performed action: " + action);
        } else {
            System.out.println("Invalid user for activity logging.");
        }
    }

    @Override
    public void uploadDocument(Document document) {
        if (authenticateUser(null)) {
            manageSession(null);
            Document filteredDocument = filterDocument(document, null);
            logActivity(null, "Upload");
            documentStorage.uploadDocument(filteredDocument);
        }
    }

    @Override
    public Document downloadDocument(String documentId) {
        if (authenticateUser(null)) {
            manageSession(null);
            logActivity(null, "Download");
            return documentStorage.downloadDocument(documentId);
        }
        return null;
    }
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    @Override
    public void editDocument(String documentId, String content) {
        if (authenticateUser(null)) {
            manageSession(null);
            logActivity(null, "Edit");
            documentStorage.editDocument(documentId, content);
        }
    }

    @Override
    public void deleteDocument(String documentId) {
        if (authenticateUser(null)) {
            manageSession(null);
            logActivity(null, "Delete");
            documentStorage.deleteDocument(documentId);
        }
    }

    @Override
    public HashMap<String, Document> searchDocuments(String query) {
        if (authenticateUser(null)) {
            manageSession(null);
            logActivity(null, "Search");
            return documentStorage.searchDocuments(query);
        }
        return null;
    }
}
