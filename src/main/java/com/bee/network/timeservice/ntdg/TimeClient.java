package com.bee.network.timeservice.ntdg;/** * TODO:class description * * @author yangying * @version 1.0 * @since 2022/7/12 **/public class TimeClient {    public static void main(String[] args) {        new Thread(new TimeClientHandler(8080)).start();    }}