package br.com.alura.screenmatch.repository;

import br.com.alura.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> /*dizer primeiro quem é a entidade que está sendo
persistida, e o segundo item é o tipo do ID que foi definido o banco de dados*/{
    @Query("SELECT s FROM Serie s LEFT JOIN FETCH s.episodios WHERE s.id = :id")
    Optional<Serie> findByIdWithEpisodes(@Param("id") Long id);
}
