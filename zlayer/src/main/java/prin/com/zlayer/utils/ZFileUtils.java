package prin.com.zlayer.utils;

/**
 * Created by prin on 2016/8/28.
 * 文件操作
 */
import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"NewApi"})
public class ZFileUtils {
    public ZFileUtils() {
    }

    public static void write(Context context, String fileName, String content) {
        if(content == null) {
            content = "";
        }

        try {
            FileOutputStream e = context.openFileOutput(fileName, 0);
            e.write(content.getBytes());
            e.close();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static String read(Context context, String fileName) {
        try {
            FileInputStream e = context.openFileInput(fileName);
            return readInStream(e);
        } catch (Exception var3) {
            var3.printStackTrace();
            return "";
        }
    }

    public static String readInStream(InputStream inStream) {
        try {
            ByteArrayOutputStream e = new ByteArrayOutputStream();
            byte[] buffer = new byte[512];
            boolean length = true;

            int length1;
            while((length1 = inStream.read(buffer)) != -1) {
                e.write(buffer, 0, length1);
            }

            e.close();
            inStream.close();
            return e.toString();
        } catch (IOException var4) {
            Log.i("FileTest", var4.getMessage());
            return null;
        }
    }

    public static File createFile(String folderPath, String fileName) {
        File destDir = new File(folderPath);
        if(!destDir.exists()) {
            destDir.mkdirs();
        }

        return new File(folderPath, fileName);
    }

    public static String readFile(Context context, String fileName) {
        try {
            FileInputStream e = new FileInputStream(fileName);
            return readInStream(e);
        } catch (Exception var3) {
            var3.printStackTrace();
            return "";
        }
    }

    public static boolean isSDCardExist() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception var1) {
            var1.printStackTrace();
            return false;
        }
    }

