using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
namespace VD1___multithread
{
    internal class Program
    {

        public static string message ="";
        public static bool check_changed = false;
        public static void getData()
        {
            do
            {
                message = Console.ReadLine();
                check_changed = true;

            } while (message.ToLower() != "thoat");
        }

        public static void showData()
        {
            while(message.ToLower() != "thoat"){
                if(check_changed == true)
                {
                    Console.WriteLine("Message: " + message);
                    check_changed = false;
                }
                Thread.Sleep(100);// ngủ tạm thời thread 2 để trình chiếu tài nguyên
            }


        }
        static void Main(string[] args)
        {

            Thread t1 = new Thread(new ThreadStart(getData));
            Thread t2 = new Thread(new ThreadStart(showData));

            t1.Start();
            t2.Start();

        }
    }
}
