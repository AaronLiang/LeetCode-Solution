import java.util.HashMap;
class Node {
  int val;
  Node prev;
  Node next;
  public Node(int val, Node next) {
    this.val = val;
    this.next = next;
    this.prev = null;
    if (next != null) 
      next.prev = this;
  }
}

public class LRUCache {
  int capacity;
  HashMap<Integer, Node> hash;
  HashMap<Integer, Integer> key_value;
  int size;
  Node head;
  Node end;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    head = null;
    end = null;
    hash = new HashMap<Integer, Node>();
    key_value = new HashMap<Integer, Integer>();
  }

  public int get(int key) {
    Node node = hash.get(key);
    if (node != null) {
      moveToHead(node);
      return key_value.get(key);
    }
    return -1;
  }

  public void set(int key, int value) {
    Node node = hash.get(key);
    if (node != null) {
      key_value.put(key, value);
      moveToHead(node);
    } else {
      size ++;
      key_value.put(key, value);
      node = new Node(key, head);
      hash.put(key, node);
      head = node;
      if (end == null) end = node;
      
      if (size > capacity) {
        size --;
        key_value.remove(end.val);
        hash.remove(end.val);
        end = end.prev;
        end.next.prev = null;
        end.next = null;  
      }
    } 
  }

  private void moveToHead(Node node) {
    if (node.prev != null) { // if node is not head
      node.prev.next = node.next;
      if (node.next != null) // if node is not end
        node.next.prev = node.prev;
      else 
        end = end.prev;
      node.prev = null;
      node.next = head;
      head.prev = node;
      head = node;
    }
  }
}

