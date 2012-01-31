/*
 * SCHype - Java package for spectral clustering in hypergraphs
 * 
 * Copyright (C) 2011-2012 Tom Michoel, Freiburg Institute for Advanced Studies
 * 
 */

import java.util.*;

public class Edge {
	
	public HashSet<String> vertices;
	
	public ArrayList<String> orderedVertices; // sometimes useful
	
	public HashSet<String> sourceVertices; // only used in directed hypergraphs
	
	public HashSet<String> targetVertices; // only used in directed hypergraphs
	
	public double weight;
	
	public Edge(){
		
	}
	
	/**
	 * Undirected edge
	 * @param vertices
	 */
	public Edge(HashSet<String> vertices){
		this.vertices = vertices;
		this.weight = 1.0;
	}
	
	/**
	 * Undirected edge
	 * @param vertices
	 * @param weight
	 */
	public  Edge(HashSet<String> vertices, double weight){
		this.vertices = vertices;
		this.weight = weight;
	}
	
	/**
	 * Undirected edge
	 * @param orderedVertices
	 */
	public Edge(ArrayList<String> orderedVertices){
		this.orderedVertices = orderedVertices;
		this.vertices = new HashSet<String>();
		for (String node : this.orderedVertices)
			this.vertices.add(node);
		this.weight = 1.0;
	}
	
	/**
	 * Undirected edge
	 * @param orderedVertices
	 * @param weight
	 */
	public  Edge(ArrayList<String> orderedVertices, double weight){
		this.orderedVertices = orderedVertices;
		this.vertices = new HashSet<String>();
		for (String node : this.orderedVertices)
			this.vertices.add(node);
		this.weight = weight;
	}
	
	/**
	 * Directed edge
	 * @param vertices
	 */
	public Edge(HashSet<String> sourceVertices, HashSet<String> targetVertices){
		this.sourceVertices = sourceVertices;
		this.targetVertices = targetVertices;
		this.vertices = new HashSet<String>();
		for (String node : this.sourceVertices)
			this.vertices.add(node);
		for (String node : this.targetVertices)
			this.vertices.add(node);
		this.weight = 1.0;
	}
	
	/**
	 * Directed edge
	 * @param vertices
	 */
	public Edge(HashSet<String> sourceVertices, HashSet<String> targetVertices, double weight){
		this.sourceVertices = sourceVertices;
		this.targetVertices = targetVertices;
		this.vertices = new HashSet<String>();
		for (String node : this.sourceVertices)
			this.vertices.add(node);
		for (String node : this.targetVertices)
			this.vertices.add(node);
		this.weight = weight;
	}
	
	/**
	 * Check if an edge is a subset of a cluster
	 * @param clust
	 * @return
	 */
	public boolean belongsTo (HashSet<String> clust){
		boolean isSubSet = true;
		for (String node : this.vertices){
			isSubSet = isSubSet & clust.contains(node);
			if (!isSubSet)
				break;
		}
		return isSubSet;
	}
	
	public boolean belongsTo (HashSet<String> sourceClust, HashSet<String> targetClust){
		boolean isSubSet = true;
		for (String node : this.sourceVertices){
			isSubSet = isSubSet & sourceClust.contains(node);
			if (!isSubSet){
				return isSubSet;
			}
		}
		for (String node : this.targetVertices){
			isSubSet = isSubSet & targetClust.contains(node);
			if (!isSubSet){
				return isSubSet;
			}
		}
		return isSubSet;
	}
	
	public String toString(){
		String out = "";
		for (String node : this.vertices)
			out += node + " ";
		out.trim();
		return out;
	}
	
	public String toStringDirected(){
		String out = "";
		for (String node : this.sourceVertices)
			out += node + " ";
		out += "| ";
		for (String node : this.targetVertices)
			out += node + " ";
		out += "> " + String.valueOf(this.weight);
		out.trim();
		return out;
	}
}
