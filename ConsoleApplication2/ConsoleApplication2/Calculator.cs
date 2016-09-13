using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication2
{
    public class Calculator
    {
        public double calculation(double operant1, double operant2, int operations)
        {
                if (operations == 1)
                {
                    return operant1 + operant2;
                }
                else if (operations == 2)
                {
                    return operant1 - operant2;
                }
                else if (operations == 3)
                {
                    return operant1 * operant2;
                }
                else if (operations == 4)
                {
                    return operant1 / operant2;
                }
                else
                     Console.WriteLine("Ошибка");
            return 0;           
        }
    }
}
