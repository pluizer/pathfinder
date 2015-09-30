A simple A* pathfinder written in Java

Example usage:
```java
World world = new World(7, 5);
world.get(3, 1).setIsReachable(false);
world.get(3, 2).setIsReachable(false);
world.get(3, 3).setIsReachable(false);
List<Node> path = Pathfinder.findPath(world.get(1, 2), world.get(5, 2));
for (Node node : path) {
    System.out.println(node);
}
```
