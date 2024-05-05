package PART1;

public class BaseSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(SupportRequest request) {
        System.out.println("Handled request by Base Support");
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }


}
