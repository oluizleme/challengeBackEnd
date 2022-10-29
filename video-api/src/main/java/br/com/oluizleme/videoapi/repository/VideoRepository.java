package br.com.oluizleme.videoapi.repository;

import br.com.oluizleme.videoapi.modelo.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
