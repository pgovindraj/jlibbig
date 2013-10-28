package it.uniud.mads.jlibbig.udlang;

import java.util.ArrayList;
import java.io.*;
import beaver.*;
import java.util.*;
import it.uniud.mads.jlibbig.core.std.Bigraph;
import it.uniud.mads.jlibbig.core.std.BigraphBuilder;
import it.uniud.mads.jlibbig.core.std.Control;
import it.uniud.mads.jlibbig.core.std.Handle;
import it.uniud.mads.jlibbig.core.std.InnerName;
import it.uniud.mads.jlibbig.core.std.Node;
import it.uniud.mads.jlibbig.core.std.OuterName;
import it.uniud.mads.jlibbig.core.std.Point;
import it.uniud.mads.jlibbig.core.std.Port;
import it.uniud.mads.jlibbig.core.std.Root;
import it.uniud.mads.jlibbig.core.std.Signature;
import it.uniud.mads.jlibbig.core.std.SignatureBuilder;

/**
 * This class is a LALR parser generated by <a
 * href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1 from the grammar
 * specification "brs_parser.grammar".
 */
public class BRSParser extends Parser {
	static public class Terminals {
		static public final short EOF = 0;
		static public final short VARID = 1;
		static public final short ZERO = 2;
		static public final short ONE = 3;
		static public final short TAGOPEN = 4;
		static public final short PAROPEN = 5;
		static public final short PLUS = 6;
		static public final short SIGIL = 7;
		static public final short NIL = 8;
		static public final short SEMICOLON = 9;
		static public final short POINT = 10;
		static public final short SQCLOSE = 11;
		static public final short DASH = 12;
		static public final short TAGCLOSE = 13;
		static public final short PIPE = 14;
		static public final short COMMA = 15;
		static public final short DPIPE = 16;
		static public final short NUM = 17;
		static public final short MODE = 18;
		static public final short SLASH = 19;
		static public final short COLON = 20;
		static public final short REACT = 21;
		static public final short PERCENT = 22;
		static public final short SQOPEN = 23;
		static public final short PARCLOSE = 24;
	}

	static final ParsingTables PARSING_TABLES = new ParsingTables(
			"U9oLb4TlKq4KXOznCDZ1CObfTkA4aE1GJ23qGEXbnuPVW4IJW1KBn0ua42n00b6a824XkYW"
					+ "I2yIU$q3llVTGGitbcybBOfw24E$fUtFFcJltvOtdHj95CzLgeYQfKfFjfoPecdNqE8ewfq"
					+ "YNX7I$a2xzKzlpa7uQoXyKqXclqnggfFgY1gXP2LHQWpLJ$N7IYca8JWPdjeOHDHB5rKTpL"
					+ "B1B6gXoJSLhKQCzinSga5cmXogpsngj2hNOVP#JKPxQ8ra$dlNJbMLDDTIHKx0Rh7DPOrYJ"
					+ "X4QbdBQR#BDOsq1MddUCKXLZJcDLONTLenaQpkmuZL2ztRBhTarDccBtx0vlAT4yBT12oHv"
					+ "8ciluG$E98lpjKMRxKhCVtrZivBpJepF$qF7$rE7r2QzZAkFNYAEgsPVXg1XVN#ET6BkLmK"
					+ "dWv7mK8Hh2ljKpb$ULXk4DW3XtpAz9it#bUEMGz3a9AcVPlSxrDLIAi6iHVf5oyal1PQN8h"
					+ "$IrghrsVfQrARAo#5MSdIpLgz19xXHr4cGF9RFphiHnCn7$1hwA4v#62WVdJrgqcOUPVN9Z"
					+ "S2qCud9O4iIhe3g8yx0IDaAZyxhWoi1wg8LPC1fMGnFiXcMm2zR10MY6Gx0Fri3XeCuHs0b"
					+ "RuMXGVXiSWrEXT#u8wNcmj4WVXrRO0oVWF9o4E9o62t06zi8vEDjLXtrfWuwYMh6YkAdulO"
					+ "6teHSltrKl61S7uzfWt1ICAu9nLz7QvRtKsr8KRm$F1$x#a6xzIzxKa3xuDysrY9FIRkqkj"
					+ "E$##Sq$logux8azjaUCN#0pV8AFtRDjzi7U#UYzGfTTjIjscV6jlR7NtdbbByDPtTc$U1Hy"
					+ "l#KvrtNqHJsEwy4SVP8B$dVavCvZD8Jh#nYK#9x8K2CJz4VdV8IU5xYkSqJfcqWtxbpN#cw"
					+ "LxzWQJvJE5KJenIwYdYprisWtDlm6h4FG9W==");

