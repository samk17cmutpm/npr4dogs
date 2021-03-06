package novahub.vn.npr4dogs;

/**
 * Created by samnguyen on 5/5/16.
 */
public interface Base {
    public static final String FONT = "fonts/avenir_next.ttc";
    public static final int TABS = 8;
    public static final int RESIDENTS = 2;
    public static final int ADD_A_DOG = 7;
    public static final int PILES = 5;
    public static final String PAGE = "PAGE";
    public static final String FROM = "FROM";
    public static final String IS_FROM_ACTION = "IS_FROM_ACTION";
    public static final String CURRENT_TAB = "CURRENT_TAB";
    public static final String POSITION = "POSITION";

    public static final int FROM_ADD_A_DOG = 1;
    public static final int FROM_PILES = 2;
    public static final int FROM_TAKE_PHOT0 = 2;
    public static final int FROM_SCAN_CARD_IO = 3;
    public static final int FROM_SCAN_BARCODE = 4;

    public static final int GO_TO_BEGIN_SURVEY = 1;
    public static final int GO_TO_PAYMENT = 2;
    public static final int GO_TO_TAKE_PHOTO_DOG = 3;
    public static final int GO_TO_TAKE_PHOTO_OWNER = 4;
    public static final int GO_TO_STEP_FIVE = 5;

    public static final int GO_TO_PILES_STEP_THREE = 2;
    public static final int GO_TO_PILES_STEP_FOUR = 3;
    public static final int GO_TO_PILES_STEP_FIVE = 4;

    public static final int TAB_ADD_A_DOG = 0;
    public static final int TAB_PILES = 1;
    public static final int TAB_RESIDENTS = 2;
    public static final int TAB_SETTINGS = 3;
    public static final int TAB_ADD_A_DOG_PAST = 4;
    public static final int TAB_TEST_A_NEW_PILE = 5;
    public static final int TAB_RESIDENTS_DETAIL = 6;
    public static final int TAB_PILES_DETAIL = 7;


    public static final int MATCH_FOUND = 0;
    public static final int PENDING_TO_TEST = 1;
    public static final int UNABLE_TO_MATCH = 2;
}
