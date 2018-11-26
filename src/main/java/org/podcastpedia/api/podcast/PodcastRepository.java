package org.podcastpedia.api.podcast;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PodcastRepository extends JpaRepository<Podcast,Long> {

     Podcast findByIdentifier(String identifier);
}
