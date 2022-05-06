package com.smartservice.core.model.enums;

import com.smartservice.core.exceptions.CategoriaNaoExistenteException;

public enum Categoria {

    HAMBURGERS,
    BEBIDAS,
    BEBIDASALCOLICAS,
    PODRAO,
    PORCOES;

    public static void verificaExistenciaCategoria(String categoria){
        try {
            valueOf(categoria);
        }
        catch (Exception e){
            throw new CategoriaNaoExistenteException("Categoria inexistente");
        }
    }
}