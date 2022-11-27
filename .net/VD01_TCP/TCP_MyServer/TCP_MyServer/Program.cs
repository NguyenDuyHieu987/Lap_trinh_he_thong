using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Sockets;
using System.Net;

namespace TCP_MyServer
{
    internal class Program
    {
        static void Main(string[] args)
        {
            try

            {
                // B1: Khởi tạo IpEndPoint

                IPEndPoint s_iep = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 8888);
                //B2: Tạo Socket / TCP
                Socket serversocket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
                //B2: Đăng ký s_iep cho serversocket thông qua phương thức bind
                serversocket.Bind(s_iep);
                // B 4: Chờ kết nối từ client
                Console.WriteLine("Chờ kết nối từ client");
                serversocket.Listen(10);
                Socket clientSocket =serversocket.Accept();

                Console.WriteLine("Két nối thành công đến client: " + clientSocket.RemoteEndPoint.ToString());

                //B5: Nhận/gửi gói tin qua phiên làm việc (clientSocket)
                //B5.1: Nhận gói tin từ client gửi lên
                byte[] bReceive = new byte[1024];
                clientSocket.Receive(bReceive);
                string message = ASCIIEncoding.ASCII.GetString(bReceive);

                Console.WriteLine("<Client>: "+message);
                //B5.2: Xử lý dữ liệu
                string send = message.ToUpper();
                //B5.3: Gửi trả về cho client
                byte[] bsend = ASCIIEncoding.ASCII.GetBytes(send);
                clientSocket.Send(bsend);


                // B5: Đóng kết nối
                clientSocket.Close();
                serversocket.Close();

            }
            catch (Exception ex)
            {
                Console.WriteLine("Loi: " + ex.ToString());
            }
            Console.ReadKey();

        }
    }
}
