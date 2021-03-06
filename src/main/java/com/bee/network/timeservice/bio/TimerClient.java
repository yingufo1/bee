package com.bee.network.timeservice.bio;import java.io.*;import java.net.Socket;/** * 一个基于tcp/ip协议的时间服务客户端，。<br></br> * 使用Socket套接字实现网络通讯，客户端与服务端之间的协议非常简单:客户端可以发送任何内容，服务端接受客户端请求内容，每读取一行，则获取一次当前时间，并返回给客户端 * * @author yangying * @version 1.0 * @since 2022/7/11 **/public class TimerClient implements Runnable{    public static void main(String[] args) {        for(int i=0;i<10;i++){            new Thread(new TimerClient()).start();        }    }    @Override    public void run() {        Socket socket = null;        BufferedReader reader = null;        PrintWriter out = null;        try {            socket = new Socket("127.0.0.1", 8080);            System.out.println(Thread.currentThread().getName()+":connect server");            out = new PrintWriter(socket.getOutputStream(),true);            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));            out.println("what the time now()");            System.out.println(Thread.currentThread().getName()+":waiting for resp");            String resp;            if ((resp = reader.readLine()) != null) {                System.out.println(resp);            }        } catch (IOException e) {            throw new RuntimeException(e);        } finally {            try {                if (reader != null) {                    reader.close();                }                if (out != null) {                    out.close();                }                if (socket != null) {                    socket.close();                }            } catch (IOException e) {                throw new RuntimeException(e);            }        }    }}