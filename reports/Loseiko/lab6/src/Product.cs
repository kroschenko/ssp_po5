using System;
using System.Collections.Generic;
using System.Text;

namespace lab6._1._9
{
    public abstract class Product
    {
        private double m_Price = 0.0;
        private string m_Name = "";

        public Product(double c_Price, string c_Name)
        {
            m_Price = c_Price;
            m_Name = c_Name;
        }

        public double f_get_price()
        {
            return m_Price;
        }

        public void f_set_price(double c_Price)
        {
            m_Price = c_Price;
        }

        public string f_get_name()
        {
            return m_Name;
        }

        public void f_set_name(string c_Name)
        {
            m_Name = c_Name;
        }
    }
}