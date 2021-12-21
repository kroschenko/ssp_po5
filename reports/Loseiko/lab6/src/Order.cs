using System;
using System.Collections.Generic;
using System.Text;

namespace lab6._1._9
{
    public class Order
    {
        private Dish m_Dish;
        private Drink m_Drink;

        private double m_PackPrice;
        private bool m_NeedToPack;

        private double m_TotalPrice;

        public Order(Builder c_Builder)
        {
            m_Dish = c_Builder.m_Dish;
            m_Drink = c_Builder.m_Drink;
            m_PackPrice = c_Builder.m_PackPrice;
            m_NeedToPack = c_Builder.m_NeedToPack;
            m_TotalPrice = c_Builder.m_TotalPrice;
        }
        Builder builder = new Builder();

        public Dish f_get_dish()
        {
            return m_Dish;
        }

        public Drink f_get_drink()
        {
            return m_Drink;
        }

        public double f_get_pack_price()
        {
            return m_PackPrice;
        }

        public bool f_get_need_to_pack()
        {
            return m_NeedToPack;
        }

        public double f_get_total_price()
        {
            return m_TotalPrice;
        }

        public class Builder
        {
            public Dish m_Dish = null;
            public Drink m_Drink = null;

            public double m_PackPrice = 0.0;
            public bool m_NeedToPack = false;

            public double m_TotalPrice = 0.0;

            public static Builder f_new_instance()
            {
                return new Builder();
            }

            public Builder()
            {
            }

            public void f_set_dish(Dish c_Dish)
            {
                m_Dish = c_Dish;
                m_TotalPrice = f_total_price();
            }

            public void f_set_drink(Drink c_Drink)
            {
                m_Drink = c_Drink;
                m_TotalPrice = f_total_price();
            }

            public void f_set_pack_price(double c_PackPrice)
            {
                m_PackPrice = c_PackPrice;
                m_TotalPrice = f_total_price();
            }

            public void f_set_need_to_pack(bool c_NeedToPack)
            {
                m_NeedToPack = c_NeedToPack;
                m_TotalPrice = f_total_price();
            }

            public double f_total_price()
            {
                double v_TotalPrice = 0.0;

                if (m_Dish != null)
                {
                    v_TotalPrice += m_Dish.f_get_price();
                }

                if (m_Drink != null)
                {
                    v_TotalPrice += m_Drink.f_get_price();
                }

                if (m_NeedToPack)
                {
                    v_TotalPrice += m_PackPrice;
                }

                return v_TotalPrice;
            }

            public Order f_build()
            {
                return new Order(this);
            }
        }
    }
}