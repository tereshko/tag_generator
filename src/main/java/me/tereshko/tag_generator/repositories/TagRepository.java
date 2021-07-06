package me.tereshko.tag_generator.repositories;

import me.tereshko.tag_generator.models.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tags, Long> {
    @Query(value = "SELECT * FROM TAGS where sections = :section", nativeQuery = true)
    List<Tags> findBySections(@Param("section") Long section);

    @Query(value = "SELECT COUNT(*) FROM TAGS where sections = :section", nativeQuery = true)
    Long countBySection(@Param("section") Long section);

    @Query(value = "SELECT * FROM TAGS where sections = :section AND id = :id", nativeQuery = true)
    Tags selectTagByIDAndSection(@Param("section") Long section, @Param("id") Long id);

    @Query(value = "SELECT * FROM TAGS where sections = :section", nativeQuery = true)
    List<Tags> selectTagsBySection(@Param("section") Long section);
}
