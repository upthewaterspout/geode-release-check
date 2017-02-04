package org.apache.geode.test;

import static org.junit.Assert.*;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionShortcut;

import org.junit.Test;

public class CRUDTest {

  @Test
  public void testCRUDOperation() {
    CacheFactory cacheFactory = new CacheFactory();
    Cache cache = cacheFactory.create();
    Region region = cache.createRegionFactory(RegionShortcut.REPLICATE).create("region");
    region.put("key", "value");
    assertEquals("value", region.get("key"));
  }

}
