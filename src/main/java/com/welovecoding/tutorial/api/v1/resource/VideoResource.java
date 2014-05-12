package com.welovecoding.tutorial.api.v1.resource;

import static com.welovecoding.tutorial.api.v1.RestConfig.JSON_MEDIATYPE;
import com.welovecoding.tutorial.api.v1.dto.VideoDTO;
import com.welovecoding.tutorial.api.v1.mapping.DTOMapper;
import com.welovecoding.tutorial.data.video.Video;
import com.welovecoding.tutorial.data.video.VideoService;
import de.yser.ownsimplecache.util.jaxrs.RESTCache;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("")
@Stateless
public class VideoResource {

  @EJB
  private VideoService videoService;

  // http://welovecoding.com/rest/service/v1/playlist/8
  // http://localhost:8080/wlc-webapp/rest/fhb/v1/playlist/8
  public VideoResource() {
  }

  @RESTCache(genericTypeHint = "com.welovecoding.tutorial.api.v1.dto.VideoDTO")
  @GET
  @Path("playlist/{playlistid}")
  @Produces(JSON_MEDIATYPE)
  public List<VideoDTO> getVideos(@PathParam("playlistid") long playlistId) {
    List<Video> videos = videoService.getVideosByPlaylistId(playlistId);
    return DTOMapper.mapVideos(videos);
  }
}
