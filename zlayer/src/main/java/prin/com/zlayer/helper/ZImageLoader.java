package prin.com.zlayer.helper;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.lang.ref.WeakReference;

/**
 * Created by prin on 2016/8/27.
 * 图片加载封装  底层加载可切换其他图片加载框架
 * 目前采用的是glide
 */
public class ZImageLoader {

    private static final String HTTP_PREFIX = "http://";
    private static final String HTTPS_PREFIX = "http://";
    private static final String FILE_PREFIX = "file://";
    private static final String CONTENT_PREFEIX = "content://";
    private static final String ASSETS_PREFIX = "assets://";
    private static final String DRAWABLE_PREFIX = "drawable://";

    private static ZImageLoader sImageLoader;
    private static WeakReference<Context> sContextWeak;

    public ZImageLoader() {

    }

    public static void init(Context context) {
        if (sImageLoader == null) {
            synchronized (ZImageLoader.class) {
                if (sImageLoader == null) {
                    sImageLoader = new ZImageLoader();
                }
            }
        }
        sContextWeak = new WeakReference<Context>(context);
    }

    public static void loadImage(ImageView imageView, String imageUrl) {
        loadImage(imageView, imageUrl, 0, 0, 0);
    }

    public static void loadImage(ImageView imageView, String imageUrl, int defaultImageId) {
        loadImage(imageView, imageUrl, defaultImageId, 0, 0);
    }

    public static void loadImage(ImageView imageView, String imageUrl, int defaultImageId, int maxWidth, int maxHeight) {
        loadImage(imageView, imageUrl, defaultImageId, maxWidth, maxHeight, ImageView.ScaleType.CENTER_INSIDE);
    }

    public static void loadImage(ImageView imageView, String imageUrl, int defaultImageId, int maxWidth, int maxHeight, ImageView.ScaleType scaleType) {
        isInitedCheck();
        loadImage((Context) sContextWeak.get(), imageView, imageUrl, defaultImageId, maxWidth, maxHeight, scaleType);
    }

    public static void loadImage(Context context, ImageView imageView, String imageUrl, int defaultImageId, int maxWidth, int maxHeight, ImageView.ScaleType scaleType) {
        if (imageUrl != null && imageUrl.length() >= 7) {
            if (!imageUrl.startsWith("http://") && !imageUrl.startsWith("https://")) {
                if (imageUrl.startsWith("file://")) {
                    if (maxWidth != 0 && maxHeight != 0) {
                        Glide.with(context).load(new File(imageUrl.substring("file://".length()))).placeholder(defaultImageId).override(maxWidth, maxHeight).into(imageView);
                    } else {
                        Glide.with(context).load(new File(imageUrl.substring("file://".length()))).placeholder(defaultImageId).into(imageView);
                    }
                } else if (imageUrl.startsWith("content://")) {
                    if (maxWidth != 0 && maxHeight != 0) {
                        Glide.with(context).load(Uri.parse(imageUrl)).placeholder(defaultImageId).placeholder(defaultImageId).override(maxWidth, maxHeight).into(imageView);
                    } else {
                        Glide.with(context).load(Uri.parse(imageUrl)).placeholder(defaultImageId).into(imageView);
                    }
                } else if (imageUrl.startsWith("assets://")) {
                    if (maxWidth != 0 && maxHeight != 0) {
                        Glide.with(context).load(Uri.parse("file:///android_asset/" + imageUrl.substring("assets://".length()))).placeholder(defaultImageId).override(maxWidth, maxHeight).into(imageView);
                    } else {
                        Glide.with(context).load(Uri.parse("file:///android_asset/" + imageUrl.substring("assets://".length()))).placeholder(defaultImageId).into(imageView);
                    }
                } else {
                    if (!imageUrl.startsWith("drawable://")) {
                        throw new IllegalArgumentException("imageUrl not support");
                    }

                    if (maxWidth != 0 && maxHeight != 0) {
                        Glide.with(context).load(Integer.valueOf(Integer.parseInt(imageUrl.substring("drawable://".length())))).placeholder(defaultImageId).override(maxWidth, maxHeight).into(imageView);
                    } else {
                        Glide.with(context).load(Integer.valueOf(Integer.parseInt(imageUrl.substring("drawable://".length())))).placeholder(defaultImageId).into(imageView);
                    }
                }
            } else if (maxWidth != 0 && maxHeight != 0) {
                Glide.with(context).load(imageUrl).placeholder(defaultImageId).override(maxWidth, maxHeight).crossFade().into(imageView);
            } else {
                Glide.with(context).load(imageUrl).placeholder(defaultImageId).crossFade().into(imageView);
            }
        } else if (defaultImageId > 0) {
            imageView.setImageResource(defaultImageId);
        } else {
            throw new IllegalArgumentException("imageUrl invalid");
        }
    }


    public static void clear() {
        isInitedCheck();
        Glide.get((Context) sContextWeak.get()).clearMemory();
    }

    private static void isInitedCheck() {
        if (sContextWeak == null || sContextWeak.get() == null) {
            throw new IllegalStateException("ImageLoader not initialized");
        }
    }
}
