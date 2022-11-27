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
        static void Main(string[] args)
        {
            try {


                //B1: Tạo IpEndPoint cửa server
                IPEndPoint s_iep = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 8888);
                // B2: tạo socket

                Socket clientSocket = new Socket(SocketType.Dgram, ProtocolType.Udp);

                //B3: Gửi/ nhận gói tin  với socket
                //B3.1: Tạo gói tin
                string send = "hello server";
                byte[] bSend = ASCIIEncoding.ASCII.GetBytes(send);
                clientSocket.SendTo(bSend, s_iep);
                Console.WriteLine("Gói tin đã được gửi đi");
                //B3.2: Nhận gói tin từ server
                byte[] bReceive = new byte[1024];
                EndPoint iep = new IPEndPoint(IPAddress.None, 0);
                clientSocket.ReceiveFrom(bReceive, ref iep);
                string message = ASCIIEncoding.ASCII.GetString(bReceive);

                Console.WriteLine("<Server>: "+message);

                //B4 Đóng client 
                clientSocket.Close();
            


            } catch (Exception ex)
            { Console.WriteLine("Loi: " + ex.Message); }
            Console.ReadKey();
        }
    }
}
