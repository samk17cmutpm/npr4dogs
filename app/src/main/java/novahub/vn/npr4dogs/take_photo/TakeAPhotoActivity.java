package novahub.vn.npr4dogs.take_photo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.andexert.library.RippleView;

import java.io.File;
import java.io.IOException;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.add_a_dog.AddADogActivity;
import novahub.vn.npr4dogs.main.MainActivity;
import novahub.vn.npr4dogs.piles.PilesActivity;

public class TakeAPhotoActivity extends AppCompatActivity implements Base{
    public final String APP_TAG = "MyCustomApp";
    public final static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1034;
    public final static int PICK_PHOTO_CODE = 1046;

    public String photoFileName = "photo.jpg";
    private RippleView rippleViewTakeNewPhoto;
    private RippleView rippleViewChooseFromGallery;
    private RippleView rippleViewRetry;
    private RippleView rippleViewDone;
    private int from;
    private ImageView ivPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_aphoto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        from = getIntent().getIntExtra(FROM, 0);

        rippleViewTakeNewPhoto = (RippleView) findViewById(R.id.rvp_take_new_photo);
        rippleViewTakeNewPhoto.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                rippleViewTakeNewPhoto.setEnabled(false);
                onLaunchCamera();
            }

        });

        rippleViewChooseFromGallery = (RippleView) findViewById(R.id.rvp_choose_from_galerry);
        rippleViewChooseFromGallery.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                rippleViewTakeNewPhoto.setEnabled(false);
                onPickPhoto();
            }

        });

        rippleViewRetry = (RippleView) findViewById(R.id.rpv_retry);
        rippleViewRetry.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                rippleViewTakeNewPhoto.setEnabled(false);
                onLaunchCamera();
            }

        });

        rippleViewDone = (RippleView) findViewById(R.id.rpv_cancel);
        rippleViewDone.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                int from = getIntent().getIntExtra(FROM, 0);
                int page = getIntent().getIntExtra(PAGE, 0);
                Intent intent = null;
                switch (from) {
                    case FROM_ADD_A_DOG:
                        intent = new Intent(TakeAPhotoActivity.this, AddADogActivity.class);
                        break;

                    case FROM_PILES:
                        intent = new Intent(TakeAPhotoActivity.this, PilesActivity.class);
                        break;

                    default:
                        intent = new Intent(TakeAPhotoActivity.this, MainActivity.class);
                        break;

                }
                intent.putExtra(IS_FROM_ACTION, true);
                intent.putExtra(PAGE, page);
                startActivity(intent);
                finish();
            }

        });

        ivPreview = (ImageView) findViewById(R.id.ivPreview);
    }
    public static Bitmap rotateImage(Bitmap source, float angle) {
        Bitmap retVal;

        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        retVal = Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);

        return retVal;
    }
    public void onLaunchCamera() {
        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, getPhotoFileUri(photoFileName)); // set the image file name

        // If you call startActivityForResult() using an intent that no app can handle, your app will crash.
        // So as long as the result is not null, it's safe to use the intent.
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Start the image capture intent to take photo
            startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        }
    }

    public void onPickPhoto() {
        // Create intent for picking a photo from the gallery
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        // If you call startActivityForResult() using an intent that no app can handle, your app will crash.
        // So as long as the result is not null, it's safe to use the intent.
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Bring up gallery to select a photo
            startActivityForResult(intent, PICK_PHOTO_CODE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Uri takenPhotoUri = getPhotoFileUri(photoFileName);
                // by this point we have the camera photo on disk
                Bitmap takenImage = BitmapFactory.decodeFile(takenPhotoUri.getPath());

                ExifInterface ei = null;
                try {
                    ei = new ExifInterface(takenPhotoUri.getPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED);
                Log.d("==============>", String.valueOf(orientation));
                Log.d("==============>", String.valueOf(ExifInterface.ORIENTATION_ROTATE_90));
                Log.d("==============>", String.valueOf(ExifInterface.ORIENTATION_ROTATE_180));
                switch(orientation) {
                    case ExifInterface.ORIENTATION_ROTATE_90:
                        ivPreview.setImageBitmap(rotateImage(takenImage, 90));
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_180:
                        ivPreview.setImageBitmap(rotateImage(takenImage, 180));
                        break;
                    case ExifInterface.ORIENTATION_NORMAL:
                        ivPreview.setImageBitmap(takenImage);
                    // etc.
                }


            } else { // Result was a failure
                Toast.makeText(this, "Picture wasn't taken!", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == PICK_PHOTO_CODE) {
            if (data != null) {
                Uri photoUri = data.getData();
                // Do something with the photo based on Uri
                Bitmap selectedImage = null;
                try {
                    selectedImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photoUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // Load the selected image into a preview
                ivPreview.setImageBitmap(selectedImage);
                ivPreview.setEnabled(false);
            }
        }
    }

    // Returns the Uri for a photo stored on disk given the fileName
    public Uri getPhotoFileUri(String fileName) {
        // Only continue if the SD Card is mounted
        if (isExternalStorageAvailable()) {
            // Get safe storage directory for photos
            // Use `getExternalFilesDir` on Context to access package-specific directories.
            // This way, we don't need to request external read/write runtime permissions.
            File mediaStorageDir = new File(
                    getExternalFilesDir(Environment.DIRECTORY_PICTURES), APP_TAG);

            // Create the storage directory if it does not exist
            if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()){
                Log.d(APP_TAG, "failed to create directory");
            }

            // Return the file target for the photo based on filename
            return Uri.fromFile(new File(mediaStorageDir.getPath() + File.separator + fileName));
        }
        return null;
    }

    // Returns true if external storage for photos is available
    private boolean isExternalStorageAvailable() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }

}
