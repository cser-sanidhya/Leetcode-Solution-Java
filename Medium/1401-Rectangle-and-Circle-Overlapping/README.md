# 1401. Circle and Rectangle Overlapping

## Approach

1. Find the point inside the rectangle that is **closest to the circle's center**.
2. For the x-coordinate:

   * If the circle center lies inside the rectangle horizontally, use `xCenter`.
   * Otherwise, use the nearest rectangle boundary (`x1` or `x2`).
3. Similarly, find the closest y-coordinate.
4. The resulting point `(closestX, closestY)` is the nearest point on or inside the rectangle to the circle's center.
5. Compute the squared distance between the circle's center and this closest point.
6. If the squared distance is less than or equal to the squared radius, the circle and rectangle overlap.
7. Otherwise, they do not overlap.

## Algorithm

1. Find the closest x-coordinate:

   ```java
   closestX = Math.max(x1, Math.min(xCenter, x2));
   ```
2. Find the closest y-coordinate:

   ```java
   closestY = Math.max(y1, Math.min(yCenter, y2));
   ```
3. Compute the horizontal distance:

   ```java
   dx = closestX - xCenter;
   ```
4. Compute the vertical distance:

   ```java
   dy = closestY - yCenter;
   ```
5. Calculate the squared distance:

   ```java
   dx * dx + dy * dy
   ```
6. Compare it with:

   ```java
   radius * radius
   ```
7. Return:

   ```java
   dx * dx + dy * dy <= radius * radius
   ```

## Time Complexity

All calculations involve a constant number of operations.

**Overall Time Complexity:**
**O(1)**

## Space Complexity

No extra data structures are used.

**Auxiliary Space Complexity:**
**O(1)**

**Overall Space Complexity:**
**O(1)**

## Concepts

* Geometry
* Math
* Coordinate System
* Distance Formula
* Closest Point
* Rectangle Boundary Clamping
* Euclidean Distance
* Simulation
