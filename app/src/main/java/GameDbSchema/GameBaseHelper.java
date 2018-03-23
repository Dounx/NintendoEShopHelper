package GameDbSchema;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static GameDbSchema.GameDbSchema.*;

public class GameBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "GameBase.db";

    public GameBaseHelper(Context context) {
        super(context, DATABASE_NAME,null,  VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + USGameTable.NAME + "(" +
                USGameTable.Cols.TITLE + " primary key, " +
                USGameTable.Cols.CATEGORY + ", " +
                USGameTable.Cols.NSUID + ", " +
                USGameTable.Cols.BUYITNOW + ", " +
                USGameTable.Cols.RELEASE_DATE + ", " +
                USGameTable.Cols.DIGITALDOWNLOAD + ", " +
                USGameTable.Cols.FREE_TO_START + ", " +
                USGameTable.Cols.SLUG + ", " +
                USGameTable.Cols.SYSTEM + ", " +
                USGameTable.Cols.ID + ", " +
                USGameTable.Cols.CA_PRICE + ", " +
                USGameTable.Cols.NUMBER_OF_PLAYERS + ", " +
                USGameTable.Cols.VIDEO_LINK + ", " +
                USGameTable.Cols.ESHOP_PRICE + ", " +
                USGameTable.Cols.FRONT_BOX_ART + ", " +
                USGameTable.Cols.GAME_CODE + ", " +
                USGameTable.Cols.BUYONLINE +
                ")"
        );

        sqLiteDatabase.execSQL("create table " + JPGameTable.NAME + "(" +
                JPGameTable.Cols.TITLE_NAME + " primary key, " +
                JPGameTable.Cols.NSUID + ", " +
                JPGameTable.Cols.INITIAL_CODE + ", " +
                JPGameTable.Cols.MAKER_NAME + ", " +
                JPGameTable.Cols.MAKER_KANA + ", " +
                JPGameTable.Cols.PRICE + ", " +
                JPGameTable.Cols.SALES_DATE + ", " +
                JPGameTable.Cols.SOFT_TYPE + ", " +
                JPGameTable.Cols.PLATFORM_ID + ", " +
                JPGameTable.Cols.DL_ICON_FLG + ", " +
                JPGameTable.Cols.LINK_URL + ", " +
                JPGameTable.Cols.SCREENSHOT_IMG_FLG + ", " +
                JPGameTable.Cols.SCREENSHOT_IMG_URL +
                ")"
        );

        sqLiteDatabase.execSQL("create table " + EUGameTable.NAME + "(" +
                EUGameTable.Cols.TITLE + " primary key, " +
                EUGameTable.Cols.FS_ID + ", " +
                EUGameTable.Cols.CHANGE_DATE + ", " +
                EUGameTable.Cols.URL + ", " +
                EUGameTable.Cols.TYPE + ", " +
                EUGameTable.Cols.CLUB_NINTENDO + ", " +
                EUGameTable.Cols.HD_RUMBLE_B + ", " +
                EUGameTable.Cols.MULTIPLAYER_MODE + ", " +
                EUGameTable.Cols.PRETTY_DATE_S + ", " +
                EUGameTable.Cols.PLAY_MODE_TV_MODE_B + ", " +
                EUGameTable.Cols.PLAY_MODE_HANDHELD_MODE_B + ", " +
                EUGameTable.Cols.IMAGE_URL_SQ_S + ", " +
                EUGameTable.Cols.PG_S + ", " +
                EUGameTable.Cols.GIFT_FINDER_DETAIL_PAGE_IMAGE_URL_S + ", " +
                EUGameTable.Cols.IMAGE_URL + ", " +
                EUGameTable.Cols.ORIGINALLY_FOR_T + ", " +
                EUGameTable.Cols.PRIORITY + ", " +
                EUGameTable.Cols.DIGITAL_VERSION_B + ", " +
                EUGameTable.Cols.IMAGE_URL_H2X1_S + ", " +
                EUGameTable.Cols.AGE_RATING_SORTING_I + ", " +
                EUGameTable.Cols.PLAY_MODE_TABLETOP_MODE_B + ", " +
                EUGameTable.Cols.PUBLISHER + ", " +
                EUGameTable.Cols.IR_MOTION_CAMERA_B + ", " +
                EUGameTable.Cols.EXCERPT + ", " +
                EUGameTable.Cols.DATE_FROM + ", " +
                EUGameTable.Cols.PRICE_HAS_DISCOUNT_B + ", " +
                EUGameTable.Cols.GIFT_FINDER_DESCRIPTION_S + ", " +
                EUGameTable.Cols.SORTING_TITLE + ", " +
                EUGameTable.Cols.COPYRIGHT_S + ", " +
                EUGameTable.Cols.GIFT_FINDER_CAROUSEL_IMAGE_URL_S + ", " +
                EUGameTable.Cols.PLAYERS_TO + ", " +
                EUGameTable.Cols.GIFT_FINDER_WISHLIST_IMAGE_URL_S + ", " +
                EUGameTable.Cols.PRETTY_AGERATING_S + ", " +
                EUGameTable.Cols.PLAYERS_FROM + ", " +
                EUGameTable.Cols.AGE_RATING_TYPE + ", " +
                EUGameTable.Cols.GIFT_FINDER_DETAIL_PAGE_STORE_LINK_S + ", " +
                EUGameTable.Cols.PRICE_SORTING_F + ", " +
                EUGameTable.Cols.PRICE_LOWEST_F + ", " +
                EUGameTable.Cols.AGE_RATING_VALUE + ", " +
                EUGameTable.Cols.PHYSICAL_VERSION_B + ", " +
                EUGameTable.Cols.GAME_CATEGORIES_TXT + ", " +
                EUGameTable.Cols.PLAYABLE_ON_TXT + ", " +
                EUGameTable.Cols.PRODUCT_CODE_TXT + ", " +
                EUGameTable.Cols.LANGUAGE_AVAILABILITY + ", " +
                EUGameTable.Cols.SYSTEM_TYPE + ", " +
                EUGameTable.Cols.DATES_RELEASED_DTS + ", " +
                EUGameTable.Cols.PRETTY_GAME_CATEGORIES_TXT + ", " +
                EUGameTable.Cols.TITLE_EXTRAS_TXT + ", " +
                EUGameTable.Cols.NSUID_TXT + ", " +
                EUGameTable.Cols.GAME_CATEGORY + ", " +
                EUGameTable.Cols.SYSTEM_NAMES_TXT +
                ")"
        );

        sqLiteDatabase.execSQL("create table " + SupportedCountryTable.NAME + "(" +
                SupportedCountryTable.Cols.NAME + " primary key, " +
                SupportedCountryTable.Cols.CODE + ", " +
                SupportedCountryTable.Cols.CURRENCY + ", " +
                SupportedCountryTable.Cols.BELONG +
                ")"
        );

        sqLiteDatabase.execSQL("CREATE VIEW TempGame AS " +
                "SELECT USGame.title AS us_title, EUGame.title AS eu_title, USGame.game_code AS game_code0, EUGame.product_code_txt AS game_code1, EUGame.language_availability AS language, USGame.nsuid AS us_nsuid, EUGame.nsuid_txt AS eu_nsuid, EUGame.price_has_discount_b AS discount, EUGame.image_url_h2x1_s AS icon_url0, USGame.slug AS url0, EUGame.url AS url1, USGame.release_date AS release_date0, EUGame.dates_released_dts AS release_date1, USGame.number_of_players AS player_number0, EUGame.players_to AS player_number1, USGame.category AS category0, EUGame.pretty_game_categories_txt AS category1 " +
                "FROM USGame LEFT OUTER JOIN EUGame ON USGame.game_code = EUGame.product_code_txt " +
                "UNION " +
                "SELECT USGame.title AS us_title, EUGame.title AS eu_title, USGame.game_code AS game_code0, EUGame.product_code_txt AS game_code1, EUGame.language_availability AS language, USGame.nsuid AS us_nsuid, EUGame.nsuid_txt AS eu_nsuid, EUGame.price_has_discount_b AS discount, EUGame.image_url_h2x1_s AS icon_url0, USGame.slug AS url0, EUGame.url AS url1, USGame.release_date AS release_date0, EUGame.dates_released_dts AS release_date1, USGame.number_of_players AS player_number0, EUGame.players_to AS player_number1, USGame.category AS category0, EUGame.pretty_game_categories_txt AS category1 " +
                "FROM EUGame LEFT OUTER JOIN USGame ON USGame.game_code = EUGame.product_code_txt;"
        );

        sqLiteDatabase.execSQL("CREATE VIEW Game AS " +
                "SELECT us_title, eu_title, JPGame.title_name AS jp_title, game_code0, game_code1, JPGame.initial_code AS game_code2, language, us_nsuid, eu_nsuid, JPGame.nsuid AS jp_nsuid, discount, icon_url0, JPGame.screenshot_img_url AS icon_url1, url0, url1, JPGame.link_url AS url2, release_date0, release_date1, JPGame.sales_date AS release_date2, player_number0, player_number1, category0, category1 " +
                "FROM TempGame LEFT OUTER JOIN JPGame ON TempGame.game_code0 = JPGame.initial_code " +
                "UNION " +
                "SELECT us_title, eu_title, JPGame.title_name AS jp_title, game_code0, game_code1, JPGame.initial_code AS game_code2, language, us_nsuid, eu_nsuid, JPGame.nsuid AS jp_nsuid, discount, icon_url0, JPGame.screenshot_img_url AS icon_url1, url0, url1, JPGame.link_url AS url2, release_date0, release_date1, JPGame.sales_date AS release_date2, player_number0, player_number1, category0, category1 " +
                "FROM JPGame LEFT OUTER JOIN TempGame ON TempGame.game_code0 = JPGame.initial_code;"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
