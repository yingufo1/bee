package com.bee.datastruct.tree.trie;/** * TrieNode * * @author yangying * @version 1.0 * @since 2022/5/29 **/public class TrieNode {    public TrieNode[] children;    public boolean isWord;    public TrieNode() {        children = new TrieNode[26];    }}