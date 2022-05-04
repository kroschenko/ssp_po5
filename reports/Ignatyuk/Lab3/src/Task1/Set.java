public final class Set {
    private final Integer MAX_POWER;
    private Integer[] base;

    private final void sort() {
        Boolean changed = false;

        for (Integer i = 0, size = this.base.length; i < size; ++i) {
            for (Integer j = 0, k = 1; k < size - i; ++j, ++k) {
                if (this.base[j] > this.base[k]) {
                    changed = true;

                    Integer temp = this.base[j];
                    this.base[j] = this.base[k];
                    this.base[k] = temp;
                }
            }

            if (!changed) {
                return;
            }
        }
    }

    private final Boolean hasSpace() {
        return this.base.length < this.MAX_POWER;
    }

    public Set(final Integer maxPower, final Integer[] base) {
        this.MAX_POWER = maxPower;
        this.base = new Integer[] {};

        for (Integer i = 0, size = base.length; i < size && this.hasSpace(); ++i) {
            this.add(base[i]);
        }

        this.sort();
    }

    public final Boolean equals(final Set other) {
        if (this.base.length != other.base.length) {
            return false;
        }

        for (Integer i = 0, size = this.base.length; i < size; ++i) {
            if (this.base[i] != other.base[i]) {
                return false;
            }
        }

        return true;
    }

    public final String toString() {
        if (this.base.length == 0) {
            return new String();
        }

        final String SEPARATOR = new String(", ");
        String result = new String();

        for (Integer i = 0, size = this.base.length - 1; i < size; ++i) {
            result += Integer.toString(this.base[i]) + SEPARATOR;
        }

        result += Integer.toString(this.base[this.base.length - 1]);
        return result;
    }

    public final void join(final Set other) {
        for (Integer i = 0, size = other.base.length; i < size && this.hasSpace(); ++i) {
            this.add(other.base[i]);
        }

        this.sort();
    }

    public final void print() {
        System.out.println(this.toString());
    }

    public final Boolean isMember(final Integer item) {
        for (Integer i = 0, size = this.base.length; i < size; ++i) {
            if (this.base[i] == item) {
                return true;
            }
        }

        return false;
    }

    public final void add(final Integer item) {
        if (!this.hasSpace()) {
            return;
        }

        if (this.isMember(item)) {
            return;
        }

        Integer[] newBase = new Integer[this.base.length + 1];

        for (Integer i = 0, size = this.base.length; i < size; ++i) {
            newBase[i] = this.base[i];
        }

        newBase[this.base.length] = item;
        this.base = newBase;
        this.sort();
    }

    public final void remove(final Integer item) {
        if (!this.isMember(item)) {
            return;
        }

        Integer[] newBase = new Integer[this.base.length - 1];

        for (Integer i = 0, size = this.base.length; i < size; ++i) {
            if (this.base[i] != item) {
                newBase[i] = this.base[i];
            }
        }

        this.base = newBase;
        this.sort();
    }
}
