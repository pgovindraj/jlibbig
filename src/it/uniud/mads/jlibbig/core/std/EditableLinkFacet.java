package it.uniud.mads.jlibbig.core.std;

import it.uniud.mads.jlibbig.core.attachedProperties.Replicable;
import it.uniud.mads.jlibbig.core.attachedProperties.ReplicationListener;
import it.uniud.mads.jlibbig.core.attachedProperties.ReplicationListenerContainer;
import it.uniud.mads.jlibbig.core.util.NameHelper;

abstract class EditableLinkFacet implements LinkFacet, EditableNamed,
		Replicable {

	private String name;
	protected final ReplicationListenerContainer rep = new ReplicationListenerContainer();

	protected EditableLinkFacet() {
		this("X_" + NameHelper.generateName());
	}

	protected EditableLinkFacet(String name) {
		setName(name);
	}

	@Override
	public void setName(String name) {
		if (name == null || name.isEmpty())
			throw new IllegalArgumentException("Name can not be empty.");
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void registerListener(ReplicationListener listener) {
		rep.registerListener(listener);
	}
	
	@Override
	public boolean isListenerRegistered(ReplicationListener listener) {
		return rep.isListenerRegistered(listener);
	}

	@Override
	public boolean unregisterListener(ReplicationListener listener) {
		return rep.unregisterListener(listener);
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 83;
		return prime * name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		EditableLinkFacet other;
		try {
			other = (EditableLinkFacet) obj;
		} catch (ClassCastException e) {
			return false;
		}
		return name.equals(other.name);
	}
}
