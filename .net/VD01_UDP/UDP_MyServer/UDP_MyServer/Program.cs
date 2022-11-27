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
                //B4: Gửi nhận gói tin bằng socket
                //B4.1: server nhận gói tin từ client
                byte[] bReceive = new byte[1024];
                EndPoint c_iep = new IPEndPoint(IPAddress.None, 0);
                Console.WriteLine("Cho nhan goi tin tu client");
                serverSocket.ReceiveFrom(bReceive, ref c_iep);

                Console.WriteLine("Nhận gói tin từ client"+ c_iep.ToString() );
                string message = ASCIIEncoding.ASCII.GetString(bReceive);
                Console.WriteLine("<Client>: " + message);
                //B4.2: Xử ls dữ liệu
                string send = message.ToUpper();
                byte[] bSend = ASCIIEncoding.ASCII.GetBytes(send);
                //B4.3: Gửi trả về  cho client
                serverSocket.SendTo(bSend, c_iep);

                //B5: Đóng socket
                serverSocket.Close();

            }
            catch(Exception ex)
            { Console.WriteLine("Loi: " + ex.Message); }
            Console.ReadKey();

        }
    }
}
