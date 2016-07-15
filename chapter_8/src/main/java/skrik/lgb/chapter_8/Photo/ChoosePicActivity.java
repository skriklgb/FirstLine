package skrik.lgb.chapter_8.Photo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import skrik.lgb.chapter_8.R;

public class ChoosePicActivity extends Activity {

    private static final int TAKE_PHOTO = 1 ;
    private static final int CROP_PHOTO = 2 ;
    private Button mTake_photo;
    private ImageView mPicture;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosepic);

        mTake_photo = (Button) findViewById(R.id.take_photo);
        mPicture = (ImageView) findViewById(R.id.picture);

        mTake_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建File对象，用于存储拍照后的图片
                File outputImage = new File(Environment.getExternalStorageDirectory(), "tempImage.jpg");
                try {
                    if (outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageUri = Uri.fromFile(outputImage);
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(intent,TAKE_PHOTO);  // 启动相机程序
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
             case TAKE_PHOTO:
                 if (resultCode == RESULT_OK){
                     Intent intent = new Intent("com.android.camera.action.CROP");
                     intent.setDataAndType(imageUri, "image/*");
                     intent.putExtra("scale", true);
                     intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                     startActivityForResult(intent, CROP_PHOTO); // 启动裁剪程序
                 }
                 break;
            case CROP_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        mPicture.setImageBitmap(bitmap); // 将裁剪后的照片显示出来
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;

             default:
                 break;
             }

    }
}
