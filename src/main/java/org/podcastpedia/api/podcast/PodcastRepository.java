package org.podcastpedia.api.podcast;

import org.springframework.data.repository.CrudRepository;

public interface PodcastRepository extends CrudRepository<Podcast,Long> {

     Podcast findByIdentifier(String identifier);
}
