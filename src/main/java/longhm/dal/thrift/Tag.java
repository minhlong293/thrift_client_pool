/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package longhm.dal.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-05-24")
public class Tag implements org.apache.thrift.TBase<Tag, Tag._Fields>, java.io.Serializable, Cloneable, Comparable<Tag> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Tag");

  private static final org.apache.thrift.protocol.TField TAG_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("tagId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField SOURCE_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("sourceList", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TagStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TagTupleSchemeFactory());
  }

  public int tagId; // required
  public List<Source> sourceList; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TAG_ID((short)1, "tagId"),
    SOURCE_LIST((short)2, "sourceList");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TAG_ID
          return TAG_ID;
        case 2: // SOURCE_LIST
          return SOURCE_LIST;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __TAGID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TAG_ID, new org.apache.thrift.meta_data.FieldMetaData("tagId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "int")));
    tmpMap.put(_Fields.SOURCE_LIST, new org.apache.thrift.meta_data.FieldMetaData("sourceList", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Source.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Tag.class, metaDataMap);
  }

  public Tag() {
  }

  public Tag(
    int tagId,
    List<Source> sourceList)
  {
    this();
    this.tagId = tagId;
    setTagIdIsSet(true);
    this.sourceList = sourceList;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Tag(Tag other) {
    __isset_bitfield = other.__isset_bitfield;
    this.tagId = other.tagId;
    if (other.isSetSourceList()) {
      List<Source> __this__sourceList = new ArrayList<Source>(other.sourceList.size());
      for (Source other_element : other.sourceList) {
        __this__sourceList.add(new Source(other_element));
      }
      this.sourceList = __this__sourceList;
    }
  }

  public Tag deepCopy() {
    return new Tag(this);
  }

  @Override
  public void clear() {
    setTagIdIsSet(false);
    this.tagId = 0;
    this.sourceList = null;
  }

  public int getTagId() {
    return this.tagId;
  }

  public Tag setTagId(int tagId) {
    this.tagId = tagId;
    setTagIdIsSet(true);
    return this;
  }

  public void unsetTagId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TAGID_ISSET_ID);
  }

  /** Returns true if field tagId is set (has been assigned a value) and false otherwise */
  public boolean isSetTagId() {
    return EncodingUtils.testBit(__isset_bitfield, __TAGID_ISSET_ID);
  }

  public void setTagIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TAGID_ISSET_ID, value);
  }

  public int getSourceListSize() {
    return (this.sourceList == null) ? 0 : this.sourceList.size();
  }

  public java.util.Iterator<Source> getSourceListIterator() {
    return (this.sourceList == null) ? null : this.sourceList.iterator();
  }

  public void addToSourceList(Source elem) {
    if (this.sourceList == null) {
      this.sourceList = new ArrayList<Source>();
    }
    this.sourceList.add(elem);
  }

  public List<Source> getSourceList() {
    return this.sourceList;
  }

  public Tag setSourceList(List<Source> sourceList) {
    this.sourceList = sourceList;
    return this;
  }

  public void unsetSourceList() {
    this.sourceList = null;
  }

  /** Returns true if field sourceList is set (has been assigned a value) and false otherwise */
  public boolean isSetSourceList() {
    return this.sourceList != null;
  }

  public void setSourceListIsSet(boolean value) {
    if (!value) {
      this.sourceList = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TAG_ID:
      if (value == null) {
        unsetTagId();
      } else {
        setTagId((Integer)value);
      }
      break;

    case SOURCE_LIST:
      if (value == null) {
        unsetSourceList();
      } else {
        setSourceList((List<Source>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TAG_ID:
      return getTagId();

    case SOURCE_LIST:
      return getSourceList();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TAG_ID:
      return isSetTagId();
    case SOURCE_LIST:
      return isSetSourceList();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Tag)
      return this.equals((Tag)that);
    return false;
  }

  public boolean equals(Tag that) {
    if (that == null)
      return false;

    boolean this_present_tagId = true;
    boolean that_present_tagId = true;
    if (this_present_tagId || that_present_tagId) {
      if (!(this_present_tagId && that_present_tagId))
        return false;
      if (this.tagId != that.tagId)
        return false;
    }

    boolean this_present_sourceList = true && this.isSetSourceList();
    boolean that_present_sourceList = true && that.isSetSourceList();
    if (this_present_sourceList || that_present_sourceList) {
      if (!(this_present_sourceList && that_present_sourceList))
        return false;
      if (!this.sourceList.equals(that.sourceList))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_tagId = true;
    list.add(present_tagId);
    if (present_tagId)
      list.add(tagId);

    boolean present_sourceList = true && (isSetSourceList());
    list.add(present_sourceList);
    if (present_sourceList)
      list.add(sourceList);

    return list.hashCode();
  }

  @Override
  public int compareTo(Tag other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTagId()).compareTo(other.isSetTagId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTagId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tagId, other.tagId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSourceList()).compareTo(other.isSetSourceList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSourceList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sourceList, other.sourceList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Tag(");
    boolean first = true;

    sb.append("tagId:");
    sb.append(this.tagId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("sourceList:");
    if (this.sourceList == null) {
      sb.append("null");
    } else {
      sb.append(this.sourceList);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TagStandardSchemeFactory implements SchemeFactory {
    public TagStandardScheme getScheme() {
      return new TagStandardScheme();
    }
  }

  private static class TagStandardScheme extends StandardScheme<Tag> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Tag struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TAG_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.tagId = iprot.readI32();
              struct.setTagIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SOURCE_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list28 = iprot.readListBegin();
                struct.sourceList = new ArrayList<Source>(_list28.size);
                Source _elem29;
                for (int _i30 = 0; _i30 < _list28.size; ++_i30)
                {
                  _elem29 = new Source();
                  _elem29.read(iprot);
                  struct.sourceList.add(_elem29);
                }
                iprot.readListEnd();
              }
              struct.setSourceListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Tag struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TAG_ID_FIELD_DESC);
      oprot.writeI32(struct.tagId);
      oprot.writeFieldEnd();
      if (struct.sourceList != null) {
        oprot.writeFieldBegin(SOURCE_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.sourceList.size()));
          for (Source _iter31 : struct.sourceList)
          {
            _iter31.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TagTupleSchemeFactory implements SchemeFactory {
    public TagTupleScheme getScheme() {
      return new TagTupleScheme();
    }
  }

  private static class TagTupleScheme extends TupleScheme<Tag> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Tag struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetTagId()) {
        optionals.set(0);
      }
      if (struct.isSetSourceList()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetTagId()) {
        oprot.writeI32(struct.tagId);
      }
      if (struct.isSetSourceList()) {
        {
          oprot.writeI32(struct.sourceList.size());
          for (Source _iter32 : struct.sourceList)
          {
            _iter32.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Tag struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.tagId = iprot.readI32();
        struct.setTagIdIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list33 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.sourceList = new ArrayList<Source>(_list33.size);
          Source _elem34;
          for (int _i35 = 0; _i35 < _list33.size; ++_i35)
          {
            _elem34 = new Source();
            _elem34.read(iprot);
            struct.sourceList.add(_elem34);
          }
        }
        struct.setSourceListIsSet(true);
      }
    }
  }

}
