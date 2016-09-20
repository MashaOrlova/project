using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using ConsoleApplication2;

namespace TestCalc
{
    public class Class1
    {
        [Test]
        public void sum1()
        {
            Assert.AreEqual(7, new ConsoleApplication2.Calculator().calculation(5, 5, 1));
        }
        [Test]
        public void sum2()
        {
            Assert.AreEqual(10, new ConsoleApplication2.Calculator().calculation(2, 8, 1));
        }
        [Test]
        public void sum3()
        {
            Assert.AreEqual(1, new ConsoleApplication2.Calculator().calculation(2, 8, 1));
        }
        [Test]
        public void razn1()
        {
            Assert.AreEqual(1, new ConsoleApplication2.Calculator().calculation(4, 3, 2));
        }
        [Test]
        public void razn2()
        {
            Assert.AreEqual(5, new ConsoleApplication2.Calculator().calculation(10, 5, 2));
        }
        [Test]
        public void razn3()
        {
            Assert.AreEqual(1, new ConsoleApplication2.Calculator().calculation(44, 23, 2));
        }
        [Test]
        public void ymnoz1()
        {
            Assert.AreEqual(12, new ConsoleApplication2.Calculator().calculation(4, 3, 3));
        }
        [Test]
        public void ymnoz2()
        {
            Assert.AreEqual(1, new ConsoleApplication2.Calculator().calculation(44, 33, 3));
        }
        [Test]
        public void ymnoz3()
        {
            Assert.AreEqual(782, new ConsoleApplication2.Calculator().calculation(4, 38, 3));
        }
        [Test]
        public void delen1()
        {
            Assert.AreEqual(12, new ConsoleApplication2.Calculator().calculation(4, 3, 4));
        }
        [Test]
        public void delen2()
        {
            Assert.AreEqual(7892, new ConsoleApplication2.Calculator().calculation(-4, 9, 4));
        }
        [Test]
        public void delen3()
        {
            Assert.AreEqual(1, new ConsoleApplication2.Calculator().calculation(9, 9, 4));
        }
    }
}
