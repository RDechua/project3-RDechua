package dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/** PrefixTree class, implements Dictionary interface.
 *  Can be used as a spell checker. */
public class PrefixTree implements Dictionary {

    // --------- Private class Node ------------
    /* Represents a node in a  prefix tree ("trie", "26-ary tree") */
    private class Node {
        Node children[]; // array of children (26 children, one corresponding to each English letter)
        boolean isWord; // true if by concatenating "edges" on the path from the root to this node, we get a valid word

        Node() {
            isWord = false;
            children = new Node[26]; // initialize the array of children
        }
    } // end of inner class Node

    private Node root; // the root of the tree

    public PrefixTree() {
        root = new Node();
    }

    /**
     * Creates a prefix tree using words from the given file.
     * The file contains one word per line.
     * @param filename the name of the file with words
     */
    public PrefixTree(String filename) {
        // FILL IN CODE:
        // Read each word from the file, add it to the tree
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String str;
            while((str = br.readLine()) != null){

            }
        }catch(IOException e){
            System.out.println(e);
        }



    }

    /** Adds a given word to the dictionary.
     * @param word the word to add to the dictionary
     */
    public void add(String word) {
        add(word.toLowerCase(), root);
    }

    /**
     * Checks if a given word is in the dictionary
     * @param word the word to check
     * @return true if the word is in the dictionary, false otherwise
     */
    public boolean check(String word) {
        return check(word.toLowerCase(), root);
    }

    /**
     * Checks if a word with the given prefix is in the dictionary
     * @param prefix The prefix of a word
     * @return true if this prefix is a prefix of any word in the dictionary,
     * and false otherwise
     * Example: "ca" is a valid prefix, if there is a word in the tree that
     * starts with "ca" (like the word "cat").
     */
    public boolean checkPrefix(String prefix) {
        return checkPrefix(prefix.toLowerCase(), root);
    }


    /**
     * If the word is a valid word in the tree, return the ArrayList with just this word.
     * If the word is NOT a valid word in this tree, return a list of valid
     * words from the tree that have the longest common prefix with the given word.
     * Refer to the description of this method in the pdf.

     * @param word the target word
     * @return a list of valid words from the tree that have the longest common prefix with the given word
     */
    @Override
    public List<String> suggest(String word) {
        List<String> suggestions = new ArrayList<>();
        // Find a node with the longest common prefix (write a helper method)
       //  Find words below the "longest common prefix" node (write another helper method)

        return suggestions;
    }

    /** Return a string representation of the prefix tree.
     * See expectedDictionary1.txt and expectedTree_Small.txt to understand the format.
     * @return string, representing the tree.
     */
    public String toString() {
        return toString(root, 0);
    }

    // ---------- Private helper methods ---------------

    /**
     * Adds (recursively) a given string to the subtree with the given root
     * @param word a word to add
     * @param node root of a subtree

     */
    private void add(String word, Node node) {
        // Must be recursive
        if (word.isEmpty()) {
            // FILL IN CODE
            // This is the node where this word "ends"
            node.isWord = true;
            return;
        }
        int index = (int) word.charAt(0) - (int) 'a'; // index of the child that corresponds to the first letter in s
        // FILL IN CODE
        // If this child is null, point it to a new Node
        // Call add recursively (decide which word to pass, and in which subtree you want to insert it)
        if(node.children[index] == null){
            node.children[index] = new Node();
        }
        System.out.println(word + " " + node.children[index].isWord);
        add(word.substring(1), node.children[index]);
    }


    /** A private recursive method to check whether a given word is stored in the given subtree.
     *  Checks if there is a node with isWord = true, such that if we concatenate all the letters
     *  in the edges on the path from the root of the subtree to this node, we will get the given word
     * Example: the tree below stores the word "ale", so check ("ale", root) would  return true.
      a
        l
          e*
     * @param word the string to check
     * @param node the root of a subtree
     * @return true if the word is in the dictionary, false otherwise
     */
    private boolean check(String word, Node node) {
        int index;
        // Must be recursive
        // FILL IN CODE

        if(node == null){
            return false;
        }
        if(word.isEmpty()){
            if(!node.isWord){
                return false;
            }else{
                return true;
            }
        }
        index = (int) word.charAt(0) - (int) 'a';
        return check(word.substring(1), node.children[index]);
    }

    /**
     * A private recursive method to check whether there is a word in the prefix tree
     * that starts with the given prefix
     * Example: consider the tree below.
     * checkPrefix("a") should return true, because "ale" starts with "a".
     * checkPrefix("al") should also return true because "ale" starts with "al".
     * checkPrefix("ale") would also be true.
     * On the other hand, checkPrefix ("le") will return false on the tree shown below.
     * Because the tree stores a single word "ale" and it does not start with "le".
     *
       a
         l
           e*

     * @param prefix the prefix
     * @param node root of the subtree
     * @return true if there is at least one word in the dictionary that starts with this prefix, false otherwise
     */
    private boolean checkPrefix(String prefix, Node node) {
        // FILL IN CODE:
        // Must be recursive

        return false;

    }

    /**
     * Returns a string representing a tree: uses indentations to show nodes at different levels
     * Shows the letter corresponding to the incoming edge of the node.
     * Adds * to the prefix of the node, if the valid bit is set to true
     * @param node the root of the tree
     * @param numIndentations the number of indentations to print at the current level
     */
    private String toString(Node node, int numIndentations) {
        StringBuilder sb = new StringBuilder();
        if (node == null) {
            return sb.toString();
        }
        // FILL IN CODE: Iterate over the children; for each child at index i: node.children[i],
        // compute the character of the edge:  char ch = (char) ('a' + i);
        // Print indentations (white spaces)
        // Print the character of the edge, ch
        // Print * if isWord is true for the child at index i
        // Append a new line character (you can use System.lineSeparator())
        // Make a recursive call on the same method and append the result to sb
        for(int i = 0; i < 26; i++){
            if(node.children[i] != null){
                sb.append((char) ('a' + i));
            }
            if(node.children[i].isWord){
                sb.append('*');
            }

        }


        return sb.toString();
    }
}
