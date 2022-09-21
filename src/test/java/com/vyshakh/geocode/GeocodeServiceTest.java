package com.vyshakh.geocode;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.vyshakh.geocode.Dao.ILocationRetriever;
import com.vyshakh.geocode.Model.Result;
import com.vyshakh.geocode.Service.GeocodeService;

@RunWith(MockitoJUnitRunner.class)
public class GeocodeServiceTest {
    @Mock
    private ILocationRetriever loc;

    @InjectMocks
    private GeocodeService geocodeService;

    @Test
    public void TestGetPositionStack(){
        var res = new Result();
        res.setLatitude("1.22");
        res.setLongitude("1.77");
        when(loc.getLatitudeLogitude(anyString())).thenReturn(res);
        var out = geocodeService.getLocation("Kolkata");
        
        assertEquals(out.getLatitude(), "1.22");
        assertEquals(out.getLongitude(), "1.77");
    }
}
