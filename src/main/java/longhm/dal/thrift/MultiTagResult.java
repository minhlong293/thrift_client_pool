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
public class MultiTagResult implements org.apache.thrift.TBase<MultiTagResult, MultiTagResult._Fields>, java.io.Serializable, Cloneable, Comparable<MultiTagResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MultiTagResult");

  private static final org.apache.thrift.protocol.TField RETURN_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("ReturnCode", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TAGS_FIELD_DESC = new org.apache.thrift.protocol.TField("tags", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new MultiTagResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new MultiTagResultTupleSchemeFactory());
  }

  /**
   * 
   * @see longhm.common.thrift.ReturnCode
   */
  public longhm.common.thrift.ReturnCode ReturnCode; // required
  public List<TagDB> tags; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see longhm.common.thrift.ReturnCode
     */
    RETURN_CODE((short)1, "ReturnCode"),
    TAGS((short)2, "tags");

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
        case 1: // RETURN_CODE
          return RETURN_CODE;
        case 2: // TAGS
          return TAGS;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RETURN_CODE, new org.apache.thrift.meta_data.FieldMetaData("ReturnCode", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, longhm.common.thrift.ReturnCode.class)));
    tmpMap.put(_Fields.TAGS, new org.apache.thrift.meta_data.FieldMetaData("tags", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TagDB.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MultiTagResult.class, metaDataMap);
  }

  public MultiTagResult() {
  }

  public MultiTagResult(
    longhm.common.thrift.ReturnCode ReturnCode,
    List<TagDB> tags)
  {
    this();
    this.ReturnCode = ReturnCode;
    this.tags = tags;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MultiTagResult(MultiTagResult other) {
    if (other.isSetReturnCode()) {
      this.ReturnCode = other.ReturnCode;
    }
    if (other.isSetTags()) {
      List<TagDB> __this__tags = new ArrayList<TagDB>(other.tags.size());
      for (TagDB other_element : other.tags) {
        __this__tags.add(new TagDB(other_element));
      }
      this.tags = __this__tags;
    }
  }

  public MultiTagResult deepCopy() {
    return new MultiTagResult(this);
  }

  @Override
  public void clear() {
    this.ReturnCode = null;
    this.tags = null;
  }

  /**
   * 
   * @see longhm.common.thrift.ReturnCode
   */
  public longhm.common.thrift.ReturnCode getReturnCode() {
    return this.ReturnCode;
  }

  /**
   * 
   * @see longhm.common.thrift.ReturnCode
   */
  public MultiTagResult setReturnCode(longhm.common.thrift.ReturnCode ReturnCode) {
    this.ReturnCode = ReturnCode;
    return this;
  }

  public void unsetReturnCode() {
    this.ReturnCode = null;
  }

  /** Returns true if field ReturnCode is set (has been assigned a value) and false otherwise */
  public boolean isSetReturnCode() {
    return this.ReturnCode != null;
  }

  public void setReturnCodeIsSet(boolean value) {
    if (!value) {
      this.ReturnCode = null;
    }
  }

  public int getTagsSize() {
    return (this.tags == null) ? 0 : this.tags.size();
  }

  public java.util.Iterator<TagDB> getTagsIterator() {
    return (this.tags == null) ? null : this.tags.iterator();
  }

  public void addToTags(TagDB elem) {
    if (this.tags == null) {
      this.tags = new ArrayList<TagDB>();
    }
    this.tags.add(elem);
  }

  public List<TagDB> getTags() {
    return this.tags;
  }

  public MultiTagResult setTags(List<TagDB> tags) {
    this.tags = tags;
    return this;
  }

  public void unsetTags() {
    this.tags = null;
  }

  /** Returns true if field tags is set (has been assigned a value) and false otherwise */
  public boolean isSetTags() {
    return this.tags != null;
  }

  public void setTagsIsSet(boolean value) {
    if (!value) {
      this.tags = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RETURN_CODE:
      if (value == null) {
        unsetReturnCode();
      } else {
        setReturnCode((longhm.common.thrift.ReturnCode)value);
      }
      break;

    case TAGS:
      if (value == null) {
        unsetTags();
      } else {
        setTags((List<TagDB>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RETURN_CODE:
      return getReturnCode();

    case TAGS:
      return getTags();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RETURN_CODE:
      return isSetReturnCode();
    case TAGS:
      return isSetTags();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MultiTagResult)
      return this.equals((MultiTagResult)that);
    return false;
  }

  public boolean equals(MultiTagResult that) {
    if (that == null)
      return false;

    boolean this_present_ReturnCode = true && this.isSetReturnCode();
    boolean that_present_ReturnCode = true && that.isSetReturnCode();
    if (this_present_ReturnCode || that_present_ReturnCode) {
      if (!(this_present_ReturnCode && that_present_ReturnCode))
        return false;
      if (!this.ReturnCode.equals(that.ReturnCode))
        return false;
    }

    boolean this_present_tags = true && this.isSetTags();
    boolean that_present_tags = true && that.isSetTags();
    if (this_present_tags || that_present_tags) {
      if (!(this_present_tags && that_present_tags))
        return false;
      if (!this.tags.equals(that.tags))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_ReturnCode = true && (isSetReturnCode());
    list.add(present_ReturnCode);
    if (present_ReturnCode)
      list.add(ReturnCode.getValue());

    boolean present_tags = true && (isSetTags());
    list.add(present_tags);
    if (present_tags)
      list.add(tags);

    return list.hashCode();
  }

  @Override
  public int compareTo(MultiTagResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetReturnCode()).compareTo(other.isSetReturnCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReturnCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ReturnCode, other.ReturnCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTags()).compareTo(other.isSetTags());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTags()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tags, other.tags);
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
    StringBuilder sb = new StringBuilder("MultiTagResult(");
    boolean first = true;

    sb.append("ReturnCode:");
    if (this.ReturnCode == null) {
      sb.append("null");
    } else {
      sb.append(this.ReturnCode);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("tags:");
    if (this.tags == null) {
      sb.append("null");
    } else {
      sb.append(this.tags);
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MultiTagResultStandardSchemeFactory implements SchemeFactory {
    public MultiTagResultStandardScheme getScheme() {
      return new MultiTagResultStandardScheme();
    }
  }

  private static class MultiTagResultStandardScheme extends StandardScheme<MultiTagResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MultiTagResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RETURN_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.ReturnCode = longhm.common.thrift.ReturnCode.findByValue(iprot.readI32());
              struct.setReturnCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TAGS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list44 = iprot.readListBegin();
                struct.tags = new ArrayList<TagDB>(_list44.size);
                TagDB _elem45;
                for (int _i46 = 0; _i46 < _list44.size; ++_i46)
                {
                  _elem45 = new TagDB();
                  _elem45.read(iprot);
                  struct.tags.add(_elem45);
                }
                iprot.readListEnd();
              }
              struct.setTagsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, MultiTagResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.ReturnCode != null) {
        oprot.writeFieldBegin(RETURN_CODE_FIELD_DESC);
        oprot.writeI32(struct.ReturnCode.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.tags != null) {
        oprot.writeFieldBegin(TAGS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.tags.size()));
          for (TagDB _iter47 : struct.tags)
          {
            _iter47.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MultiTagResultTupleSchemeFactory implements SchemeFactory {
    public MultiTagResultTupleScheme getScheme() {
      return new MultiTagResultTupleScheme();
    }
  }

  private static class MultiTagResultTupleScheme extends TupleScheme<MultiTagResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MultiTagResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetReturnCode()) {
        optionals.set(0);
      }
      if (struct.isSetTags()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetReturnCode()) {
        oprot.writeI32(struct.ReturnCode.getValue());
      }
      if (struct.isSetTags()) {
        {
          oprot.writeI32(struct.tags.size());
          for (TagDB _iter48 : struct.tags)
          {
            _iter48.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MultiTagResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.ReturnCode = longhm.common.thrift.ReturnCode.findByValue(iprot.readI32());
        struct.setReturnCodeIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list49 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.tags = new ArrayList<TagDB>(_list49.size);
          TagDB _elem50;
          for (int _i51 = 0; _i51 < _list49.size; ++_i51)
          {
            _elem50 = new TagDB();
            _elem50.read(iprot);
            struct.tags.add(_elem50);
          }
        }
        struct.setTagsIsSet(true);
      }
    }
  }

}

