package me.tereshko.tag_generator.repositories;

import me.tereshko.tag_generator.models.Sections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionsRepository extends JpaRepository<Sections, Long> {
}
