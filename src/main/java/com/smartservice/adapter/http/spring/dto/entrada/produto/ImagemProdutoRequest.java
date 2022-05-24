package com.smartservice.adapter.http.spring.dto.entrada.produto;

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

    @Override
    public String toString() {
        return "ImagemProdutoRequest{" +
                "imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
