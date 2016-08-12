package tutorial.freelancertraning.tuanvu.baitaplon01.Membres;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import tutorial.freelancertraning.tuanvu.baitaplon01.R;

public class DownloadWebPage extends AsyncTask<String, Void, ArrayList<Items>> {

    public ArrayList<Items> arr = new ArrayList<Items>();
    private Context context;
    private XmlPullParserFactory xmlFactoryObject;
    private ListView lv;
    private ProgressDialog press;
    private AsyncResponse asyncResponse;

    public DownloadWebPage(Context context, ListView lv, ArrayList<Items> arr) {
        this.context = context;
        this.arr = arr;
        this.lv = lv;
    }

    public DownloadWebPage(Context context, ListView lv, ArrayList<Items> arr, AsyncResponse asyncResponse) {
        this.context = context;
        this.arr = arr;
        this.lv = lv;
        this.asyncResponse = asyncResponse;
    }

    public void initProgress() {
        press = new ProgressDialog(context);
        press.setTitle("Vui lòng chờ trong ít phút...");
        press.setIndeterminate(true);
        press.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    }

    // check Internet conenction.
    private void checkInternetConenction() {

        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (isConnected) {
            Toast.makeText(context, "Internet is connected",
                    Toast.LENGTH_SHORT).show();
            press.show();

        } else {
            Toast.makeText(context, "not conencted to internet",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPreExecute() {
        initProgress();
        checkInternetConenction();

    }

    @Override
    protected ArrayList<Items> doInBackground(String... arg0) {
        ArrayList<Items> data = new ArrayList<Items>();
        String webPage = "";
        try {
            String link = (String) arg0[0];
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", "Fiddler");
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            int statusconnect = conn.getResponseCode();
            if (statusconnect == 200) {
                InputStream is = conn.getInputStream();
                // neu link anh
                // Bitmap myBitmap = BitmapFactory.decodeStream(input);
                // https://scontent-a.xx.fbcdn.net/hphotos-xap1/t31.0-8/s720x720/10841776_773096199429721_1050736871535693539_o.jpg
                // buoc nay tao ra duoc inputstream rồi
                xmlFactoryObject = XmlPullParserFactory.newInstance();
                XmlPullParser myparser = xmlFactoryObject.newPullParser();
                myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,
                        false);
                myparser.setInput(is, null);
                data = parseXMLAndStoreIt(myparser);
                is.close();

            }

        } catch (Exception e) {
            Log.e("error", e.toString());
        }
        return data;
    }

    public ArrayList<Items> parseXMLAndStoreIt(XmlPullParser myParser) {
        ArrayList<Items> data = new ArrayList<Items>();
        int event;
        String text = null;
        int count = 0;
        Items item = new Items();
        try {
            event = myParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {

                String name = myParser.getName();
                switch (event) {
                    case XmlPullParser.START_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;
                    case XmlPullParser.END_TAG:

                        if (name.equals("title")) {
                            item.setTitle(text);
                            // Log.i("title", text);
                        } else if (name.equals("link")) {
                            item.setLink(text);
                            // Log.i("Link", text);
                        } else if (name.equals("description")) {
//                       String values =  myParser.getAttributeValue(null,"value");
                            String des = text;
                            if (des.contains("\"")) {
                                des = des.replace("\"", "");
                                // // lay ve link anh

                                String img = des.substring(des.indexOf("src="),
                                        des.indexOf(" ></a>"));
                                img = img.replace("src=", "");
                                //
                                item.setImage(img);
                            }
                        } else if (name.equals("pubDate")) {
                            item.setDate(text);
                            // Log.i("Pubdate", text);
                        }
                        if (item.getDate() != null && item.getLink() != null) {
                            data.add(item);
                            item = new Items();
                        }

                        break;
                }
                event = myParser.next();

            }

        } catch (Exception e) {
            Log.e("Tai du lieu", e.toString());
        }
        data.remove(0);

        return data;
    }

    @Override
    protected void onPostExecute(ArrayList<Items> result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        press.dismiss();
        arr = result;
        LayerAdapter strValues = new LayerAdapter(context, R.layout.list_item,
                arr);

        lv.setAdapter(strValues);
        asyncResponse.processFinish(result);
    }

}
