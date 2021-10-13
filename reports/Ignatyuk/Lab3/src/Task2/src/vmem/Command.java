package vmem;

public final class Command implements java.io.Serializable {
    private String name = null;
    private Integer paramsCount = null;

    public Command(final String name, final Integer paramsCount) {
        this.name = new String(name);
        this.paramsCount = paramsCount;
    }

    public final String getName() {
        return new String(this.name);
    }

    public final void setName(final String name) {
        this.name = new String(name);
    }

    public final Integer getParamsCount() {
        return this.paramsCount;
    }

    public final void setParamsCount(final Integer paramsCount) {
        this.paramsCount = paramsCount;
    }
}
