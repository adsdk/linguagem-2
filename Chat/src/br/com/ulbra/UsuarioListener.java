package br.com.ulbra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioListener extends Thread implements Serializable {

    private final Usuario usuario;

    public UsuarioListener(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void run() {
        try {
            this.usuario.getConexao().enviar("Para fazer parte do grupo, insira 'ENTRAR + seu nickname'");
            while (this.usuario.getConexao().isConectionOpen()) {
                String msg = this.usuario.getConexao().receber();
                int indexOf = msg.indexOf(" ");
                String request[] = new String[2];
                try {
                    request[0] = msg.substring(0, indexOf);
                    request[1] = msg.substring(indexOf + 1);
                } catch (StringIndexOutOfBoundsException e) {
                    request[0] = msg;
                }
                tratarMensagem(request);
            }
        } catch (IOException e) {
            System.err.println("Falha no Listener do Usuario! " + e.getMessage());
        }
    }

    @Override
    public void interrupt() {
        try {
            this.usuario.getConexao().close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void tratarMensagem(String[] msg) throws IOException {
        switch (msg[0].toUpperCase()) {
            case "ENTRAR":
                if (msg[1] == null || msg[1].trim().length() == 0) {
                    this.usuario.getConexao().enviar("Formato incorreto de requisicao");
                } else {
                    if (this.usuario.getNome() != null) {
                        this.usuario.getConexao().enviar("Voce jah faz parte deste grupo com o nickname: " + this.usuario.getNome());
                    } else if (msg[1].trim().length() > 0 && isUnique(msg[1])) {
                        this.usuario.setNome(msg[1].trim());
                        obterUltimasMensagens();
                        for (UsuarioListener listener : ServidorPrincipal.USUARIOS_CONECTADOS) {
                            if (listener.usuario.getNome() != null
                                    && !listener.usuario.getNome().isEmpty()
                                    && !listener.usuario.getNome().equals(this.usuario.getNome())) {
                                listener.usuario.getConexao().enviar("MSG " + this.usuario.getNome() + " entrou no grupo");
                            }
                        }
                    } else {
                        this.usuario.getConexao().enviar("Nickname jah utilizado");
                    }
                }
                break;
            case "MSG":
                if (msg[1] == null || msg[1].trim().length() == 0) {
                    this.usuario.getConexao().enviar("Formato incorreto de requisicao");
                } else {
                    salvarMensagem("MSG " + this.usuario.getNome() + " " + msg[1]);
                    for (UsuarioListener listener : ServidorPrincipal.USUARIOS_CONECTADOS) {
                        if (listener.usuario.getNome() != null
                                && !listener.usuario.getNome().equals(this.usuario.getNome())) {
                            listener.usuario.getConexao().enviar("MSG " + this.usuario.getNome() + " " + msg[1]);
                        }
                    }
                }
                break;
            case "SAIR":
                for (UsuarioListener listener : ServidorPrincipal.USUARIOS_CONECTADOS) {
                    if (listener.usuario.getNome() != null
                            && !listener.usuario.getNome().equals(this.usuario.getNome())) {
                        listener.usuario.getConexao().enviar("MSG " + this.usuario.getNome() + " saiu no grupo");
                    }
                }
                removeUser();
                this.usuario.getConexao().close();
                break;
            default:
                this.usuario.getConexao().enviar("Formato incorreto de requisicao");
        }
    }

    private boolean isUnique(String nome) {
        Optional<UsuarioListener> filter = ServidorPrincipal.USUARIOS_CONECTADOS.stream().findFirst().filter((t) -> {
            return t.usuario.getNome() != null && t.usuario.getNome().toUpperCase().equals(nome.toUpperCase());
        });
        return !filter.isPresent();
    }

    private void removeUser() {
        Optional<UsuarioListener> filter = ServidorPrincipal.USUARIOS_CONECTADOS.stream().findFirst().filter((t) -> {
            return t.usuario.getNome().toUpperCase().equals(this.usuario.getNome().toUpperCase());
        });
        if (filter.isPresent()) {
            ServidorPrincipal.USUARIOS_CONECTADOS.remove(filter.get());
        }
    }

    private void obterUltimasMensagens() throws IOException {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("conversa.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo ainda não criado! " + e.getMessage());
        }

        if (linhas.size() > 20) {
            for (int i = linhas.size(); i > linhas.size() - 20; i--) {
                this.usuario.getConexao().enviar(linhas.get(i - 1));
            }
        } else {
            for (String linha : linhas) {
                this.usuario.getConexao().enviar(linha);
            }
        }
    }

    private synchronized void salvarMensagem(String string) {
        File arquivo = new File("conversa.txt");
        try (FileWriter fw = new FileWriter(arquivo, true)) {
            fw.write(string + "\n");
            fw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
