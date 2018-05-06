/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edge.Edge;

/**
 * A mutable weighted directed graph with labeled vertices.
 * Vertices have distinct labels of an immutable type {@code L} when compared
 * using the {@link Object#equals(Object) equals} method.
 * Edges are directed and have a positive weight of type {@code int}.
 * 
 * <p>PS2 instructions: this is a required ADT interface.
 * You MUST NOT change the specifications or add additional methods.
 * 
 * @param <L> type of vertex labels in this graph, must be immutable
 */
public interface Graph<L, E> {
    
    /**
     * Create an empty graph.
     * 
     * @param <L> type of vertex labels in the graph, must be immutable
     * @return a new empty weighted directed graph
     */
    public static ConcreteGraph empty() {
    	return null;
    }
    
    /**
     * Add a vertex to this graph.
     * 
     * @param vertex label for the new vertex
     * @return true if this graph did not already include a vertex with the
     *         given label; otherwise false (and this graph is not modified)
     */
    public boolean add(L v);
    
    /**
     * Remove a vertex from this graph; any edges to or from the vertex are
     * also removed.
     * 
     * @param vertex label of the vertex to remove
     * @return true if this graph included a vertex with the given label;
     *         otherwise false (and this graph is not modified)
     */
    public boolean remove(L v);
    
    /**
     * Get all the vertices in this graph.
     * 
     * @return the set of labels of vertices in this graph
     */
    public Set<L> vertices();
    
    /**
     * Get the source vertices with directed edges to a target vertex and the
     * weights of those edges.
     * 
     * @param target a label
     * @return a map where the key set is the set of labels of vertices such
     *         that this graph includes an edge from that vertex to target, and
     *         the value for each key is the (nonzero) weight of the edge from
     *         the key to target
     */
    public Map<L, List<Double>> sources(L target);
    
    /**
     * Get the target vertices with directed edges from a source vertex and the
     * weights of those edges.
     * 
     * @param source a label
     * @return a map where the key set is the set of labels of vertices such
     *         that this graph includes an edge from source to that vertex, and
     *         the value for each key is the (nonzero) weight of the edge from
     *         source to the key
     */
    public Map<L, List<Double>> targets(L source);
    
    /**
     * Add a edge to this graph.
     * 
     * @param edge label for the new edge
     * @return true if this graph did not already include a edge with the
     *         given label; otherwise false (and this graph is not modified)
     */
    public boolean addEdge(E edge);
    
    /**
     * Remove a edge from this graph.
     * 
     * @param edge label of the edge to remove
     * @return true if this graph included a edge with the given label;
     *         otherwise false (and this graph is not modified)
     */
    public boolean removeEdge(E edge); 
    
    /**
     * Get all the edges in this graph.
     * 
     * @return the set of labels of edges in this graph
     */
    public Set<Edge> edges();
    
    public String setLabel(String s);
    public String getLabel();
}
