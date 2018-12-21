package com.example.android.retrofitgsonplusroom.room;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.android.retrofitgsonplusroom.model.Locations;
import io.reactivex.Flowable;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public final class LocationsDao_Impl implements LocationsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfLocations;

  private final Converters __converters = new Converters();

  public LocationsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLocations = new EntityInsertionAdapter<Locations>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Locations`(`idd`,`id`,`name`,`type`,`dimension`,`residents`,`url`,`created`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Locations value) {
        stmt.bindLong(1, value.getIdd());
        if (value.getId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getType());
        }
        if (value.getDimension() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDimension());
        }
        final String _tmp;
        _tmp = __converters.fromCountryLangList(value.getResidents());
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp);
        }
        if (value.getUrl() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUrl());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCreated());
        }
      }
    };
  }

  @Override
  public void insertCurrent(final Locations item) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfLocations.insert(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flowable<List<Locations>> getAll() {
    final String _sql = "SELECT * FROM Locations";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"Locations"}, new Callable<List<Locations>>() {
      @Override
      public List<Locations> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfIdd = CursorUtil.getColumnIndexOrThrow(_cursor, "idd");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfDimension = CursorUtil.getColumnIndexOrThrow(_cursor, "dimension");
          final int _cursorIndexOfResidents = CursorUtil.getColumnIndexOrThrow(_cursor, "residents");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
          final List<Locations> _result = new ArrayList<Locations>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Locations _item;
            final int _tmpIdd;
            _tmpIdd = _cursor.getInt(_cursorIndexOfIdd);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpDimension;
            _tmpDimension = _cursor.getString(_cursorIndexOfDimension);
            final List<String> _tmpResidents;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfResidents);
            _tmpResidents = __converters.toCountryLangList(_tmp);
            final String _tmpUrl;
            _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            final String _tmpCreated;
            _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
            _item = new Locations(_tmpIdd,_tmpId,_tmpName,_tmpType,_tmpDimension,_tmpResidents,_tmpUrl,_tmpCreated);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
