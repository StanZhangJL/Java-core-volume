package day7.eums;

public enum LogLevel {
    DEBUG(1, "Debug level"),
    INFO(2, "Info level"),
    WARN(3, "Warn level"),
    ERROR(4, "Error level");

    private final int level;
    private final String description;

    private LogLevel(int level, String description){
        this.level = level;
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }
}
