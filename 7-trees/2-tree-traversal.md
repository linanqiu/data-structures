- infix, postfix, prefix using public private pattern and stringbuilder

```java
public String prefix(Node node) {
  StringBuilder sb = new StringBuilder();
  prefix(node, sb);
  return sb.toString().trim();
}

public void prefix(Node node, StringBuilder sb) {
  sb.append(node);
  sb.append(" ");

  if(node.left != null) {
    prefix(node.left, sb);
  }

  if(node.right != null) {
    prefix(node.right, sb);
  }
}
```

- iterative version of the recursive traversal using a stack
  + demonstrate that the function stack is the stack used for recursive methods
- iterating a tree using traversal and stack
- BFS using a queue
