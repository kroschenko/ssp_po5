using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace prikol1
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form1 frm = new Form1();
            if (textBox1.Text == "" || textBox2.Text == "" || textBox3.Text == "" || textBox4.Text == "")
            {
                MessageBox.Show("Заполните все поля!");
            }
            else if(int.TryParse(textBox1.Text, out int number1) || int.TryParse(textBox2.Text, out int number2)||
                int.TryParse(textBox3.Text, out int number3)|| int.TryParse(textBox4.Text, out int number4))
            {
                frm.Set(number1, 90, 200, 700);
                frm.Show();
            }
            else
            {
                MessageBox.Show("Заполните все поля цифрами!");
            }



        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form3 frm = new Form3();
            frm.Show();
        }

    }
}
