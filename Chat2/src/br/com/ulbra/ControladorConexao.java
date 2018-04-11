package br.com.ulbra;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ControladorConexao {

    private final Socket socket;
    private final Scanner input;
    private final PrintWriter output;
    private boolean conectionOpen;

    public ControladorConexao(Socket socket) throws IOException {
        this.socket = socket;
        this.input = new Scanner(this.socket.getInputStream());
        this.output = new PrintWriter(this.socket.getOutputStream());
        this.conectionOpen = true;
    }

    public Socket getSocket() {
        return socket;
    }

    public Scanner getInput() {
        return input;
    }

    public PrintWriter getOutput() {
        return output;
    }

    public boolean enviar(String msg) throws IOException {
        if (isConectionOpen()) {
            output.println(msg);
            output.flush();
        }
        return true;
    }

    public String receber() {
        if (isConectionOpen()) {
            return input.nextLine();
        }
        return null;
    }

    public void close() throws IOException {
        this.conectionOpen = false;
        this.output.close();
        this.input.close();
        this.socket.close();
    }

    public boolean isConectionOpen() {
        return conectionOpen;
    }
}
