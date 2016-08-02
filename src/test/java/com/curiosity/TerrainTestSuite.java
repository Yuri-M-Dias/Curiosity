package com.curiosity;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CircularTerrainRoversTest.class,
        RectangleTerrainRoversTest.class
})
public class TerrainTestSuite {
}
