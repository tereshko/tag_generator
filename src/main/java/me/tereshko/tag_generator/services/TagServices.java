package me.tereshko.tag_generator.services;

import lombok.RequiredArgsConstructor;
import me.tereshko.tag_generator.models.Tags;
import me.tereshko.tag_generator.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServices {
    private final TagRepository tagRepository;

    public List<Tags> findAllTags() {
        return tagRepository.findAll();
    }

    public List<Tags> findAllBySectionsEquals(Long id) {
        return tagRepository.findBySections(id);
    }

    public Long getCountBySections(Long section) {
        return tagRepository.countBySection(section);
    }

    public Tags getTagsBySectionAndId(Long section, int tagNumber) {
        List<Tags> tags = tagRepository.selectTagsBySection(section);
        return tags.get(tagNumber);
    }

    public List<Tags> getRandomTagsBySectionAndCount(Long section, int count) {
        List<Integer> randomListOfNumbers = getRandomListOfNumbers(section, count);
        //System.out.println("SECTION: " + section + " LIST: " + randomListOfNumbers + " SIZE: " + randomListOfNumbers.size());
        List<Tags> tagsList = new ArrayList<>();

        List<Tags> tags = tagRepository.selectTagsBySection(section);

        //System.out.println("TAGS: " + tags);
        //System.out.println("TAGS SIZE: " + tags.size());

        int randSize = randomListOfNumbers.size();
        for (int i = 0; i <= randSize-1; i++) {
            //System.out.println("!!! i: " + i);
            //System.out.println("!!! randomListOfNumbers.get(i): " + randomListOfNumbers.get(i));
            tagsList.add(tags.get((randomListOfNumbers.get(i)-1)));
        }

        //System.out.println("TAGS IN THE LIST: " + tagsList);

        return tagsList;
    }

    private ArrayList<Integer> getRandomListOfNumbers(Long section, int count) {
        int min = 1;
        int max = Math.toIntExact(getCountBySections(section));

        ArrayList<Integer> list = new ArrayList<>();

        while (list.size() < count) {
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            if (!list.contains(random_int)) {
                list.add(random_int);
            }
        }
        return list;
    }

}
