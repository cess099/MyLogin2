import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Define your database schema and methods here

    public static final String DATABASE_NAME = "YourDatabaseName";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_USER = "users";
    public static final String KEY_ID = "id";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    private static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + " (" +
            KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            KEY_EMAIL + " TEXT," +
            KEY_PASSWORD + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    public long addUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, email);
        values.put(KEY_PASSWORD, password);
        long userId = db.insert(TABLE_USER, null, values);
        db.close();
        return userId;
    }

    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {KEY_ID};
        String selection = KEY_EMAIL + "=? and " + KEY_PASSWORD + "=?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        return count > 0;
    }
}
