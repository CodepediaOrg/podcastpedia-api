package org.podcastpedia.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.podcastpedia.api.podcast.Podcast;
import org.podcastpedia.api.podcast.PodcastController;
import org.podcastpedia.api.podcast.PodcastNotFoundException;
import org.podcastpedia.api.podcast.PodcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ama on 15.11.18.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PodcastController.class)
public class PodcastControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PodcastService podcastService;

    @Test
    public void getPodcastByIdentifier_ShouldReturnPodcast() throws Exception {
        given(podcastService.getPodcastDetails(anyString())).willReturn(new Podcast("javascript-jabber"));

        mockMvc.perform(MockMvcRequestBuilders.get("/podcasts/javascript-jabber"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("identifier").value("javascript-jabber"));
    }

    @Test
    public void getPodcastByIdentifier_notFound() throws Exception {
        given(podcastService.getPodcastDetails(anyString())).willThrow(new PodcastNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/podcasts/strang-identifier"))
                .andExpect(status().isNotFound());
    }
}
