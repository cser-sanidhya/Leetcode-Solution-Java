# 836. Rectangle Overlap

## Approach

1. Two rectangles overlap only if they share a region with **positive area**.
2. Find the overlapping boundaries between the two rectangles:

   * The left boundary of the overlap is the maximum of the two left edges.
   * The right boundary of the overlap is the minimum of the two right edges.
   * The bottom boundary of the overlap is the maximum of the two bottom edges.
   * The top boundary of the overlap is the minimum of the two top edges.
3. If:

   * `left < right`
   * `bottom < top`

   then the overlapping region has a positive width and height, meaning the rectangles overlap.
4. Otherwise, the rectangles either:

   * Do not intersect, or
   * Only touch at an edge or corner (which is not considered an overlap).

## Algorithm

1. Compute the left boundary of the intersection:

   ```java
   int left = Math.max(rec1[0], rec2[0]);
   ```
2. Compute the right boundary of the intersection:

   ```java
   int right = Math.min(rec1[2], rec2[2]);
   ```
3. Compute the bottom boundary of the intersection:

   ```java
   int bottom = Math.max(rec1[1], rec2[1]);
   ```
4. Compute the top boundary of the intersection:

   ```java
   int top = Math.min(rec1[3], rec2[3]);
   ```
5. Check whether the intersection has positive width and height:

   ```java
   return left < right && bottom < top;
   ```
6. Return the result.

## Time Complexity

Only a constant number of arithmetic and comparison operations are performed.

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
* Rectangles
* Coordinate System
* Intersection of Rectangles
* Math
* Boundary Calculation
