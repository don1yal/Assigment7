package PART1;

public class Test {
    public static void main(String[] args) {
        TicketSystem ticketingSystem = new TicketSystem();
        SupportHandler baseHandler = new BaseSupportHandler();
        SupportHandler hardwareHandler = new HardwareSupportHandler();
        SupportHandler softwareHandler = new SoftwareSupportHandler();
        SupportHandler networkHandler = new NetworkSupportHandler();

        baseHandler.setNextHandler(hardwareHandler);
        hardwareHandler.setNextHandler(softwareHandler);
        softwareHandler.setNextHandler(networkHandler);

        ticketingSystem.registerHandler("base", baseHandler);
        ticketingSystem.registerHandler("hardware", hardwareHandler);
        ticketingSystem.registerHandler("software", softwareHandler);
        ticketingSystem.registerHandler("network", networkHandler);

        SupportRequest hardwareRequest = new SupportRequest("1", "Hardware issue", 2, "hardware");
        SupportRequest softwareRequest = new SupportRequest("2", "Software issue", 4, "software");
        SupportRequest networkRequest = new SupportRequest("3", "Network issue", 6, "network");

        ticketingSystem.submitRequest(hardwareRequest);
        ticketingSystem.submitRequest(softwareRequest);
        ticketingSystem.submitRequest(networkRequest);
    }
}
