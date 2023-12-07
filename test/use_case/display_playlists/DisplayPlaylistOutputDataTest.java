package use_case.display_playlists;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class DisplayPlaylistOutputDataTest {
     private DisplayPlaylistsOutputData outputData;
     @Before
     public void init() {
         HashMap<String, String> samplePlaylistIDName = new HashMap<>();
         samplePlaylistIDName.put("Name", "Data");
         this.outputData = new DisplayPlaylistsOutputData(samplePlaylistIDName);
     }

     @Test
     public void testGetPlaylistIDName() {
         HashMap<String, String> samplePlaylistIDName = new HashMap<>();
         samplePlaylistIDName.put("Name", "Data");

         assertEquals(samplePlaylistIDName, outputData.getPlaylistIdName());
    }


}
