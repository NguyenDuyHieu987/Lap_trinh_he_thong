using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;
using System.Net.Sockets;

namespace TCP_MyClient
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
            try { // B1: Xác định IpEndPoint cửa server
            IPEndPoint s_iep = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 8888);
            //B2: Tạo socket / TCP
            Socket clientsocket = new Socket(SocketType.Stream, ProtocolType.Tcp);
            // B3: Tạo kết nối đến server

            clientsocket.Connect(s_iep);

            Console.WriteLine("Kết nối thành công đến server");
                //B4: Nhân/gửi gói tin qua phiên làm việc (clientsocket)

                //B4.1: Gửi 1 thông điệp lên server

                while (true) {
                    Console.Write("<<Client>>: ");
                    string send = Console.ReadLine();
                    byte[] bSend = new byte[send.Length];
                    bSend = ASCIIEncoding.ASCII.GetBytes(send);

                    clientsocket.Send(bSend);

                    if(send == "thoat")
                    {
                        clientsocket.Close();
                        Console.Write("Đã ngắt kết nối đến server");
                        break;
                    }
                    else
                    {
                        byte[] bReceive = new byte[1024];
                        clientsocket.Receive(bReceive);
                       string message = ASCIIEncoding.ASCII.GetString(TrimEnd(bReceive));
                        Console.WriteLine("                                    "+message + " :<<Server>>" );
                    }
                }
          
            //B4.2: Nhận thông điệp từ server trả về 
      

     

            //B5: Đóng kêt nối
        } catch(Exception ex)
            {
                Console.WriteLine("Loi: "+ex.ToString());
            }

             Console.ReadKey();
        }
    }
}
