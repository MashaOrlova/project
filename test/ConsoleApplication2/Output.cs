using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication2
{
    public class Output
    {
        public void vivod()
        {
            Calculator calcul = new Calculator();
            int operations;
            double operant1;
            double operant2;
            double answer;

            Console.WriteLine("Hello! This is Kalculator");

            Console.WriteLine("Введите первое число:");
            operant1 = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("Выберите нужное действие: + (1), - (2), * (3), / (4)");
            operations = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Введите второе число:");
            operant2 = Convert.ToDouble(Console.ReadLine());
                       
            answer = calcul.calculation(operant1, operant2, operations);
            Console.WriteLine("Результат вычисления: {0}", answer);           
        }
        
    }
}
