using System;
using System.Collections.Generic;
using System.Text;

namespace lab6._1._9
{
    public abstract class Drink : Product
    {
        private double m_Volume = 0.0;
        private Type m_Type;

        public Drink(double c_Price, string c_Name, double c_Volume, Type c_Type) : base(c_Price, c_Name)
        {
            m_Volume = c_Volume;
            m_Type = c_Type;
        }

        public double f_get_volume()
        {
            return m_Volume;
        }

        public void f_set_volume(double c_Volume)
        {
            m_Volume = c_Volume;
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
            HOT, 
            COLD
        }
    }
}
