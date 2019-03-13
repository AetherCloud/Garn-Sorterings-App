package ftb.dk.garnsorteringsapp;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
@Deprecated
public class DriveGetter extends AsyncTask<String, Void, ArrayList<Bitmap>> {

    private String urlString = "https://www.googleapis.com/drive/v3/files";

    @Override
    protected ArrayList<Bitmap> doInBackground(String... strings) {
        byte[] response;
        try {
            response = getUrlBytes(urlString);
            String responseString = new String(response);
//            textView.setText(responseString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public byte[] getUrlBytes(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {

                throw new IOException(connection.getResponseMessage() +
                        ": with " +
                        urlString);
            }
            int bytesRead = 0;
            Bitmap[] buf = new Bitmap[500];
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }

}
