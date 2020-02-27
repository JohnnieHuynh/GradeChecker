package com.example.finalproject5.Model.Assignment;

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
public final class AssignmentDao_Impl implements AssignmentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Assignment> __insertionAdapterOfAssignment;

  private final EntityDeletionOrUpdateAdapter<Assignment> __deletionAdapterOfAssignment;

  private final EntityDeletionOrUpdateAdapter<Assignment> __updateAdapterOfAssignment;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFromUsername;

  private final SharedSQLiteStatement __preparedStmtOfDeleteFromSwipe;

  public AssignmentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAssignment = new EntityInsertionAdapter<Assignment>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `assignment` (`assignmentID`,`details`,`assignmentName`,`maxScore`,`earnedScore`,`assignedDate`,`dueDate`,`courseID`,`categoryID`,`username`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Assignment value) {
        stmt.bindLong(1, value.getAssignmentID());
        if (value.getDetails() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDetails());
        }
        if (value.getAssignmentName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAssignmentName());
        }
        stmt.bindDouble(4, value.getMaxScore());
        stmt.bindDouble(5, value.getEarnedScore());
        if (value.getAssignedDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAssignedDate());
        }
        if (value.getDueDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDueDate());
        }
        stmt.bindLong(8, value.getCourseID());
        if (value.getCategoryID() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCategoryID());
        }
        if (value.getUsername() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUsername());
        }
      }
    };
    this.__deletionAdapterOfAssignment = new EntityDeletionOrUpdateAdapter<Assignment>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `assignment` WHERE `assignmentID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Assignment value) {
        stmt.bindLong(1, value.getAssignmentID());
      }
    };
    this.__updateAdapterOfAssignment = new EntityDeletionOrUpdateAdapter<Assignment>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `assignment` SET `assignmentID` = ?,`details` = ?,`assignmentName` = ?,`maxScore` = ?,`earnedScore` = ?,`assignedDate` = ?,`dueDate` = ?,`courseID` = ?,`categoryID` = ?,`username` = ? WHERE `assignmentID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Assignment value) {
        stmt.bindLong(1, value.getAssignmentID());
        if (value.getDetails() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDetails());
        }
        if (value.getAssignmentName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAssignmentName());
        }
        stmt.bindDouble(4, value.getMaxScore());
        stmt.bindDouble(5, value.getEarnedScore());
        if (value.getAssignedDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAssignedDate());
        }
        if (value.getDueDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDueDate());
        }
        stmt.bindLong(8, value.getCourseID());
        if (value.getCategoryID() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCategoryID());
        }
        if (value.getUsername() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUsername());
        }
        stmt.bindLong(11, value.getAssignmentID());
      }
    };
    this.__preparedStmtOfUpdateFromUsername = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Assignment SET username = ? WHERE username = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteFromSwipe = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM assignment WHERE username = ? AND courseID = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Assignment assignment) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAssignment.insert(assignment);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Assignment assignment) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAssignment.handle(assignment);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Assignment assignment) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAssignment.handle(assignment);
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
  public void deleteFromSwipe(final String username, final int courseID) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteFromSwipe.acquire();
    int _argIndex = 1;
    if (username == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, username);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, courseID);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteFromSwipe.release(_stmt);
    }
  }

  @Override
  public Assignment getFromUsername(final String givenUsername) {
    final String _sql = "SELECT * FROM assignment WHERE username = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (givenUsername == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, givenUsername);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignmentID = CursorUtil.getColumnIndexOrThrow(_cursor, "assignmentID");
      final int _cursorIndexOfDetails = CursorUtil.getColumnIndexOrThrow(_cursor, "details");
      final int _cursorIndexOfAssignmentName = CursorUtil.getColumnIndexOrThrow(_cursor, "assignmentName");
      final int _cursorIndexOfMaxScore = CursorUtil.getColumnIndexOrThrow(_cursor, "maxScore");
      final int _cursorIndexOfEarnedScore = CursorUtil.getColumnIndexOrThrow(_cursor, "earnedScore");
      final int _cursorIndexOfAssignedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "assignedDate");
      final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
      final int _cursorIndexOfCourseID = CursorUtil.getColumnIndexOrThrow(_cursor, "courseID");
      final int _cursorIndexOfCategoryID = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryID");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final Assignment _result;
      if(_cursor.moveToFirst()) {
        final String _tmpDetails;
        _tmpDetails = _cursor.getString(_cursorIndexOfDetails);
        final String _tmpAssignmentName;
        _tmpAssignmentName = _cursor.getString(_cursorIndexOfAssignmentName);
        final double _tmpMaxScore;
        _tmpMaxScore = _cursor.getDouble(_cursorIndexOfMaxScore);
        final double _tmpEarnedScore;
        _tmpEarnedScore = _cursor.getDouble(_cursorIndexOfEarnedScore);
        final String _tmpAssignedDate;
        _tmpAssignedDate = _cursor.getString(_cursorIndexOfAssignedDate);
        final String _tmpDueDate;
        _tmpDueDate = _cursor.getString(_cursorIndexOfDueDate);
        final int _tmpCourseID;
        _tmpCourseID = _cursor.getInt(_cursorIndexOfCourseID);
        final String _tmpCategoryID;
        _tmpCategoryID = _cursor.getString(_cursorIndexOfCategoryID);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _result = new Assignment(_tmpAssignmentName,_tmpDetails,_tmpMaxScore,_tmpEarnedScore,_tmpAssignedDate,_tmpDueDate,_tmpCourseID,_tmpCategoryID,_tmpUsername);
        final int _tmpAssignmentID;
        _tmpAssignmentID = _cursor.getInt(_cursorIndexOfAssignmentID);
        _result.setAssignmentID(_tmpAssignmentID);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Assignment> getAllCourseAssignments(final String user, final int courseID) {
    final String _sql = "SELECT * FROM assignment WHERE username = ? and courseID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (user == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, user);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, courseID);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignmentID = CursorUtil.getColumnIndexOrThrow(_cursor, "assignmentID");
      final int _cursorIndexOfDetails = CursorUtil.getColumnIndexOrThrow(_cursor, "details");
      final int _cursorIndexOfAssignmentName = CursorUtil.getColumnIndexOrThrow(_cursor, "assignmentName");
      final int _cursorIndexOfMaxScore = CursorUtil.getColumnIndexOrThrow(_cursor, "maxScore");
      final int _cursorIndexOfEarnedScore = CursorUtil.getColumnIndexOrThrow(_cursor, "earnedScore");
      final int _cursorIndexOfAssignedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "assignedDate");
      final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
      final int _cursorIndexOfCourseID = CursorUtil.getColumnIndexOrThrow(_cursor, "courseID");
      final int _cursorIndexOfCategoryID = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryID");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final List<Assignment> _result = new ArrayList<Assignment>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Assignment _item;
        final String _tmpDetails;
        _tmpDetails = _cursor.getString(_cursorIndexOfDetails);
        final String _tmpAssignmentName;
        _tmpAssignmentName = _cursor.getString(_cursorIndexOfAssignmentName);
        final double _tmpMaxScore;
        _tmpMaxScore = _cursor.getDouble(_cursorIndexOfMaxScore);
        final double _tmpEarnedScore;
        _tmpEarnedScore = _cursor.getDouble(_cursorIndexOfEarnedScore);
        final String _tmpAssignedDate;
        _tmpAssignedDate = _cursor.getString(_cursorIndexOfAssignedDate);
        final String _tmpDueDate;
        _tmpDueDate = _cursor.getString(_cursorIndexOfDueDate);
        final int _tmpCourseID;
        _tmpCourseID = _cursor.getInt(_cursorIndexOfCourseID);
        final String _tmpCategoryID;
        _tmpCategoryID = _cursor.getString(_cursorIndexOfCategoryID);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _item = new Assignment(_tmpAssignmentName,_tmpDetails,_tmpMaxScore,_tmpEarnedScore,_tmpAssignedDate,_tmpDueDate,_tmpCourseID,_tmpCategoryID,_tmpUsername);
        final int _tmpAssignmentID;
        _tmpAssignmentID = _cursor.getInt(_cursorIndexOfAssignmentID);
        _item.setAssignmentID(_tmpAssignmentID);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Assignment> getAll(final String username, final String categoryID,
      final int courseID) {
    final String _sql = "select * from assignment where username = ? and categoryID = ? and courseID = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    _argIndex = 2;
    if (categoryID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, categoryID);
    }
    _argIndex = 3;
    _statement.bindLong(_argIndex, courseID);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignmentID = CursorUtil.getColumnIndexOrThrow(_cursor, "assignmentID");
      final int _cursorIndexOfDetails = CursorUtil.getColumnIndexOrThrow(_cursor, "details");
      final int _cursorIndexOfAssignmentName = CursorUtil.getColumnIndexOrThrow(_cursor, "assignmentName");
      final int _cursorIndexOfMaxScore = CursorUtil.getColumnIndexOrThrow(_cursor, "maxScore");
      final int _cursorIndexOfEarnedScore = CursorUtil.getColumnIndexOrThrow(_cursor, "earnedScore");
      final int _cursorIndexOfAssignedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "assignedDate");
      final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
      final int _cursorIndexOfCourseID = CursorUtil.getColumnIndexOrThrow(_cursor, "courseID");
      final int _cursorIndexOfCategoryID = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryID");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final List<Assignment> _result = new ArrayList<Assignment>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Assignment _item;
        final String _tmpDetails;
        _tmpDetails = _cursor.getString(_cursorIndexOfDetails);
        final String _tmpAssignmentName;
        _tmpAssignmentName = _cursor.getString(_cursorIndexOfAssignmentName);
        final double _tmpMaxScore;
        _tmpMaxScore = _cursor.getDouble(_cursorIndexOfMaxScore);
        final double _tmpEarnedScore;
        _tmpEarnedScore = _cursor.getDouble(_cursorIndexOfEarnedScore);
        final String _tmpAssignedDate;
        _tmpAssignedDate = _cursor.getString(_cursorIndexOfAssignedDate);
        final String _tmpDueDate;
        _tmpDueDate = _cursor.getString(_cursorIndexOfDueDate);
        final int _tmpCourseID;
        _tmpCourseID = _cursor.getInt(_cursorIndexOfCourseID);
        final String _tmpCategoryID;
        _tmpCategoryID = _cursor.getString(_cursorIndexOfCategoryID);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _item = new Assignment(_tmpAssignmentName,_tmpDetails,_tmpMaxScore,_tmpEarnedScore,_tmpAssignedDate,_tmpDueDate,_tmpCourseID,_tmpCategoryID,_tmpUsername);
        final int _tmpAssignmentID;
        _tmpAssignmentID = _cursor.getInt(_cursorIndexOfAssignmentID);
        _item.setAssignmentID(_tmpAssignmentID);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Assignment getAssignmentByID(final int id) {
    final String _sql = "SELECT * FROM assignment WHERE assignmentID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignmentID = CursorUtil.getColumnIndexOrThrow(_cursor, "assignmentID");
      final int _cursorIndexOfDetails = CursorUtil.getColumnIndexOrThrow(_cursor, "details");
      final int _cursorIndexOfAssignmentName = CursorUtil.getColumnIndexOrThrow(_cursor, "assignmentName");
      final int _cursorIndexOfMaxScore = CursorUtil.getColumnIndexOrThrow(_cursor, "maxScore");
      final int _cursorIndexOfEarnedScore = CursorUtil.getColumnIndexOrThrow(_cursor, "earnedScore");
      final int _cursorIndexOfAssignedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "assignedDate");
      final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
      final int _cursorIndexOfCourseID = CursorUtil.getColumnIndexOrThrow(_cursor, "courseID");
      final int _cursorIndexOfCategoryID = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryID");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final Assignment _result;
      if(_cursor.moveToFirst()) {
        final String _tmpDetails;
        _tmpDetails = _cursor.getString(_cursorIndexOfDetails);
        final String _tmpAssignmentName;
        _tmpAssignmentName = _cursor.getString(_cursorIndexOfAssignmentName);
        final double _tmpMaxScore;
        _tmpMaxScore = _cursor.getDouble(_cursorIndexOfMaxScore);
        final double _tmpEarnedScore;
        _tmpEarnedScore = _cursor.getDouble(_cursorIndexOfEarnedScore);
        final String _tmpAssignedDate;
        _tmpAssignedDate = _cursor.getString(_cursorIndexOfAssignedDate);
        final String _tmpDueDate;
        _tmpDueDate = _cursor.getString(_cursorIndexOfDueDate);
        final int _tmpCourseID;
        _tmpCourseID = _cursor.getInt(_cursorIndexOfCourseID);
        final String _tmpCategoryID;
        _tmpCategoryID = _cursor.getString(_cursorIndexOfCategoryID);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _result = new Assignment(_tmpAssignmentName,_tmpDetails,_tmpMaxScore,_tmpEarnedScore,_tmpAssignedDate,_tmpDueDate,_tmpCourseID,_tmpCategoryID,_tmpUsername);
        final int _tmpAssignmentID;
        _tmpAssignmentID = _cursor.getInt(_cursorIndexOfAssignmentID);
        _result.setAssignmentID(_tmpAssignmentID);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
