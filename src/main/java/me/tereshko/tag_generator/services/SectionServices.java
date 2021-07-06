package me.tereshko.tag_generator.services;

import lombok.RequiredArgsConstructor;
import me.tereshko.tag_generator.models.Sections;
import me.tereshko.tag_generator.repositories.SectionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionServices {
    private final SectionsRepository sectionsRepository;

    public List<Sections> findAllSections() {
        return sectionsRepository.findAll();
    }

    public Sections finSectionByName(Long id) {
        return sectionsRepository.getById(id);
    }
}
