package me.tereshko.tag_generator.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tags")
@Data
@NoArgsConstructor
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tag")
    private String tag;

    @OneToOne
    @JoinColumn(name = "sections")
    private Sections sections;

    @Override
    public String toString() {
        return String.format("tag 1: %s, section 2: %s", tag, sections);
    }
}
