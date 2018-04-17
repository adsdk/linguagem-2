package br.com.ulbra;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorPrincipal implements Serializable {

    public static List<UsuarioListener> USUARIOS_CONECTADOS = new ArrayList<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket;
        int porta = 8976;

        System.out.println("Iniciando servidor na porta " + porta);
        serverSocket = new ServerSocket(porta, 100);

        while (true) {
            System.out.println("Aguardando conexao...");
            Socket socket = serverSocket.accept();

            System.out.println("Conexao estabelecida...");

            System.out.println("Iniciando thread para tratar requisicao...");
            ControladorConexao controladorConexao = new ControladorConexao(socket);
            Usuario usuario = new Usuario(controladorConexao);
            UsuarioListener listener = new UsuarioListener(usuario);
            USUARIOS_CONECTADOS.add(listener);
            listener.start();
        }
    }

}
