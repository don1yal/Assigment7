package PART1;

public class HardwareSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(SupportRequest request) {
        if ("hardware".equals(request.getType()) && request.getPriority() <= 4) {
            System.out.println("Handled by Hardware Support");
        }
        else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
        else {
            System.out.println("Unable to handle");
        }
    }
}
