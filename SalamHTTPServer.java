import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class SalamHTTPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9090);
        System.out.println("Server started");
        try{
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true){
                String line;
                while(true){
                    line=in.readLine();
                 if(line==null)
                 {
                     System.out.println("line is null");
                     break;
                 }
                 if(line.equals(""))
                     break;
                }
                String response = "<!DOCTYPE html>\n" +
                        "<html>" +
                        "<head>" +
                        "<title>SalamServer</title>"+
                        "<style>" +
                        "h1{border:5px groove red; margin:10px; padding:4px; }" +
                        "</style> </head>" +
                        "<body>" +
                        "<h1>sallam!</h1>\n " +
                        "</body>" +
                        "</html>";
                out.println("HTTP/1.1 200 OK");
                out.println("Date: "+ Calendar.getInstance().getTime());
                out.println("Content-Type: text/html");
                out.println("content-Length: "+ response.length());
                out.println();
                out.println(response);
                out.flush();
            }
        }finally {
            server.close();
        }
    }
}
