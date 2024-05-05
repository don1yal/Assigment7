package PART1;

public class SoftwareSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(SupportRequest request) {
        if ("software".equals(request.getType()) && request.getPriority() <= 5) {
            System.out.println("Handled by Software Support");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("Unable to handle");
        }
    }
}
