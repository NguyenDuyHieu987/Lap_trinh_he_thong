using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;
using System.Net.Sockets;

namespace UDP_MyServer
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
                //B1: Tạo IpEndPoint của client
                IPEndPoint s_iep = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 8888);
                // B2: tạo socket

                Socket serverSocket = new Socket(SocketType.Dgram, ProtocolType.Udp);
                //B3: Đăng ký sử dụng s_iep cho serverSocket bằng bind
                serverSocket.Bind(s_iep);
                Console.WriteLine("Cho nhan goi tin tu client");

                //B4: Gửi nhận gói tin bằng socket
                //B4.1: server nhận gói tin từ client
                while (true)
                {
                    byte[] bReceive = new byte[1024];
                    EndPoint c_iep = new IPEndPoint(IPAddress.None, 0);
                    serverSocket.ReceiveFrom(bReceive, ref c_iep);
                    string message = ASCIIEncoding.ASCII.GetString(TrimEnd(bReceive));

                    Console.WriteLine("                                   " + message + " :<<Client>>");
                    if (message == "thoat")
                    {
                        serverSocket.Close();
                        Console.WriteLine("Client đã ngắt kết nối");
                        break;
                    }
                    else
                    {
                        //B5.2: Xử lý dữ liệu
                        Console.Write("<<Server>>: ");
                        string send = Console.ReadLine();
                        //B5.3: Gửi trả về cho client
                        byte[] bsend = new byte[send.Length];
                        bsend = ASCIIEncoding.ASCII.GetBytes(send);
                        serverSocket.SendTo(bsend, c_iep);
                   
                    }
                }

    

        

          

            }
            catch (Exception ex)
            { Console.WriteLine("Loi: " + ex.Message); }
            Console.ReadKey();
        }
    }
}
