package ru.stqa.pft.soap;

import com.buzzbuzhome.BBHLocation;
import com.buzzbuzhome.GeoIP;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class GeoIpServiceTests {
  @Test
 public void testMyIp() {
      BBHLocation geoIPnew =  new GeoIP().getGeoIPSoap12().getUserLocation("93.85.129.120");
      assertEquals(geoIPnew.getCountryCode(), "US");
    }
}
