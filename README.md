A simple A* pathfinder written in Java

Example usage:
```java
World world = new World(7, 5);
world.get(2, 1).setIsReachable(false);
world.get(3, 1).setIsReachable(false);
world.get(3, 2).setIsReachable(false);
world.get(3, 3).setIsReachable(false);
world.get(4, 3).setIsReachable(false);
List<Node> path = Pathfinder.findPath(world.get(2, 2), world.get(5, 2));
for (Node node : path) {
    System.out.println(node);
}
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
