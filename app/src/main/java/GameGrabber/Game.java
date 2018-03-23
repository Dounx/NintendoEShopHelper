package GameGrabber;

import java.util.Date;

/**
 * The final class showed for users, it's data from Game View (from database)
 */
public class Game {
    private String mUsTitle;
    private String mEuTitle;
    private String mJpTitle;
    private String mGameCode;    // Parsed game code, such as HACPAACCA become AACC
    private String mLanguage;
    private String mUsNsUid;
    private String mEuNsUid;
    private String mJpNsUid;
    private boolean mDiscount;
    private boolean mFavour;
    private String mIconUrl;
    private String mUrl;
    private Date mReleaseDate;
    private String mPlayerNumber;
    private String mCategory;
    private Price mPrice;    // Only get data when needed, use class method queryPrice()

    public String getTitle() {
        if (mUsTitle != null) {
            return mUsTitle;
        } else if (mEuTitle != null) {
            return mEuTitle;
        } else if (mJpTitle != null) {
            return mJpTitle;
        }
        return null;
    }

    public String getIconUrl() {
        return mIconUrl;
    }

    public void setIconUrl(String iconUrl) {
        mIconUrl = iconUrl;
    }

    public boolean isFavour() {
        return mFavour;
    }

    public void setFavour(boolean favour) {
        mFavour = favour;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public String getUsNsUid() {
        return mUsNsUid;
    }

    public void setUsNsUid(String usNsUid) {
        mUsNsUid = usNsUid;
    }

    public String getEuNsUid() {
        return mEuNsUid;
    }

    public void setEuNsUid(String euNsUid) {
        mEuNsUid = euNsUid;
    }

    public String getJpNsUid() {
        return mJpNsUid;
    }

    public void setJpNsUid(String jpNsUid) {
        mJpNsUid = jpNsUid;
    }

    public boolean isDiscount() {
        return mDiscount;
    }

    public void setDiscount(boolean discount) {
        this.mDiscount = discount;
    }

    public String getUsTitle() {
        return mUsTitle;
    }

    public void setUsTitle(String usTitle) {
        mUsTitle = usTitle;
    }

    public String getEuTitle() {
        return mEuTitle;
    }

    public void setEuTitle(String euTitle) {
        mEuTitle = euTitle;
    }

    public String getJpTitle() {
        return mJpTitle;
    }

    public void setJpTitle(String jpTitle) {
        mJpTitle = jpTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getGameCode() {
        return mGameCode;
    }

    public void setGameCode(String gameCode) {
        mGameCode = gameCode;
    }

    public Date getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        mReleaseDate = releaseDate;
    }

    public String getPlayerNumber() {
        return mPlayerNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        mPlayerNumber = playerNumber;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public Price getPrice() {
        return mPrice;
    }

    public void setPrice(Price price) {
        mPrice = price;
    }
}
