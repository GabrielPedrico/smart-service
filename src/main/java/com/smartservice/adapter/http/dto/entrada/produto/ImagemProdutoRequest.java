package com.smartservice.adapter.http.dto.entrada.produto;

public class ImagemProdutoRequest {

    private String imgUrl;

    public ImagemProdutoRequest(String imgUrl) {

        this.imgUrl = imgUrl;
    }

    @Deprecated
    public ImagemProdutoRequest() {
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