    public static boolean writeFile(byte[] buffer, String folder, String fileName) {
        boolean writeSucc = false;
        String folderPath = "";
        if(isSDCardExist()) {
            folderPath = Environment.getExternalStorageDirectory() + File.separator + folder + File.separator;
        } else {
            writeSucc = false;
        }

        File fileDir = new File(folderPath);
        if(!fileDir.exists()) {
            fileDir.mkdirs();
        }

        File file = new File(folderPath + fileName);
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(file);
            out.write(buffer);
            writeSucc = true;
        } catch (Exception var17) {
            var17.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException var16) {
                var16.printStackTrace();
            }

        }

        return writeSucc;
    }

    public static boolean writeFile(byte[] buffer, String fileName) {
        boolean writeSucc = false;
        File file = new File(fileName);
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(file);
            out.write(buffer);
            writeSucc = true;
        } catch (Exception var14) {
            var14.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException var13) {
                var13.printStackTrace();
            }

        }

        return writeSucc;
    }

    public static String getFileName(String filePath) {
        return TextUtils.isEmpty(filePath)?"":filePath.substring(filePath.lastIndexOf(File.separator) + 1);
    }

    public static String getFileNameNoFormat(String filePath) {
        if(TextUtils.isEmpty(filePath)) {
            return "";
        } else {
            int point = filePath.lastIndexOf(46);
            return filePath.substring(filePath.lastIndexOf(File.separator) + 1, point);
        }
    }

    public static String getFileFormat(String fileName) {
        if(TextUtils.isEmpty(fileName)) {
            return "";
        } else {
            int point = fileName.lastIndexOf(46);
            return fileName.substring(point + 1);
        }
    }

    public static long getFileSize(String filePath) {
        long size = 0L;
        File file = new File(filePath);
        if(file != null && file.exists()) {
            size = file.length();
        }

        return size;
    }

    public static String getFileSize(long size) {
        if(size <= 0L) {
            return "0";
        } else {
            DecimalFormat df = new DecimalFormat("##.##");
            float temp = (float)size / 1024.0F;
            return temp >= 1024.0F?df.format((double)(temp / 1024.0F)) + "M":df.format((double)temp) + "K";
        }
    }

    public static String formatFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if(fileS < 1024L) {
            fileSizeString = df.format((double)fileS) + "B";
        } else if(fileS < 1048576L) {
            fileSizeString = df.format((double)fileS / 1024.0D) + "KB";
        } else if(fileS < 1073741824L) {
            fileSizeString = df.format((double)fileS / 1048576.0D) + "MB";
        } else {
            fileSizeString = df.format((double)fileS / 1.073741824E9D) + "G";
        }

        return fileSizeString;
    }

    public static long getDirSize(File dir) {
        if(dir == null) {
            return 0L;
        } else if(!dir.isDirectory()) {
            return 0L;
        } else {
            long dirSize = 0L;
            File[] files = dir.listFiles();
            File[] var4 = files;
            int var5 = files.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                File file = var4[var6];
                if(file.isFile()) {
                    dirSize += file.length();
                } else if(file.isDirectory()) {
                    dirSize += file.length();
                    dirSize += getDirSize(file);
                }
            }

            return dirSize;
        }
    }

    public long getFileList(File dir) {
        long count = 0L;
        File[] files = dir.listFiles();
        count = (long)files.length;
        File[] var5 = files;
        int var6 = files.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            File file = var5[var7];
            if(file.isDirectory()) {
                count += this.getFileList(file);
                --count;
            }
        }

        return count;
    }

    public static byte[] toBytes(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int ch;
        while((ch = in.read()) != -1) {
            out.write(ch);
        }

        byte[] buffer = out.toByteArray();
        out.close();
        return buffer;
    }

    public static boolean checkFilePathExists(String path) {
        return (new File(path)).exists();
    }

    public static long getFreeDiskSpace() {
        long freeSpace = 0L;
        if(isSDCardExist()) {
            try {
                File e = Environment.getExternalStorageDirectory();
                StatFs stat = new StatFs(e.getPath());
                long blockSize = (long)stat.getBlockSize();
                long availableBlocks = (long)stat.getAvailableBlocks();
                freeSpace = availableBlocks * blockSize / 1024L;
            } catch (Exception var8) {
                var8.printStackTrace();
            }

            return freeSpace;
        } else {
            return -1L;
        }
    }

    public static boolean createDirectory(String directoryName) {
        boolean status;
        if(!directoryName.equals("") && isSDCardExist()) {
            File path = Environment.getExternalStorageDirectory();
            File newPath = new File(path.toString() + directoryName);
            status = newPath.mkdir();
            status = true;
        } else {
            status = false;
        }

        return status;
    }

    public static boolean isFolderExists(String strFolder) {
        File file = new File(strFolder);
        return !file.exists()?file.mkdirs():true;
    }

    public static boolean checkExternalSDExists() {
        Map evn = System.getenv();
        return evn.containsKey("SECONDARY_STORAGE");
    }

    public static boolean deleteDirectory(String fileName) {
        SecurityManager checker = new SecurityManager();
        boolean status;
        if(!fileName.equals("") && isSDCardExist()) {
            File path = Environment.getExternalStorageDirectory();
            File newPath = new File(path.toString() + fileName);
            checker.checkDelete(newPath.toString());
            if(newPath.isDirectory()) {
                String[] listfile = newPath.list();

                try {
                    for(int e = 0; e < listfile.length; ++e) {
                        File deletedFile = new File(newPath.toString() + "/" + listfile[e].toString());
                        deletedFile.delete();
                    }

                    newPath.delete();
                    status = true;
                } catch (Exception var8) {
                    var8.printStackTrace();
                    status = false;
                }
            } else {
                status = false;
            }
        } else {
            status = false;
        }

        return status;
    }

    public static boolean deleteFile(String fileName) {
        SecurityManager checker = new SecurityManager();
        boolean status;
        if(!fileName.equals("") && isSDCardExist()) {
            File path = Environment.getExternalStorageDirectory();
            File newPath = new File(path.toString() + fileName);
            checker.checkDelete(newPath.toString());
            if(newPath.isFile()) {
                try {
                    newPath.delete();
                    status = true;
                } catch (SecurityException var6) {
                    var6.printStackTrace();
                    status = false;
                }
            } else {
                status = false;
            }
        } else {
            status = false;
        }

        return status;
    }

    public static int deleteBlankPath(String path) {
        File f = new File(path);
        return !f.canWrite()?1:(f.list() != null && f.list().length > 0?2:(f.delete()?0:3));
    }

    public static boolean reNamePath(String oldName, String newName) {
        File f = new File(oldName);
        return f.renameTo(new File(newName));
    }

    public static boolean deleteFileWithPath(String filePath) {
        SecurityManager checker = new SecurityManager();
        File f = new File(filePath);
        checker.checkDelete(filePath);
        if(f.isFile()) {
            f.delete();
            return true;
        } else {
            return false;
        }
    }

    public static void clearFileWithPath(String filePath) {
        List files = listPathFiles(filePath);
        if(!files.isEmpty()) {
            Iterator var2 = files.iterator();

            while(var2.hasNext()) {
                File f = (File)var2.next();
                if(f.isDirectory()) {
                    clearFileWithPath(f.getAbsolutePath());
                } else {
                    f.delete();
                }
            }

        }
    }

    public static String getSDRoot() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static String getExternalSDRoot() {
        Map evn = System.getenv();
        return (String)evn.get("SECONDARY_STORAGE");
    }

    public static List<String> listPath(String root) {
        ArrayList allDir = new ArrayList();
        SecurityManager checker = new SecurityManager();
        File path = new File(root);
        checker.checkRead(root);
        if(path.isDirectory()) {
            File[] var4 = path.listFiles();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                File f = var4[var6];
                if(f.isDirectory() && !f.getName().startsWith(".")) {
                    allDir.add(f.getAbsolutePath());
                }
            }
        }

        return allDir;
    }

    public static List<File> listPathFiles(String root) {
        ArrayList allDir = new ArrayList();
        SecurityManager checker = new SecurityManager();
        File path = new File(root);
        checker.checkRead(root);
        File[] files = path.listFiles();
        File[] var5 = files;
        int var6 = files.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            File f = var5[var7];
            if(f.isFile()) {
                allDir.add(f);
            } else {
                listPath(f.getAbsolutePath());
            }
        }

        return allDir;
    }

    public static ZFileUtils.PathStatus createPath(String newPath) {
        File path = new File(newPath);
        return path.exists()?ZFileUtils.PathStatus.EXITS:(path.mkdir()?ZFileUtils.PathStatus.SUCCESS:ZFileUtils.PathStatus.ERROR);
    }

    public static String getPathName(String absolutePath) {
        int start = absolutePath.lastIndexOf(File.separator) + 1;
        int end = absolutePath.length();
        return absolutePath.substring(start, end);
    }

    public static String getAppCache(Context context, String dir) {
        String savePath = context.getCacheDir().getAbsolutePath() + "/" + dir + "/";
        File savedir = new File(savePath);
        if(!savedir.exists()) {
            savedir.mkdirs();
        }

        savedir = null;
        return savePath;
    }

    public static String getDownloadPath(Context context) {
        try {
            String downloadPath;
            if(!isSDCardExist()) {
                downloadPath = context.getFilesDir() + File.separator + "download";
            } else {
                PackageInfo e = ZPackageUtil.getPackageInfo(context);
                String downloadRootPath = File.separator + "download" + File.separator + e.packageName + File.separator;
                downloadPath = Environment.getExternalStorageDirectory().getAbsolutePath() + downloadRootPath;
            }

            File e1 = new File(downloadPath);
            if(!e1.exists()) {
                e1.mkdirs();
            }

            return e1.getPath();
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static String getPath(Context context, Uri uri) {
        boolean isKitKat = Build.VERSION.SDK_INT >= 19;
        if(isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            String docId;
            String[] split;
            String type;
            if(isExternalStorageDocument(uri)) {
                docId = DocumentsContract.getDocumentId(uri);
                split = docId.split(":");
                type = split[0];
                if("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else {
                if(isDownloadsDocument(uri)) {
                    docId = DocumentsContract.getDocumentId(uri);
                    Uri split1 = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId).longValue());
                    return getDataColumn(context, split1, (String)null, (String[])null);
                }

                if(isMediaDocument(uri)) {
                    docId = DocumentsContract.getDocumentId(uri);
                    split = docId.split(":");
                    type = split[0];
                    Uri contentUri = null;
                    if("image".equals(type)) {
                        contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if("video".equals(type)) {
                        contentUri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if("audio".equals(type)) {
                        contentUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }

                    String selection = "_id=?";
                    String[] selectionArgs = new String[]{split[1]};
                    return getDataColumn(context, contentUri, "_id=?", selectionArgs);
                }
            }
        } else {
            if("content".equalsIgnoreCase(uri.getScheme())) {
                if(isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }

                return getDataColumn(context, uri, (String)null, (String[])null);
            }

            if("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }

        return null;
    }

    public static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        String column = "_data";
        String[] projection = new String[]{"_data"};

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, (String)null);
            if(cursor != null && cursor.moveToFirst()) {
                int index = cursor.getColumnIndexOrThrow("_data");
                String var8 = cursor.getString(index);
                return var8;
            }
        } finally {
            if(cursor != null) {
                cursor.close();
            }

        }

        return null;
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static String getRealFileNameFromUrl(String url) {
        Object name = null;

        try {
            if(ZStringUtil.isEmpty(url)) {
                return (String)name;
            }

            URL e = new URL(url);
            HttpURLConnection mHttpURLConnection = (HttpURLConnection)e.openConnection();
            mHttpURLConnection.setConnectTimeout(5000);
            mHttpURLConnection.setRequestMethod("GET");
            mHttpURLConnection.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
            mHttpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
            mHttpURLConnection.setRequestProperty("Referer", url);
            mHttpURLConnection.setRequestProperty("Charset", "UTF-8");
            mHttpURLConnection.setRequestProperty("User-Agent", "");
            mHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            mHttpURLConnection.connect();
            if(mHttpURLConnection.getResponseCode() == 200) {
                int i = 0;

                while(true) {
                    String mine = mHttpURLConnection.getHeaderField(i);
                    if(mine == null) {
                        break;
                    }

                    if("content-disposition".equals(mHttpURLConnection.getHeaderFieldKey(i).toLowerCase())) {
                        Matcher m = Pattern.compile(".*filename=(.*)").matcher(mine.toLowerCase());
                        if(m.find()) {
                            return m.group(1).replace("\"", "");
                        }
                    }

                    ++i;
                }
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return (String)name;
    }

    public static String getRealFileName(HttpURLConnection connection) {
        Object name = null;

        try {
            if(connection == null) {
                return (String)name;
            }

            if(connection.getResponseCode() == 200) {
                int e = 0;

                while(true) {
                    String mime = connection.getHeaderField(e);
                    if(mime == null) {
                        break;
                    }

                    if("content-disposition".equals(connection.getHeaderFieldKey(e).toLowerCase())) {
                        Matcher m = Pattern.compile(".*filename=(.*)").matcher(mime.toLowerCase());
                        if(m.find()) {
                            return m.group(1).replace("\"", "");
                        }
                    }

                    ++e;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return (String)name;
    }



    public static String getCacheFileNameFromUrl(String url, HttpURLConnection connection) {
        if(ZStringUtil.isEmpty(url)) {
            return null;
        } else {
            String name = null;

            try {
                String e = getMIMEFromUrl(url, connection);
                if(ZStringUtil.isEmpty(e)) {
                    e = ".ab";
                }

                name = ZMD5Util.md5Digest(url) + e;
            } catch (Exception var4) {
                var4.printStackTrace();
            }

            return name;
        }
    }

    public static String getMIMEFromUrl(String url, HttpURLConnection connection) {
        if(ZStringUtil.isEmpty(url)) {
            return null;
        } else {
            String suffix = null;

            try {
                if(url.lastIndexOf(".") != -1) {
                    suffix = url.substring(url.lastIndexOf("."));
                    if(suffix.indexOf("/") != -1 || suffix.indexOf("?") != -1 || suffix.indexOf("&") != -1) {
                        suffix = null;
                    }
                }

                if(ZStringUtil.isEmpty(suffix)) {
                    String e = getRealFileName(connection);
                    if(e != null && e.lastIndexOf(".") != -1) {
                        suffix = e.substring(e.lastIndexOf("."));
                    }
                }
            } catch (Exception var4) {
                var4.printStackTrace();
            }

            return suffix;
        }
    }


    public static enum PathStatus {
        SUCCESS,
        EXITS,
        ERROR;

        private PathStatus() {
        }
    }
}
