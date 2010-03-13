package geoscript.geom

import com.vividsolutions.jts.geom.Geometry as JtsGeometry
import com.vividsolutions.jts.geom.GeometryFactory
import com.vividsolutions.jts.geom.prep.PreparedGeometryFactory
import com.vividsolutions.jts.io.WKTReader
import com.vividsolutions.jts.io.WKBReader
import com.vividsolutions.jts.io.WKBWriter
import com.vividsolutions.jts.geom.Envelope
import com.vividsolutions.jts.geom.IntersectionMatrix

/**
 * The base class for other Geomtries
 */
class Geometry {
	
    /**
     * The wrapped JTS Geometry
     */
    JtsGeometry g
	
    /**
     * The JTS GeometryFactory used to create JTS Geometry
     */
    static GeometryFactory factory = new GeometryFactory()

    /**
     * The JTS PreparedGeometryFactory used to create prepared JTS Geometry
     */
    static PreparedGeometryFactory preparedFactory = new PreparedGeometryFactory()

    /**
     * The JTS WKTReader
     */
    private static WKTReader wktReader = new WKTReader()

    /**
     * The JTS WKBWriter
     */
    private static WKBWriter wkbWriter = new WKBWriter()

    /**
     * The JTS WKBReader
     */
    private static WKBReader wkbReader = new WKBReader()

    /**
     * Create a new Geometry wrapping a JTS Geometry
     */
    Geometry (JtsGeometry g) {
        this.g = g
    }
	

    /**
     * Round Buffer cap style
     */
    static final int CAP_ROUND = com.vividsolutions.jts.operation.buffer.BufferOp.CAP_ROUND

    /**
     * Butt Buffer cap style
     */
    static final int CAP_BUTT = com.vividsolutions.jts.operation.buffer.BufferOp.CAP_BUTT

    /**
     * Square Buffer cap style
     */
    static final int CAP_SQUARE = com.vividsolutions.jts.operation.buffer.BufferOp.CAP_SQUARE

    /**
     * Buffer the Geometry by some distance
     */
    Geometry buffer(double distance, int quadrantSegments = 8, int endCapStyle = CAP_ROUND) {
        wrap(g.buffer(distance, quadrantSegments, endCapStyle))
    }

    /**
     * Whether this Geometry contains the other Geometry
     */
    boolean contains(Geometry other) {
        this.g.contains(other.g)
    }

    /**
     * Calculate the convex hull of this Geometry
     */
    Geometry convexHull() {
        wrap(g.convexHull())
    }

    /**
     * Whether this Geometry is covered by the other Geometry
     */
    boolean coveredBy(Geometry other) {
        this.g.coveredBy(other.g)
    }

    /**
     * Whether this Geometry covers the other Geometry
     */
    boolean covers(Geometry other) {
        this.g.covers(other.g)
    }

    /**
     * Whether this Geometry crosses the other Geometry
     */
    boolean crosses(Geometry other) {
        this.g.crosses(other.g)
    }

    /**
     * Calculate the difference between this Geometry and the other Geometry
     */
    Geometry difference(Geometry other) {
        wrap(this.g.difference(other.g))
    }

    /**
     * Whether this Geometry is disjoint from the other Geometry
     */
    boolean disjoint(Geometry other) {
        this.g.disjoin(other.g)
    }

    /**
     * Calculate the distance between this Geometry and other Geometry
     */
    double distance(Geometry other) {
        this.g.distance(other.g)
    }

    /**
     * Get the area of this Geometry
     */
    double getArea() {
        this.g.area
    }

    /**
     * Get the boundary of this Geometry
     */
    double getBoundary() {
        this.g.boundary
    }

    /**
     * Calculate the centroid of this Geometry
     */
    Point getCentroid() {
        wrap(this.g.centroid)
    }

    /**
     * Calculate the envelope of this Geometry
     */
    Envelope getEnvelope() {
        this.g.envelope
    }

    /**
     * Calculate the internal Envelope of this Geometry
     */
    Envelope getEnvelopeInternal() {
        this.g.envelopeInternal
    }

    /**
     * Get the nth Geometry in this Geometry
     */
    Geometry getGeometryN(int n) {
        wrap(this.g.getGeometryN(n))
    }

    /**
     * Get the interior Point of this Geometry
     */
    Point getInteriorPoint() {
        wrap(this.g.getInteriorPoint())
    }

    /**
     * Get the length of this Geometry
     */
    double getLength() {
        this.g.length
    }

