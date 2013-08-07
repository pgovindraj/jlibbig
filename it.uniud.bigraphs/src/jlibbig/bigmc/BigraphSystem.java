package jlibbig.bigmc;

import jlibbig.core.*;
import jlibbig.core.exceptions.*;

import java.util.*;

/**
 * This class stores a set of bigraphs and a set of reactions.
 * It also stores the set of outernames that aren't free names in the reactions.
 * Bigraphs, redexes and reacta of the same system share the same signature and this signature (system's signature) can't change.
 */
public class BigraphSystem{
	private Signature signature;
	private Set<AgentBigraph> bigraphs;
	private Set<String> outerNames;
	private Set<Reaction<ReactionBigraph>> reactionRules;
	
	/**
	 * @param sig signature used for every bigraph and reaction of this system.	
	 */
	public BigraphSystem( Signature sig ){
		if( sig == null )
			throw new IllegalArgumentException( "Signature can't be null" );
		signature = sig;
		bigraphs = new HashSet<>();
		outerNames = new HashSet<>();
		reactionRules = new HashSet<>();
	}
	
	/**
	 * Add an outername to the list of non-free outernames.
	 * @param name name (string) that will be added to the list.
	 */
	public void addName( String name ){
		outerNames.add( name );
	}
	
	/**
	 * Get the system's signature
	 * @return The system's signature
	 * @see Signature
	 */
	public Signature getSignature(){ 
		return signature; 
	}

	/**
	 * Get the list of non-free outernames stored in the system.
	 * @return The list of outernames.
	 */
	public Set<String> getOuterNames(){
		return Collections.unmodifiableSet( outerNames );			
	}

	/**
	 * Add a bigraph to the system. Its signature must match with the system's signature.
	 * @param b the bigraph that will be added to the system.
	 * @throws RuntimeException if both signatures don't match.
	 * @see Bigraph
	 */
	public void addBigraph( AgentBigraph b ){
		if( signature != b.getSignature() )
			throw new IncompatibleSignatureException( signature , b.getSignature() , "Can't add a Bigraph to a BigraphSystem. Its Signature must be equal to the BigraphSystem's signature" );
		bigraphs.add( b );
	}
	
	/**
	 * Add a reaction to the system. Signatures of redex and reactum must match the system's signature.
	 * @param redex the bigraph representing reaction's redex
	 * @param reactum the bigraph representing reaction's reactum
	 * @throws RuntimeException if signatures don't match or if redex and reactum don't have the same number of roots
	 * @see ReactionBigraph
	 */
	public void addReaction( ReactionBigraph redex , ReactionBigraph reactum ){
		if( signature != redex.getSignature() || signature != reactum.getSignature() )
			throw new IncompatibleSignatureException( signature , redex.getSignature() , "Can't add a Reaction to a BigraphSystem. Both ( redex and reactum ) Signatures must be equal to the BigraphSystem's signature" );
		if( redex.getRoots().size() != reactum.getRoots().size() )
			throw new IncompatibleInterfacesException( redex , reactum , "Redex and Reactum must have the same number of roots." );
		reactionRules.add( new Reaction<ReactionBigraph>( redex , reactum ) );
	}
	
	/**
	 * Add a reaction to the system. Reaction's signature must match the system's signature.
	 * @param reaction
	 */
	public void addReaction( Reaction<ReactionBigraph> reaction ){
		if( signature != reaction.getSignature() )
			throw new IncompatibleSignatureException( signature , reaction.getSignature() , "Can't add a Reaction<ReactionBigraph> to a BigraphSystem. Reaction's signature must be equal to the BigraphSystem's signature" );
		reactionRules.add( reaction );
	}
	
	/**
	 * Get the set of system's bigraphs.
	 * @return The set of bigraphs stored in the system.
	 * @see Bigraph
	 */
	public Set<AgentBigraph> getBigraphs(){
		return Collections.unmodifiableSet( bigraphs );
	}
	
	/**
	 * Get the set of reactions.
	 * @return A set or Reaction.
	 * @see Bigraph
	 * @see Reaction
	 */
	public Set<Reaction<ReactionBigraph>> getReactions(){
		return Collections.unmodifiableSet( reactionRules );
	}
}
