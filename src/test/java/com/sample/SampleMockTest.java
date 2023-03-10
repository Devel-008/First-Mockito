package com.sample;

import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class SampleMockTest {
    SampleMock sampleMock;
    @Test
    public void mockTest(){
  sampleMock = new SampleMock();
  sampleMock.getMocking();
    }
    @Test
    public void mocker(){
        ArtifactInfo info = new ArtifactInfo("hello");
        ArtifactService service = new ArtifactService();
        service.getArtifactInfo("1","v","y","u");
        sampleMock.getArtifactConfiguration("1","v","y","u");
        sampleMock.getInquiries("1","v","y","u","oo");



    }
    @Test
    public void test() {
        // using Mockito.mock() method
        List<String> mockList = mock(List.class);
        when(mockList.size()).thenReturn(5);
        assertTrue(mockList.size()==5);
    }

}