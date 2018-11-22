package org.podcastpedia.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.podcastpedia.api.podcast.Podcast;
import org.podcastpedia.api.podcast.PodcastRepository;
import org.podcastpedia.api.podcast.PodcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by ama on 22.11.18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
public class CachingTest {

    @Autowired
    private PodcastService podcastService;

    @MockBean
    private PodcastRepository podcastRepository;

    @Test
    public void caching() throws Exception {
        given(podcastRepository.findByIdentifier(anyString())).willReturn(new Podcast("javascript-jabber"));

        podcastService.getPodcastDetails("javascript-jabber");
        podcastService.getPodcastDetails("javascript-jabber");

        verify(podcastRepository, times(1)).findByIdentifier("javascript-jabber");
    }
}
