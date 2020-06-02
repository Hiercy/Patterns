package com.mike.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {

    private final Map<TreeType, Tree> trees;

    public TreeFactory() {
        trees = new HashMap<>();
    }

    Tree createTree(TreeType type) {
        Tree tree = trees.get(type);
        if (tree == null) {
            switch (type) {
                case OAK -> {
                    tree = new OakTree();
                    trees.put(type, tree);
                }
                case MAPLE -> {
                    tree = new MapleTree();
                    trees.put(type, tree);
                }
            }
        }
        return tree;
    }
}
