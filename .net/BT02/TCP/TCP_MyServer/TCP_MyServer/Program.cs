using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;
using System.Net.Sockets;

namespace TCP_MyServer
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
                IPEndPoint s_iep = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 8888);
                //B2: Tạo Socket / TCP
                Socket serversocket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
                //B2: Đăng ký s_iep cho serversocket thông qua phương thức bind
                serversocket.Bind(s_iep);
                // B 4: Chờ kết nối từ client
                Console.WriteLine("Chờ kết nối từ client");
                serversocket.Listen(10);
                Socket clientSocket = serversocket.Accept();

                Console.WriteLine("Két nối thành công đến client: " + clientSocket.RemoteEndPoint.ToString());

                //B5: Nhận/gửi gói tin qua phiên làm việc (clientSocket)
                //B5.1: Nhận gói tin từ client gửi lên
                while (true)
                {
                    byte[] bReceive = new byte[1024];
                    clientSocket.Receive(bReceive);
                    string message = ASCIIEncoding.ASCII.GetString(TrimEnd(bReceive));
                    Console.WriteLine("                                   " + message+ " :<<Client>>" );
                    if (message == "thoat")
                    {
                        clientSocket.Close();
                        serversocket.Close();
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

                        clientSocket.Send(bsend);
                    }
                }



                // B5: Đóng kết nối

            }
            catch (Exception ex)
            {
                Console.WriteLine("Loi: " + ex.Message);
            }
        }
    }
}
