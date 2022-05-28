using System;
using System.Collections.Generic;
using System.Text;

namespace lab6._1._9
{
    public class ColdDrink : Drink
    {
        private ColdDrinkType m_ColdDrinkType;

        public ColdDrink(double c_Price, string c_Name, double c_Volume, ColdDrinkType c_ColdDrinkType) : base(c_Price, c_Name, c_Volume, Drink.Type.HOT)
        {
            m_ColdDrinkType = c_ColdDrinkType;
        }

        public ColdDrinkType f_get_cold_drink_type()
        {
            return m_ColdDrinkType;
        }

        public void f_set_cold_drink_type(ColdDrinkType c_ColdDrinkType)
        {
            m_ColdDrinkType = c_ColdDrinkType;
        }

        public enum ColdDrinkType
        {
            COLA, 
            PEPSI
        }
    }
}
