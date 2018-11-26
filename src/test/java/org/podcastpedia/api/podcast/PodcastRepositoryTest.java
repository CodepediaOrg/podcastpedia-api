package org.podcastpedia.api.podcast;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ama on 17.11.18.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PodcastRepositoryTest {

    @Autowired
    private PodcastRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findByIdentifier() throws Exception {
        Podcast savedPodcast = entityManager.persistFlushFind(new Podcast("javascript-jabber"));
        Podcast podcast = repository.findByIdentifier("javascript-jabber");

        assertThat(podcast.getIdentifier()).isEqualTo(savedPodcast.getIdentifier());
    }

    @Test
    public void findAllPodcasts() {
        Podcast savedPodcast = entityManager.persistFlushFind(new Podcast("javascript-jabber"));
        Podcast savedPodcast2 = entityManager.persistFlushFind(new Podcast("java-podcast"));

        final List<Podcast> allPodcasts = repository.findAll();

        assertThat(allPodcasts.size()).isEqualTo(2);

    }
}