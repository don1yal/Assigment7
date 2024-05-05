package PART1;

public class NetworkSupportHandler implements SupportHandler{
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(SupportRequest request) {
        if ("network".equals(request.getType()) && request.getPriority() <= 8) {
            System.out.println("Handled by Network Support");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("Unable to handle");
        }
    }
}
