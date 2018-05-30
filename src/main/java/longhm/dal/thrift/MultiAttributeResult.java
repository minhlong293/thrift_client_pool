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
public class MultiAttributeResult implements org.apache.thrift.TBase<MultiAttributeResult, MultiAttributeResult._Fields>, java.io.Serializable, Cloneable, Comparable<MultiAttributeResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MultiAttributeResult");

  private static final org.apache.thrift.protocol.TField RETURN_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("ReturnCode", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField ATTRIBUTES_FIELD_DESC = new org.apache.thrift.protocol.TField("attributes", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new MultiAttributeResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new MultiAttributeResultTupleSchemeFactory());
  }

  /**
   * 
   * @see longhm.common.thrift.ReturnCode
   */
  public longhm.common.thrift.ReturnCode ReturnCode; // required
  public List<AttributeDB> attributes; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see longhm.common.thrift.ReturnCode
     */
    RETURN_CODE((short)1, "ReturnCode"),
    ATTRIBUTES((short)2, "attributes");

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
        case 2: // ATTRIBUTES
          return ATTRIBUTES;
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
    tmpMap.put(_Fields.ATTRIBUTES, new org.apache.thrift.meta_data.FieldMetaData("attributes", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, AttributeDB.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MultiAttributeResult.class, metaDataMap);
  }

  public MultiAttributeResult() {
  }

  public MultiAttributeResult(
    longhm.common.thrift.ReturnCode ReturnCode,
    List<AttributeDB> attributes)
  {
    this();
    this.ReturnCode = ReturnCode;
    this.attributes = attributes;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MultiAttributeResult(MultiAttributeResult other) {
    if (other.isSetReturnCode()) {
      this.ReturnCode = other.ReturnCode;
    }
    if (other.isSetAttributes()) {
      List<AttributeDB> __this__attributes = new ArrayList<AttributeDB>(other.attributes.size());
      for (AttributeDB other_element : other.attributes) {
        __this__attributes.add(new AttributeDB(other_element));
      }
      this.attributes = __this__attributes;
    }
  }

  public MultiAttributeResult deepCopy() {
    return new MultiAttributeResult(this);
  }

  @Override
  public void clear() {
    this.ReturnCode = null;
    this.attributes = null;
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
  public MultiAttributeResult setReturnCode(longhm.common.thrift.ReturnCode ReturnCode) {
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

  public int getAttributesSize() {
    return (this.attributes == null) ? 0 : this.attributes.size();
  }

  public java.util.Iterator<AttributeDB> getAttributesIterator() {
    return (this.attributes == null) ? null : this.attributes.iterator();
  }

  public void addToAttributes(AttributeDB elem) {
    if (this.attributes == null) {
      this.attributes = new ArrayList<AttributeDB>();
    }
    this.attributes.add(elem);
  }

  public List<AttributeDB> getAttributes() {
    return this.attributes;
  }

  public MultiAttributeResult setAttributes(List<AttributeDB> attributes) {
    this.attributes = attributes;
    return this;
  }

  public void unsetAttributes() {
    this.attributes = null;
  }

  /** Returns true if field attributes is set (has been assigned a value) and false otherwise */
  public boolean isSetAttributes() {
    return this.attributes != null;
  }

  public void setAttributesIsSet(boolean value) {
    if (!value) {
      this.attributes = null;
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

    case ATTRIBUTES:
      if (value == null) {
        unsetAttributes();
      } else {
        setAttributes((List<AttributeDB>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RETURN_CODE:
      return getReturnCode();

    case ATTRIBUTES:
      return getAttributes();

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
    case ATTRIBUTES:
      return isSetAttributes();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MultiAttributeResult)
      return this.equals((MultiAttributeResult)that);
    return false;
  }

  public boolean equals(MultiAttributeResult that) {
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

    boolean this_present_attributes = true && this.isSetAttributes();
    boolean that_present_attributes = true && that.isSetAttributes();
    if (this_present_attributes || that_present_attributes) {
      if (!(this_present_attributes && that_present_attributes))
        return false;
      if (!this.attributes.equals(that.attributes))
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

    boolean present_attributes = true && (isSetAttributes());
    list.add(present_attributes);
    if (present_attributes)
      list.add(attributes);

    return list.hashCode();
  }

  @Override
  public int compareTo(MultiAttributeResult other) {
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
    lastComparison = Boolean.valueOf(isSetAttributes()).compareTo(other.isSetAttributes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAttributes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.attributes, other.attributes);
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
    StringBuilder sb = new StringBuilder("MultiAttributeResult(");
    boolean first = true;

    sb.append("ReturnCode:");
    if (this.ReturnCode == null) {
      sb.append("null");
    } else {
      sb.append(this.ReturnCode);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("attributes:");
    if (this.attributes == null) {
      sb.append("null");
    } else {
      sb.append(this.attributes);
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

  private static class MultiAttributeResultStandardSchemeFactory implements SchemeFactory {
    public MultiAttributeResultStandardScheme getScheme() {
      return new MultiAttributeResultStandardScheme();
    }
  }

  private static class MultiAttributeResultStandardScheme extends StandardScheme<MultiAttributeResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MultiAttributeResult struct) throws org.apache.thrift.TException {
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
          case 2: // ATTRIBUTES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list68 = iprot.readListBegin();
                struct.attributes = new ArrayList<AttributeDB>(_list68.size);
                AttributeDB _elem69;
                for (int _i70 = 0; _i70 < _list68.size; ++_i70)
                {
                  _elem69 = new AttributeDB();
                  _elem69.read(iprot);
                  struct.attributes.add(_elem69);
                }
                iprot.readListEnd();
              }
              struct.setAttributesIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, MultiAttributeResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.ReturnCode != null) {
        oprot.writeFieldBegin(RETURN_CODE_FIELD_DESC);
        oprot.writeI32(struct.ReturnCode.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.attributes != null) {
        oprot.writeFieldBegin(ATTRIBUTES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.attributes.size()));
          for (AttributeDB _iter71 : struct.attributes)
          {
            _iter71.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MultiAttributeResultTupleSchemeFactory implements SchemeFactory {
    public MultiAttributeResultTupleScheme getScheme() {
      return new MultiAttributeResultTupleScheme();
    }
  }

  private static class MultiAttributeResultTupleScheme extends TupleScheme<MultiAttributeResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MultiAttributeResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetReturnCode()) {
        optionals.set(0);
      }
      if (struct.isSetAttributes()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetReturnCode()) {
        oprot.writeI32(struct.ReturnCode.getValue());
      }
      if (struct.isSetAttributes()) {
        {
          oprot.writeI32(struct.attributes.size());
          for (AttributeDB _iter72 : struct.attributes)
          {
            _iter72.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MultiAttributeResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.ReturnCode = longhm.common.thrift.ReturnCode.findByValue(iprot.readI32());
        struct.setReturnCodeIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list73 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.attributes = new ArrayList<AttributeDB>(_list73.size);
          AttributeDB _elem74;
          for (int _i75 = 0; _i75 < _list73.size; ++_i75)
          {
            _elem74 = new AttributeDB();
            _elem74.read(iprot);
            struct.attributes.add(_elem74);
          }
        }
        struct.setAttributesIsSet(true);
      }
    }
  }

}

