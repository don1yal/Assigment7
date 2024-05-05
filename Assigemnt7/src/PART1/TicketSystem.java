package PART1;

import java.util.HashMap;
import java.util.Map;

public class TicketSystem {
    private Map<String, SupportHandler> map;

    public TicketSystem() {
        map = new HashMap<>();
    }
    public void registerHandler(String type, SupportHandler handler) {
        map.put(type,handler);
    }
    public void submitRequest(SupportRequest request) {
        SupportHandler handler = map.get(request.getType());

        if (handler != null) {
            handler.handleRequest(request);
        } else {
            System.out.println("Not Found Handler");
        }
    }
}
