package it.uniud.mads.jlibbig.core.std;

import java.util.*;

import it.uniud.mads.jlibbig.core.AbstractNamed;
import it.uniud.mads.jlibbig.core.BigraphHandler;
import it.uniud.mads.jlibbig.core.Owner;
import it.uniud.mads.jlibbig.core.attachedProperties.*;

class EditableRoot implements EditableParent, Root, EditableOwned {

	static final String PROPERTY_OWNER = "Owner";

	private Set<EditableChild> children = new HashSet<>();
	private final Set<? extends Child> ro_chd = Collections
			.unmodifiableSet(this.children);

	private final ProtectedProperty.ValueSetter<Owner> ownerSetter = new ProtectedProperty.ValueSetter<>();
	private final ProtectedProperty<Owner> owner = new ProtectedProperty<Owner>(
			PROPERTY_OWNER, null, ownerSetter);

	private final ReplicateListenerContainer rep = new ReplicateListenerContainer();
	private final PropertyContainer props = new PropertyContainer(this);

	private final String name;

	EditableRoot() {
		this(null);
	}

	EditableRoot(Owner owner) {
		this.name = "R_" + AbstractNamed.generateName();
		props.attachProperty(this.owner);
		if (owner != null)
			ownerSetter.set(owner);
	}
	
	@Override
	public String toString() {
		Owner o = this.getOwner();
		if(o != null){
			BigraphHandler<?> h = (BigraphHandler<?>) o;
			int i = h.getRoots().indexOf(this);
			if(i >= 0)
				return i + ":r";
		}
		return this.name;
	}

	@Override
	public Collection<? extends Child> getChildren() {
		return this.ro_chd;
	}

	@Override
	public void addChild(EditableChild child) {
		if (child == null)
			return;
		this.children.add(child);
		if (this != child.getParent()) {
			child.setParent(this);
		}
	}

	@Override
	public void removeChild(EditableChild child) {
		if (child == null)
			return;
		this.children.remove(child);
		if (this == child.getParent())
			child.setParent(null);
	}

	@Override
	public Set<EditableChild> getEditableChildren() {
		return this.children;
	}

	@Override
	public EditableRoot getRoot() {
		return this;
	}

	@Override
	public EditableRoot replicate() {
		EditableRoot copy = new EditableRoot();
		rep.tell(this, copy);
		return copy;
	}

	@Override
	public void registerListener(ReplicateListener listener) {
		rep.registerListener(listener);
	}

	@Override
	public boolean unregisterListener(ReplicateListener listener) {
		return rep.unregisterListener(listener);
	}

	@Override
	public Property<?> attachProperty(Property<?> prop) {
		if(prop == null)
			throw new IllegalArgumentException("Argument can not be null.");
		String name = prop.getName();
		if (name.equals(PROPERTY_OWNER))
			throw new IllegalArgumentException("Property '" + name
					+ "' can not be substituted");
		return props.attachProperty(prop);
	}

	@Override
	public <V> Property<V> detachProperty(Property<V> prop) {
		if(prop == null)
			throw new IllegalArgumentException("Argument can not be null.");
		return this.detachProperty(prop.getName());
	}

	@Override
	public <V> Property<V> detachProperty(String name) {
		if (PROPERTY_OWNER.equals(name))
			throw new IllegalArgumentException("Property '" + name
					+ "' can not be detached");
		return props.detachProperty(name);
	}

	@Override
	public <V> Property<V> getProperty(String name) {
		return props.getProperty(name);
	}

	@Override
	public Set<String> getPropertyNames() {
		return props.getPropertyNames();
	}

	@Override
	public Owner getOwner() {
		return this.owner.get();
	}

	@Override
	public void setOwner(Owner value) {
		this.ownerSetter.set(value);
	}

	@Override
	public EditableRoot getEditable() {
		return this;
	}

	@Override
	public boolean isParent() {
		return true;
	}

	@Override
	public boolean isChild() {
		return false;
	}

	@Override
	public boolean isRoot() {
		return true;
	}

	@Override
	public boolean isSite() {
		return false;
	}

	@Override
	public boolean isNode() {
		return false;
	}
}