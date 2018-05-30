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
public class MultiGroupResult implements org.apache.thrift.TBase<MultiGroupResult, MultiGroupResult._Fields>, java.io.Serializable, Cloneable, Comparable<MultiGroupResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MultiGroupResult");

  private static final org.apache.thrift.protocol.TField RETURN_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("ReturnCode", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField GROUPS_FIELD_DESC = new org.apache.thrift.protocol.TField("groups", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new MultiGroupResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new MultiGroupResultTupleSchemeFactory());
  }

  /**
   * 
   * @see longhm.common.thrift.ReturnCode
   */
  public longhm.common.thrift.ReturnCode ReturnCode; // required
  public List<GroupDB> groups; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see longhm.common.thrift.ReturnCode
     */
    RETURN_CODE((short)1, "ReturnCode"),
    GROUPS((short)2, "groups");

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
        case 2: // GROUPS
          return GROUPS;
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
    tmpMap.put(_Fields.GROUPS, new org.apache.thrift.meta_data.FieldMetaData("groups", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, GroupDB.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MultiGroupResult.class, metaDataMap);
  }

  public MultiGroupResult() {
  }

  public MultiGroupResult(
    longhm.common.thrift.ReturnCode ReturnCode,
    List<GroupDB> groups)
  {
    this();
    this.ReturnCode = ReturnCode;
    this.groups = groups;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MultiGroupResult(MultiGroupResult other) {
    if (other.isSetReturnCode()) {
      this.ReturnCode = other.ReturnCode;
    }
    if (other.isSetGroups()) {
      List<GroupDB> __this__groups = new ArrayList<GroupDB>(other.groups.size());
      for (GroupDB other_element : other.groups) {
        __this__groups.add(new GroupDB(other_element));
      }
      this.groups = __this__groups;
    }
  }

  public MultiGroupResult deepCopy() {
    return new MultiGroupResult(this);
  }

  @Override
  public void clear() {
    this.ReturnCode = null;
    this.groups = null;
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
  public MultiGroupResult setReturnCode(longhm.common.thrift.ReturnCode ReturnCode) {
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

  public int getGroupsSize() {
    return (this.groups == null) ? 0 : this.groups.size();
  }

  public java.util.Iterator<GroupDB> getGroupsIterator() {
    return (this.groups == null) ? null : this.groups.iterator();
  }

  public void addToGroups(GroupDB elem) {
    if (this.groups == null) {
      this.groups = new ArrayList<GroupDB>();
    }
    this.groups.add(elem);
  }

  public List<GroupDB> getGroups() {
    return this.groups;
  }

  public MultiGroupResult setGroups(List<GroupDB> groups) {
    this.groups = groups;
    return this;
  }

  public void unsetGroups() {
    this.groups = null;
  }

  /** Returns true if field groups is set (has been assigned a value) and false otherwise */
  public boolean isSetGroups() {
    return this.groups != null;
  }

  public void setGroupsIsSet(boolean value) {
    if (!value) {
      this.groups = null;
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

    case GROUPS:
      if (value == null) {
        unsetGroups();
      } else {
        setGroups((List<GroupDB>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RETURN_CODE:
      return getReturnCode();

    case GROUPS:
      return getGroups();

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
    case GROUPS:
      return isSetGroups();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MultiGroupResult)
      return this.equals((MultiGroupResult)that);
    return false;
  }

  public boolean equals(MultiGroupResult that) {
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

    boolean this_present_groups = true && this.isSetGroups();
    boolean that_present_groups = true && that.isSetGroups();
    if (this_present_groups || that_present_groups) {
      if (!(this_present_groups && that_present_groups))
        return false;
      if (!this.groups.equals(that.groups))
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

    boolean present_groups = true && (isSetGroups());
    list.add(present_groups);
    if (present_groups)
      list.add(groups);

    return list.hashCode();
  }

  @Override
  public int compareTo(MultiGroupResult other) {
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
    lastComparison = Boolean.valueOf(isSetGroups()).compareTo(other.isSetGroups());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGroups()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.groups, other.groups);
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
    StringBuilder sb = new StringBuilder("MultiGroupResult(");
    boolean first = true;

    sb.append("ReturnCode:");
    if (this.ReturnCode == null) {
      sb.append("null");
    } else {
      sb.append(this.ReturnCode);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("groups:");
    if (this.groups == null) {
      sb.append("null");
    } else {
      sb.append(this.groups);
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

  private static class MultiGroupResultStandardSchemeFactory implements SchemeFactory {
    public MultiGroupResultStandardScheme getScheme() {
      return new MultiGroupResultStandardScheme();
    }
  }

  private static class MultiGroupResultStandardScheme extends StandardScheme<MultiGroupResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MultiGroupResult struct) throws org.apache.thrift.TException {
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
          case 2: // GROUPS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list52 = iprot.readListBegin();
                struct.groups = new ArrayList<GroupDB>(_list52.size);
                GroupDB _elem53;
                for (int _i54 = 0; _i54 < _list52.size; ++_i54)
                {
                  _elem53 = new GroupDB();
                  _elem53.read(iprot);
                  struct.groups.add(_elem53);
                }
                iprot.readListEnd();
              }
              struct.setGroupsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, MultiGroupResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.ReturnCode != null) {
        oprot.writeFieldBegin(RETURN_CODE_FIELD_DESC);
        oprot.writeI32(struct.ReturnCode.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.groups != null) {
        oprot.writeFieldBegin(GROUPS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.groups.size()));
          for (GroupDB _iter55 : struct.groups)
          {
            _iter55.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MultiGroupResultTupleSchemeFactory implements SchemeFactory {
    public MultiGroupResultTupleScheme getScheme() {
      return new MultiGroupResultTupleScheme();
    }
  }

  private static class MultiGroupResultTupleScheme extends TupleScheme<MultiGroupResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MultiGroupResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetReturnCode()) {
        optionals.set(0);
      }
      if (struct.isSetGroups()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetReturnCode()) {
        oprot.writeI32(struct.ReturnCode.getValue());
      }
      if (struct.isSetGroups()) {
        {
          oprot.writeI32(struct.groups.size());
          for (GroupDB _iter56 : struct.groups)
          {
            _iter56.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MultiGroupResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.ReturnCode = longhm.common.thrift.ReturnCode.findByValue(iprot.readI32());
        struct.setReturnCodeIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list57 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.groups = new ArrayList<GroupDB>(_list57.size);
          GroupDB _elem58;
          for (int _i59 = 0; _i59 < _list57.size; ++_i59)
          {
            _elem58 = new GroupDB();
            _elem58.read(iprot);
            struct.groups.add(_elem58);
          }
        }
        struct.setGroupsIsSet(true);
      }
    }
  }

}

