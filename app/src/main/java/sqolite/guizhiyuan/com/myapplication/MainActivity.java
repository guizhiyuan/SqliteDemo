package sqolite.guizhiyuan.com.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private MyDatabaseHelper databaseHelper;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        button= (Button) findViewById(R.id.create_database);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.getWritableDatabase();
            }
        });
    }

    public class MyDatabaseHelper extends SQLiteOpenHelper {

        private static final String DATABASE_CREATE = "create table book (" +
                "id integer primary key autoincrement," + "author text," + "price real,"
                + "page integer," + "name text)";
        private Context mContext;

        public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
            mContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
            Toast.makeText(mContext, "创建成功", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }


}
