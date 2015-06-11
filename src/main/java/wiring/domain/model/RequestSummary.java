package wiring.domain.model;

public class RequestSummary {
    private int sessionCounter;
    private int globalCounter;

    public RequestSummary(int sessionCounter, int globalCounter) {
        this.sessionCounter = sessionCounter;
        this.globalCounter = globalCounter;
    }

    public int getSessionCounter() {
        return sessionCounter;
    }

    public void setSessionCounter(int sessionCounter) {
        this.sessionCounter = sessionCounter;
    }

    public int getGlobalCounter() {
        return globalCounter;
    }

    public void setGlobalCounter(int globalCounter) {
        this.globalCounter = globalCounter;
    }
}
