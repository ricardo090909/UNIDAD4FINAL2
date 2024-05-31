package modelo;

import interfaces.Keyable;
import interfaces.Operable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prestamos implements Operable {
    private List<Keyable> prestamos;
    private int capacidadMaxima;

    public Prestamos(int capacidadMaxima) {
        this.prestamos = new ArrayList<>();
        this.capacidadMaxima = capacidadMaxima;
    }

    @Override
    public boolean isFull() {
        return prestamos.size() >= capacidadMaxima;
    }

    @Override
    public boolean isEmpty() {
        return prestamos.isEmpty();
    }

    @Override
    public void add(Keyable item) {
        if (!isFull()) {
            prestamos.add(item);
        }
    }

    @Override
    public int getPosition(String clave) {
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getKey().equals(clave)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exist(int position) {
        return position >= 0 && position < prestamos.size();
    }

    @Override
    public Keyable getItem(int position) {
        if (exist(position)) {
            return prestamos.get(position);
        }
        return null;
    }

    @Override
    public void remove(int position) {
        if (exist(position)) {
            prestamos.remove(position);
        }
    }

    @Override
    public void update(Keyable item, int position) {
        if (exist(position)) {
            prestamos.set(position, item);
        }
    }

    @Override
    public String getList(String titulo) {
        StringBuilder sb = new StringBuilder(titulo + "\n");
        for (Keyable prestamo : prestamos) {
            sb.append(prestamo.getKey()).append(" - ").append(prestamo.getAtributeComparable()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void ordenar() {
        Collections.sort(prestamos);
    }

    @Override
    public void sort() {
        ordenar();
    }
}