    /**
     * Get the number of Geometries in this Geometry
     */
    int getNumGeometries() {
        this.g.numGeometries
    }

    /**
     * Get the number of Points in this Geometry
     */
    int getNumPoints () {
        this.g.numPoints
    }

    /**
     * Calculate the intersection between this Geometry and the other Geometry
     */
    Geometry intersection(Geometry other) {
        wrap(this.g.intersection(other.g))
    }

    /**
     * Whether this Geometry intersects the other Geometry
     */
    boolean intersects(Geometry other) {
        this.g.intersects(other.g)
    }

    /**
     * Whether this Geometry is empty
     */
    boolean isEmpty() {
        this.g.isEmpty()
    }

    /**
     * Whether this Geometry is rectangular
     */
    boolean isRectangle() {
        this.g.isRectangle()
    }

    /**
     * Whether this Geometry is simple
     */
    boolean isSimple() {
        this.g.isSimple()
    }

    /**
     * Whether this Geometry is valid
     */
    boolean isValid() {
        this.g.isValid()
    }

    /**
     * Whether this Geometry is within the given distance of the other Geometry
     */
    boolean isWithinDistance(Geometry geom, double distance) {
        this.g.isWithinDistance(geom.g, distance)
    }

    /**
     * Whether this Geometry overlaps the other Geometry
     */
    boolean overlaps(Geometry other) {
        this.g.overlaps(other.g)
    }

    /**
     * Calculate the D9 Intersection Matrix of this Geometry with the other
     * Geometry
     */
    IntersectionMatrix relate(Geometry other) {
        this.g.relate(other.g)
    }

    /**
     * Whether this Geometry relates with the other Geometry given a D9 intesection
     * matrix pattern
     */
    boolean relate(Geometry other, String intersectionPattern) {
        this.g.relate(other.g, intersectionPattern)
    }

    /**
     * Calculate the symmetric difference between this Geometry and the other
     * Geometry
     */
    Geometry symDifference(Geometry other) {
        wrap(this.g.symDifference(other.g))
    }

    /**
     * Whether this Geometry touches the other Geometry
     */
    boolean touches(Geometry other) {
        this.g.touches(other.g)
    }

    /**
     * Calculate the union of this Geometry
     */
    Geometry union() {
        wrap(this.g.union())
    }

    /**
     * Calculate the union of this Geometry with the other Geometry
     */
    Geometry union(Geometry other) {
        wrap(this.g.union(other.g))
    }

    /**
     * Whether this Geometry is within the other Geometry
     */
    boolean within(Geometry other) {
        this.g.within(other.g)
    }

    /**
     * Get the WKT of the Geometry
     */
    String getWkt() {
        g.toText()
    }
    
    /**
     * Get the WKB of the Geometry
     */
    byte[] getWkb() {
        wkbWriter.write(g)
    }

    /**
     * The string reprensentation
     */
    String toString() {
        return wkt
    }

    /**
     * Get a PreparedGeometry for this Geometry
     */
    PreparedGeometry prepare() {
        new PreparedGeometry(this)
    }

    /**
     * Wrap a JTS Geometry in a geoscript.geom.Geometry
     */
    static Geometry wrap(JtsGeometry jts) {
        if (jts instanceof com.vividsolutions.jts.geom.Point) {
            return new Point(jts)
        }
        else if (jts instanceof com.vividsolutions.jts.geom.LineString) {
            return new LineString(jts)
        }
        else if (jts instanceof com.vividsolutions.jts.geom.LinearRing) {
            return new LinearRing(jts)
        }
        else if (jts instanceof com.vividsolutions.jts.geom.Polygon) {
            return new Polygon(jts)
        }
        else if (jts instanceof com.vividsolutions.jts.geom.MultiPoint) {
            return new MultiPoint(jts)
        }
        else if (jts instanceof com.vividsolutions.jts.geom.MultiLineString) {
            return new MultiLineString(jts)
        }
        else if (jts instanceof com.vividsolutions.jts.geom.MultiPolygon) {
            return new MultiPolygon(jts)
        }
        else {
            return new Geometry(jts)
        }
    }
	
    /**
     * Get a Geometry from WKT
     */
    static Geometry fromWKT(String wkt) {
        wrap(wktReader.read(wkt))
    }

    /**
     * Get a Geometry from WKB
     */
    static Geometry fromWKB(byte[] wkb) {
        wrap(wkbReader.read(wkb))
    }

    /**
     * Get a PreparedGeometry for the given Geometry
     */
    static PreparedGeometry prepare(Geometry g) {
        new PreparedGeometry(g)
    }
}