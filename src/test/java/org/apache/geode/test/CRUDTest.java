package org.apache.geode.test;

import static org.junit.Assert.*;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionShortcut;

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
