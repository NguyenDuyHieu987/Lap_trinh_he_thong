using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Sockets;
using System.Net;

namespace TCP_VD1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            try {

                // B1: Xác định IpEndPoint cửa server
                IPEndPoint s_iep = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 8888);
                //B2: Tạo socket / TCP
                Socket clientsocket = new Socket(SocketType.Stream, ProtocolType.Tcp);
                // B3: Tạo kết nối đến server

                clientsocket.Connect(s_iep);

                Console.WriteLine("Kết nối thành công đến server");
                //B4: Nhân/gửi gói tin qua phiên làm việc (clientsocket)

                //B4.1: Gửi 1 thông điệp lên server
                string send = "hello server";
                byte[] bSend = ASCIIEncoding.ASCII.GetBytes(send);
                clientsocket.Send(bSend);
                //B4.2: Nhận thông điệp từ server trả về 
                byte[] bReceive = new byte[1024];
                clientsocket.Receive(bReceive);

                string message = ASCIIEncoding.ASCII.GetString(bReceive);
                Console.WriteLine("<Server>: " + message);

                //B5: Đóng kêt nối
                clientsocket.Close();
            } catch(Exception ex)
            {
                Console.WriteLine("Loi: "+ex.ToString());
            }

            Console.ReadKey();
          
        }
    }
}
