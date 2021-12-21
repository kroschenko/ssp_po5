using System;
using System.Collections.Generic;
using System.Text;

namespace lab6._1._9
{
    public abstract class Dish : Product
    {
        private double m_Weight = 0.0;
        private Type m_Type;

        public Dish(double c_Price, string c_Name, double c_Weight, Type c_Type) : base(c_Price, c_Name)
        {
            m_Weight = c_Weight;
            m_Type = c_Type;
        }

        public double f_get_weight()
        {
            return m_Weight;
        }

        public void f_set_wight(double c_Weight)
        {
            m_Weight = c_Weight;
        }

        public Type f_get_type()
        {
            return m_Type;
        }

        public void f_set_type(Type c_Type)
        {
            m_Type = c_Type;
        }

        public enum Type
        {
            BURGER, 
            SALAD
        }
    }
}
