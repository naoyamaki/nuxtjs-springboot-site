/*
 * This file is generated by jOOQ.
 */
package com.example.infrastructure.jooq.tables.records;


import com.example.infrastructure.jooq.tables.User;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record7<Integer, String, String, String, LocalDateTime, LocalDateTime, Byte> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>main.user.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>main.user.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>main.user.email</code>.
     */
    public void setEmail(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>main.user.email</code>.
     */
    public String getEmail() {
        return (String) get(1);
    }

    /**
     * Setter for <code>main.user.password</code>.
     */
    public void setPassword(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>main.user.password</code>.
     */
    public String getPassword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>main.user.user_name</code>.
     */
    public void setUserName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>main.user.user_name</code>.
     */
    public String getUserName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>main.user.insert_date</code>.
     */
    public void setInsertDate(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>main.user.insert_date</code>.
     */
    public LocalDateTime getInsertDate() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>main.user.update_date</code>.
     */
    public void setUpdateDate(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>main.user.update_date</code>.
     */
    public LocalDateTime getUpdateDate() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>main.user.delete_flag</code>.
     */
    public void setDeleteFlag(Byte value) {
        set(6, value);
    }

    /**
     * Getter for <code>main.user.delete_flag</code>.
     */
    public Byte getDeleteFlag() {
        return (Byte) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, String, String, LocalDateTime, LocalDateTime, Byte> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Integer, String, String, String, LocalDateTime, LocalDateTime, Byte> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return User.USER.ID;
    }

    @Override
    public Field<String> field2() {
        return User.USER.EMAIL;
    }

    @Override
    public Field<String> field3() {
        return User.USER.PASSWORD;
    }

    @Override
    public Field<String> field4() {
        return User.USER.USER_NAME;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return User.USER.INSERT_DATE;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return User.USER.UPDATE_DATE;
    }

    @Override
    public Field<Byte> field7() {
        return User.USER.DELETE_FLAG;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getEmail();
    }

    @Override
    public String component3() {
        return getPassword();
    }

    @Override
    public String component4() {
        return getUserName();
    }

    @Override
    public LocalDateTime component5() {
        return getInsertDate();
    }

    @Override
    public LocalDateTime component6() {
        return getUpdateDate();
    }

    @Override
    public Byte component7() {
        return getDeleteFlag();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getEmail();
    }

    @Override
    public String value3() {
        return getPassword();
    }

    @Override
    public String value4() {
        return getUserName();
    }

    @Override
    public LocalDateTime value5() {
        return getInsertDate();
    }

    @Override
    public LocalDateTime value6() {
        return getUpdateDate();
    }

    @Override
    public Byte value7() {
        return getDeleteFlag();
    }

    @Override
    public UserRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public UserRecord value2(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public UserRecord value3(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public UserRecord value4(String value) {
        setUserName(value);
        return this;
    }

    @Override
    public UserRecord value5(LocalDateTime value) {
        setInsertDate(value);
        return this;
    }

    @Override
    public UserRecord value6(LocalDateTime value) {
        setUpdateDate(value);
        return this;
    }

    @Override
    public UserRecord value7(Byte value) {
        setDeleteFlag(value);
        return this;
    }

    @Override
    public UserRecord values(Integer value1, String value2, String value3, String value4, LocalDateTime value5, LocalDateTime value6, Byte value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(Integer id, String email, String password, String userName, LocalDateTime insertDate, LocalDateTime updateDate, Byte deleteFlag) {
        super(User.USER);

        setId(id);
        setEmail(email);
        setPassword(password);
        setUserName(userName);
        setInsertDate(insertDate);
        setUpdateDate(updateDate);
        setDeleteFlag(deleteFlag);
    }
}