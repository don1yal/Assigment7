package PART1;

public class SupportRequest {
    private String id;
    private String description;
    private int priority;
    private String type;

    public SupportRequest(String id, String description, int priority, String type) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
