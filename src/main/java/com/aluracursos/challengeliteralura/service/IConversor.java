package com.aluracursos.challengeliteralura.service;

public interface IConversor {
    <T> T obtenerDatos(String json, Class<T> clase);
}
