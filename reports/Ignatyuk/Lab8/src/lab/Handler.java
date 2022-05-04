package lab;

public final class Handler {
    private Row row;
    private Thread thread;

    private final boolean isSet() {
        return this.row != null && this.thread != null;
    }

    public Handler() {
        this.row = null;
        this.thread = null;
    }

    public final void start() {
        if (this.isSet()) {
            this.thread.start();
        }
    }

    public final void stop() {
        if (this.isSet()) {
            this.row.stop();
        }
    }

    public final void resume() {
        if (this.isSet()) {
            this.row.start();
        }
    }

    public final void interrupt() {
        if (this.isSet()) {
            this.thread.interrupt();
        }
    }

    public final void setRow(final Row row) {
        if (this.isSet()) {
            this.interrupt();
        }

        this.row = row;
        this.thread = new Thread(this.row);
    }
}
