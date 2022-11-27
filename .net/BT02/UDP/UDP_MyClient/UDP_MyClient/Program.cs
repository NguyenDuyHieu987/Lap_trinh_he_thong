using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;
using System.Net.Sockets;

namespace UDP_MyClient
{
    internal class Program
    {
        public static byte[] TrimEnd(byte[] array)
        {
            int lastIndex = Array.FindLastIndex(array, b => b != 0);

            Array.Resize(ref array, lastIndex + 1);

            return array;
        }
        static void Main(string[] args)
        {
            try
            {
                //B1: Tạo IpEndPoint cửa server
                IPEndPoint s_iep = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 8888);
                // B2: tạo socket

                Socket clientSocket = new Socket(SocketType.Dgram, ProtocolType.Udp);
                //B3: Gửi/ nhận gói tin  với socket
                //B3.1: Tạo gói tin

                while (true)
                {
                    Console.Write("<<Client>>: ");
                    string send = Console.ReadLine();
                    byte[] bSend = new byte[send.Length];
                    bSend = ASCIIEncoding.ASCII.GetBytes(send);

                    clientSocket.SendTo(bSend, s_iep);


                    if (send == "thoat")
                    {
                        clientSocket.Close();
                        Console.Write("Đã ngắt kết nối đến server");
                        break;
                    }
                    else
                    {
                        byte[] bReceive = new byte[1024];
                        EndPoint iep = new IPEndPoint(IPAddress.None, 0);
                        clientSocket.ReceiveFrom(bReceive, ref iep);
                        string message = ASCIIEncoding.ASCII.GetString(TrimEnd(bReceive));
                        Console.WriteLine("                                    " + message + " :<<Server>>");
                    }
                }

           

                //B4 Đóng client 



            }
            catch (Exception ex)
            { Console.WriteLine("Loi: " + ex.Message); }
            Console.ReadKey();
        }
    }
}
