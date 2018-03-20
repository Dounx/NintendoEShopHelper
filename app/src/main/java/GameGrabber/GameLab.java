package GameGrabber;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import GameDbSchema.GameBaseHelper;
import GameDbSchema.GameCursorWrapper;

import static GameDbSchema.GameDbSchema.*;

/**
 * Singleton pattern for Game class
 */
public class GameLab {
    private static GameLab sGameLab;
    private final Context mContext;
    private final SQLiteDatabase mDatabase;
    public HashMap<String, Double> mRatesMap;

    public static GameLab get(Context context) {
        if (sGameLab == null) {
            sGameLab = new GameLab(context);
        }
        return sGameLab;
    }

    private GameLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new GameBaseHelper(mContext).getReadableDatabase();
    }

    public List<Game> getGames() {
        List<Game> games = new ArrayList<>();

        try (GameCursorWrapper cursor = queryGames(null, null)) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                games.add(cursor.getGame());
                cursor.moveToNext();
            }
        }
        return games;
    }

    public Game getGame(String title) {
        try (GameCursorWrapper cursor = queryGames("us_title = ?", new String[]{title})) {
            cursor.moveToFirst();
            return cursor.getGame();
        }
    }

    public List<Game> getGamesByReleaseDate(final boolean isAsc) {
        List<Game> games = getGames();

        Collections.sort(games,new Comparator<Game>(){
            public int compare(Game arg0, Game arg1) {
                Date date0 = null;
                Date date1 = null;
                DateFormat format = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
                try {
                    date0 = format.parse(arg0.getReleaseDate());
                    date1 = format.parse(arg1.getReleaseDate());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return isAsc? date0.compareTo(date1) : date1.compareTo(date0);
            }
        });

        return games;
    }

    public List<Game> getNewGames() {
        List<Game> games = getGames();
        List<Game> newGames = new ArrayList<>();
        List<Date> dates = new ArrayList<>();
        DateFormat format = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);

        for (Game game : games) {
            Date date = null;
            try {
                date = format.parse(game.getReleaseDate());
            } catch (Exception e) {
                e.printStackTrace();
            }
            dates.add(date);
        }

        Date currentDate = Calendar.getInstance(Locale.US).getTime();

        for (int i = 0; i < dates.size(); i++) {
            if (dates.get(i).after(currentDate)) {
                newGames.add(games.get(i));
            }
        }
        return newGames;
    }

    public List<Game> getDiscountGames() {
        List<Game> games = getGames();
        List<Game> discountGames = new ArrayList<>();

        for (Game game : games) {
            if (game.isDiscount()) {
                discountGames.add(game);
            }
        }
        return discountGames;
    }

    // Close the database connection
    public void Clean() {
        if (mDatabase.isOpen()) {
            mDatabase.close();
        }
    }

    private GameCursorWrapper queryGames(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                GameView.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new GameCursorWrapper(cursor);
    }
}
