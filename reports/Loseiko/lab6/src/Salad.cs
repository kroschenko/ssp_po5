using System;
using System.Collections.Generic;
using System.Text;

namespace lab6._1._9
{
    public class Salad : Dish
    {
        private SaladType m_SaladType;

        public Salad(double c_Price, string c_Name, double c_Weight, SaladType c_SaladType) : base(c_Price, c_Name, c_Weight, Dish.Type.SALAD)
        {
            m_SaladType = c_SaladType;
        }

        public SaladType f_get_salad_type()
        {
            return m_SaladType;
        }

        public void f_set_salad_type(SaladType c_SaladType)
        {
            m_SaladType = c_SaladType;
        }

        public enum SaladType
        {
            VEGETABLE, 
            SEAFOOD
        }
    }
}
