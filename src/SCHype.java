/*
 * SCHype - Java package for spectral clustering in hypergraphs
 * 
 * Copyright (C) 2011-2012 Tom Michoel, Freiburg Institute for Advanced Studies
 * 
 */
 
import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class SCHype {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// mandatory parameters
		String hgfile = null;
		String outputfile = null;
		
		// optional parameters
		boolean dir = false;
		double p = 1.0;
		double q = p;
		boolean clusteredges = true;
		double tolerance = 1E-5;
		int maxstep = 1000;
		int minclustsize = 1;
		double minclustscore = 0.0;
		
		// create options
		Options opts = new Options();
		opts.addOption("hgfile", true, "Hypergraph input file.");
		opts.addOption("outputfile", true, "Output file name.");
		opts.addOption("dir", true, "Flag for directed hypergraphs, default 0.");
		opts.addOption("p", true, "Edge-to-node scaling parameter, default 1.0.");
		opts.addOption("q", true, "Edge-to-node scaling parameter for target set in directed hypergpraphs," +
				", default equal to p.");
		opts.addOption("clusteredges", true, "Flag for clustering edges or nodes, default 1.");
		opts.addOption("tolerance", true, "Tolerance for convergence of eigenvector calculation, default 1E-5.");
		opts.addOption("maxstep", true, "Maximum number of iterations in eigenvector calculation, default 1000, " +
				" message printed if exceeded.");
		opts.addOption("minclustsize", true, "In output, only keep clusters with at least this number of nodes, " +
				"default 1.");
		opts.addOption("minclustscore", true, "In output, only keep clusters with at least this score value, " +
				"default 0.0.");
		
	}
	
	public static void Die (String msg) {
		System.out.println(msg);
		System.exit(1);
	}
	
	public static void printBanner () {
		System.out.println("");
		System.out.println("SCHype - Spectral Clustering in Hypergraphs");
		System.out.println("-------------------------------------------");
		System.out.println("Version 1.0");
		System.out.println("Copyright (c) 2011-2012 Tom Michoel");
		System.out.println("");
	}

}
