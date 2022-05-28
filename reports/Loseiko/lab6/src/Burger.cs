using System;
using System.Collections.Generic;
using System.Text;

namespace lab6._1._9
{
    public class Burger : Dish
    {
        private BurgerType m_BurgerType;

        public Burger(double c_Price, string c_Name, double c_Weight, BurgerType c_BurgerType) : base(c_Price, c_Name, c_Weight, Dish.Type.BURGER)
        {
            m_BurgerType = c_BurgerType;
        }

        public BurgerType f_get_burger_type()
        {
            return m_BurgerType;
        }

        public void f_set_burger_type(BurgerType c_BurgerType)
        {
            m_BurgerType = c_BurgerType;
        }

        public enum BurgerType
        {
            VEGAN, 
            CHICKEN
        }
    }
}
