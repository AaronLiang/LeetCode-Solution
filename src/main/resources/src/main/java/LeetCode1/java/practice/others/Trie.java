/**
 * 
 */
package java.practice.others;

import java.util.HashMap;
import java.util.Map;

/**
 * Source: LeetCode
 * 
 * 
 * http://blog.csdn.net/fightforyourdream/article/details/18332799
 * 
 * @author Aaron
 * 
 * 
 */
public class Trie {

    private TrieNode root; // Root node in trie

    /**
     * Constructor for Trie class
     */
    public Trie() {
        root = new TrieNode((char) 0);
    }

    /**
     * A method to insert a word into the trie
     * 
     * @param word
     *            The word to be inserted
     */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            Map<Character, TrieNode> children = cur.getChildren();
            char c = word.charAt(i);
            if (children.containsKey(c)) { // If the character is in trie,
                                           // continue searching
                cur = children.get(c);
            } else { // Otherwise, create a new trie node
                TrieNode newNode = new TrieNode(c);
                children.put(c, newNode);
                cur = newNode;
            }
        }
        cur.setEnd(true); // Markup for the end of word
    }

    /**
     * A method used to determine if a word is stored in trie or not
     * 
     * @param word
     *            The word to be checked
     * @return True if the word is stored in trie, false otherwise
     */
    public boolean contains(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) { // Some letter is not in trie,
                                                // return false
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.isEnd; // When reaches the end of word, return value is based
                          // on if the markup is set or not
    }

    /**
     * Inner class for Trie Node
     * 
     * @author Bin Feng
     * 
     */
    class TrieNode {
        private char letter; // Letter associate with the node
        private Map<Character, TrieNode> children; // Children of current node
        private boolean isEnd; // Markup for end of word

        /**
         * Constructor for TrieNode class
         * 
         * @param letter
         *            The letter associate with node
         */
        public TrieNode(char letter) {
            this.letter = letter;
            children = new HashMap<Character, Trie.TrieNode>();
            isEnd = false;
        }

        /**
         * Getters and Setters
         */
        public char getLetter() {
            return letter;
        }

        public void setLetter(char letter) {
            this.letter = letter;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public void setChildren(Map<Character, TrieNode> children) {
            this.children = children;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }

    }
}

/**
 * TRIE is an interesting data-structure used mainly for manipulating with Words
 * in a language. This word is got from the word retrieve. TRIE (pronounced as
 * 'try') has a wide variety of applications in Spell checking Data compression
 * Computational biology Routing table for IP addresses Storing/Querying XML
 * documents etc., We shall see how to construct a basic TRIE data structure in
 * Java.
 * 
 * A TRIE tree would typically look like the following
 * 
 * 
 * 
 * The above TRIE is constructed by inserting the words ball, bat, doll, dork,
 * do, dorm, send, sense. The markers are denoted on the Node using a red
 * star(*). We shall look into more about the TRIE data structure in depth in
 * the next post.
 * 
 * In this section we shall see how the insert() method on the TRIE data
 * structure works. We shall take a specific case and analyze it with pictorial
 * representation.
 * 
 * Before we begin, assume we already have an existing TRIE as shown below.
 * 
 * 
 * Lets see the steps on how to insert a word "bate". Any insertion would
 * ideally be following the below algorithm.
 * 
 * If the input string length is zero, then set the marker for the root node to
 * be true. If the input string length is greater than zero, repeat steps 3 and
 * 4 for each character If the character is present in the child node of the
 * current node, set the current node point to the child node. If the character
 * is not present in the child node, then insert a new node and set the current
 * node to that newly inserted node. Set the marker flag to true when the end
 * character is reached. Now lets see how the word "bate" is getting inserted.
 * Since the word "bate" is having length greater than zero, we can start
 * inspecting each word. See whether "b" is present in the current node's
 * children (which is root). Yes its present, so set the current node to the
 * child node which is having the character "b". See whether "a" is present in
 * the current node's children. Yes its present, so set the current node to the
 * child node which is having the character "a". See whether "t" is present in
 * the current node's children. Yes its present, so set the current node to the
 * child node which is having the character "t". See whether "e" is present in
 * the current node's children. No, its not present, so create a new node with
 * character set to "e". Since "e" is the end of the word, set the marker flag
 * to true.
 * 
 * 
 * 
 * The above picture shows how the word "bate" is inserted into the existing
 * TRIE data structure. This example clearly shows how the insertion in a TRIE
 * happens.
 * 
 * Consider the following TRIE as usual.
 * 
 * 
 * The search alogirthm involves the following steps For each character in the
 * string, see if there is a child node with that character as the content. If
 * that character does not exist, return false If that character exist, repeat
 * step 1. Do the above steps until the end of string is reached. When end of
 * string is reached and if the marker of the current Node is set to true,
 * return true, else return false. Using the above algorithm, lets perform a
 * search for the key "do". See whether "d" is present in the current node's
 * children. Yes its present, so set the current node to child node which is
 * having character "d". See whether "o" is present in the current node's
 * children. Yes its present, so set the current node to child node which is
 * having character "o". Since "o" is the end of the word, see whether marker is
 * set to true or false. Marker is set to false which means that "do" is not
 * registered as a word in the TRIE. So, return false.
 * 
 * 
 * 
 * Using the same algorithm, lets perform a search for the key "ball" See
 * whether "b" is present in the current node's children. Yes its present, so
 * set the current node to child node which is having character "b". See whether
 * "a" is present in the current node's children. Yes its present, so set the
 * current node to child node which is having character "a". See whether "l" is
 * present in the current node's children. Yes its present, so set the current
 * node to child node which is having character "l". See whether "l" is present
 * in the current node's children. Yes its present, so set the current node to
 * child node which is having character "l". Since "l" is the end of the word,
 * see whether marker is set to true or false. Marker is set to true which means
 * that "ball" is registered as a word in the TRIE. So, return true
 * 
 * 
 * Now that we've seen the basic operations on how to work with a TRIE, we shall
 * now see the space and time complexities in order to get a real feel of how
 * good a TRIE data structure is. Lets take the two important operations INSERT
 * and SEARCH to measure the complexity.
 * 
 * INSERT operation first. Lets always take into account the worst case timing
 * first and later convince ourselves of the practical timings. For every Node
 * in the TRIE we had something called as Collection where the Collection can be
 * either a Set or a List. If we choose Set, the order of whatever operation we
 * perform over that will be in O(1) time, whereas if we use a LinkedList the
 * number of comparisons at worst will be 26 (the number of alphabets). So for
 * moving from one node to another, there will be at least 26 comparisons will
 * be required at each step.
 * 
 * Having these in mind, for inserting a word of length 'k' we need (k * 26)
 * comparisons. By Applying the Big O notation it becomes O(k) which will be
 * again O(1). Thus insert operations are performed in constant time
 * irrespective of the length of the input string (this might look lik an
 * understatement, but if we make the length of the input string a worst case
 * maximum, this sentence holds true).
 * 
 * Same holds true for the search operation as well. The search operation
 * exactly performs the way the insert does and its order is O(k*26) = O(1)
 */
