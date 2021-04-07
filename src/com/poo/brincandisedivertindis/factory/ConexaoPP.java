package com.poo.brincandisedivertindis.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoPP {
    private static String HOST = "localhost";
    private static String DATABASE = "estacionamento";
    private static String USER = "root";
    private static String PASSWORD = "sft6033";
    private static String PORT = "3306";
    private static String URL_DATABASE = "";

    public static Connection ConectarBD() throws Exception{
        URL_DATABASE = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL_DATABASE, USER, PASSWORD);

        return connection;
    }
}
