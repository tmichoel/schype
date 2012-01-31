/*
 * SCHype - Java package for spectral clustering in hypergraphs
 * 
 * Copyright (C) 2011-2012 Tom Michoel, Freiburg Institute for Advanced Studies
 * 
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dir = "/Users/tom/Research/Net_Align/yeast_paths_tfs_del/tfdel_paths_dir";
		String file = "yeast_paths_tfdel_dir.txt";
		boolean undirected = false; //true;
		HyperGraph hg = new HyperGraph(dir, file, undirected);
		PFClustering clust = new PFClustering(hg, 1.0, 1.0);
//		PFClustering clust = new PFClustering(hg, 1.0);
//		clust.pfClustering();
		clust.recursivePfClustering();
		clust.postProcessing();
//		clust.writeScores(dir, "Cross_tissue_lemone_hypergraph_scores.txt");
		clust.writeClusters("test", "path_clusters.txt");
		clust.writeClusterEdges("test", "path_clusters_edges.txt");
//		for (int k=0; k<clust.clusters.size(); k++){
//			writeVector(clust.clusters.get(k).perronVector, dir, "geom_graph_100_tri_vector_"+k+".txt");
//		}
	}

	public static void writeVector(HashMap<String,Double> v, String dir, String file){
		try {
			File f = new File(dir, file);
			PrintWriter pw = new PrintWriter(f);
			for (String node : v.keySet())
				pw.println(node + "\t" + v.get(node));
			pw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
