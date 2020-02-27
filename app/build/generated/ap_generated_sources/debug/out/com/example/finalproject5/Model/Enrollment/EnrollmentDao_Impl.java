package com.example.finalproject5.Model.Enrollment;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EnrollmentDao_Impl implements EnrollmentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Enrollment> __insertionAdapterOfEnrollment;

  private final EntityDeletionOrUpdateAdapter<Enrollment> __deletionAdapterOfEnrollment;

  private final EntityDeletionOrUpdateAdapter<Enrollment> __updateAdapterOfEnrollment;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFromUsername;

  public EnrollmentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEnrollment = new EntityInsertionAdapter<Enrollment>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `enrollment` (`enrollmentID`,`studentID`,`courseID`,`enrollmentDate`,`username`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Enrollment value) {
        stmt.bindLong(1, value.getEnrollmentID());
        stmt.bindLong(2, value.getStudentID());
        stmt.bindLong(3, value.getCourseID());
        if (value.getEnrollmentDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEnrollmentDate());
        }
        if (value.getUsername() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUsername());
        }
      }
    };
    this.__deletionAdapterOfEnrollment = new EntityDeletionOrUpdateAdapter<Enrollment>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `enrollment` WHERE `enrollmentID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Enrollment value) {
        stmt.bindLong(1, value.getEnrollmentID());
      }
    };
    this.__updateAdapterOfEnrollment = new EntityDeletionOrUpdateAdapter<Enrollment>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `enrollment` SET `enrollmentID` = ?,`studentID` = ?,`courseID` = ?,`enrollmentDate` = ?,`username` = ? WHERE `enrollmentID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Enrollment value) {
        stmt.bindLong(1, value.getEnrollmentID());
        stmt.bindLong(2, value.getStudentID());
        stmt.bindLong(3, value.getCourseID());
        if (value.getEnrollmentDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEnrollmentDate());
        }
        if (value.getUsername() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUsername());
        }
        stmt.bindLong(6, value.getEnrollmentID());
      }
    };
    this.__preparedStmtOfUpdateFromUsername = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE enrollment SET username = ? WHERE username = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Enrollment enrollment) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEnrollment.insert(enrollment);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Enrollment enrollmentr) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEnrollment.handle(enrollmentr);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Enrollment enrollment) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEnrollment.handle(enrollment);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateFromUsername(final String newUsername, final String givenUsername) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFromUsername.acquire();
    int _argIndex = 1;
    if (newUsername == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, newUsername);
    }
    _argIndex = 2;
    if (givenUsername == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, givenUsername);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateFromUsername.release(_stmt);
    }
  }

  @Override
  public List<Enrollment> getAllClassEnrollments() {
    final String _sql = "SELECT * FROM enrollment ORDER BY enrollmentID DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfEnrollmentID = CursorUtil.getColumnIndexOrThrow(_cursor, "enrollmentID");
      final int _cursorIndexOfStudentID = CursorUtil.getColumnIndexOrThrow(_cursor, "studentID");
      final int _cursorIndexOfCourseID = CursorUtil.getColumnIndexOrThrow(_cursor, "courseID");
      final int _cursorIndexOfEnrollmentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "enrollmentDate");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final List<Enrollment> _result = new ArrayList<Enrollment>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Enrollment _item;
        final int _tmpStudentID;
        _tmpStudentID = _cursor.getInt(_cursorIndexOfStudentID);
        final int _tmpCourseID;
        _tmpCourseID = _cursor.getInt(_cursorIndexOfCourseID);
        final String _tmpEnrollmentDate;
        _tmpEnrollmentDate = _cursor.getString(_cursorIndexOfEnrollmentDate);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _item = new Enrollment(_tmpStudentID,_tmpCourseID,_tmpEnrollmentDate,_tmpUsername);
        final int _tmpEnrollmentID;
        _tmpEnrollmentID = _cursor.getInt(_cursorIndexOfEnrollmentID);
        _item.setEnrollmentID(_tmpEnrollmentID);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
