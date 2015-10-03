A simple A* pathfinder written in Java

## Example usage:

### Square grids

```java
World world = new SquareWorld(7, 5);
world.get(2, 1).setIsReachable(false);
world.get(3, 1).setIsReachable(false);
world.get(3, 2).setIsReachable(false);
world.get(3, 3).setIsReachable(false);
world.get(4, 3).setIsReachable(false);
List<Node> path = Pathfinder.findPath(world.get(2, 2), world.get(5, 2));
path.forEach((node) -> System.out.println(node));
```

gives the following output:
```
(2, 2)
(1, 1)
(2, 0)
(3, 0)
(4, 1)
(5, 2)
```

Or to put it in a picture:

![path example](https://github.com/pluizer/pathfinder/raw/master/path.png)

### Hexagon grids

This library also included support for hexagon grids:

```java
World world = new HexWorld(7, 5);
world.get(2, 1).setIsReachable(false);
world.get(3, 1).setIsReachable(false);
world.get(3, 2).setIsReachable(false);
world.get(3, 3).setIsReachable(false);
world.get(4, 3).setIsReachable(false);
List<Node> path = Pathfinder.findPath(world.get(2, 2), world.get(5, 2));
path.forEach((node) -> System.out.println(node));
```

gives the following output:
```
(2, 2)
(2, 3)
(3, 4)
(4, 4)
(5, 4)
(5, 3)
(5, 2)
```

Or to put it in a picture:

![path example](https://github.com/pluizer/pathfinder/raw/master/pathHex.png)