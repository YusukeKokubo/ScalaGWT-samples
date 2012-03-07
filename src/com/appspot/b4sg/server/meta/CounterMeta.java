package com.appspot.b4sg.server.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-03-07 14:18:20")
/** */
public final class CounterMeta extends org.slim3.datastore.ModelMeta<com.appspot.b4sg.shared.model.Counter> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.b4sg.shared.model.Counter, java.lang.Integer> count = new org.slim3.datastore.CoreAttributeMeta<com.appspot.b4sg.shared.model.Counter, java.lang.Integer>(this, "count", "count", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.b4sg.shared.model.Counter, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.appspot.b4sg.shared.model.Counter, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.b4sg.shared.model.Counter, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.appspot.b4sg.shared.model.Counter, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final CounterMeta slim3_singleton = new CounterMeta();

    /**
     * @return the singleton
     */
    public static CounterMeta get() {
       return slim3_singleton;
    }

    /** */
    public CounterMeta() {
        super("Counter", com.appspot.b4sg.shared.model.Counter.class);
    }

    @Override
    public com.appspot.b4sg.shared.model.Counter entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.appspot.b4sg.shared.model.Counter model = new com.appspot.b4sg.shared.model.Counter();
        model.setCount(longToInteger((java.lang.Long) entity.getProperty("count")));
        model.setKey(entity.getKey());
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.appspot.b4sg.shared.model.Counter m = (com.appspot.b4sg.shared.model.Counter) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("count", m.getCount());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.appspot.b4sg.shared.model.Counter m = (com.appspot.b4sg.shared.model.Counter) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.appspot.b4sg.shared.model.Counter m = (com.appspot.b4sg.shared.model.Counter) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.appspot.b4sg.shared.model.Counter m = (com.appspot.b4sg.shared.model.Counter) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.appspot.b4sg.shared.model.Counter m = (com.appspot.b4sg.shared.model.Counter) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        com.appspot.b4sg.shared.model.Counter m = (com.appspot.b4sg.shared.model.Counter) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCount() != null){
            writer.setNextPropertyName("count");
            encoder0.encode(writer, m.getCount());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.appspot.b4sg.shared.model.Counter jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.appspot.b4sg.shared.model.Counter m = new com.appspot.b4sg.shared.model.Counter();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("count");
        m.setCount(decoder0.decode(reader, m.getCount()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}