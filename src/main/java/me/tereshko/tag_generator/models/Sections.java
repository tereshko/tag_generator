package me.tereshko.tag_generator.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sections")
@Data
@NoArgsConstructor
public class Sections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sections")
    private String sections;

    @Override
    public String toString() {
        return String.format("section: %s", sections);
    }
}
