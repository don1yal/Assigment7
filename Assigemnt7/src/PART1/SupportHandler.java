package PART1;

public interface SupportHandler {
    void setNextHandler(SupportHandler handler);
    void handleRequest(SupportRequest request);
}
