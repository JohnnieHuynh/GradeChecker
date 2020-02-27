package com.example.finalproject5.Model.Category;

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
public final class CategoryDao_Impl implements CategoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Category> __insertionAdapterOfCategory;

  private final EntityDeletionOrUpdateAdapter<Category> __deletionAdapterOfCategory;

  private final EntityDeletionOrUpdateAdapter<Category> __updateAdapterOfCategory;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFromUsername;

  private final SharedSQLiteStatement __preparedStmtOfDeleteFromSwipe;

  public CategoryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCategory = new EntityInsertionAdapter<Category>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `category` (`categoryID`,`courseID`,`title`,`weight`,`assignedDate`,`gradeID`,`username`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Category value) {
        stmt.bindLong(1, value.getCategoryID());
        stmt.bindLong(2, value.getCourseID());
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        stmt.bindLong(4, value.getWeight());
        if (value.getAssignedDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAssignedDate());
        }
        stmt.bindLong(6, value.getGradeID());
        if (value.getUsername() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUsername());
        }
      }
    };
    this.__deletionAdapterOfCategory = new EntityDeletionOrUpdateAdapter<Category>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `category` WHERE `categoryID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Category value) {
        stmt.bindLong(1, value.getCategoryID());
      }
    };
    this.__updateAdapterOfCategory = new EntityDeletionOrUpdateAdapter<Category>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `category` SET `categoryID` = ?,`courseID` = ?,`title` = ?,`weight` = ?,`assignedDate` = ?,`gradeID` = ?,`username` = ? WHERE `categoryID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Category value) {
        stmt.bindLong(1, value.getCategoryID());
        stmt.bindLong(2, value.getCourseID());
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        stmt.bindLong(4, value.getWeight());
        if (value.getAssignedDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAssignedDate());
        }
        stmt.bindLong(6, value.getGradeID());
        if (value.getUsername() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUsername());
        }
        stmt.bindLong(8, value.getCategoryID());
      }
    };
    this.__preparedStmtOfUpdateFromUsername = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Category SET username = ? WHERE username = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteFromSwipe = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM category WHERE username = ? AND courseID = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Category category) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCategory.insert(category);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Category category) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCategory.handle(category);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Category category) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCategory.handle(category);
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
  public void deleteFromSwipe(final String username, final String courseID) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteFromSwipe.acquire();
    int _argIndex = 1;
    if (username == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, username);
    }
    _argIndex = 2;
    if (courseID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, courseID);
    }
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
  public List<Category> getAllCategories(final String username, final int courseID) {
    final String _sql = "SELECT * FROM category where username= ? and courseID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, courseID);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCategoryID = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryID");
      final int _cursorIndexOfCourseID = CursorUtil.getColumnIndexOrThrow(_cursor, "courseID");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
      final int _cursorIndexOfAssignedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "assignedDate");
      final int _cursorIndexOfGradeID = CursorUtil.getColumnIndexOrThrow(_cursor, "gradeID");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final List<Category> _result = new ArrayList<Category>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Category _item;
        final int _tmpCourseID;
        _tmpCourseID = _cursor.getInt(_cursorIndexOfCourseID);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final int _tmpWeight;
        _tmpWeight = _cursor.getInt(_cursorIndexOfWeight);
        final String _tmpAssignedDate;
        _tmpAssignedDate = _cursor.getString(_cursorIndexOfAssignedDate);
        final int _tmpGradeID;
        _tmpGradeID = _cursor.getInt(_cursorIndexOfGradeID);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _item = new Category(_tmpTitle,_tmpCourseID,_tmpWeight,_tmpAssignedDate,_tmpGradeID,_tmpUsername);
        final int _tmpCategoryID;
        _tmpCategoryID = _cursor.getInt(_cursorIndexOfCategoryID);
        _item.setCategoryID(_tmpCategoryID);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Category> getAllCategories() {
    final String _sql = "SELECT * FROM category ORDER BY categoryID DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCategoryID = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryID");
      final int _cursorIndexOfCourseID = CursorUtil.getColumnIndexOrThrow(_cursor, "courseID");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
      final int _cursorIndexOfAssignedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "assignedDate");
      final int _cursorIndexOfGradeID = CursorUtil.getColumnIndexOrThrow(_cursor, "gradeID");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final List<Category> _result = new ArrayList<Category>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Category _item;
        final int _tmpCourseID;
        _tmpCourseID = _cursor.getInt(_cursorIndexOfCourseID);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final int _tmpWeight;
        _tmpWeight = _cursor.getInt(_cursorIndexOfWeight);
        final String _tmpAssignedDate;
        _tmpAssignedDate = _cursor.getString(_cursorIndexOfAssignedDate);
        final int _tmpGradeID;
        _tmpGradeID = _cursor.getInt(_cursorIndexOfGradeID);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _item = new Category(_tmpTitle,_tmpCourseID,_tmpWeight,_tmpAssignedDate,_tmpGradeID,_tmpUsername);
        final int _tmpCategoryID;
        _tmpCategoryID = _cursor.getInt(_cursorIndexOfCategoryID);
        _item.setCategoryID(_tmpCategoryID);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Category getCategoryByID(final String id) {
    final String _sql = "SELECT * FROM category WHERE categoryID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCategoryID = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryID");
      final int _cursorIndexOfCourseID = CursorUtil.getColumnIndexOrThrow(_cursor, "courseID");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
      final int _cursorIndexOfAssignedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "assignedDate");
      final int _cursorIndexOfGradeID = CursorUtil.getColumnIndexOrThrow(_cursor, "gradeID");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final Category _result;
      if(_cursor.moveToFirst()) {
        final int _tmpCourseID;
        _tmpCourseID = _cursor.getInt(_cursorIndexOfCourseID);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final int _tmpWeight;
        _tmpWeight = _cursor.getInt(_cursorIndexOfWeight);
        final String _tmpAssignedDate;
        _tmpAssignedDate = _cursor.getString(_cursorIndexOfAssignedDate);
        final int _tmpGradeID;
        _tmpGradeID = _cursor.getInt(_cursorIndexOfGradeID);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _result = new Category(_tmpTitle,_tmpCourseID,_tmpWeight,_tmpAssignedDate,_tmpGradeID,_tmpUsername);
        final int _tmpCategoryID;
        _tmpCategoryID = _cursor.getInt(_cursorIndexOfCategoryID);
        _result.setCategoryID(_tmpCategoryID);
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
  public Category getCategoryByName(final String name) {
    final String _sql = "SELECT * FROM category WHERE title = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCategoryID = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryID");
      final int _cursorIndexOfCourseID = CursorUtil.getColumnIndexOrThrow(_cursor, "courseID");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "weight");
      final int _cursorIndexOfAssignedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "assignedDate");
      final int _cursorIndexOfGradeID = CursorUtil.getColumnIndexOrThrow(_cursor, "gradeID");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final Category _result;
      if(_cursor.moveToFirst()) {
        final int _tmpCourseID;
        _tmpCourseID = _cursor.getInt(_cursorIndexOfCourseID);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final int _tmpWeight;
        _tmpWeight = _cursor.getInt(_cursorIndexOfWeight);
        final String _tmpAssignedDate;
        _tmpAssignedDate = _cursor.getString(_cursorIndexOfAssignedDate);
        final int _tmpGradeID;
        _tmpGradeID = _cursor.getInt(_cursorIndexOfGradeID);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _result = new Category(_tmpTitle,_tmpCourseID,_tmpWeight,_tmpAssignedDate,_tmpGradeID,_tmpUsername);
        final int _tmpCategoryID;
        _tmpCategoryID = _cursor.getInt(_cursorIndexOfCategoryID);
        _result.setCategoryID(_tmpCategoryID);
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
