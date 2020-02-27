package com.example.finalproject5.Model.Instructor;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class InstructorDao_Impl implements InstructorDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Instructor> __insertionAdapterOfInstructor;

  private final EntityDeletionOrUpdateAdapter<Instructor> __deletionAdapterOfInstructor;

  private final EntityDeletionOrUpdateAdapter<Instructor> __updateAdapterOfInstructor;

  public InstructorDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInstructor = new EntityInsertionAdapter<Instructor>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `instructor` (`instructorID`,`firstName`,`lastName`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Instructor value) {
        stmt.bindLong(1, value.getInstructorID());
        if (value.getFirstName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFirstName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLastName());
        }
      }
    };
    this.__deletionAdapterOfInstructor = new EntityDeletionOrUpdateAdapter<Instructor>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `instructor` WHERE `instructorID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Instructor value) {
        stmt.bindLong(1, value.getInstructorID());
      }
    };
    this.__updateAdapterOfInstructor = new EntityDeletionOrUpdateAdapter<Instructor>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `instructor` SET `instructorID` = ?,`firstName` = ?,`lastName` = ? WHERE `instructorID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Instructor value) {
        stmt.bindLong(1, value.getInstructorID());
        if (value.getFirstName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFirstName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLastName());
        }
        stmt.bindLong(4, value.getInstructorID());
      }
    };
  }

  @Override
  public void insert(final Instructor instructor) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfInstructor.insert(instructor);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Instructor instructor) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfInstructor.handle(instructor);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Instructor instructor) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfInstructor.handle(instructor);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Instructor> getAllInstructors() {
    final String _sql = "SELECT * FROM instructor ORDER BY instructorID DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfInstructorID = CursorUtil.getColumnIndexOrThrow(_cursor, "instructorID");
      final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "firstName");
      final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "lastName");
      final List<Instructor> _result = new ArrayList<Instructor>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Instructor _item;
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        _item = new Instructor(_tmpFirstName,_tmpLastName);
        final int _tmpInstructorID;
        _tmpInstructorID = _cursor.getInt(_cursorIndexOfInstructorID);
        _item.setInstructorID(_tmpInstructorID);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
