package geoscript.proj

import org.junit.Test
import static org.junit.Assert.*
import geoscript.geom.Point
import geoscript.proj.Projection

/**
 * The Projection UnitTest
 */
class ProjectionTestCase {

    @Test void constructors() {

        Projection p1 = new Projection("EPSG:2927")
        assertEquals "EPSG:2927", p1.id

        Projection p2 = new Projection("""GEOGCS["GCS_WGS_1984",DATUM["D_WGS_1984",SPHEROID["WGS_1984",6378137,298.257223563]],PRIMEM["Greenwich",0],UNIT["Degree",0.017453292519943295]]""")
        assertEquals "EPSG:4326", p2.id

        Projection p3 = new Projection(org.geotools.referencing.CRS.decode("EPSG:2927"))
        assertEquals "EPSG:2927", p3.id

        Projection p4 = new Projection(p1)
        assertEquals "EPSG:2927", p4.id

    }

    @Test void getId() {
        Projection p1 = new Projection("EPSG:2927")
        assertEquals "EPSG:2927", p1.id
    }

    @Test void getWkt() {
        Projection p1 = new Projection("EPSG:4326")

        String expected = """GEOGCS["WGS 84", 
  DATUM["World Geodetic System 1984", 
    SPHEROID["WGS 84", 6378137.0, 298.257223563, AUTHORITY["EPSG","7030"]], 
    AUTHORITY["EPSG","6326"]], 
  PRIMEM["Greenwich", 0.0, AUTHORITY["EPSG","8901"]], 
  UNIT["degree", 0.017453292519943295], 
  AXIS["Geodetic latitude", NORTH], 
  AXIS["Geodetic longitude", EAST], 
  AUTHORITY["EPSG","4326"]]"""

        String actual = p1.wkt
        
        assertEquals expected, actual

    }

    @Test void transform() {
        Point point = new Point(1181199.82, 652100.72)
        Projection src = new Projection("EPSG:2927")
        Projection dest = new Projection("EPSG:4326")
        Point projectedPoint = src.transform(point, dest)
        assertEquals "POINT (47.10679261700989 -122.34429002073523)", projectedPoint.toString()
    }

    @Test void testToString() {
        Projection p1 = new Projection("EPSG:2927")
        assertEquals "EPSG:2927", p1.toString()
    }

    @Test void testEquals() {
        assertTrue new Projection("EPSG:2927") == new Projection("EPSG:2927")
        assertFalse new Projection("EPSG:2927") == new Projection("EPSG:4326")
    }

    @Test void staticTransform() {
        Point point = new Point(1181199.82, 652100.72)
        Projection src = new Projection("EPSG:2927")
        Projection dest = new Projection("EPSG:4326")
        Point projectedPoint = Projection.transform(point, src, dest)
        assertEquals "POINT (47.10679261700989 -122.34429002073523)", projectedPoint.toString()
    }
    
}
