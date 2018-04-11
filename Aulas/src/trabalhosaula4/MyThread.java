package trabalhosaula4;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Runnable, Comparable<MyThread> {

    private int distanciaPercorrida = 0;
    private int quantidadeSaltos;
    private LocalDateTime chegada;

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (getDistanciaPercorrida() < 20) {
            setQuantidadeSaltos(getQuantidadeSaltos() + 1);
            final int random = ThreadLocalRandom.current().nextInt(1, 4);
            setDistanciaPercorrida(getDistanciaPercorrida() + random);
            System.out.println("Lebre " + getName() + " pulou " + random + " metro(s)");
            Thread.yield();
        }
        setChegada(LocalDateTime.now());
    }

    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(int distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public int getQuantidadeSaltos() {
        return quantidadeSaltos;
    }

    public void setQuantidadeSaltos(int quantidadeSaltos) {
        this.quantidadeSaltos = quantidadeSaltos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getChegada() {
        return chegada;
    }

    public void setChegada(LocalDateTime chegada) {
        this.chegada = chegada;
    }

    @Override
    public int compareTo(MyThread o) {
        return this.chegada.compareTo(o.getChegada());
    }
}
