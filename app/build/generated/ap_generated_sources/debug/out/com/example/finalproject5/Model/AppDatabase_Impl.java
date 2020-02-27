package com.example.finalproject5.Model;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.finalproject5.Model.Assignment.AssignmentDao;
import com.example.finalproject5.Model.Assignment.AssignmentDao_Impl;
import com.example.finalproject5.Model.Category.CategoryDao;
import com.example.finalproject5.Model.Category.CategoryDao_Impl;
import com.example.finalproject5.Model.Course.CourseDao;
import com.example.finalproject5.Model.Course.CourseDao_Impl;
import com.example.finalproject5.Model.Enrollment.EnrollmentDao;
import com.example.finalproject5.Model.Enrollment.EnrollmentDao_Impl;
import com.example.finalproject5.Model.Instructor.InstructorDao;
import com.example.finalproject5.Model.Instructor.InstructorDao_Impl;
import com.example.finalproject5.Model.User.UserDao;
import com.example.finalproject5.Model.User.UserDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserDao _userDao;

  private volatile CourseDao _courseDao;

  private volatile AssignmentDao _assignmentDao;

  private volatile CategoryDao _categoryDao;

  private volatile EnrollmentDao _enrollmentDao;

  private volatile InstructorDao _instructorDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user` (`userID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `username` TEXT, `password` TEXT, `firstName` TEXT, `lastName` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `course` (`courseID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `instructor` TEXT, `title` TEXT, `description` TEXT, `startDate` TEXT, `endDate` TEXT, `username` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `assignment` (`assignmentID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `details` TEXT, `assignmentName` TEXT, `maxScore` REAL NOT NULL, `earnedScore` REAL NOT NULL, `assignedDate` TEXT, `dueDate` TEXT, `courseID` INTEGER NOT NULL, `categoryID` TEXT, `username` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `category` (`categoryID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `courseID` INTEGER NOT NULL, `title` TEXT, `weight` INTEGER NOT NULL, `assignedDate` TEXT, `gradeID` INTEGER NOT NULL, `username` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `enrollment` (`enrollmentID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `studentID` INTEGER NOT NULL, `courseID` INTEGER NOT NULL, `enrollmentDate` TEXT, `username` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `instructor` (`instructorID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `firstName` TEXT, `lastName` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5d41bf3135a60620edaf8bd1a5129bae')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `user`");
        _db.execSQL("DROP TABLE IF EXISTS `course`");
        _db.execSQL("DROP TABLE IF EXISTS `assignment`");
        _db.execSQL("DROP TABLE IF EXISTS `category`");
        _db.execSQL("DROP TABLE IF EXISTS `enrollment`");
        _db.execSQL("DROP TABLE IF EXISTS `instructor`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(5);
        _columnsUser.put("userID", new TableInfo.Column("userID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("firstName", new TableInfo.Column("firstName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("lastName", new TableInfo.Column("lastName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("user", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(_db, "user");
        if (! _infoUser.equals(_existingUser)) {
          return new RoomOpenHelper.ValidationResult(false, "user(com.example.finalproject5.Model.User.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        final HashMap<String, TableInfo.Column> _columnsCourse = new HashMap<String, TableInfo.Column>(7);
        _columnsCourse.put("courseID", new TableInfo.Column("courseID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourse.put("instructor", new TableInfo.Column("instructor", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourse.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourse.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourse.put("startDate", new TableInfo.Column("startDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourse.put("endDate", new TableInfo.Column("endDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCourse.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCourse = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCourse = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCourse = new TableInfo("course", _columnsCourse, _foreignKeysCourse, _indicesCourse);
        final TableInfo _existingCourse = TableInfo.read(_db, "course");
        if (! _infoCourse.equals(_existingCourse)) {
          return new RoomOpenHelper.ValidationResult(false, "course(com.example.finalproject5.Model.Course.Course).\n"
                  + " Expected:\n" + _infoCourse + "\n"
                  + " Found:\n" + _existingCourse);
        }
        final HashMap<String, TableInfo.Column> _columnsAssignment = new HashMap<String, TableInfo.Column>(10);
        _columnsAssignment.put("assignmentID", new TableInfo.Column("assignmentID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignment.put("details", new TableInfo.Column("details", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignment.put("assignmentName", new TableInfo.Column("assignmentName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignment.put("maxScore", new TableInfo.Column("maxScore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignment.put("earnedScore", new TableInfo.Column("earnedScore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignment.put("assignedDate", new TableInfo.Column("assignedDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignment.put("dueDate", new TableInfo.Column("dueDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignment.put("courseID", new TableInfo.Column("courseID", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignment.put("categoryID", new TableInfo.Column("categoryID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAssignment.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAssignment = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAssignment = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAssignment = new TableInfo("assignment", _columnsAssignment, _foreignKeysAssignment, _indicesAssignment);
        final TableInfo _existingAssignment = TableInfo.read(_db, "assignment");
        if (! _infoAssignment.equals(_existingAssignment)) {
          return new RoomOpenHelper.ValidationResult(false, "assignment(com.example.finalproject5.Model.Assignment.Assignment).\n"
                  + " Expected:\n" + _infoAssignment + "\n"
                  + " Found:\n" + _existingAssignment);
        }
        final HashMap<String, TableInfo.Column> _columnsCategory = new HashMap<String, TableInfo.Column>(7);
        _columnsCategory.put("categoryID", new TableInfo.Column("categoryID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("courseID", new TableInfo.Column("courseID", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("weight", new TableInfo.Column("weight", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("assignedDate", new TableInfo.Column("assignedDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("gradeID", new TableInfo.Column("gradeID", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategory.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCategory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategory = new TableInfo("category", _columnsCategory, _foreignKeysCategory, _indicesCategory);
        final TableInfo _existingCategory = TableInfo.read(_db, "category");
        if (! _infoCategory.equals(_existingCategory)) {
          return new RoomOpenHelper.ValidationResult(false, "category(com.example.finalproject5.Model.Category.Category).\n"
                  + " Expected:\n" + _infoCategory + "\n"
                  + " Found:\n" + _existingCategory);
        }
        final HashMap<String, TableInfo.Column> _columnsEnrollment = new HashMap<String, TableInfo.Column>(5);
        _columnsEnrollment.put("enrollmentID", new TableInfo.Column("enrollmentID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEnrollment.put("studentID", new TableInfo.Column("studentID", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEnrollment.put("courseID", new TableInfo.Column("courseID", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEnrollment.put("enrollmentDate", new TableInfo.Column("enrollmentDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEnrollment.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEnrollment = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEnrollment = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEnrollment = new TableInfo("enrollment", _columnsEnrollment, _foreignKeysEnrollment, _indicesEnrollment);
        final TableInfo _existingEnrollment = TableInfo.read(_db, "enrollment");
        if (! _infoEnrollment.equals(_existingEnrollment)) {
          return new RoomOpenHelper.ValidationResult(false, "enrollment(com.example.finalproject5.Model.Enrollment.Enrollment).\n"
                  + " Expected:\n" + _infoEnrollment + "\n"
                  + " Found:\n" + _existingEnrollment);
        }
        final HashMap<String, TableInfo.Column> _columnsInstructor = new HashMap<String, TableInfo.Column>(3);
        _columnsInstructor.put("instructorID", new TableInfo.Column("instructorID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInstructor.put("firstName", new TableInfo.Column("firstName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInstructor.put("lastName", new TableInfo.Column("lastName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInstructor = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInstructor = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInstructor = new TableInfo("instructor", _columnsInstructor, _foreignKeysInstructor, _indicesInstructor);
        final TableInfo _existingInstructor = TableInfo.read(_db, "instructor");
        if (! _infoInstructor.equals(_existingInstructor)) {
          return new RoomOpenHelper.ValidationResult(false, "instructor(com.example.finalproject5.Model.Instructor.Instructor).\n"
                  + " Expected:\n" + _infoInstructor + "\n"
                  + " Found:\n" + _existingInstructor);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "5d41bf3135a60620edaf8bd1a5129bae", "17b9bd3b2535f8c2585c84fabe4c0b6d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "user","course","assignment","category","enrollment","instructor");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `user`");
      _db.execSQL("DELETE FROM `course`");
      _db.execSQL("DELETE FROM `assignment`");
      _db.execSQL("DELETE FROM `category`");
      _db.execSQL("DELETE FROM `enrollment`");
      _db.execSQL("DELETE FROM `instructor`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public UserDao dao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public CourseDao courseDao() {
    if (_courseDao != null) {
      return _courseDao;
    } else {
      synchronized(this) {
        if(_courseDao == null) {
          _courseDao = new CourseDao_Impl(this);
        }
        return _courseDao;
      }
    }
  }

  @Override
  public AssignmentDao assignmentDao() {
    if (_assignmentDao != null) {
      return _assignmentDao;
    } else {
      synchronized(this) {
        if(_assignmentDao == null) {
          _assignmentDao = new AssignmentDao_Impl(this);
        }
        return _assignmentDao;
      }
    }
  }

  @Override
  public CategoryDao categoryDao() {
    if (_categoryDao != null) {
      return _categoryDao;
    } else {
      synchronized(this) {
        if(_categoryDao == null) {
          _categoryDao = new CategoryDao_Impl(this);
        }
        return _categoryDao;
      }
    }
  }

  @Override
  public EnrollmentDao enrollmentDao() {
    if (_enrollmentDao != null) {
      return _enrollmentDao;
    } else {
      synchronized(this) {
        if(_enrollmentDao == null) {
          _enrollmentDao = new EnrollmentDao_Impl(this);
        }
        return _enrollmentDao;
      }
    }
  }

  @Override
  public InstructorDao instructorDao() {
    if (_instructorDao != null) {
      return _instructorDao;
    } else {
      synchronized(this) {
        if(_instructorDao == null) {
          _instructorDao = new InstructorDao_Impl(this);
        }
        return _instructorDao;
      }
    }
  }
}
