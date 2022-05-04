package build;

public final class Order {
    final private Dish m_Dish;
    final private Drink m_Drink;

    final private Double m_PackPrice;
    final private Boolean m_NeedToPack;

    final private Double m_TotalPrice;

    public Order(final Builder c_Builder) {
        this.m_Dish = c_Builder.m_Dish;
        this.m_Drink = c_Builder.m_Drink;
        this.m_PackPrice = c_Builder.m_PackPrice;
        this.m_NeedToPack = c_Builder.m_NeedToPack;
        this.m_TotalPrice = c_Builder.m_TotalPrice;
    }

    public final Dish f_get_dish() {
        return this.m_Dish;
    }

    public final Drink f_get_drink() {
        return this.m_Drink;
    }

    public final Double f_get_pack_price() {
        return this.m_PackPrice;
    }

    public final Boolean f_get_need_to_pack() {
        return this.m_NeedToPack;
    }

    public final Double f_get_total_price() {
        return this.m_TotalPrice;
    }

    public static class Builder {
        private Dish m_Dish = null;
        private Drink m_Drink = null;

        private Double m_PackPrice = 0.0;
        private Boolean m_NeedToPack = Boolean.FALSE;

        private Double m_TotalPrice = 0.0;

        public static Builder f_new_instance() {
            return new Builder();
        }

        private Builder() {
        }

        public final void f_set_dish(final Dish c_Dish) {
            this.m_Dish = c_Dish;
            this.m_TotalPrice = this.f_total_price();
        }

        public final void f_set_drink(final Drink c_Drink) {
            this.m_Drink = c_Drink;
            this.m_TotalPrice = this.f_total_price();
        }

        public final void f_set_pack_price(final Double c_PackPrice) {
            this.m_PackPrice = c_PackPrice;
            this.m_TotalPrice = this.f_total_price();
        }

        public final void f_set_need_to_pack(final Boolean c_NeedToPack) {
            this.m_NeedToPack = c_NeedToPack;
            this.m_TotalPrice = this.f_total_price();
        }

        private final Double f_total_price() {
            Double v_TotalPrice = 0.0;

            if (this.m_Dish != null) {
                v_TotalPrice += this.m_Dish.f_get_price();
            }

            if (this.m_Drink != null) {
                v_TotalPrice += this.m_Drink.f_get_price();
            }

            if (this.m_NeedToPack) {
                v_TotalPrice += this.m_PackPrice;
            }

            return v_TotalPrice;
        }

        public final Order f_build() {
            return new Order(this);
        }
    }
}
