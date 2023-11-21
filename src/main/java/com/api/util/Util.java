package com.api.util;

import org.springframework.stereotype.Service;

@Service
public class Util {

    public String formatearTiempo(String tiempo) {
        String[] partes = tiempo.split("\\s+");

        int horas = Integer.parseInt(partes[6]);
        int minutos = Integer.parseInt(partes[8]);
        double segundosDouble = Double.parseDouble(partes[10]);
        int segundos = (int) Math.round(segundosDouble);

        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public int formatearTiempoEnMinutos(String tiempo) {
        String[] partes = tiempo.split("\\s+");

        int horas = Integer.parseInt(partes[6]);
        int minutos = Integer.parseInt(partes[8]);
        double segundos = Double.parseDouble(partes[10]);

        int tiempoEnMinutos = horas * 60 + minutos + (int) Math.round(segundos / 60.0);
        return tiempoEnMinutos;
    }

}
