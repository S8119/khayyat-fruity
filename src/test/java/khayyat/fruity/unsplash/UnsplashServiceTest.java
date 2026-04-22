package khayyat.fruity.unsplash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnsplashServiceTest
{
    @Test
    void search()
    {
        //given
        UnsplashService service = new UnsplashServiceFactory().create();

        //when
        Photos photos = service.search("strawberry").blockingGet();

        //then
        Results[] results = photos.results();
        for(Results result : results)
        {
            Urls urls = result.urls();
            String small = urls.small();
            assertNotNull(small);
        }
    }
}
