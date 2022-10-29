package br.com.oluizleme.videoapi.controller;

import br.com.oluizleme.videoapi.modelo.Video;
import br.com.oluizleme.videoapi.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoRepository repositorioVideo;


    @GetMapping("/{id}")
    Video obterVideo(@PathVariable("id") Long id) {
        return repositorioVideo.findById(id).get();
    }

    @GetMapping
    List<Video> listar() {
        return repositorioVideo.findAll();
    }

    @PostMapping
    void salvarUmVidedo(@RequestBody @Valid Video video) {
        repositorioVideo.save(video);
    }

    @PutMapping("/{id}")
    @Transactional
    ResponseEntity<Video> atualizarVideo(@PathVariable Long id, @RequestBody Video novoVideo) {
        Optional<Video> optional = repositorioVideo.findById(id);
        if(optional.isPresent()) {
            Video videoExistente = optional.get();
            videoExistente.atualizar(novoVideo);
            repositorioVideo.save(videoExistente);
            return ResponseEntity.ok(videoExistente);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    @Transactional
    ResponseEntity<Video> atualizarPartesDoVideo(@PathVariable Long id, @RequestBody Video novoVideo){
        Optional<Video> optional = repositorioVideo.findById(id);
        if(optional.isPresent()) {
            Video videoExistente = optional.get();
            videoExistente.atualizarTituloEDescricao(novoVideo);
            repositorioVideo.save(videoExistente);
            return ResponseEntity.ok(videoExistente);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity deletarVideo(@PathVariable Long id) {
        Optional<Video> optional = repositorioVideo.findById(id);
        if (optional.isPresent()) {
            repositorioVideo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
