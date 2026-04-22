package khayyat.fruity.unsplash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnsplashServiceTest
{
    @Test
    public void search()
    {
        //given
        UnsplashService service = new UnsplashServiceFactory().create();

        //when
        Photos photos = service.search("strawberry").blockingGet();

        //then
        assertNotNull(photos.results()[0].urls().small());
    }
}
