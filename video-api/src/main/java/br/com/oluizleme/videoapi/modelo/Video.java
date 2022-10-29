package br.com.oluizleme.videoapi.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "videos")
@Getter
public class Video {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty
    @JsonProperty
    private String titulo;
    @NotNull @NotEmpty
    @JsonProperty
    private String descricao;
    @NotNull @NotEmpty
    @JsonProperty
    private String url;

    @Deprecated
    public Video() {

    }

    public Video(String titulo, String descricao, String url) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
    }

    public void atualizar(Video novoVideo) {
        this.titulo = novoVideo.getTitulo();
        this.descricao = novoVideo.getDescricao();
        this.url = novoVideo.getUrl();
    }

    public void atualizarTituloEDescricao(Video novoVideo) {
        this.titulo= novoVideo.getTitulo();
        this.descricao = novoVideo.getDescricao();
    }
}