	static final Action RETURN2 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 2];
		}
	};

	private static final BRSParser instance = new BRSParser();
	private BigraphRewritingSystem _sys;

	/**
	 * Get an instance of this parser.
	 * 
	 * @return Parser's instance.
	 */
	BRSParser getInstance() {
		return instance;
	}

	/**
	 * Generate a system (sets of bigraphs and reactions with the same
	 * signature) from a string.
	 * 
	 * @param str
	 *            the string that will be parsed.
	 * @return Return a system, carrying bigraphs and reactions with the same
	 *         signature.
	 * @throws IOException
	 * @throws Parser.Exception
	 * @see BigraphRewritingSystem
	 */
	BigraphRewritingSystem parse(String str) throws IOException, Exception {
		return parse(new StringReader(str));
	}

	/**
	 * Generate a system (sets of bigraphs and reactions with the same
	 * signature) from a string.
	 * 
	 * @param in
	 *            the Reader that will be parsed.
	 * @return Return a system, carrying bigraphs and reactions with the same
	 *         signature.
	 * @throws IOException
	 * @throws Parser.Exception
	 * @see BigraphRewritingSystem
	 */
	BigraphRewritingSystem parse(Reader in) throws IOException, Exception {
		_sys = null;
		parse(new BRSLexer(in));
		return _sys;
	}

	/**
	 * Generate a system (sets of bigraphs and reactions with the same
	 * signature) from a string.
	 * 
	 * @param str
	 *            the string that will be parsed.
	 * @param sig
	 *            the signature that will be used in the system.
	 * @return Return a system, carrying bigraphs and reactions with the same
	 *         signature.
	 * @throws IOException
	 * @throws Parser.Exception
	 * @see BigraphRewritingSystem
	 */
	BigraphRewritingSystem parse(String str, Signature sig) throws IOException,
			Exception {
		return parse(new StringReader(str), sig);
	}

	/**
	 * Generate a system (sets of bigraphs and reactions with the same
	 * signature) from a string.
	 * 
	 * @param in
	 *            the Reader that will be parsed.
	 * @param sig
	 *            the signature that will be used in the system.
	 * @return Return a system, carrying bigraphs and reactions with the same
	 *         signature.
	 * @throws IOException
	 * @throws Parser.Exception
	 * @see BigraphRewritingSystem
	 */
	BigraphRewritingSystem parse(Reader in, Signature sig) throws IOException,
			Exception {
		_sys = new BigraphRewritingSystem(sig);
		parse(new BRSLexer(in));
		return _sys;
	}

	/**
	 * Override default recoverFromError method. Policy: never recover.
	 */
	protected void recoverFromError(Symbol token, TokenStream in)
			throws IOException, Parser.Exception {
		throw new IOException("Syntax Error.");
	}

	/**
	 * This class stores inner and outer names
	 * 
	 */
	private class NameId {
		private String name;
		private Boolean outer;

		NameId(String name, Boolean outer) {
			this.name = name;
			this.outer = outer;
		}
	}

	/**
	 * Class used to store bigraphs during parse.
	 * 
	 */
	private class ParsedBigraph {
		private BigraphBuilder bb;
		private Boolean polymorphicSites;
		private List<Integer> siteNames;

		ParsedBigraph(Signature sig) {
			bb = new BigraphBuilder(sig);
			polymorphicSites = false;
			siteNames = new ArrayList<>();
		}

		/**
		 * Close all sites of the parsed bigraph.
		 */
		void closeSites() {
			this.polymorphicSites = false;
			BigraphBuilder ground = new BigraphBuilder(this.bb.getSignature());
			for (int i = 0; i < this.bb.getSites().size(); ++i)
				ground.addRoot();
			for (InnerName in : this.bb.getInnerNames())
				ground.addInnerName(in.getName(),
						ground.addOuterName(in.getName()));
			this.bb.innerCompose(ground.makeBigraph());
		}

		/**
		 * Juxtapose the current bigraph with the ParsedBigraph in input.
		 * 
		 * @param pb
		 *            bigraph that will be juxtaposed.
		 */
		void juxtapose(ParsedBigraph pb) throws IllegalArgumentException {
			if (!Collections.disjoint(this.siteNames, pb.siteNames))
				throw new IllegalArgumentException(
						"Can't juxtapose two bigraph with overlapping sites: "
								+ this.siteNames + " + " + pb.siteNames);
			if (pb.polymorphicSites)
				pb.closeSites();
			if (this.polymorphicSites)
				this.closeSites();

			this.bb.rightJuxtapose(pb.bb.makeBigraph());
			this.siteNames.addAll(pb.siteNames);
		}

		/**
		 * Juxtapose the current bigraph with the bigraph in input. Outernames
		 * in both bigraph will be merged.
		 * 
		 * @param pb
		 *            bigraph that will be juxtaposed.
		 */
		void parallelProduct(ParsedBigraph pb) throws IllegalArgumentException {
			if (!Collections.disjoint(this.siteNames, pb.siteNames))
				throw new IllegalArgumentException(
						"Can't juxtapose two bigraph with overlapping sites: "
								+ this.siteNames + " + " + pb.siteNames);
			if (pb.polymorphicSites)
				pb.closeSites();
			if (this.polymorphicSites)
				this.closeSites();

			this.bb.rightParallelProduct(pb.bb.makeBigraph());
			this.siteNames.addAll(pb.siteNames);
		}

		/**
		 * Merge the current bigraph with the bigraph in input.
		 * 
		 * @param pb
		 *            bigraph that will be juxtaposed.
		 */
		void merge(ParsedBigraph pb) throws IllegalArgumentException {
			if (!Collections.disjoint(this.siteNames, pb.siteNames))
				throw new IllegalArgumentException(
						"Can't juxtapose two bigraph with overlapping sites: "
								+ this.siteNames + " + " + pb.siteNames);
			if (pb.polymorphicSites)
				pb.closeSites();
			if (this.polymorphicSites)
				this.closeSites();

			this.bb.rightParallelProduct(pb.bb.makeBigraph());
			this.bb.merge();
			this.siteNames.addAll(pb.siteNames);
		}

		/**
		 * Nest the bigraph in input with the current bigraph. Input bigraph's
		 * innernames not appearing in current bigraph's outerface will appear
		 * in the resulting bigraph's innerface. bigraph's outernames not
		 * appearing in input bigraph's innerface will appear in the resulting
		 * bigraph's outerface.
		 * 
		 * @param pb
		 *            bigraph that will be composed.
		 */
		void outerNest(ParsedBigraph pb) throws RuntimeException {
			if (pb.polymorphicSites) {
				if (pb.bb.getSites().size() == 0) {
					for (int i = 0; i < this.bb.getRoots().size(); ++i) {
						pb.bb.addSite(pb.bb.addRoot());
						pb.siteNames.add(i);
					}
				} else {
					pb.siteNames.add(0);
				}
				pb.polymorphicSites = false;
			}

			Set<String> this_outernames = new HashSet<>();
			Set<String> outer_innernames = new HashSet<>();
			Map<String, OuterName> outer_outernames = new HashMap<>();

			for (OuterName out : this.bb.getOuterNames())
				this_outernames.add(out.getName());

			for (InnerName inn : pb.bb.getInnerNames()) {
				if (!this_outernames.contains(inn.getName())) {
					try {
						this.bb.addInnerName(inn.getName(),
								this.bb.addOuterName(inn.getName()));
					} catch (RuntimeException e) {
						throw new RuntimeException(
								"The same innername ( -"
										+ inn.getName()
										+ " ) can't appear multiple times in a single bigraph");
					}
				}
				outer_innernames.add(inn.getName());
			}

			for (OuterName out : pb.bb.getOuterNames())
				outer_outernames.put(out.getName(), out);

			for (String outer : this_outernames) {
				if (!outer_innernames.contains(outer)) {
					OuterName outername = outer_outernames.get(outer);
					if (outername == null) {
						OuterName new_out = pb.bb.addOuterName(outer);
						outer_outernames.put(outer, new_out);
						pb.bb.addInnerName(outer, new_out);
					} else
						pb.bb.addInnerName(outer, outername);
				}
			}

			this.bb.outerCompose(pb.makeBigraph());
		}

		/**
		 * This operation is meant to be used to perform a set of operation on
		 * the link graph. The first parameter, if not null, represent an
		 * outername that will be added. if null, it represent an edge. The
		 * second parameter is a list of names that will be linked with the
		 * Handle generated from the first parameter. The resulting link graph
		 * will be nested with the current bigraph (using an identity place
		 * graph), according with the following rules: if a name of the second
		 * parameter is an innername (-x) then it will appear in the resulting
		 * bigraph's innerface. if it isnt an innername, then if exists an
		 * outername of the current bigraph with the same name, it will be
		 * linked with this outername, otherwise the name will be treated as an
		 * innername.
		 * 
		 * @param outer
		 *            outername
		 * @param names
		 *            list of names.
		 */
		void rename(NameId outer, List<NameId> names) throws RuntimeException {
			if (outer == null && names.size() == 0)
				return;
			if (outer != null && outer.outer != null && !outer.outer)
				throw new IllegalArgumentException(
						"Innernames ( -"
								+ outer.name
								+ " ) can't appear as the first argument of <x/xs> operator.");
			BigraphBuilder outer_bigraph = new BigraphBuilder(
					this.bb.getSignature());

			Handle o = null;
			if (outer != null)
				o = outer_bigraph.addOuterName(outer.name);

			Set<String> this_outernames = new HashSet<>();
			Set<String> names_string = new HashSet<>();

			for (OuterName out : this.bb.getOuterNames())
				this_outernames.add(out.getName());

			for (NameId name : names) {
				if (name.outer != null && name.outer)
					throw new RuntimeException(
							"Outernames ( +"
									+ name.name
									+ " ) can't appear in the second argument of <x/xs> operator.");
				String new_name = name.name;
				if (name.outer != null || !this_outernames.contains(name.name)) {
					OuterName newOuter = this.bb.addOuterName();
					try {
						this.bb.addInnerName(name.name, newOuter);
					} catch (RuntimeException e) {
						throw new RuntimeException(
								"The same innername ( -"
										+ name.name
										+ " ) can't appear multiple times in a single bigraph");
					}
					new_name = newOuter.getName();
				} else
					names_string.add(name.name);

				if (o == null)
					o = outer_bigraph.addInnerName(new_name).getHandle();
				else
					outer_bigraph.addInnerName(new_name, o);
			}

			for (String outername : this_outernames) {
				if (!names_string.contains(outername)) {
					if (outer == null || !outer.name.equals(outername))
						outer_bigraph.addInnerName(outername,
								outer_bigraph.addOuterName(outername));
					else
						outer_bigraph.addInnerName(outername, o);
				}
			}

			for (int i = 0; i < this.bb.getRoots().size(); ++i)
				outer_bigraph.addSite(outer_bigraph.addRoot());

			this.bb.outerCompose(outer_bigraph.makeBigraph());
		}

		/**
		 * Make a Bigraph from the current ParsedBigraph. This procedure isn't
		 * meant to be used by the user, as it change the internal state of the
		 * ParsedBigraph and can only be used once.
		 * 
		 * @return The generated bigraph.
		 */
		Bigraph makeBigraph() throws RuntimeException {
			if (polymorphicSites && bb.getSites().size() == 1) {
				closeSites();
				return bb.makeBigraph();
			}

			class SiteInt implements Comparable<SiteInt> {
				private Root root;
				private Integer pos;

				SiteInt(Root r, int i) {
					root = r;
					pos = i;
				}

				public int compareTo(SiteInt si) {
					return pos.compareTo(si.pos);
				}
			}

			if (bb.getSites().size() != siteNames.size())
				throw new RuntimeException(
						"Error while checking the number of sites. Indices Lost.");

			List<SiteInt> siteints = new ArrayList<>();
			BigraphBuilder inner = new BigraphBuilder(bb.getSignature());
			for (InnerName in : bb.getInnerNames())
				inner.addInnerName(in.getName(),
						inner.addOuterName(in.getName()));

			for (Integer v : siteNames)
				siteints.add(new SiteInt(inner.addRoot(), v));

			Collections.sort(siteints);
			for (SiteInt sint : siteints)
				inner.addSite(sint.root);

			bb.innerCompose(inner.makeBigraph());

			return bb.makeBigraph();
		}

	}

	/**
	 * Generate a ParsedBigraph with only one root and a site ($i).
	 * 
	 * @param sig
	 *            Signature of the bigraph.
	 * @param i
	 *            Index of the site ($i).
	 * @return A bigraph with only one root and one site.
	 */
	static ParsedBigraph site(Signature sig, Integer i) {
		ParsedBigraph pb = instance.new ParsedBigraph(sig);
		pb.bb.addSite(pb.bb.addRoot());
		pb.siteNames.add(i);
		return pb;
	}

	/**
	 * Generate a ParsedBigraph with only one root.
	 * 
	 * @param sig
	 *            Signature of the bigraph.
	 * @return A bigraph with only one root.
	 */
	static ParsedBigraph nil(Signature sig) {
		ParsedBigraph pb = instance.new ParsedBigraph(sig);
		pb.bb.addRoot();
		return pb;
	}

	/**
	 * Generate a ParsedBigraph with one root and a node inside it. The node
	 * will have an "anonymous site" inside it, that will automatically closed
	 * if no composition are made using this bigraph.
	 * 
	 * @param sig
	 *            Signature of the bigraph.
	 * @param name
	 *            control's name.
	 * @param list
	 *            list of names connected with the node's ports. If an entry of
	 *            this list is null, then the corresponding port will remain
	 *            unlinked.
	 * @return The resulting bigraph.
	 */
	static ParsedBigraph node(Signature sig, String name, List<NameId> list)
			throws RuntimeException {
		ParsedBigraph pb = instance.new ParsedBigraph(sig);
		pb.polymorphicSites = true;

		if (pb.bb.getSignature().getByName(name) == null)
			throw new IllegalArgumentException("Control \"" + name
					+ "\" should be in the signature.");
		// place graph
		Node node = pb.bb.addNode(name, pb.bb.addRoot());
		pb.bb.addSite(node);

		// link graph
		if (list == null)
			return pb;

		List<? extends Port> ports = node.getPorts();

		if (ports.size() < list.size())
			throw new IllegalArgumentException("Control \"" + name + "\" have "
					+ ports.size() + " ports, " + list.size()
					+ " ports found in one of its instances.");

		Map<String, OuterName> outerNames = new HashMap<>();
		Set<String> innerNames = new HashSet<>();

		Iterator<? extends Port> portIt = ports.iterator();
		for (NameId nameid : list) {
			if (nameid == null) {
				// case: "-" , skip this port (already has an edge attached to
				// it)
				portIt.next();
				continue;
			}
			if (nameid.outer == null || nameid.outer == true) {
				// case: "+p" or "p" , this name must appear in the outerface of
				// this bigraph
				OuterName outer = outerNames.get(nameid.name);
				if (outer == null)
					outerNames.put(nameid.name,
							outer = pb.bb.addOuterName(nameid.name));
				pb.bb.relink(outer,(Point) portIt.next());
			} else {
				// case: "-p" , innerface
				if (innerNames.contains(nameid.name))
					throw new RuntimeException(
							"Innernames ( -"
									+ nameid.name
									+ " ) can't appear multiple time in a single bigraph.");
				Handle inner_edge = ((Port) portIt.next()).getHandle();
				pb.bb.addInnerName(nameid.name, inner_edge);
				innerNames.add(nameid.name);
			}
		}

		return pb;
	}

	/**
	 * This function is meant to change the value of the parsed eta, and build a
	 * new eta where all values are <= redex_sites.size(). The user can also use
	 * non-consecutives names for redex' sites, but redex will be represented as
	 * consecutives and, with this function, the same will be done for the eta.
	 */
	static int[] eta(List<Integer> redex_sites, List<Integer> parsed_eta)
			throws RuntimeException {
		int[] r_eta = new int[parsed_eta.size()];
		int i = 0;
		for (Integer j : parsed_eta) {
			if ((r_eta[i++] = redex_sites.indexOf(j)) == -1)
				throw new RuntimeException("No sites named " + j
						+ " in the redex of this reaction. Sites: "
						+ redex_sites + ". Eta: " + parsed_eta);
		}
		return r_eta;
	}

	private final Action[] actions;

	public BRSParser() {
		super(PARSING_TABLES);
		actions = new Action[] { RETURN2, // [0] start = definitionlist models;
											// returns 'models' although none is
											// marked
				Action.RETURN, // [1] start = models
				new Action() { // [2] definitionlist = definitions.sb MODE.m
								// VARID.v COLON num.n SEMICOLON
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_sb = _symbols[offset + 1];
						final SignatureBuilder sb = (SignatureBuilder) _symbol_sb.value;
						final Symbol _symbol_m = _symbols[offset + 2];
						final boolean m = (boolean) _symbol_m.value;
						final Symbol _symbol_v = _symbols[offset + 3];
						final String v = (String) _symbol_v.value;
						final Symbol _symbol_n = _symbols[offset + 5];
						final int n = (int) _symbol_n.value;

						if (_sys == null) {
							if (sb.contains(v))
								throw new RuntimeException("Line: "
										+ Symbol.getLine(_symbol_m.getStart())
										+ " - Control already defined: " + v);
							sb.add(v, m, n);
							_sys = new BigraphRewritingSystem(sb.makeSignature());
							return new Symbol(null);
						}
						Control c = null;
						if ((c = _sys.getSignature().getByName(v)) == null
								|| n > c.getArity() || c.isActive() != m)
							throw new RuntimeException("Line: "
									+ Symbol.getLine(_symbol_m.getStart())
									+ " - Control " + v + ", "
									+ (m == true ? "active" : "passive")
									+ " and with arity greater or equal to "
									+ n
									+ ", not found in the input's signature");
						return new Symbol(null);
					}
				}, new Action() { // [3] definitions =
					public Symbol reduce(Symbol[] _symbols, int offset) {

						if (_sys == null)
							return new Symbol(new SignatureBuilder());
						return new Symbol(null);
					}
				}, new Action() { // [4] definitions = definitions.sb MODE.m
									// VARID.v COLON num.n SEMICOLON
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_sb = _symbols[offset + 1];
						final SignatureBuilder sb = (SignatureBuilder) _symbol_sb.value;
						final Symbol _symbol_m = _symbols[offset + 2];
						final boolean m = (boolean) _symbol_m.value;
						final Symbol _symbol_v = _symbols[offset + 3];
						final String v = (String) _symbol_v.value;
						final Symbol _symbol_n = _symbols[offset + 5];
						final int n = (int) _symbol_n.value;

						if (_sys == null) {
							if (sb.contains(v))
								throw new RuntimeException("Line: "
										+ Symbol.getLine(_symbol_m.getStart())
										+ " - Control already defined: " + v);
							sb.add(v, m, n);
							return new Symbol(sb);
						}
						Control c = null;
						if ((c = _sys.getSignature().getByName(v)) == null
								|| n > c.getArity() || c.isActive() != m)
							throw new RuntimeException("Line: "
									+ Symbol.getLine(_symbol_m.getStart())
									+ " - Control " + v + ", "
									+ (m == true ? "active" : "passive")
									+ " and with arity greater or equal to "
									+ n
									+ ", not found in the input's signature");
						return new Symbol(null);
					}
				}, new Action() { // [5] models = models big.b SEMICOLON
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_b = _symbols[offset + 2];
						final ParsedBigraph b = (ParsedBigraph) _symbol_b.value;

						try {
							_sys.addBigraph(b.makeBigraph());
						} catch (RuntimeException e) {
							throw new RuntimeException("Line: "
									+ Symbol.getLine(_symbol_b.getStart())
									+ " - " + e.getMessage());
						}
						return new Symbol(null);
					}
				}, new Action() { // [6] models = models big.r REACT big.s
									// SEMICOLON
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_r = _symbols[offset + 2];
						final ParsedBigraph r = (ParsedBigraph) _symbol_r.value;
						final Symbol _symbol_s = _symbols[offset + 4];
						final ParsedBigraph s = (ParsedBigraph) _symbol_s.value;

						try {
							_sys.addReaction(r.makeBigraph(), s.makeBigraph(),
									new int[0]);
						} catch (RuntimeException e) {
							throw new RuntimeException("Line: "
									+ Symbol.getLine(_symbol_s.getStart())
									+ " - " + e.getMessage());
						}
						return new Symbol(null);
					}
				}, new Action() { // [7] models = models big.r REACT big.s
									// PERCENT eta.et SEMICOLON
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_r = _symbols[offset + 2];
						final ParsedBigraph r = (ParsedBigraph) _symbol_r.value;
						final Symbol _symbol_s = _symbols[offset + 4];
						final ParsedBigraph s = (ParsedBigraph) _symbol_s.value;
						final Symbol _symbol_et = _symbols[offset + 6];
						final LinkedList<Integer> et = (LinkedList<Integer>) _symbol_et.value;

						ArrayList<Integer> redex_sites = new ArrayList<>(
								r.siteNames);
						Collections.sort(redex_sites);
						try {
							_sys.addReaction(r.makeBigraph(), s.makeBigraph(),
									eta(redex_sites, et));
						} catch (RuntimeException e) {
							throw new RuntimeException("Line: "
									+ Symbol.getLine(_symbol_s.getStart())
									+ " - " + e.getMessage());
						}
						return new Symbol(null);
					}
				}, new Action() { // [8] models =
					public Symbol reduce(Symbol[] _symbols, int offset) {
						if (_sys == null)
							_sys = new BigraphRewritingSystem(
									new SignatureBuilder().makeSignature());
						return new Symbol(null);
					}
				}, new Action() { // [9] big = big.b PLUS big.p
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_b = _symbols[offset + 1];
						final ParsedBigraph b = (ParsedBigraph) _symbol_b.value;
						final Symbol _symbol_p = _symbols[offset + 3];
						final ParsedBigraph p = (ParsedBigraph) _symbol_p.value;

						try {
							b.juxtapose(p);
						} catch (RuntimeException e) {
							throw new RuntimeException("Line: "
									+ Symbol.getLine(_symbol_p.getStart())
									+ " - " + e.getMessage());
						}
						return new Symbol(b);
					}
				}, new Action() { // [10] big = big.b DPIPE big.p
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_b = _symbols[offset + 1];
						final ParsedBigraph b = (ParsedBigraph) _symbol_b.value;
						final Symbol _symbol_p = _symbols[offset + 3];
						final ParsedBigraph p = (ParsedBigraph) _symbol_p.value;

						try {
							b.parallelProduct(p);
						} catch (RuntimeException e) {
							throw new RuntimeException("Line: "
									+ Symbol.getLine(_symbol_p.getStart())
									+ " - " + e.getMessage());
						}
						return new Symbol(b);
					}
				}, new Action() { // [11] big = big.b PIPE big.p
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_b = _symbols[offset + 1];
						final ParsedBigraph b = (ParsedBigraph) _symbol_b.value;
						final Symbol _symbol_p = _symbols[offset + 3];
						final ParsedBigraph p = (ParsedBigraph) _symbol_p.value;

						try {
							b.merge(p);
						} catch (RuntimeException e) {
							throw new RuntimeException("Line: "
									+ Symbol.getLine(_symbol_p.getStart())
									+ " - " + e.getMessage());
						}
						return new Symbol(b);
					}
				}, new Action() { // [12] big = big.p POINT big.b
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_p = _symbols[offset + 1];
						final ParsedBigraph p = (ParsedBigraph) _symbol_p.value;
						final Symbol _symbol_b = _symbols[offset + 3];
						final ParsedBigraph b = (ParsedBigraph) _symbol_b.value;

						try {
							b.outerNest(p);
						} catch (RuntimeException e) {
							throw new RuntimeException("Line: "
									+ Symbol.getLine(_symbol_p.getStart())
									+ " - " + e.getMessage());
						}
						return new Symbol(b);
					}
				}, new Action() { // [13] big = TAGOPEN voidorname.x SLASH
									// namesnonull.l TAGCLOSE
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_x = _symbols[offset + 2];
						final NameId x = (NameId) _symbol_x.value;
						final Symbol _symbol_l = _symbols[offset + 4];
						final LinkedList<NameId> l = (LinkedList<NameId>) _symbol_l.value;

						ParsedBigraph b = new ParsedBigraph(_sys.getSignature());
						b.polymorphicSites = true;
						try {
							b.rename(x, l);
						} catch (RuntimeException e) {
							throw new RuntimeException("Line: "
									+ Symbol.getLine(_symbol_x.getStart())
									+ " - " + e.getMessage());
						}
						return new Symbol(b);
					}
				}, new Action() { // [14] big = TAGOPEN voidorname.x SLASH
									// namesnonull.l TAGCLOSE big.b
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_x = _symbols[offset + 2];
						final NameId x = (NameId) _symbol_x.value;
						final Symbol _symbol_l = _symbols[offset + 4];
						final LinkedList<NameId> l = (LinkedList<NameId>) _symbol_l.value;
						final Symbol _symbol_b = _symbols[offset + 6];
						final ParsedBigraph b = (ParsedBigraph) _symbol_b.value;

						try {
							b.rename(x, l);
						} catch (RuntimeException e) {
							throw new RuntimeException("Line: "
									+ Symbol.getLine(_symbol_x.getStart())
									+ " - " + e.getMessage());
						}
						return new Symbol(b);
					}
				}, new Action() { // [15] big = VARID.c SQOPEN names.l SQCLOSE
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_c = _symbols[offset + 1];
						final String c = (String) _symbol_c.value;
						final Symbol _symbol_l = _symbols[offset + 3];
						final LinkedList<NameId> l = (LinkedList<NameId>) _symbol_l.value;

						ParsedBigraph pb;
						try {
							pb = node(_sys.getSignature(), c, l);
						} catch (IllegalArgumentException e) {
							throw new RuntimeException("Line: "
									+ Symbol.getLine(_symbol_c.getStart())
									+ " - " + e.getMessage());
						}
						return new Symbol(pb);
					}
				}, new Action() { // [16] big = VARID.c
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_c = _symbols[offset + 1];
						final String c = (String) _symbol_c.value;

						ParsedBigraph pb;
						try {
							pb = node(_sys.getSignature(), c, null);
						} catch (IllegalArgumentException e) {
							throw new RuntimeException("Line: "
									+ Symbol.getLine(_symbol_c.getStart())
									+ " - " + e.getMessage());
						}
						return new Symbol(pb);
					}
				}, new Action() { // [17] big = SIGIL num.n
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_n = _symbols[offset + 2];
						final int n = (int) _symbol_n.value;
						return new Symbol(site(_sys.getSignature(), n));
					}
				}, new Action() { // [18] big = ZERO
					public Symbol reduce(Symbol[] _symbols, int offset) {
						return new Symbol(
								new ParsedBigraph(_sys.getSignature()));
					}
				}, new Action() { // [19] big = ONE
					public Symbol reduce(Symbol[] _symbols, int offset) {
						return new Symbol(nil(_sys.getSignature()));
					}
				}, new Action() { // [20] big = PAROPEN big.pb PARCLOSE
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_pb = _symbols[offset + 2];
						final ParsedBigraph pb = (ParsedBigraph) _symbol_pb.value;
						return new Symbol(pb);
					}
				}, new Action() { // [21] big = NIL
					public Symbol reduce(Symbol[] _symbols, int offset) {
						return new Symbol(nil(_sys.getSignature()));
					}
				}, new Action() { // [22] eta =
					public Symbol reduce(Symbol[] _symbols, int offset) {
						return new Symbol(new LinkedList<>());
					}
				}, new Action() { // [23] eta = notemptyeta.l
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_l = _symbols[offset + 1];
						final LinkedList<Integer> l = (LinkedList<Integer>) _symbol_l.value;
						return new Symbol(l);
					}
				}, new Action() { // [24] notemptyeta = num.n
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_n = _symbols[offset + 1];
						final int n = (int) _symbol_n.value;

						LinkedList<Integer> l = new LinkedList<>();
						l.add(n);
						return new Symbol(l);
					}
				}, new Action() { // [25] notemptyeta = num.n COMMA
									// notemptyeta.l
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_n = _symbols[offset + 1];
						final int n = (int) _symbol_n.value;
						final Symbol _symbol_l = _symbols[offset + 3];
						final LinkedList<Integer> l = (LinkedList<Integer>) _symbol_l.value;

						l.addFirst(n);
						return new Symbol(l);
					}
				}, new Action() { // [26] num = ZERO
					public Symbol reduce(Symbol[] _symbols, int offset) {
						return new Symbol(0);
					}
				}, new Action() { // [27] num = ONE
					public Symbol reduce(Symbol[] _symbols, int offset) {
						return new Symbol(1);
					}
				}, new Action() { // [28] num = NUM.n
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_n = _symbols[offset + 1];
						final int n = (int) _symbol_n.value;
						return new Symbol(n);
					}
				}, new Action() { // [29] voidorname =
					public Symbol reduce(Symbol[] _symbols, int offset) {
						return new Symbol(null);
					}
				}, new Action() { // [30] voidorname = name.n
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_n = _symbols[offset + 1];
						final NameId n = (NameId) _symbol_n.value;
						return new Symbol(n);
					}
				}, new Action() { // [31] namesnonull =
					public Symbol reduce(Symbol[] _symbols, int offset) {
						return new Symbol(new LinkedList<>());
					}
				}, new Action() { // [32] namesnonull = notemptynamesnonull.l
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_l = _symbols[offset + 1];
						final LinkedList<NameId> l = (LinkedList<NameId>) _symbol_l.value;
						return new Symbol(l);
					}
				}, new Action() { // [33] notemptynamesnonull = name.n
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_n = _symbols[offset + 1];
						final NameId n = (NameId) _symbol_n.value;

						List<NameId> l = new LinkedList<>();
						l.add(n);
						return new Symbol(l);
					}
				}, new Action() { // [34] notemptynamesnonull = name.n COMMA
									// notemptynamesnonull.l
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_n = _symbols[offset + 1];
						final NameId n = (NameId) _symbol_n.value;
						final Symbol _symbol_l = _symbols[offset + 3];
						final LinkedList<NameId> l = (LinkedList<NameId>) _symbol_l.value;
						l.addFirst(n);
						return new Symbol(l);
					}
				}, new Action() { // [35] names =
					public Symbol reduce(Symbol[] _symbols, int offset) {
						return new Symbol(new LinkedList<>());
					}
				}, new Action() { // [36] names = notemptynames.l
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_l = _symbols[offset + 1];
						final LinkedList<NameId> l = (LinkedList<NameId>) _symbol_l.value;
						return new Symbol(l);
					}
				}, new Action() { // [37] notemptynames = name.n
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_n = _symbols[offset + 1];
						final NameId n = (NameId) _symbol_n.value;

						List<NameId> l = new LinkedList<>();
						l.add(n);
						return new Symbol(l);
					}
				}, new Action() { // [38] notemptynames = DASH
					public Symbol reduce(Symbol[] _symbols, int offset) {

						List<NameId> l = new LinkedList<>();
						l.add(null);
						return new Symbol(l);
					}
				}, new Action() { // [39] notemptynames = name.n COMMA
									// notemptynames.l
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_n = _symbols[offset + 1];
						final NameId n = (NameId) _symbol_n.value;
						final Symbol _symbol_l = _symbols[offset + 3];
						final LinkedList<NameId> l = (LinkedList<NameId>) _symbol_l.value;
						l.addFirst(n);
						return new Symbol(l);
					}
				}, new Action() { // [40] notemptynames = DASH COMMA
									// notemptynames.l
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_l = _symbols[offset + 3];
						final LinkedList<NameId> l = (LinkedList<NameId>) _symbol_l.value;
						l.addFirst(null);
						return new Symbol(l);
					}
				}, new Action() { // [41] name = PLUS VARID.n
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_n = _symbols[offset + 2];
						final String n = (String) _symbol_n.value;
						return new Symbol(new NameId(n, true));
					}
				}, new Action() { // [42] name = VARID.n
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_n = _symbols[offset + 1];
						final String n = (String) _symbol_n.value;
						return new Symbol(new NameId(n, null));
					}
				}, new Action() { // [43] name = DASH VARID.n
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_n = _symbols[offset + 2];
						final String n = (String) _symbol_n.value;
						return new Symbol(new NameId(n, false));
					}
				} };
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
